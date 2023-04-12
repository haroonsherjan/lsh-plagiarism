/** Class for a tree node
 */
class MyNode {

    // array index for left and right child
    private int leftChildIndex;			  
    private int rightChildIndex;		 

    // Constructor
    public MyNode(int leftIndex, int rightIndex)
	{
		leftChildIndex = leftIndex;
		rightChildIndex = rightIndex;
	}

	//Accessors
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

    // constant for the relationship
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
	public String relationship(int nodeA, int nodeB)
	{
		if (isAncestor(nodeA,nodeB))
			return ANCESTOR;
		else if (isAncestor(nodeB,nodeA))
			return DESCENDANT;
		else if (isLeftSibling(nodeA,nodeB))
			return LEFT_SIBLING;
		else if (isLeftSibling(nodeB,nodeA))
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

		if (myTree[A].getLeft()!= -1)	//Traverse the left subtree if it's not empty
			isInLeft = isAncestor(myTree[A].getLeft(),B);
		
		if (myTree[A].getRight()!=-1)	//Traverse the right subtree if it's not empty
			isInRight = isAncestor(myTree[A].getRight(),B);

		return isInLeft || isInRight;	//Return true when the node with label B is in either the right or left subtree of A.
	}//end method isAncestor

	//to check if node A is the left sibling of node B
	private boolean isLeftSibling(int A, int B)
	{
		// check all the nodes in the tree if A is left child and B is right child
		for (int i = 0; i<size; i++)
		{
			if (myTree[i].getLeft()==A && myTree[i].getRight()==B)
			{
				return true;
			}
				
		}

		return false;
	}
}
import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver 
{
    
    public static void main(String[] args) 
    {
		Scanner scanner = new Scanner(System.in);
		
		// read the tree
			
		// read number of nodes
		int n = scanner.nextInt();
		// initialize the tree
		MyTree tree = new MyTree(n);	
	
		// read all pairs of children
		for (int i=0; i<n; i++) 
		{
		    int leftChild = scanner.nextInt();			   
		    int rightChild = scanner.nextInt();			   
	
			tree.insert(leftChild, rightChild);	
		}
						   
		// read number of queries
		int numberOfQueries = scanner.nextInt();
		String[] query = new String[numberOfQueries];

		// read pairsOfNodes to determine the relationship
		for (int i=0; i<numberOfQueries; i++) 
		{
	    	int nodeA = scanner.nextInt();			   
	    	int nodeB = scanner.nextInt();			   
			
			// find the relationship
			System.out.println(tree.relationship(nodeA, nodeB));	
		}			
	
	
	}
}
