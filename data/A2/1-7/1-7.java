/** Node and Tree class
  */

class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    	public int left;			  // left child index in array
    	public int right;		 // right child index in array
	public int parent;
    // Accessor and mutator methods
	public void setLeft(int l) {
		this.left = l;
	}	
	
	public int getLeft() {
		return this.left;
	}

	public void setRight(int r) {
		this.right = r;
	}	
	
	public int getRight() {
		return this.right;
	}

	public void setParent(int p) {
		this.parent = p;
	}	
	
	public int getParent() {
		return this.parent;
	}

	public MyNode() {
		this.left = -1;
		this.right = -1;
		this.parent = -1;
	}
}

/** Class for a binary tree ADT
 */
public class MyTree {
    private final int MAX_NODES = 1000;
    MyNode[] myTree;// = new MyNode[MAX_NODES];
    int size;	// make sure to update this variable as needed

	public MyTree(int numNodes) {
		myTree = new MyNode[numNodes];
		for (int i=0;i<numNodes;i++) {
			myTree[i] = new MyNode();
		}
		size = numNodes;
	}

	public void add(int label, int left, int right) {
		myTree[label].left = left;
		myTree[label].right = right;
	}

	public void generateParents() {
		for(int i=0;i<size;i++) {
			if (myTree[i].left>0) myTree[myTree[i].left].parent=i;
			if (myTree[i].right>0) myTree[myTree[i].right].parent=i;
		}
	}

	public String checkRS(int a, int b) {
		if(isAncestor(a,b)) return "ANCESTOR";
		if(isDescendant(a,b)) return "DESCENDANT";
		if(isLeftSib(a,b)) return "LEFT SIBLING";
		if(isRightSib(a,b)) return "RIGHT SIBLING";
		return "NONE";
	}

	private boolean isLeftSib (int a, int b) {
		return myTree[myTree[a].parent].right == b;
	}

	private boolean isRightSib (int a, int b) {
		return myTree[myTree[a].parent].left == b;
	}

	private boolean isAncestor(int a, int b) {
		int parent = myTree[b].parent;
		while(parent!=-1) {
			if(parent==a) return true;
			parent = myTree[parent].parent;
		}
		return false;
	}

	private boolean isDescendant(int a, int b) {
		return isAncestor(b, a);
	}
}
/** Tree Genealogy
  */

import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
	static MyTree myTree;

    /** Read in the tree
     */
    public static void readTree () {
		// Read in number of nodes
		int n = sc.nextInt();

		myTree = new MyTree(n);
		// Read pairs of children
		for (int i=0;i<n;i++) {
		    int left = sc.nextInt();
		    int right = sc.nextInt();
		    myTree.add(i,left,right);
		}
		myTree.generateParents();
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
		// Read in number of pairs
		int m = sc.nextInt();
		// Read pairs of number for query
		for (int i=0;i<m;i++) {
		    int a = sc.nextInt();
		    int b = sc.nextInt();
			System.out.println(myTree.checkRS(a, b));
		}
    }
    
    public static void main(String[] args) {
		sc = new Scanner(System.in);
		readTree();				   // read in the tree
		readQueries();			// read in the queries
    }
}
