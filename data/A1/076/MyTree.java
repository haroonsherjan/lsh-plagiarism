/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe=true;				  // is the city safe?
    int leftChildIndex=-1;			  // left child index in array
    int rightChildIndex=-1;		 // right child index in array

    public MyNode(){}
    // fill in your accessor and mutator methods here
    public void setSafe(int n){
		if (n==0) isSafe = false;
	}
	public boolean getSafe(){
		return isSafe;
	}
	public void setLeft(int index){
		leftChildIndex = index;
	}
	public int getLeft(){
		return leftChildIndex;
	}
	public void setRight(int index){
		rightChildIndex = index;
	}
	public int getRight(){
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

    public MyTree(){}
	public void buildCity(MyNode city){
		myTree[size] = city;
		size++;
	}
	public boolean safeRoute(int A, int B){
		if (A == B && myTree[A].getSafe())
			return true;

	}
}
