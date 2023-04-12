/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
	int item;
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // Assessor
	public int getItem(){
		return item;
		}
	public int getLeft(){
		return leftChildIndex;
		}
	public int getRight(){
		return rightChildIndex;
		}
	//Mutator
	public void setItem(int newItem){
		item = newItem;
		}
	public void setLeft(int left){
		leftChildIndex = left;
		}
	public void setRight(int right){
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
	MyNode root;

    // fill in your ADT methods here
    // constructor
	public MyTree(int size){
		root = myTree[0];
		this.size = size;
		}

	//Read Node
	public void readNode(int index, int newItem){
		myTree[index].setItem(newItem);
		}

	//Create new Child
	public void attachLeft(int leftIndex){
		if(root != null){
			for(int i=0; i<size; i++){
				myTree[i].setLeft(leftIndex);
				}
			}
		}
	public void attachRight(int rightIndex){
		if(root != null){
			for(int i=0; i<size; i++){
				myTree[i].setRight(rightIndex);
				}
			}
		}
}
