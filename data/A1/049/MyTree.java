
/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

	public MyNode(int element, int left, int right) {
		if (element == 0)
			isSafe = false;
		else
			isSafe = true;
		leftChildIndex = left;
		rightChildIndex = right;
	}

	public boolean getIsSafe() {
		return isSafe;
	}

	public int getLeft() {
		return leftChildIndex;
	}

	public int getRight() {
		return rightChildIndex;
	}

	public void setIsSafe(int element) {
		if (element == 0)
			isSafe = false;
		else
			isSafe = true;
	}

	public void setLeft(int left) {
		leftChildIndex = left;
	}

	public void setRight(int right) {
		rightChildIndex = right;
	}

} // end MyNode class

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

	public MyTree(int n) {
		size = n;
	}

	public void insert(int index, int isSafe, int left, int right) {
		myTree[index] = new MyNode(isSafe, left, right);
	}

	// return false if it's unsafe and true if it's safe to travel
	public boolean checkQueries(int start, int end) {
		boolean safe = true;
		int tempStart = start;
		int tempEnd = end;
		int temp;
		boolean startIsLeft = true, endIsLeft = true, isSameSubTree = false;

		if ((!myTree[start].getIsSafe()) || (!myTree[end].getIsSafe()))
			return false;
		
			// check if it's in root's left subtree
			while (tempStart != 0) {
				tempStart = (tempStart - 1) / 2;
				temp = tempStart;
				if (tempStart == 0) {
					if (myTree[tempStart].getLeft() == temp)
						startIsLeft = true;
					else
						startIsLeft = false;
				}
			}
			
			// check if it's in root's left subtree
			while (tempEnd != 0) {
				tempEnd = (tempEnd - 1) / 2;
				temp = tempEnd;
				if (tempEnd == 0) {
					if (myTree[tempEnd].getLeft() == temp)
						endIsLeft = true;
					else
						endIsLeft = false;
				}
			}

			// check if they're in the same subtree
			if ((!startIsLeft) && (endIsLeft))
				isSameSubTree = true;
			else if ((startIsLeft) && (!endIsLeft))
				isSameSubTree = true;

			if (isSameSubTree) {
				while ((start != end) && ((start - 1 > 0) && (end - 1 > 0))){
					start = (start - 1) / 2;
					end = (end - 1) / 2;
					tempStart = start;
					tempEnd = end;

					if (!myTree[start].getIsSafe() || (!myTree[end].getIsSafe()))
						return false;
				}
			}
			else {
				while (start != 0 && end != 0) {
					start = (start - 1) / 2;
					end = (end - 1) / 2;
					tempStart = start;
					tempEnd = end;

					if (!myTree[start].getIsSafe() || (!myTree[end].getIsSafe()))
						return false;
				}
			}

		return true;
	}

	public void printTree() {
		for (int i = 0; i < size; i++) {
			System.out.println(i + " " + myTree[i].getLeft() + " " + myTree[i].getRight() + " " + myTree[i].getIsSafe());
		}
	}
} // end MyTree class
