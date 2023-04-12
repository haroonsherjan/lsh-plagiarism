
class MyNode {
    int leftIn;			  // left child 
    int rightIn;		 // right child 
}

public class MyTree {
    MyNode[] myTree;
	
	// Create a specified size tree
	public MyTree(int numNodes)
	{
		myTree = new MyNode[numNodes];
		for ( int i = 0; i < numNodes; i ++ )
			myTree[i] = new MyNode();
	}

	// Insert children to a parent
	public void insert(int leftChild, int rightChild, int parid)
	{
        myTree[parid].rightIn = rightChild;
		myTree[parid].leftIn = leftChild;

	}

	// Check if two nodes are siblings
	public int isSibling(int nodeA, int nodeB)
	{
        // the parent id
		int parent; 		
		// Scan to check if two nodes have the same parent
		for ( parent = 0; parent < myTree.length; parent++ )
			if ( (myTree[parent].leftIn == nodeA) && (myTree[parent].rightIn == nodeB) )				
				return 1;
			else if ( (myTree[parent].leftIn == nodeB) && (myTree[parent].rightIn == nodeA) )
				return -1;		
		return 0;
	}

	// Check if one node is ancestor of another
	public boolean isAncestor(int nodeA, int nodeB)
	{
		if ( nodeA == -1 )
			return false;
		// check if node A is the parent of B
		else if ( (myTree[nodeA].leftIn == nodeB) || (myTree[nodeA].rightIn == nodeB) )
			return true;
		// check if the children of A is the ancestor of B
		else 
		{
			return (isAncestor(myTree[nodeA].leftIn, nodeB) || isAncestor(myTree[nodeA].rightIn,nodeB));
		}
	}
}
import java.util.*;

public class TreeGenealogyDriver {
    static Scanner sc;
    public static MyTree readTree () 
	{		
		int n = sc.nextInt(); // read a number
		MyTree tree = new MyTree(n); // Creat a new tree
	
		//read pairs of children
		for ( int i = 0; i < n; i ++ ) 
	    	tree.insert(sc.nextInt(), sc.nextInt(), i);
		return tree;	
    }
    
    public static int[][] readQueries ()  //read in query
	{
		// read in a number
		int m = sc.nextInt();
		int[][] querry = new int[m][2];

		// read children for query
		for ( int i = 0; i < m; i ++ ) 
		{
	    	querry[i][0] = sc.nextInt();			 
	    	querry[i][1] = sc.nextInt();			  
		}
		return querry;
    }
    
    public static void main(String[] args) 
	{
		sc = new Scanner(System.in);
		MyTree tree = readTree();	           // read in the tree
		int[][] querry = readQueries();		   // read in the queries
		int checkSibling;

		// process queries
		for ( int i = 0; i < querry.length; i ++ )
		{
			checkSibling = tree.isSibling(querry[i][0], querry[i][1]);

			if ( checkSibling == 1 )
			{
				System.out.println("LEFT SIBLING");
			}

			else if ( checkSibling == -1 )
			{
				System.out.println("RIGHT SIBLING");
			}
			// check whether they have ancestor descendant relation 
			else
			{
				// If the relation is ancestor
				if ( tree.isAncestor(querry[i][0], querry[i][1]) )
					System.out.println("ANCESTOR");

				// If the relation is descendant	
				else if ( tree.isAncestor(querry[i][1], querry[i][0] ) )
					System.out.println("DESCENDANT");

				// If they have no relation
				else
					System.out.println("NONE");
			}
		}

    }
}
