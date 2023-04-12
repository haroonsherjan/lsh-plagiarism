/* Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a bicnary tree

    // you can add other variables if you'd like
    public int left;			  // left child index in array
    public int right;		 // right child index in array
    public int parent;
    // fill in your accessor and mutator methods here
    // ...
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
		for(int i=0; i<numNodes; i++) {
			myTree[i] = new MyNode();
		}
		size = numNodes;
	}

	public void add(int index, int left, int right) {
		myTree[index].left = left;
		myTree[index].right = right;
	}

	public void generateParents() {
		for(int i=0;i<size;i++) {
			if (myTree[i].left>0) 
				myTree[myTree[i].left].parent=i;
			if (myTree[i].right>0) 
				myTree[myTree[i].right].parent=i;
		}
	}
	
	private boolean isLeftSibling (int a, int b) {
		return myTree[myTree[a].parent].right == b;
	}

	private boolean isRightSibling (int a, int b) {
		return myTree[myTree[a].parent].left == b;
	}

	private boolean isAncestor(int a, int b) {
		int parent = myTree[b].parent;
		while(parent!= -1) {
			if(parent == a) 
			    return true;
			parent = myTree[parent].parent;
		}
		return false;
	}

	private boolean isDescendant(int a, int b) {
		return isAncestor(b, a);
	}

	public String determineRelationship(int a, int b) {
		if(isAncestor(a,b)) return "ANCESTOR";
		if(isDescendant(a,b)) return "DESCENDANT";
		if(isLeftSibling(a,b)) return "LEFT SIBLING";
		if(isRightSibling(a,b)) return "RIGHT SIBLING";
		return "NONE";
	}



}
import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
    static MyTree myTree;
    
    public static void main(String[] args) {

		// Setting up the tree
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		int left, right;

		myTree = new MyTree(n);
		// loop to read pairs of children
		for (int i=0; i<n; i++) {
		    left = sc.nextInt();
		    right = sc.nextInt();
		    myTree.add(i,left, right);
		}
		myTree.generateParents();


		// Ready to get input
		int m = sc.nextInt();
		int input1, input2;

		for (int i=0; i<m; i++) {
		    input1 = sc.nextInt();
		    input2 = sc.nextInt();
		    System.out.println(myTree.determineRelationship(input1, input2));
		}
    }
}
