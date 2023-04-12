import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;

    
    /** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	MyTree tree = new MyTree();
	int n = sc.nextInt();
	// read in tree, safety line
	for (int i = 0; i < n; i++) {
	    tree.route(sc.nextInt());			   // modify this line
	}
	
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
		int left = sc.nextInt();
		int right = sc.nextInt();
	    tree.addLeft(left);
		tree.addItem(left);					// modify this line
	    tree.addRight(right);			   // modify this line
		tree.addItem(right);
	}

    }

    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
		int m = sc.nextInt();
	// loop to read pairs of children for query
	/*	for (int i=0;i<m;i++) {
	 	   int start = sc.nextInt();			   // modify this line
	   		 int end = sc.nextInt(); 				// modify this line

			if( tree.isSafe(start) && tree.isSafe(end)) {
				tree.search(start, end);	
			}
		}	
		*/ 
		//check for parent to see if they have a common ancestor, if they do, check if the ancestor is safe to travel through.
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
