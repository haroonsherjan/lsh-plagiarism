import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
    static MyTree tree;

    /** Read in the tree
     */
    public static void readTree () {
	    // read in one integer
	    int n = sc.nextInt();
	    tree = new MyTree(n);

	    // loop to read pairs of children
	    int left, right ;
	    for (int i=0;i<n;i++) {
	        left = sc.nextInt();			   // modify this line
	        right = sc.nextInt();              // modify this line
		    tree.setNode(i, left, right);
     	}
    } // end readTree
    
    /** Read in query statements
     */
    public static void readQueries () {
	    // read in one integer
	    int m = sc.nextInt();
	    // loop to read pairs of children for query
		int a, b;
	    for (int i=0;i<m;i++) {
	        a = sc.nextInt();			   // modify this line
	        b = sc.nextInt();              // modify this line
			processQuery(a,b);
    	}
    }// end readQueries
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    } // end main

	public static void processQuery(int a, int b) {
		if ( tree.isLeftSibling(a,b) )
			System.out.println("LEFT SIBLING");
		else if ( tree.isRightSibling(a,b) )
			System.out.println("RIGHT SIBLING");
	    else if ( tree.isAncestor(a,b) )
			System.out.println("ANCESTOR");
		else if ( tree.isDescendant(a,b) )
			System.out.println("DESCENDANT");
		else
			System.out.println("NONE");
	} // end processQuery
          
   
	
}// end class
