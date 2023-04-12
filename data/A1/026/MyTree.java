/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
    int parentIndex;             // parent index in array
    public void setState(int s) {
		if (s == 0)
			isSafe = false;
	    if (s == 1)
			isSafe = true;
	}
    
	public void setLeft(int l) {
		leftChildIndex = l;
	}

	public void setRight(int r) {
		rightChildIndex = r;
	}

	public void setParent(int p) {
		parentIndex = p;
	}

	public boolean getState() {
		return isSafe;
	}

    public int getLeft() {
		return leftChildIndex;
	}

	public int getRight() {
		return rightChildIndex;
	}

	public int getParent() {
		return parentIndex;
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

    public void add(int s) {
		myTree[size] = new MyNode();
		myTree[size].setState(s);
		size++;
	}
    
	public MyNode get(int i) {
		if (i < size)
			return myTree[i];
		return null;
	}

	public boolean canTravel(int i, int j) {
		if (i == j)
			return myTree[i].getState();
	    int c = findCommonAncestor(i, j);
		while (i != c && j != c)
		{
			if (!myTree[i].getState() || !myTree[j].getState())
				return false;
			else
			{
				if (i != c)
				    i = myTree[i].getParent();
				if (j != c)
				    j = myTree[j].getParent();
			}
		}
		return myTree[c].getState();
	}

	private int findCommonAncestor(int i, int j) {
		int[] arr1 = new int[MAX_NODES];
		int[] arr2 = new int[MAX_NODES];
		int a1 = 0, a2 = 0;
		while (i != 0) {
			arr1[a1] = i;
			i = myTree[i].getParent();
			a1++;
		}
		while (j != 0) {
			arr2[a2] = j;
			j = myTree[j].getParent();
			a2++;
		}
		for (int k=0; k<a1; k++)
		{
			for (int l=0; l<a2; l++)
				if (arr1[k] ==arr2[l])
					return arr1[k];
		}
		return 0;
	}
}
