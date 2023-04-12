/**
  Class for a tree node
 */
class MyNode 
{
    int isSafe;// is the city safe?
	int parent;
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    public MyNode()
	{
		parent = -1;
	}

	public int getSafety()
	{
		return isSafe;
	}

	public int getLeft()
	{
		return leftChildIndex;
	}

	public int getRight()
	{
		return rightChildIndex;
	}

	public void setSafety(int n)
	{
		isSafe = n;
	}

	public void setLeft(int n)
	{
		leftChildIndex = n;
	}

	public void setRight(int n)
	{
		rightChildIndex = n;
	}

	public int getParent()
	{
		return parent;
	}

	public void setParent(int n)
	{
		parent = n;
	}
}


/** 
  Class for a binary tree ADT
 */
public class MyTree 
{
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.
    MyNode[] myTree;
    int size = 0;	// make sure to update this variable as needed

    public MyTree(int capacity)
	{
		myTree = new MyNode[capacity];
		for (int i = 0; i < capacity; i++)
			myTree[i] = new MyNode();
	}

	public MyNode getTreeNode(int index)
	{
		return myTree[index];
	}
    
	private void backRoute(int index1, int index2, State state, boolean f)
	{
		if (index1 != -1 && f)
		{
		    if (index1 == index2)
			{
				f = false;
			    state.setCounterAnotherIndex();
			}
			if (f)
			{
	            if (getTreeNode(index1).getSafety() == 0)
			        state.setCounterUnsafeCity();
		        backRoute(getTreeNode(index1).getParent(), index2, state, f);
			}
		}
	}
		
	public boolean isSafe(int index1, int index2)
	{
		if (getTreeNode(index1).getSafety() == 0)
			return false;
	    else if (getTreeNode(index2).getSafety() == 0)
			return false;
	    else
		{
			State state1 = new State();
			State state2 = new State();
			backRoute(index1, index2, state1, true);
            backRoute(index2, index1, state2, true);
			if (state1.counterUnsafeCity() == false &&
			    state2.counterUnsafeCity() == false)
				return true;
		    else if (state1.counterUnsafeCity() == true &&
				     state2.counterUnsafeCity() == true)
				return false;
		    else if (state1.counterUnsafeCity() == true &&
				     state2.counterUnsafeCity() == false &&
					 state2.counterAnotherCity() == true)
				return true;
			else if (state2.counterUnsafeCity() == true &&
				     state1.counterUnsafeCity() == false &&
					 state1.counterAnotherCity() == true)
				return true;
		    else
				return false;
		}
	}

        


    // fill in your ADT methods here
    // ...
}

class State
{
	boolean counterAnotherIndex = false;
	boolean counterUnsafeCity = false;

	public State()
	{}

	public boolean counterAnotherCity()
	{
		return counterAnotherIndex;
	}

	public boolean counterUnsafeCity()
	{
		return counterUnsafeCity;
	}

	public void setCounterAnotherIndex()
	{
		counterAnotherIndex = true;
	}

	public void setCounterUnsafeCity()
	{
		counterUnsafeCity = true;
	}
}


