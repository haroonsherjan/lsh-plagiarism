/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;          // right child index in array
	int parentIndex;              // parent index in array

	public MyNode() { //default constructor
	}

	public boolean getSafe() {

		return this.isSafe;
	}

	public int getLeft() {

		return this.leftChildIndex;
	}

	public int getRight() {

		return this.rightChildIndex;
	}

	public int getParent() {

		return this.parentIndex;
	}

	public void setSafe(int num) {

	    if(num == 1){
			isSafe = true;
		}
		else {
			isSafe = false;
		}
	}

    public void setLeft(int left) {

		this.leftChildIndex = left;
    }

	public void setRight(int right) {

		this.rightChildIndex = right;
    }

	public void setParent(int parent) {

		this.parentIndex = parent;
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

    public void add(int cityNum, int safeNum) { //update number of cities and its safty
       
	    myTree[cityNum] = new MyNode();
		myTree[cityNum].setSafe(safeNum);
		size ++;
	}

	public void updateChildren(int cityNum, int left, int right) { // update the left and right child of the city

	    myTree[cityNum].setLeft(left);
		myTree[cityNum].setRight(right);
    }

	public void updateParents() { // update parent of city

		for(int i = 0; i < size; i ++) {

			if(myTree[i].getLeft() != -1) {
                
				myTree[myTree[i].getLeft()].setParent(i);
			}

			if(myTree[i].getRight() != -1) {

				myTree[myTree[i].getRight()].setParent(i);
			}
      	}
	}

	public boolean determinSafety(int start, int end) { // determin if path is safe

		if(start == end){

			return true;
		}


		if (myTree[start].getParent() != -1) {

			if (myTree[start].getParent() == end) {

				return true;
			}

		    else if (myTree[myTree[start].getParent()].getSafe()){
				
				determinSafety(myTree[start].getParent(), end);
			}
		}
		            
		if (myTree[start].getLeft() != -1) {

			if (myTree[start].getLeft() == end) {

				return true;
			}
		    
		    else if (myTree[myTree[start].getLeft()].getSafe()){
				
				determinSafety(myTree[start].getLeft(), end);
			}
		}

		if (myTree[start].getRight() != -1) {

			if (myTree[start].getRight() == end) {

				return true;
			}
				
		    else if (myTree[myTree[start].getRight()].getSafe()){
				determinSafety(myTree[start].getRight(), end);
			}
		}
		return false;
    }

}

