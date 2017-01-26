@SuppressWarnings("unchecked")
public class FrequencyBag<T> 
{
	private int NumOfNodes;
	private int size;
	private double prob;
	private double frequency;
	private int MaxFreq;
	Node firstNode;
	
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
		public Node (T aValue, int aNum, Node aPointer)
		{
			freq = aNum;
			value = aValue;
			next = aPointer;
		}
		public boolean equals (Object otherObject)
		{
			if (this.value.equals(otherObject))
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
	}
	public int getNumNodes()
	{
		return NumOfNodes;
	}
	/**
	 * Constructor
	 * Constructs an empty frequency bag.
	 */
	public FrequencyBag()
	{
		firstNode = null;
	}
	/**
	 * Adds new entry into this frequency bag.
	 * @param aData the data to be added into this frequency bag.
	 */
	public void add(T aData)
	{
		size++;
		//System.out.println("size = " + size);
		Node currentNode = firstNode;
		if (firstNode == null)
		{
			firstNode = new Node(aData, 1, null);
			NumOfNodes++;
		}
		else 
		{
			while (currentNode.next != null)
			{
				if(currentNode.equals(aData))
				{
					int tempFreq = currentNode.freq;
					tempFreq++;
					currentNode.freq = tempFreq;
					return;
				}
				currentNode = currentNode.next;
			}
			if(currentNode.equals(aData))
			{
				int tempFreq = currentNode.freq;
				tempFreq++;
				currentNode.freq = tempFreq;
				return;
			}
			else
			{
				Node newNode = new Node (aData, 1, null);
				currentNode.next = newNode;
				NumOfNodes++;
			}
		}	
	}
	/**
	 * Gets the number of occurrences of aData in this frequency bag.
	 * @param aData the data to be checked for its number of occurrences.
	 * @return the number of occurrences of aData in this frequency bag.
	 */
	public int getFrequencyOf(T aData)
	{
		Node currentNode = firstNode;
		while(currentNode != null)
		{
			if (currentNode.equals(aData))
			{
				return currentNode.freq;	
			}
			currentNode = currentNode.next;
		}			
		return 0;
	}
	/**
	 * Gets the maximum number of occurrences in this frequency bag.
	 * @return the maximum number of occurrences of an entry in this
	 * frequency bag.
	 */
	public int getMaxFrequency()
	{
		Node currentNode = firstNode;
		while(currentNode != null)
		{
			if (currentNode.freq > MaxFreq)
			{
				MaxFreq = currentNode.freq;
			}
			currentNode = currentNode.next;
		}
		return MaxFreq;
	}
	/**
	 * Gets the probability of aData
	 * @param aData the specific data to get its probability.
	 * @return the probability of aData
	 */
	public double getProbabilityOf(T aData)
	{
		return (double)getFrequencyOf(aData)/size;
	}
	/**
	 * Empty this bag.
	 */
	public void clear()
	{
		firstNode = null;
		size = 0;
		MaxFreq = 0;
	}
	/**
	 * Gets the number of entries in this bag.
	 * @return the number of entries in this bag.
	 */
	public int size()
	{
		return size;
	}
}

