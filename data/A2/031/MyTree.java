/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	
	public MyNode(int left, int right)
	{
		leftChildIndex = left;
		rightChildIndex = right;
	}

	public int getLeftChildIndex()
	{
		return leftChildIndex;
	}	

	public void setLeftChild(int left)
	{
		leftChildIndex = left;
	}

	public int getRightChildIndex()
	{
		return rightChildIndex;
	}

	public void setRightChild(int right)
	{
		rightChildIndex = right;
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

    public MyTree()
	{	
	}
	
	public void addNode(MyNode node,int index)
	{
		myTree[index] = node;
		size++;
	}

	public MyNode getNode(int index)
	{
		return myTree[index];
	}

	public String compareRelationShip(int elementA, int elementB)
	{	
		//corresponding nodes with elements
		MyNode nodeA = myTree[elementA];
		MyNode nodeB = myTree[elementB];
		
		return "NONE";
	}
}
