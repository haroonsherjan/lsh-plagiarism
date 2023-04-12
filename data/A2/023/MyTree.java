/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
   	int item;
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // ...

	public int getItem()
	{
		return item;
	}
	public void setItem(int i)
	{
		item = i;
	}

	public int getLeftChild()
	{
		return leftChildIndex;
	}
	public int getRightChild()
	{
		return rightChildIndex;
	}
	public void setLeftChild(int c)
	{
		leftChildIndex = c;
	}
	public void setRightChild(int c)
	{
		rightChildIndex = c;
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

    // fill in your ADT methods here
    // ...

}
