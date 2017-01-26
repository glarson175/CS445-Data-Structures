
public class LInfiniteInteger implements InfiniteIntegerInterface
{
	private Node firstNode;
	private  Node lastNode;
	private int numberOfDigits;
	private  boolean isNegative;
	private String str;
	//private Node currentNode = null;
	
	public String removeLeadingZeros(String st) 
	{
		if (Integer.valueOf(st)==0)
		{
			st = "0";
			return st;
		}
		if (Integer.valueOf(st)!=0)
		{
			while (st.indexOf("0")==0)
			{
				st = st.substring(1);
			}
		}
		return st;
	}

	/**
	 * Constructor: Constructs this infinite integer from a string
	 * representing an integer.
	 * @param s  a string represents an integer
	 */
	public LInfiniteInteger(String s)
	{
		int j = Character.digit(s.charAt(0), 10);
		if (j == -1)
		{
			s = s.substring(1); //should remove the -1
			while(Character.digit(s.charAt(0), 10) == 0&& s.length()>1)
			{
				s = s.substring(1);
			}
			//s = removeLeadingZeros(s);
			firstNode = new Node(null, Character.digit(s.charAt(0), 10), null);
			firstNode.negative = true;
			lastNode = firstNode;
			for(int i = 1; i < s.length(); i++) 
			{
				j = Character.digit(s.charAt(i), 10);
				Node newNode = new Node(lastNode, j, null);			
				lastNode.next = newNode;
				lastNode = newNode;
			}
		}
		else
		{
			while(Character.digit(s.charAt(0), 10) == 0&& s.length()>1)
			{
				s = s.substring(1);
			}
			firstNode = new Node(null, Character.digit(s.charAt(0), 10), null);
			firstNode.negative = false;
			lastNode = firstNode;
			for(int i = 1; i < s.length(); i++) 
			{
				j = Character.digit(s.charAt(i), 10);		
				Node newNode = new Node(lastNode, j, null);			
				lastNode.next = newNode;
				lastNode = newNode;
			}
		}	
	}
	/**
	 * Constructor: Constructs this infinite integer from an integer.
	 * @param anInteger  an integer
	 */
	public LInfiniteInteger(int anInteger)
	{
		String s = String.valueOf(anInteger);
		int j = Character.digit(s.charAt(0), 10);
		if (j == -1)
		{
			s = s.substring(1); //should remove the -1
			while(Character.digit(s.charAt(0), 10) == 0&& s.length()>1)
			{
				s = s.substring(1);
			}
			firstNode = new Node(null, Character.digit(s.charAt(0), 10), null);
			firstNode.negative = true;
			lastNode = firstNode;
			for(int i = 1; i < s.length(); i++) 
			{
				j = Character.digit(s.charAt(i), 10);
				Node newNode = new Node(lastNode, j, null);			
				lastNode.next = newNode;
				lastNode = newNode;
			}
		}
		else
		{
			while(Character.digit(s.charAt(0), 10) == 0&& s.length()>1)
			{
				s = s.substring(1);
			}
			firstNode = new Node(null, Character.digit(s.charAt(0), 10), null);
			firstNode.negative = false;
			lastNode = firstNode;
			for(int i = 1; i < s.length(); i++) 
			{
				j = Character.digit(s.charAt(i), 10);		
				Node newNode = new Node(lastNode, j, null);			
				lastNode.next = newNode;
				lastNode = newNode;
			}
		}			
	}
	
	public LInfiniteInteger ()
	{
		firstNode = new Node(null, 0, null);
		lastNode = firstNode;
	}
	/**
	 * Gets the number of digits of this infinite integer.
	 * @return an integer representing the number of digits
	 * of this infinite integer.
	 */
	public int getNumberOfDigits()
	{
		numberOfDigits = 0;
		Node currentNode = firstNode;
		if(currentNode == null)
		{
			return numberOfDigits;
		}
		if(currentNode.data == 0)
		{
			return 1;
		}
		while(currentNode != null)
		{
			numberOfDigits++;
			currentNode = currentNode.next;
		}
		return numberOfDigits;
	
	}

	/**
	 * Checks whether this infinite integer is a negative number.
	 * @return true if this infinite integer is a negative number.
	 * Otherwise, return false.
	 */
	public boolean isNegative()
	{
		//Node currentNode = firstNode;
		if (firstNode.negative == true)
		{
			isNegative = true;
		}
		else if (firstNode.negative == false)
		{
			isNegative = false;
		}
		return isNegative;
	}

	/**
	 * Calculates the result of this infinite integer plus anInfiniteInteger
	 * @param anInfiniteInteger the infinite integer to be added to this
	 * infinite integer.
	 * @return a NEW infinite integer representing the result of this
	 * infinite integer plus anInfiniteInteger
	 */
	public InfiniteIntegerInterface plus(final InfiniteIntegerInterface anInfiniteInteger)
	{		
		LInfiniteInteger fuckbitches = (LInfiniteInteger) anInfiniteInteger;
		LInfiniteInteger result = new LInfiniteInteger();//with a firstNode = null
		int Blah= this.getNumberOfDigits();
		if(Blah<fuckbitches.getNumberOfDigits())
		{
			Blah = fuckbitches.getNumberOfDigits();
		}
		if (this.compareValue(fuckbitches)==-1)
		{
			if (this.isNegative() == false && fuckbitches.isNegative() == false )
			{
				result = addPositive(fuckbitches,this, Blah);
				result.firstNode.negative = false;
			}
			else if (this.isNegative() == true && fuckbitches.isNegative() == false)
			{
				result = subPositive(fuckbitches,this, Blah);
				result.firstNode.negative = false;
			}
			
			else if (this.isNegative() == false && fuckbitches.isNegative() == true)
			{
				result = subPositive(fuckbitches,this, Blah);
				result.firstNode.negative = true;
				
			}
			else if (this.isNegative()== true && fuckbitches.isNegative() == true)
			{
				result = addPositive(this, fuckbitches, Blah);
				result.firstNode.negative = true;
			}
		}
		else if (this.compareValue(fuckbitches)==0)
		{
			if (this.isNegative() == false && fuckbitches.isNegative() == false )
			{
				result = addPositive(fuckbitches,this, Blah);
				result.firstNode.negative = false;
			}
			else if (this.isNegative() == true && fuckbitches.isNegative() == false)
			{
				result = new LInfiniteInteger();
			}
			
			else if (this.isNegative() == false && fuckbitches.isNegative() == true)
			{
				result = new LInfiniteInteger();
			}
			else if (this.isNegative()== true && fuckbitches.isNegative() == true)
			{
				result = addPositive(this, fuckbitches, Blah);
				result.firstNode.negative = true;
			}
		}
		else if (this.compareValue(fuckbitches)==1)
		{
			if (this.isNegative() == false && fuckbitches.isNegative() == false )
			{
				result = addPositive(fuckbitches,this, Blah);
				result.firstNode.negative = false;
			}
			else if (this.isNegative() == true && fuckbitches.isNegative() == false)
			{
				result = subPositive(this, fuckbitches, Blah);
				result.firstNode.negative = true;
			}
			else if (this.isNegative() == false && fuckbitches.isNegative() == true)
			{
				result = subPositive(this, fuckbitches,Blah);
				result.firstNode.negative = false;
			}
			else if (this.isNegative()== true && fuckbitches.isNegative() == true)
			{
				result = addPositive(this, fuckbitches, Blah);
				result.firstNode.negative = false;
			}
		}
		return result;
	}	
	public LInfiniteInteger addPositive(LInfiniteInteger first, LInfiniteInteger second, int biggerNum)
	{
		LInfiniteInteger zero = new LInfiniteInteger("0");
		LInfiniteInteger add = new LInfiniteInteger();
		Node currentFirst = first.lastNode;
		Node currentSecond = second.lastNode;
		Node newNode;
		if (first.compareValue(zero) == 0)
		{
			add = second;
			add.firstNode.negative = false;
			return add;
		}
		else if (second.compareValue(zero) == 0)
		{
			add= first;
			add.firstNode.negative = first.firstNode.negative;
			return add;
		}
		for (int i = 0; i < biggerNum; i++)
		{		
			int addThis = currentFirst.data + currentSecond.data + add.firstNode.data;
			if (addThis<10)
			{
				add.firstNode.data = addThis;
				
				if (currentFirst.previous != null && currentSecond.previous == null)
				{
					newNode = new Node(null, 0 , add.firstNode);
					add.firstNode.previous = newNode;
					add.firstNode = newNode;
					
					newNode = new Node (null, 0, second.firstNode);
					second.firstNode.previous = newNode;
					second.firstNode = newNode;
					currentFirst = currentFirst.previous;
					currentSecond = currentSecond.previous;
				}
				else if (currentSecond.previous != null && currentFirst.previous == null)
				{
					newNode = new Node(null, 0 , add.firstNode);
					add.firstNode.previous = newNode;
					add.firstNode = newNode;
					
					newNode = new Node (null, 0, first.firstNode);
					first.firstNode.previous = newNode;
					first.firstNode = newNode;
					currentFirst = currentFirst.previous;
					currentSecond = currentSecond.previous;
				}
				else if (currentSecond.previous != null && currentFirst.previous != null)
				{
					newNode = new Node(null, 0 , add.firstNode);
					add.firstNode.previous = newNode;
					add.firstNode = newNode;
					currentFirst = currentFirst.previous;
					currentSecond = currentSecond.previous;
				}
				else if (currentSecond.previous == null && currentFirst.previous == null)
				{
					return add;
				}
			}
			else if (addThis >= 10)
			{
				addThis = addThis - 10;
				add.firstNode.data = addThis;
				newNode = new Node(null, 1 , add.firstNode);
				add.firstNode.previous = newNode;
				add.firstNode = newNode;
				if (currentFirst.previous != null && currentSecond.previous == null)
				{
					newNode = new Node (null, 0, second.firstNode);
					second.firstNode.previous = newNode;
					second.firstNode = newNode;
					currentFirst = currentFirst.previous;
					currentSecond = currentSecond.previous;
				}
				else if (currentSecond.previous != null && currentFirst.previous == null)
				{
					newNode = new Node (null, 0, first.firstNode);
					first.firstNode.previous = newNode;
					first.firstNode = newNode;
					currentFirst = currentFirst.previous;
					currentSecond = currentSecond.previous;
				}
				else if (currentSecond.previous != null && currentFirst.previous != null)
				{
					currentFirst = currentFirst.previous;
					currentSecond = currentSecond.previous;
				}
				else if (currentSecond.previous == null && currentFirst.previous == null)
				{
					return add;
				}
			}		
		}
		return add;
	}
	/**
	 * Calculates the result of this infinite integer subtracted by anInfiniteInteger
	 * @param anInfiniteInteger the infinite integer to subtract.
	 * @return a NEW infinite integer representing the result of this
	 * infinite integer subtracted by anInfiniteInteger
	 */
	public InfiniteIntegerInterface minus(final InfiniteIntegerInterface anInfiniteInteger)
	{
		LInfiniteInteger fuckbitches = (LInfiniteInteger) anInfiniteInteger;
		LInfiniteInteger result = new LInfiniteInteger();//with a firstNode = null
		int Blah= this.getNumberOfDigits();
		if (Blah>fuckbitches.getNumberOfDigits())
		{
			Blah = fuckbitches.getNumberOfDigits();
		}
		if (this.compareValue(fuckbitches)==-1)
		{
			if (this.isNegative() == false && fuckbitches.isNegative() == false )
			{
				result = subPositive(fuckbitches,this, Blah);
				result.firstNode.negative = true;
			}
			else if (this.isNegative() == true && fuckbitches.isNegative() == false)
			{
				result = addPositive(this,fuckbitches,Blah);
				result.firstNode.negative = true;
			}
			else if (this.isNegative() == false && fuckbitches.isNegative() == true)
			{
				result = addPositive(fuckbitches,this, Blah);
				result.firstNode.negative = false;
			}
			else if (this.isNegative()== true && fuckbitches.isNegative() == true)
			{
				result = subPositive( fuckbitches, this, Blah);
				result.firstNode.negative = false;
			}
		}
		else if (this.compareValue(fuckbitches)==0)
		{
			if (this.isNegative() == false && fuckbitches.isNegative() == false )
			{
				result = new LInfiniteInteger("0");
			}
			else if (this.isNegative() == true && fuckbitches.isNegative() == false)
			{
				result = addPositive(this, fuckbitches, Blah);
				result.firstNode.negative = true;
			}
			else if (this.isNegative() == false && fuckbitches.isNegative() == true)
			{
				result = addPositive(this, fuckbitches, Blah);
				result.firstNode.negative = false;
			}
			else if (this.isNegative()== true && fuckbitches.isNegative() == true)
			{
				result = new LInfiniteInteger("0");
			}
		}
		else if (this.compareValue(fuckbitches)==1)
		{
			if (this.isNegative() == false && fuckbitches.isNegative() == false )
			{
				result = subPositive(this,fuckbitches, Blah);
				result.firstNode.negative = false;
			}
			else if (this.isNegative() == true && fuckbitches.isNegative() == false)
			{
				result = addPositive(this, fuckbitches, Blah);
				result.firstNode.negative = true;
			}
			else if (this.isNegative() == false && fuckbitches.isNegative() == true)
			{
				result = addPositive(this, fuckbitches,Blah);
				result.firstNode.negative = false;
			}
			else if (this.isNegative()== true && fuckbitches.isNegative() == true)
			{
				result = subPositive(this, fuckbitches, Blah);
				result.firstNode.negative = true;
			}
		}
		return result;
	}
	public LInfiniteInteger subPositive(LInfiniteInteger first, LInfiniteInteger second, int smallerNum)
	{
		LInfiniteInteger sub = new LInfiniteInteger(first.toString());
		LInfiniteInteger zero = new LInfiniteInteger("0");
		int carry = 0;
		int subMe = 0 ;
		Node currentFirst = first.lastNode;
		Node currentSecond = second.lastNode;
		Node subMover = sub.lastNode;
		Node newNode;
		int difference = 0;
		if (first.compareValue(zero) == 0)
		{
			sub = second;
			sub.firstNode.negative = true;
			return sub;
		}
		else if (second.compareValue(zero) == 0)
		{
			sub = first;
			sub.firstNode.negative = false;
			return sub;
		}
		carry = 0;
		
		for (int i = 0; i < smallerNum ; i++) 
		{
			subMe = (currentFirst.data + carry) - currentSecond.data;
			if (subMe >= 0)
			{
				subMover.data = (currentFirst.data + carry) - currentSecond.data;
				carry = 0;
				if(subMover.previous == null)
				{
					newNode = new Node(carry);
					newNode.next = subMover;
					subMover.previous = newNode;
					subMover = newNode;
				}
				else
				{
					subMover = subMover.previous;
					subMover.data = subMover.data + carry;
				}
			}
			else if (subMe < 0 )
			{
				subMe = currentFirst.data + 10 + carry;
				subMover.data = subMe - currentSecond.data;
				carry = -1;
				if(subMover.previous == null)
				{
					newNode = new Node(0);
					newNode.next = subMover;
					subMover.previous = newNode;
					subMover = newNode;
					//sub.firstNode = newNode;
				}
				else
				{
					subMover = subMover.previous;
					subMover.data = subMover.data + carry;
				}
			}
			if (currentSecond.previous!= null)
			{
				currentSecond = currentSecond.previous;
			}
			currentFirst = currentFirst.previous;
		}
		if (sub.firstNode.data == 0)
		{
			sub.firstNode = sub.firstNode.next;
		}
		difference = first.getNumberOfDigits() - second.getNumberOfDigits();
		for (int s = 0; s < difference; s++)
		{
			subMe = currentFirst.data + carry;
			subMover.data = subMe;
			carry = 0;
			
			if(currentFirst.previous != null)
			{
				newNode = new Node(carry);
				newNode.next = subMover;
				subMover.previous = newNode;
				subMover = newNode;
				currentFirst = currentFirst.previous;
				
			}
			sub.firstNode = subMover;
		}
		return sub;
	}
	/**
	 * Generates a string representing this infinite integer. If this infinite integer
	 * is a negative number a minus symbol should be in the front of numbers. For example,
	 * "-12345678901234567890". But if the infinite integer is a positive number, no symbol
	 * should be in the front of the numbers (e.g., "12345678901234567890").
	 * @return a string representing this infinite integer number.
	 */
	public String toString()
	{
		Node currentNode = firstNode;
		String result ="";
		if(firstNode.negative == true)
		{
			result = "-";
		}
		else if (firstNode.negative == false)
		{
			result = "";
		}
		while(currentNode != null)
		{
			result = result + currentNode.data;
			currentNode = currentNode.next;
		}
		return result;
	}
	public int compareValue(LInfiniteInteger compare)
	{
		int returnVal = 0;
		if(this.getNumberOfDigits() < compare.getNumberOfDigits())
		{
			returnVal = -1;
		}
		else if(this.getNumberOfDigits() > compare.getNumberOfDigits())
		{
			returnVal = 1;
		}
		Node currentThis = this.firstNode;
		Node currentInfinite = compare.firstNode;
		for (int i =0; i < this.getNumberOfDigits(); i++)
		{
			if(currentThis == null || currentInfinite == null)
			{
				return 0;
			}
			if (currentThis.data == currentInfinite.data)
			{
				currentThis = currentThis.next;
				currentInfinite = currentInfinite.next;
			}
			else if (currentThis.data < currentInfinite.data)
			{
				returnVal = -1;
				return returnVal;
			}
			else if (currentThis.data > currentInfinite.data)
			{
				returnVal = 1;
				return returnVal;
			}
		}
		return returnVal;
	}
	/**
	 * Compares this infinite integer with anInfiniteInteger
	 * @return either -1, 0, or 1 as follows:
	 * If this infinite integer is less than anInfiniteInteger, return -1.
	 * If this infinite integer is equal to anInfiniteInteger, return 0.
	 * If this infinite integer is greater than anInfiniteInteger, return 1.
	 */
	public int compareTo(InfiniteIntegerInterface anInfiniteInteger)
	{
		LInfiniteInteger fuckbitches = (LInfiniteInteger) anInfiniteInteger;

		int returnVal = 0;
		if (this.isNegative() == true && fuckbitches.isNegative() == false)
		{
			returnVal = -1;
		}
		else if (this.isNegative()  ==false && fuckbitches.isNegative()  == true)
		{
			returnVal = 1;
		}
		else 
		{
			returnVal = this.compareValue(fuckbitches);
		}
		return returnVal;
	}
	public Node getFirstNode()
	{
		return firstNode;
	}
	/**
	 * Calculates the result of this infinite integer multiplied by anInfiniteInteger
	 * @param anInfiniteInteger the multiplier.
	 * @return a NEW infinite integer representing the result of this
	 * infinite integer multiplied by anInfiniteInteger.
	 */
	public InfiniteIntegerInterface multiply(final InfiniteIntegerInterface anInfiniteInteger)
	{
		LInfiniteInteger cast = (LInfiniteInteger) anInfiniteInteger;
		LInfiniteInteger result = new LInfiniteInteger();
		LInfiniteInteger zero = new LInfiniteInteger("0");
		int first= this.getNumberOfDigits();
		int second = cast.getNumberOfDigits();
		if (this.compareTo(zero) == 0||cast.compareTo(zero) == 0)
		{
			return zero;
		}
		if(this.compareValue(cast) == 1 )
		{
			result = multi(this, cast, first, second);
		}
		else
		{
			result = multi(cast, this, second, first );
		}
		if ((this.isNegative() == false && cast.isNegative() == true)||(this.isNegative() == true && cast.isNegative() == false))
		{
			result.firstNode.negative = true;
		}
		else 
		{
			result.firstNode.negative = false;
		}
		return result;
	}
	public LInfiniteInteger multi (LInfiniteInteger multiplicant, LInfiniteInteger multiplier, int bigger, int smaller)
	{
		LInfiniteInteger result = new LInfiniteInteger();
		Node newNode;
		Node currentMultiplier = multiplier.lastNode;
		Node currentMultiplicant;
		Node cock = result.lastNode;
		int count = 0;
		for (int i = 0; i<smaller; i++)
		{
			int carry = 0;
			currentMultiplicant = multiplicant.lastNode;
			for (int j = 0; j<bigger; j ++)
			{
				int mult = (currentMultiplier.data * currentMultiplicant.data) + cock.data ;//+ result.firstNode.data;
				if (mult >= 10)
				{
					String whatever = Integer.toString(mult);
					mult = Integer.parseInt(whatever.substring(1));
					carry = Integer.parseInt(whatever.substring(0,1));
					cock.data = mult;
					if (cock.previous == null)
					{
						Node tempNode = new Node(carry);
						tempNode.next = cock;
						cock.previous = tempNode;
						cock = tempNode;
					}
					else
					{
						cock = cock.previous;
						cock.data = cock.data + carry;
					}
				}
				else if (mult <10)
				{
					cock.data = mult;
					carry = 0;
					if (cock.previous == null)
					{
						Node tempNode = new Node(carry);
						tempNode.next = cock;
						cock.previous = tempNode;
						cock = tempNode;
					}
					else
					{
						cock = cock.previous;
						cock.data = cock.data + carry;
					}
				}
				result.firstNode = cock;
				currentMultiplicant = currentMultiplicant.previous;
			}
			count++;
			currentMultiplier = currentMultiplier.previous;
			cock = result.lastNode;
			for(int d = 0; d < count; d++)
			{
				cock = cock.previous;
			}
		}
		if(result.firstNode.data == 0)
		{
			result.firstNode = result.firstNode.next;
		}
		return result;
	}
	private class Node
	{
		private int data;
		private Node next;
		private Node previous;
		private boolean negative;
		
		private Node(Node previousNode, int aData, Node nextNode)
		{
			previous = previousNode;
			data = aData;
			next = nextNode;

		}
		
		private Node(int aData)
		{
			this(null, aData, null);
		}
	}
}
