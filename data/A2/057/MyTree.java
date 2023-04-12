/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	int value;					// value of the node in array
	int index;				   // index of nodes in array
    // fill in your accessor and mutator methods here
    // ...
	//constructor
	public MyNode(int value)
	{
		this.value = value;
	}
	// mutator method to set value of node
	public void setValue(int value)
	{
		this.value = value;
	}
	// accessor to get value of node
	public int getValue()
	{
		return value;
	}
	// mutator method to set Index
	public void setIndex(int index)
	{
		this.index = index;
	}
	// accessor to get value of node
	public int getIndex()
	{
		return index;
	}
	// mutator method to set left Child Index
	public void setleftChildIndex(int leftChildIndex)
	{
		this.leftChildIndex = leftChildIndex;
	}
	// accessor method to get left Child Index
	public int getleftChildIndex()
	{
		return leftChildIndex;
	}
	// mutator method to set right Child Index
	public void setrightChildIndex(int rightChildIndex)
	{
		this.rightChildIndex = rightChildIndex;
	}
	// accessor method to get right Child Index
	public int getrightChildIndex()
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
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed
	int root = 0;	// root is always 0
	int count = 0;  // for indexing
	String s = "";  // to store msg of relationship
    //default class constructor
	public MyTree()
	{}
	// fill in your ADT methods here
    // ...
	// insert method
	public void insert(int value)
	{
		// creates a new node of root value 0
		// root is always 0 in this case
		// and update the filled size of the array by 1;
		if(myTree[0] == null)
		{
			myTree[0] = new MyNode(root);
			size = 1;
		}
		// if the root is 0, moves on to the next
		// space in the array and creates the new node
		// & value, update the size after that
		myTree[size] = new MyNode(value);
		size++;
	}
	// finds the index position of the value in the array
	public int position(int nodeValue)
	{
		// calls indexing method to calculate the index
		indexing();
		return position(nodeValue, 0);
	}
	private int position(int nodeValue, int loc)
	{
		// if any of this conditions happen, it would nt be possible to find the position
		// this, return -1
		if(myTree == null || loc >= myTree.length || myTree[loc] == null)
		{
			return -1;
		}
		// if there is a match in value, return
		else if(myTree[loc].getValue() == nodeValue)
		{		
			return myTree[loc].getIndex();
		}
		return -1;
	}
	// calculates the indexing
	private void indexing()
	{
		count = 1;
		indexing(0);
	}
	private void indexing(int loc)
	{
		if(myTree == null || loc >= myTree.length || myTree[loc] == null)
		{
			return;
		}
		indexing(loc*2+1);
		myTree[loc].setIndex(count);
		count++;
		indexing(loc*2+2);
	}
	// checks the position of the 2 values
	// if either 1 is -1, returns NONE
	// 
	public String check(int c, int d)
	{
		int cc = position(c);
		int dd = position(d);
		if(cc == -1 || dd == -1)
		{
		String s = "ANCESTOR";
		}
	return s;
	}
}
