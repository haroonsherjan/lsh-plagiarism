/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    public MyNode(boolean isSafe) {
		this.isSafe = isSafe;
		leftChildIndex = -1;
		rightChildIndex = -1;
	}
	public MyNode(boolean s,int l,int r) {
		isSafe = s;
		leftChildIndex = l;
		rightChildIndex = r;
	}
/*********accessors**********************/
    public boolean isSafe() {
		return isSafe;
	}
	public int getLeft() {
		return leftChildIndex;
	}
	public int getRight() {
		return rightChildIndex;
	}

/************mutators*******************/
    public void setIsSafe(boolean s) {
		isSafe = s;
	}
	public void setLeft(int l) {
		leftChildIndex = l;
	}
	public void setRight(int r) {
		rightChildIndex = r;
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
  /**********constructors**************/
    public MyTree() {
	}
	public MyNode get(int i) {
		return myTree[i];
	}

	//add a node into the tree
	public void add( MyNode node) {
		myTree[size] = node;
		size++;
	}
	//check whether there is a safe path from city start to city end
	public boolean isSafe(int start,int end) {
		if(start==-1||end==-1)  
			return true;
		if(!myTree[start].isSafe()||!myTree[end].isSafe())  //if either of the two cities is unsafe,return false
			return false;
	    if(start==end)
			return true;
		int ancestor = findCommonAncestor(start,end); //find the common ancestor of the two node
		if(ancestor==start) {  //if the ancestor is start node
			int sLeft =  myTree[start].getLeft();
			int sRight = myTree[start].getRight();
			return (isSafe(sLeft,end)||isSafe(sRight,end));
		}
		else if(ancestor==end) {  //if the ancestor is end node
            int eLeft = myTree[end].getLeft();
			int eRight = myTree[end].getRight();
			return (isSafe(eLeft,start)||isSafe(eRight,start));
		}
		else {  //if the two cities are in different subtrees
			return (isSafe(start,ancestor)&&isSafe(end,ancestor));
		}
	}

	private int findCommonAncestor(int i, int j) {  //find the common ancestor of node i and node j
		if(isChild(i,j))
			return j;
		else if(isChild(j,i))
			return i;
		else {
			int parent = i;
			for(int k = 0;k<size;k++) {
				if(myTree[k].getLeft()==i||myTree[k].getRight()==i)
					parent = k;
					break;
			}
			return findCommonAncestor(parent,j);
		}
	}

    private boolean isChild(int i,int j) {  //determine whether i is a child of j
	    if(j==-1)
			return false;
	    else if(myTree[j].getLeft()==i||myTree[j].getRight()==i)
			return true;
		else {
			return (isChild(i,myTree[j].getLeft())||isChild(i,myTree[j].getRight()));
		}
	}
}
