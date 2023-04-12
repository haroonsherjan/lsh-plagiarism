/** Class for a tree node
 */

 /*
NOT using 

class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // ...
}

*/

/** Class for a binary tree ADT
 */
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

    //private final int MAX_NODES = 1000;
    private int[] myTree;
    //int size = 0;	// make sure to update this variable as needed
	
	//constructor to build the tree from an input array
    public MyTree(int[] arr) {
		//array size of the tree is 1 + arr.length because root is always 0
		this.myTree = new int[arr.length + 1];
		this.myTree[0] = 0; 		//set the root to zero
		//copy contents of array input to myTree
		for (int i=0; i<arr.length; i++) {
			this.myTree[i+1] = arr[i];
		}
	} //end constructor
	
	//method which takes in 2 integers to check for the relationship
	//between them
	public String checkRelation(int a, int b) {
		if (isLeftSibling(a,b)) {
			return "LEFT SIBLING";
		}
		if (isRightSibling(a,b)) {
			return "RIGHT SIBLING";
		}
		if (isAncestor(a,b)) {
			return "ANCESTOR";
		}
		if (isDescendent(a,b)) {
			return "DESCENDENT";
		}
		//a and b have failed the 4 possible cases so there
		//is no relationship between them
		return "NONE";
	}//end checkRelation

	private boolean isLeftSibling(int a, int b) {
		// a is the left sibling of b
		// a has to be at odd index position and b has to 
		// be at the position  right next to a
		int indexA = getIndex(a);
		return (indexA%2 == 1) && (this.myTree[indexA+1] == b);
	}

	private boolean isRightSibling(int a, int b) {
		//a is the right sibling of b
		// a has to be at even index position and 
		// b has to be at the position to the left of a
		int indexA = getIndex(a);
		return (indexA%2 == 0) && (this.myTree[indexA-1] == b);
	}
	
	private boolean isAncestor(int a, int b) {
		//a is the ancestor of b
		// find the index of b and keep looking for b's ancestors
		//through the formula parent = (i-1)/2
		int indexB = getIndex(b);
		int parent = (indexB-1) / 2;			//the index of b's parent
		while(parent >=0) {
			if (this.myTree[parent] == a) {
				return true;
			}
			parent = (parent-1)/2;
		}
		//else a is not the ancestor of b
		return false;
	}

	private boolean isDescendent(int a,int b) {
		// a is the descendent of b
		// find the index of b and keep looking for b's children
		// using left child = 2i +1 and right child = 2i+2
		int indexB = getIndex(b);
		//use recursion by calling another method
		return isDescHelp(a, indexB);
	}
	private boolean isDescHelp(int a, int index) {
		if (index > this.myTree.length) {
			//out of array/tree already
			//base case
			return false;
		} else if (this.myTree[index] == a) {
			// a is the descendent of b
			return true;
		} else {
			//search both left and right childs
			//if its found there would be one true
			//else if not found all would return false by going out of index
			return isDescHelp(a, 2*index+1) || isDescHelp(a, 2*index+2);
		}
	}

	//use a linear search to determine the index position of the node
	private int getIndex(int node) {
		for (int i=0; i<this.myTree.length; i++) {
			if (this.myTree[i] == node) {
				return i;
			}
		}
		//else its not in the tree just return -1
		//the query would not refernce not-existing nodes anyway
		return -1;
	}
}//end MyTree
