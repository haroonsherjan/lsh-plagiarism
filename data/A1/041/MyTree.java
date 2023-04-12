/** Class for a tree node
 */
class MyNode {

    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

	public void setIsSafe(int i) { // set according to number inputed
		if (i == 1) {
			this.isSafe = true;
		}
		else {
			this.isSafe = false;
		}
	}

	public void setLeft(int i) { //set to only setLeft for shorter code
	    this.leftChildIndex = i;
	}

    public void setRight(int i) {
		this.rightChildIndex = i;
	}

	public boolean getIsSafe() {
		return this.isSafe;
	}

	public int getLeft() {
		return this.leftChildIndex;
	}

	public int getRight() {
		return this.rightChildIndex;
	}
}

/** Class for a binary tree ADT
 */
public class MyTree {


    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed

    public MyTree(int size) {
		this.size = size;
	}

    public void insertIsSafe(int i,int safe) {
	    myTree[i].setIsSafe(safe);
	}

	public void insertLeft(int i, int left) {
		myTree[i].setLeft(left);
	}

	public void insertRight(int i, int right) {
		myTree[i].setRight(right);
	}

	public int travelFor(int city1, int city2) {
		if (!this.isSafe(city1)) {
			return 0;
		}
		if (myTree[city1].getLeft() != -1) {
			if (myTree[city1].getLeft() == city2) {
				return 1;
			}
			else {
				travelFor(myTree[city1].getLeft(), city2);
			}
		}
		if (myTree[city1].getRight() != -1) {
			if (myTree[city1].getRight() == city2) {
				return 1;
			}
			else {
				travelFor(myTree[city1].getRight(), city2);
			}
		}
		return -1;
	}

	public int travelBack(int city1, int city2) {
		for (int i=0; i<this.size; i++) {
			if (!this.isSafe(i)) {
				return 0;
			}
			if (myTree[i].getLeft() == city1) {
				if (i == city2) {
					return 1;
				}
				else {
					this.travelBack(i, city2);
				}
			}
			else if (myTree[i].getRight() == city1) {
				if (i==city2) {
					return 1;
				}
				else {
					this.travelBack(i, city2);
				}
			}
		}
		return -1;
	}

	public boolean isSafe(int city) {
		if (myTree[city].getIsSafe()) {
			return true;
		}
		else {
			return false;
		}
	}
 
}
