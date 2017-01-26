public class List<T>
{
	private int numberOfEntries;
	private Node firstNode;
	
	public class Node<T>
	{
		private int freq; //how many of each i have
		private T value; // 
		private Node next; 
		
		public Node()
		{
			freq = 0;
			value = null;
			next = null;
		}
	
		public Node (T aValue, int aNum, T aPointer)
		{
			freq = aNum;
			value = aValue;
			next = aPointer;
		}
	}
	
	public void add(T item)
	{
		
		
	}
	
	public void replace(T aValue)
	{
		
	}
	
	public void empty()
	{
		
	}
	
	public Node get(T aValue)
	{
		return 
	}
}