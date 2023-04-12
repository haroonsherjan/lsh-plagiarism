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
	public MyNode() {
		isSafe = true;
		leftChildIndex = -1;
		rightChildIndex = -1;
	}

	public void setSafe(int flag) {
		if (flag==0)   this.isSafe=false;
	}

	public void setLeft(int leftIndex) {
		this.leftChildIndex=leftIndex;
	}

	public void setRight(int rightIndex) {
		this.rightChildIndex=rightIndex;
	}

	public boolean getSafe() {
		return isSafe;
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
	public MyTree() {
		for (int i=0;i<MAX_NODES;i++)  myTree[i]= new MyNode();
	}

	public void setSize(int newSize) {
		this.size=newSize;
	}

	public int getSize() {
		return this.size;
	}

	public void attachChild(int index,int left,int right) {
		myTree[index].setLeft(left);
		myTree[index].setRight(right);
	}

	public void setSafe(int index, int flag)  {
		myTree[index].setSafe(flag);
	}

	public int backToParent(int x) {
		int index = 0;
        for (int i=0;i<size; i++) {
			if (myTree[i].getLeft()==x || myTree[i].getRight()==x) 
				index = i;
		}
        return index;
	}
}
