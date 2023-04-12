/*
 * This is a Java program that uses a Tree ADT to store and check if a path between two cities is safe
 */

class MyNode
{
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    public MyNode(boolean isSafe)
	{
		this.isSafe = isSafe; //set the value of isSafe
		leftChildIndex = -2; //set temporary value for left index
		rightchildIndex = -2; //set temporary value for right index
	} //close constructor

	public void setIndexes(int left, int right) //setty function for indexes
	{ 
		leftChildIndex = left; //sets value for left index
		rightChildIndex = right; //sets value for right index
	} //close setIndexes()

	public int getLeft() //getty function for left value
	{
		return leftChildIndex;
	} //close getLeft()

	public int getRight() //getty function for right value
	{
		return rightChildIndex;
	} //close getRight()

	public boolean getSafe()
	{
		return isSafe;
	}

} //close Class MyNode

/** Class for a binary tree ADT
 */

public class MyTree 
{
    private final int MAX_NODES = 1000; //set maximum number of cities
    MyNode[] myTree; //declares an array of MyNode
    int size = 0;	//number of cities and also used to know the next free position in the array
	int root;  //creates a storage for the root position

	public MyTree() //constructor
	{
		root = 0; //root is always 0
		myTree = newMyNode[MAX_NODES]; //creates the array myTree
	} //close constructor

	public void insertBoolean(int safe, int node) //function to insert a new MyNode into MyTree
	{
		boolean safety;
		if(safe = 1)
		{
			safety = true;
		}
		else
		{
			safety = false;
		}

		myTree[node] = new MyNode(safety); //creates a new node with values from input
		size++; //increase the number of cities by one
	} //close insert

	public void insertIndexes(int node, int left, int right) //function to set the indexes for a root
	{
		myTree[node].setIndexes(left,right); //sets the values of left and right for node
	} //close insertIndexes()

	public int getSize() //getty function for size
	{
		return size; //returns value of size
	} //close getSize()

	public int getLeft(int node) //getty function for left of a node
	{
		return myTree[node].getLeft(); //returns left value of node
	} //close getLeft()

	public int getRight(int node) //getty function for right of a node
	{
		return myTree[node].getRight(); //returns right value of node
	} //close getRight()

	public boolean getSafe(int node)
	{
		return myTree[node].getSafe();
	}

} //close class MyTree
