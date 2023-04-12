/** Class for a tree node
 */
class MyNode {
    private int leftChildIndex;			  // left child index in array
    private int rightChildIndex;		 // right child index in array

    public MyNode(int left, int right) {
		leftChildIndex = left;
		rightChildIndex = right;
	}

	public int getLeft() {
		return leftChildIndex;
	}

	public int getRight() {
		return rightChildIndex;
	}

	public void setLeft(int left) {
		leftChildIndex = left;
	}

	public void setRight(int right) {
		rightChildIndex = right;
	}
}

/** Class for a binary tree ADT
 */
public class MyTree {
    public final int root = 0;
    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    private int size = 0;	// make sure to update this variable as needed
    
	public int getSize() {
		return size;
	}

	public void add(int index, int leftChild, int rightChild) {
		myTree[index] = new MyNode(leftChild, rightChild);
		size++;
	}

    public String relation(int first, int second) {
		boolean isAnc = isAncestor(first, second);
		boolean isDes = isDescendant(first, second);
		if (isAnc && isDes) {
			if (getParent(second) == first)
				return "ANCESTOR";
			else 
				return "DESCENDANT";
		}
		else if (isAncestor(first, second))
			return "ANCESTOR";
		else if (isDescendant(first, second))
			return "DESCENDANT";
		else if (isSibling(first, second) == 1)
			return "LEFT SIBLING";
		else if (isSibling(first, second) == 2)
			return "RIGHT SIBLING";
		else
			return "NONE";
	}

    
    private boolean isAncestor(int first, int second) {
		int parentIndex = getParent(second);
		if (myTree[first].getLeft() == second || myTree[first].getRight() == second)
			return true;
		else if (parentIndex == root)
			return false;
		return isAncestor(first, parentIndex);
	}
	
	private boolean isDescendant(int first, int second) {
		int parentIndex = getParent(first);
		if (myTree[second].getLeft() == first || myTree[second].getRight() == first)
			return true;
		else if (parentIndex == root)
			return false;
		return isDescendant(parentIndex, second);
	}

	private int isSibling(int first, int second) {
		int parentIndex = getParent(second);
		if (myTree[parentIndex].getLeft() == first)
			return 1; // 1 is Left Sibling of 2
		else if (myTree[parentIndex].getRight() == first)
			return 2; // 1 is Right Sibling of 2
		return -1;
	}

	/* private int getParent(int first, int second) {
		for (int i = 0; i < size; i++)
			if ((myTree[i].getLeft() == first && myTree[i].getRight() == second)
					|| (myTree[i].getRight() == first && myTree[i].getLeft() == second))
				return i;
		return -1;
	} */

    private int getParent(int node) {
		for (int i = 0; i < size; i++)
			if (myTree[i].getLeft() == node || myTree[i].getRight() == node)
				return i;
		return -1;
	}
	public void preorder() {
		for (int i = 0; i < size; i++)
			System.out.print(myTree[i].getLeft() + " " + myTree[i].getRight());
	}

}
