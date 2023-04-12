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
	public MyNode(){
	}

	public MyNode(boolean isSafe){
		this.isSafe = isSafe;
		leftChildIndex = -1;
		rightChildIndex = -1;
	}

	public MyNode(boolean isSafe, int left, int right){
		this.isSafe = isSafe;
		leftChildIndex = left;
		rightChildIndex = right;
	}
	
	public boolean getSafe(){
		return isSafe;
	}

	public int getLeft(){
		return leftChildIndex;
	}

	public int getRight(){
		return rightChildIndex;
	}

	public void setSafe(boolean isSafe){
		this.isSafe = isSafe;
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

    // fill in your ADT methods here
    // ...
	public MyTree(){}
	
	public MyNode getNode(int index){
		return myTree[index];
	}

	public void setNode(int index, MyNode myNode){
		myTree[index] = myNode;
	}
	
	public void setSize(int newSize){
		size = newSize;
	}

	public void setSafe(int index, boolean isSafe){
		myTree[index].setSafe(isSafe);
	}

	public void setChild(int index, int left, int right){
		myTree[index].setLeft(left);
		myTree[index].setRight(right);
	}

	public int findAn(int myNode){
		// find its ancestor
		for(int i=0; i<size; i++){
			if(myTree[i].getLeft() == myNode || myTree[i].getRight() == myNode)
				return i;
		}
		return -1;
	}
		
	
}
