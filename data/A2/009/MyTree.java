/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		  // right child index in array
	int label;                    // label of the node

    // constructor
	public MyNode(int value) {
		label = value;
	}
    
	// mutators
	public void setLabel(int value) {
		label = value;
	}

	public void setLeftChild (int left) {
		leftChildIndex = left;
	}

	public void setRightChild (int right) {
		rightChildIndex = right;
	}

	// accessors

	public int getLabel() {
		return label;
	}

	public int getLeftChildIndex () {
		return leftChildIndex;
	}

	public int getRightChildIndex() {
		return rightChildIndex;
	}

}//end MyNode

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
    int count = 0;   // to count the nodes traversed

    // fill in your ADT methods here
    // ...

	public void MyTree() {
		myTree[0] = new MyNode(0);
		size = 1;
	}

	public void insert(int label, int leftChild, int rightChild) {
		if (myTree == null) {
			myTree = new MyNode[MAX_NODES];
			myTree[1] = new MyNode(0);
		}

		else {
			while (count <= size) {
				if (myTree[count].getLabel() == label) {
					
					// if there are 2 children for node
					if (leftChild != -1 && rightChild != -1) {
						insert (leftChild, count * 2 + 1);
					    insert (rightChild, count * 2 + 2);
					    count = size;
					}

					// if only left child
					else if (rightChild == -1 && leftChild != -1) {
						insert (leftChild, count * 2 + 1);
					}

					// if only right child
					else if (rightChild != -1 && leftChild == 1) {
						insert (rightChild, count * 2 + 2);
					}

					// no children then nothing is done

				}//end if
			}//end while
		}//end else
	}//end insert

	public void insert(int value, int location) {
		myTree[location] = new MyNode(value);
		size++;
	}

	public String relationship(int firstNode, int secondNode) {
		
		String relation;

		// if left sibling, difference in location should be -1
		
		if (myTree[firstNode].getLabel() < myTree[secondNode].getLabel()) {
			
			// if left sibling, difference in location should be 1
			// and belonging to same parent
			if (myTree[secondNode].getLabel() - myTree[firstNode].getLabel() == 1 && 
				(myTree[secondNode].getLabel()-2)/2 == (myTree[firstNode].getLabel()-1)/2) {
				relation = "LEFT SIBLING";
			    return relation;
			}

			else if ( (myTree[secondNode].getLabel()-1)/2 == myTree[firstNode].getLabel()) {
				relation = "ANCESTOR";
				return relation;
			}

			else {
				relation = "NONE";
				return relation;
			}	
		}

		else {

			// if right sibling, difference in location should be 1
			// and belonging to same parent
			if (myTree[firstNode].getLabel() - myTree[secondNode].getLabel() == 1 &&
			    (myTree[firstNode].getLabel()-2)/2 == (myTree[secondNode].getLabel()-1)/2) {
				relation = "RIGHT SIBLING";
				return relation;
			}

			else {
				relation = "NONE";
				return relation;
			}
		}
	}
}
