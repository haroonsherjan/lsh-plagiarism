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
		cities = new MyTree(n);
	
		// read in tree, safety line
		for (int i=0;i<n;i++) {
			cities.setNodeSafe(i , sc.nextInt());	
		}

	
		// loop to read pairs of children
		for (int i=0;i<n;i++) {
	    	cities.setChild(i, sc.nextInt(), sc.nextInt());
	    	sc.nextLine();
		}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
		// read in one integer
		int m = sc.nextInt();

		// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
	    	System.out.println(cities.safeRoute(sc.nextInt(), sc.nextInt()));
			sc.nextLine();
		} // end loop for reading in and output
    }
    
	private static MyTree cities;

    public static void main(String[] args) {
		sc = new Scanner(System.in);
		readTree();				   // read in the tree
		readQueries();				// read in the queries and outputs the results
    }
}
