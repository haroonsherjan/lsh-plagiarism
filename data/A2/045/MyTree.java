/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	int num;		//The number of the node

	//Constructor	
	MyNode(int num, int leftChild, int rightChild) {
		this.num = num; 
		leftChildIndex = leftChild;
		rightChildIndex = rightChild;
	}

	//printing out the node - for debugging
	public void printNode(){
		System.out.print("" + num + " " + leftChildIndex + " " + rightChildIndex);
	}
	
	//this method returns true if the specified node is my parent
	//it checks for the specified node's children index if it is equal to my number
	public boolean isMyParent(MyNode node) {
		if(node.leftChildIndex == num || node.rightChildIndex == num)
			return true;
		else
			return false;
	}

	//this method returns false if the specifid node is my child
	//it checks if the node's num is in one of my children index
	public boolean isMyChild(MyNode node) {
		if (node.num == leftChildIndex || node.num == rightChildIndex)
			return true;
		else
			return false;
	}
	
	//this method returns the num of the node
	public int getNum() {
		return num;
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
	

    //this method inserts a node into the tree
	public void insert(int num, int leftChild, int rightChild) {
		myTree[size] = new MyNode(num, leftChild, rightChild);
		size++;
	}
	
	//accessor for a node in the tree
	public MyNode getNode(int i){
		return myTree[i];
	}
	
	//this method searches through the whole array to look who has data as one of its children index
	public MyNode getParent(int data) {
		for(int i = 0; i< size ;i++) {
			if(myTree[i].leftChildIndex == data || myTree[i].rightChildIndex == data)
				return myTree[i];
		}
		return null;
	}
	
	//I GOT NO TIME TO TEST THIS METHOD!!!
	//this method returns 1 is it is a left sibliing, and 2 if right. 0 is neither
	public int checkSibling(int data1, int data2) {
		MyNode parent = getParent(data1);
		if(parent.isMyChild(myTree[data2]))
			return 1;
		else if(parent.isMyChild(myTree[data2]))
			return 2;
		else 
			return 0;
	}

	//helper method for printing out the tree for debugging purposes
 	public void printTree(){
		for(int i = 0; i< size ; i++) {
			myTree[i].printNode();
			System.out.println();
		}
	}
}
