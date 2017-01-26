/**
 * It is okay to use ArrayList class but you are not allowed to use any other
 * predefined class supplied by Java.
 */
import java.util.ArrayList;

public class CompressDecompress
{
	/**
	 * Get a string representing a Huffman tree where its root node is root
	 * @param root the root node of a Huffman tree
	 * @return a string representing a Huffman tree
	 */
	public static String getTreeString(final BinaryNodeInterface<Character> root)
	{
		String str = "";
		if(root == null)
		{
			return str;
		}
		str = helper(root, str);
		return str;	// Do not forget to change this line!!!
	}
	public static String helper(BinaryNodeInterface<Character> root, String str)
	{
		String result = str;
		if (!root.isLeaf())
		{
			result = result + "I";
			if (root.hasLeftChild())
			{
				result = helper (root.getLeftChild(), result);
			}
			if (root.hasRightChild())
			{	
				result = helper (root.getRightChild(), result);
			}
		}
		else 
		{
			result = result+ "L" + root.getData();
		}
		return result;
	}
	/**
	 * Compress the message using Huffman tree represented by treeString
	 * @param root the root node of a Huffman tree
	 * @param message the message to be compressed
	 * @return a string representing compressed message.
	 */
	public static String compress(final BinaryNodeInterface<Character> root, final String message)
	{
		char character;
		String path;
		char[] charArray = message.toCharArray();
		String result = "";
		if (root == null)
		{
			return result;
		}
		int size = message.length();
		for(int i=0; i<size; i++)
		{
			character = charArray[i];
			path = traverse(root, character, "");
			result = result + path;
		}
		return result;	// Do not forget to change this line!!!
	}
	private static String getPathTo(final BinaryNodeInterface<Character> root, char c)
	{
		String result = traverse(root, c, "");
		return result;
	}
	public static String traverse(BinaryNodeInterface<Character> root, char c, String str)
	{
		String path = str;
		String leftVar = "";
		String rightVar = "";
		if (root == null)
		{
			return "";
		}
		if (root.isLeaf()&&root.getData().equals(c))
		{
			return str;
		}
		if (root.hasLeftChild())
		{
			leftVar= traverse(root.getLeftChild(), c, str+"0");
		}
		if (root.hasRightChild())
		{	
			rightVar= traverse(root.getRightChild(), c, str +"1");
		}
		return leftVar + rightVar;
	}
	/**
	 * Decompress the message using Huffman tree represented by treeString
	 * @param treeString the string represents the Huffman tree of the
	 * compressed message
	 * @param message the compressed message to be decompressed
	 * @return a string representing decompressed message
	 */
	public static String decompress(final String treeString, final String message)
	{
		if(message == "" || message == null)
		{
			return "";
		}
		String DecompressedString = "";
		ArrayList<Character> treeArray = new ArrayList<Character>();
		char [] tree = treeString.toCharArray(); 
		for(int i = 0;i<tree.length;i++)
		{
			treeArray.add(tree[i]);
		}
		BinaryNodeInterface<Character> root = MakeTree(treeArray);
		BinaryNodeInterface<Character> current = root;
		char [] binary = message.toCharArray(); 
		for (char c : binary)
		{
			if (c == '0')
			{
				current = current.getLeftChild();
			}
			else if (c == '1')
			{
				current = current.getRightChild();
			}
			if (current.isLeaf())
			{
				DecompressedString = DecompressedString + current.getData();
				current = root;
			}
		}

		return DecompressedString;	// Do not forget to change this line!!!
	}
	public static BinaryNodeInterface<Character> MakeTree(ArrayList<Character> arraylist)
	{
			BinaryNodeInterface<Character> newNode = new BinaryNode<Character>();
			char c = arraylist.get(0);
			if (c == 'L')
			{
				arraylist.remove(0);
				newNode.setData(arraylist.remove(0));
			}
			if (c == 'I')
			{
				arraylist.remove(0);
				newNode.setLeftChild(MakeTree(arraylist));
				newNode.setRightChild(MakeTree(arraylist));
			}
		return newNode;
	}
	
}
