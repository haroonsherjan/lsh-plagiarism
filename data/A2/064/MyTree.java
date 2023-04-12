/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
    int left;
	int right;

    // fill in your accessor and mutator methods here
	public int getLeft() {
		return left;
	}
	public int getRight() {
		return right;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public void setRight(int right) {
		this.right = right;
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
	int root;

    // fill in your ADT methods here
	public MyTree() {
		root = 0;
	}
	
	private void insert (int left, int right)
	{
		for (int i=1; i<=myTree.length; i=i+2)
		{
			myTree[i].setLeft(left);
		}

		for (int i=2; i<=myTree.length; i=i+2)
		{
			myTree[i].setRight(right);
		}

	}

	private void query (int left, int right)
	{
		if (myTree[right] == myTree[2*left+1])
		{
			System.out.println("LEFT SIBLING");
		}

		else if (myTree[right] == myTree[(left-1)/2])
		{
			System.out.println("DESCENDANT");
		}
		
		else if (myTree[left] == myTree[(right-1)/2])
		{
			System.out.println("ANCESTOR");
		}

		else if (myTree[left] == myTree[2*right+1])
		{
			System.out.println("RIGHT SIBLING");
		}

		else
		{
			System.out.println("NONE");
		}
	}
}
