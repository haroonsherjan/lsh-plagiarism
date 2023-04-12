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
	int n = sc.nextInt();
	// read in tree, safety line
	int safe = 0;
	for (int i=0;i<n;i++) 
	    safe = sc.nextInt();			   // modify this line
		myTree.setSafe(safe, n);


	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    int left = sc.nextInt();              // modify this line
	    int right = sc.nextInt();			   // modify this line
		myTree.set(left, right);
	}



    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    sc.nextInt();			   // modify this line
	    sc.nextInt();			   // modify this line
	}
    }
    
    public static void main(String[] args) {
	MyTree myTree = new MyTree();
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
