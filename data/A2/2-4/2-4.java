
/** Class for a tree node
 */
class MyNode {

    int lChild;			  // left child index in array
    int rChild;		 // right child index in array
}

/** Class for a binary tree ADT
 */
public class MyTree {

    MyNode[] T;

    // Create a tree with specified number of nodes
    public MyTree(int numNodes) {
        T = new MyNode[numNodes];

        for (int i = 0; i < numNodes; i++) {
            T[i] = new MyNode();
        }
    }

    // Insert the left and the right child to the specific parent
    public void insert(int leftChild, int rightChild, int dad) {

        T[dad].rChild = rightChild;
        T[dad].lChild = leftChild;
    }

    public int isSibling(int u, int v) {
        int dad;

        // Scan to check whether node A and B have the same parent
        for (dad = 0; dad < T.length; dad++) {
            if ((T[dad].lChild == u) && (T[dad].rChild == v)) return 1;
            if ((T[dad].lChild == v) && (T[dad].rChild == u)) return -1;
            } 
        return 0;
    }

    // Check whether node A is ancestor of node B
    public boolean isAncestor(int u, int v) {
        // if node A is null
        if (u == -1) {
            return false;
        } // If node A is the parent of B
        else if ((T[u].lChild == v) || (T[u].rChild == v)) {
            return true;
        } // If A is not a parent of B
        // check whether if the children of A is the ancestor of B
        else {
            return (isAncestor(T[u].lChild, v) || isAncestor(T[u].rChild, v));
        }
    }
}
import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;

    /** Read in the tree
     */
    public static MyTree readTree () 
	{
		// read in one integer
		int n = sc.nextInt();

		// Creat a new tree with n nodes
		MyTree tree = new MyTree(n);
	
		// loop to read pairs of children
		for ( int i = 0; i < n; i ++ ) 
	    	tree.insert(sc.nextInt(), sc.nextInt(), i);

		return tree;	
    }
    
    /** Read in query statements
     */
    public static int[][] readQueries () 
	{
		// read in one integer
		int m = sc.nextInt();

		int[][] querry = new int[m][2];

		// loop to read pairs of children for query
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

		// then process the queries
		for ( int i = 0; i < querry.length; i ++ )
		{
			checkSibling = tree.isSibling(querry[i][0], querry[i][1]);
			
			// If the relation is left sibling
			if ( checkSibling == 1 )
			{
				System.out.println("LEFT SIBLING");
			}
			
			// If the relation is right sibling
			else if ( checkSibling == -1 )
			{
				System.out.println("RIGHT SIBLING");
			}

			// If the 2 nodes are not siblings
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
