/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // ...
}

/** Class for a binary tree ADT
 */
public class MyTree 
{
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.
	/*
    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
	int size = 0;	// make sure to update this variable as needed
	*/
	private MyTree leftChild, rightChild;
	private int cityState, cityNum;

    // fill in your ADT methods here
    // ...

	// Constructor
	public MyTree()
	{
		leftChild = null;
		rightChild = null;
	}

	// Methods
	public String query(MyTree myTree, int startCity, int endCity)
	{
		if (myTree.getCityNum() != startCity)
		{
			myTree.query(myTree.getLeft(), startCity, endCity);
			myTree.query(myTree.getRight(), startCity, endCity);
			return "YES";
		}
		return "NO";
	}

	// Accessors and Mutators
	public void setLeft(MyTree myTree)
	{
		leftChild = myTree;
	}

	public MyTree getLeft()
	{
		return leftChild;
	}

	public void setRight(MyTree myTree)
	{
		rightChild = myTree;
	}

	public MyTree getRight()
	{
		return rightChild;
	}

	public void setCityState(int num)
	{
		cityState = num;
	}

	public int getCityState()
	{
		return cityState;
	}

	public int getCityNum()
	{
		return cityNum;
	}

	public void setCityNum(int num)
	{
		cityNum = num;
	}
}
