import java.util.*;

/** Class for a tree node
 */
class MyNode {
	// You may use this class if you'd like.  It may help you if you use
	// an array based implementation of a binary tree

	// you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
    int item;
    
    public MyNode(int item,int leftIndex,int rightIndex)
    {
    	this.item = item;
    	this.leftChildIndex = leftIndex;
    	this.rightChildIndex = rightIndex;
    }
    
    public int getItem()
    {
    	return item;
    }
    
    public int getLeftChildIndex()
    {
    	return leftChildIndex;
    }
    
    public int getRightChildIndex()
    {
    	return rightChildIndex;
    }
}

/** Class for a binary tree ADT
 */
public class MyTree {
	// You may want to use an array based implementation for 
	// your tree, or change this to another implementation

	// Note that this code and the driver code do not necessarily
	// match well -- you decide how you want these two parts to work
	// together.

	private final int MAX_NODES = 1000;
	ArrayList <MyNode> myTree;
	int size = 0;
	
	public MyTree()
	{
		myTree = new ArrayList <MyNode>();
		myTree.add(new MyNode(0,1,2));
		size++;
	}
	
	//adds item left and right into the tree
	public void add(int left, int right)
	{
		myTree.add(new MyNode(left,size*2+1,size*2 + 2));
		size++;
		myTree.add(new MyNode(right,size*2+1,size*2 + 2));
		size++;
	}
	
	//return the string describing the relationship of A to B
	public String relationship(int A, int B)
	{
		int indexOfB = 0;
		boolean isFound = false;
		
		//find where is B
		while(!isFound)
		{
			if(myTree.get(indexOfB).getItem() == B)
				isFound = true;
			else
				indexOfB++;
		}
		
		int indexOfA = 0;
		isFound = false;
		
		//find where is A
		while(!isFound)
		{
			if(myTree.get(indexOfA).getItem() == A)
				isFound = true;
			else
				indexOfA++;
		}
	
		if (isLeftSibling(indexOfA,indexOfB))
			return "LEFT SIBLING";
		else if(isRightSibling(indexOfA,indexOfB))
			return "RIGHT SIBLING";
		else if (isAncestor(indexOfA,indexOfB))
			return "ANCESTOR";
		else if (isChild(A,B))
			return "DESCENDANT";
		else
			return "NONE";
	}
	
	//return true if A is left of B
	private boolean isLeftSibling(int A,int B)
	{
		if(A+1 == B)
			return true;
		else
			return false;
	}
	
	//return true if A is right of B
	private boolean isRightSibling(int A,int B)
	{
		if(A-1 == B)
			return true;
		else
			return false;
	}
	
	public boolean isAncestor(int indexOfA,int indexOfB)
	{
		int itemA = myTree.get(indexOfA).getItem();
		
		//if A is root
		if(itemA == 0)
			return true;
		
		while(indexOfB > 0)
		{
			if(indexOfA == indexOfB)
				return true;
			else
				indexOfB = (indexOfB-1)/2;
		}
		return false;//if run over loop means item not linked
	}
	
	public boolean isChild(int indexOfA,int indexOfB)
	{
		int itemB = myTree.get(indexOfB).getItem();
		
		//if B is root
		if(itemB == 0)
			return true;
			
		while(indexOfA > 0)
		{
			if(myTree.get(indexOfA).getItem() == itemB)
				return true;
			else
				indexOfA = (indexOfA-1)/2;
		}
		return false;//if run over loop means item not linked
	}
}
