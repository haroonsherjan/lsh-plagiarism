/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
   // boolean isSafe;				  // is the city safe?
   // int leftChildIndex;			  // left child index in array
   // int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // ...
}

/** Class for a binary tree ADT
 */
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

   // private final int MAX_NODES = 1000;
    //MyNode[] myTree = new MyNode[MAX_NODES];
    //int size = 0;	// make sure to update this variable as needed

    // fill in your ADT methods here
    
	
	
	// ...
	private int root;
	private int  leftChild;
	private int rightChild;

	public MyTree() {
	}//end default constructor

	public MyTree(int newItem) {
		//initialize tree node with root and no children\
		root = newItem;
		leftChild = -1;
		rightChild = -1;
	}//end constructor

	public MyTree(int newItem, int left, int right){
		//initialize tree node with root and left and right references
		root = newItem;
		leftChild = left;
		rightChild = right;
	}//end constructor

	public int getRoot() {
		//returns root field
		return root;
	}//end getRoot

	public void setRoot(int newItem) {
		// sets the root field to the new value newItem
		root = newItem;
	}//end setRoot

	public int getLeft() {
		//returns the reference to the left child
		return leftChild;
	}//end getLeft

	public int getRight() {
		// returns the reference to the right child
		return rightChild;
	}//end getRight

	public void setLeft(int left) {
		//sets the left child reference to the left
		leftChild = left;
	}// end setLeft

	public void setRight(int right) {
		//sets the right child reference to the right
		rightChild = right;
	}//end setRight




}
