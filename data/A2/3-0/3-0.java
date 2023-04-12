/** Class for a tree node
 */
class MyNode {

    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // Constructor which initializes the left child and right child.
    public MyNode(int left, int right)
	{
		leftChildIndex = left;
		rightChildIndex = right;
	}

	//Accessors for the left child and right child.
	public int getLeft()
	{
		return leftChildIndex;
	}

	public int getRight()
	{
		return rightChildIndex;
	}
}//end class MyNode.

/** Class for a binary tree ADT
 */
public class MyTree {

    //Constant strings which denote the relationship between two nodes.
	public static final String ANCESTOR = "ANCESTOR";
	public static final String DESCENDANT = "DESCENDANT";
	public static final String LEFT_SIBLING = "LEFT SIBLING";
	public static final String RIGHT_SIBLING = "RIGHT SIBLING";
	public static final String NONE = "NONE";

    MyNode[] myTree;
    int size = 0;	//The current size of the tree.

	//Constructor which initializes the tree to have a constant number of nodes denoted by the argument numNodes.
    public MyTree(int numNodes)
	{
		myTree = new MyNode[numNodes];
	}//end constructor

	//Inserts into the tree a node whose left child is left and right child is right.
	public void insert(int left, int right)
	{
		myTree[size] = new MyNode(left, right);
		size++;
	}//end method insert

	//Determines the relationship between two node with label A and B.
	public String relationship(int A, int B)
	{
		if (isAncestor(A,B))
			return ANCESTOR;
		else if (isAncestor(B,A))
			return DESCENDANT;
		else if (isLeftSibling(A,B))
			return LEFT_SIBLING;
		else if (isLeftSibling(B,A))
			return RIGHT_SIBLING;
		else
			return NONE;	//If the nodes have none of the above relationships
	}//end method relationship

	//Returns true if node with label A is an ancestor of the node with label B.
	private boolean isAncestor(int A, int B)
	{
		//Variables to determine whether node with label B is in A's left subtree or right subtree.
		boolean isInLeft = false;
		boolean isInRight = false;

		if (A==B)	//Node with label B has been found in A's subtree.
			return true;

		if (myTree[A].getLeft()!=-1)	//Traverse the left subtree if it's not empty
			isInLeft = isAncestor(myTree[A].getLeft(),B);
		
		if (myTree[A].getRight()!=-1)	//Traverse the right subtree if it's not empty
			isInRight = isAncestor(myTree[A].getRight(),B);

		return isInLeft || isInRight;	//Return true when the node with label B is in either the right or left subtree of A.
	}//end method isAncestor

	//Returns true if node with label A is the left sibling of the node with label B.
	private boolean isLeftSibling(int A, int B)
	{
		//Iterate through every node and determine whether there exists a node with left child A and right child B.
		for (int i = 0; i<size; i++)
		{
			if (myTree[i].getLeft()==A && myTree[i].getRight()==B)
				return true;
		}

		return false;
	}//end method isLeftSibling
}//end class MyTree.
import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
	static MyTree tree;
	static String[] query;	//Array to store the results of each query.

    /** Read in the tree
     */
    public static void readTree () {
	// read in one integer
	int n = sc.nextInt();
	tree = new MyTree(n);	//Initialize a tree with size n.

	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    int leftChild = sc.nextInt();			   
	    int rightChild = sc.nextInt();			   

		tree.insert(leftChild, rightChild);	//Insert the node into the tree.
	}
    }//end method readTree.
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	query = new String[m];

	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    int nodeA = sc.nextInt();			   
	    int nodeB = sc.nextInt();			   

		query[i] = tree.relationship(nodeA, nodeB);	//Store the result of each query.
	}
    }//end method readQueries.
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	for (int i = 0; i<query.length; i++)
	{
		System.out.println(query[i]);	//Print out the result of each query.
    }
	}//end main.
}//end class TreeGenealogyDriver
