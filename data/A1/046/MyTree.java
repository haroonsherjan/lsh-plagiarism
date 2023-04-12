/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
	int city;
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // ...

	public MyNode() //default constructor
	{
	}

//***********************************************************	

	public MyNode(int cityNumber)
	{
		this.city = cityNumber;
	}

//***********************************************************
	
	public void setCity(int city)
	{
		this.city = city;
	}

//***********************************************************	

	public void setIsSafe(int x)
	{
		if (x == 1)
		{
			this.isSafe = true;
		}

		else
		{
			this.isSafe = false;
		}
	}
//***********************************************************
	
	public void setLeftChildIndex(int index)
	{
		this.leftChildIndex = index;
	}

//***********************************************************

	public void setRightChildIndex(int index)
	{
		this.rightChildIndex= index;
	}

//***********************************************************
	
	public int getCity()
	{
		return this.city;
	}

//***********************************************************

	public boolean getIsSafe()
	{
		return this.isSafe;
	}

//***********************************************************

	public int getLeftChildIndex()
	{
		return this.leftChildIndex;
	}

//***********************************************************	

	public int getRightChildIndex()
	{
		return this.rightChildIndex;
	}

//***********************************************************

}//end of class MyNode

