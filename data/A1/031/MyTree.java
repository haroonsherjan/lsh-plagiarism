/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				// is the city safe?
    int rootVal;
	int leftChildIndex;		  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // ...
	public MyNode(int root){
		//initialises tree node with item and no children.
		rootVal = root;
		leftChildIndex = -1;
		rightChildIndex= -1;
	}
	public MyNode(int root ,int left,int right){
		//initialises tree node with item and the left and right children references.
		rootVal = root;
		leftChildIndex = left;
		rightChildIndex = right;
	}
	public int getRoot(){
		//Return the isSafe value
		return rootVal;
	}
	public void setRoot(int root){
		//Sets the isSafe value to a new value.
		rootVal = root;
	}
	public int getLeft(){
		//Return the left child.
		return leftChildIndex;
	}
	public void setLeft(int left){
		//Sete the leftChildIndex to a new value
		leftChildIndex = left;
	}
	public int getRight(){
		//Return the right child.
		return rightChildIndex;
	}
	public void setRight(int right){
		//sets the rightChildIndex to a new value.
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
    //private final int MAX_NODES = 1000;
    //MyNode[] myTree = new MyNode[MAX_NODES];
    
	protected MyNode root;
	int size = 0;	// make sure to update this variable as needed

    // fill in your ADT methods here
	public MyTree(int root){
		root=0;
	}
	public MyTree(int rootItem,int leftTree,int rightTree){
		root= new MyNode(rootItem,-1,-1);
		//attachedLeftSubTree(leftTree);
		//attachedRightSubTree(rightTree);
	}
	public void setRootItem(int newRoot){
		if(root!=null){
			root.setRoot(newRoot);
		}
		else{
			root = new MyNode(newRoot,-1,-1);
		}
	}
	public boolean isEmpty(){
		//check if tree is empty.
		return root == null;
	}

}
