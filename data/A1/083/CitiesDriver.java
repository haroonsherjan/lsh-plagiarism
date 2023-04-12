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
	
	MyTree city = new MyTree(n);

	// read in tree, safety lin
	for (int i=0;i<n;i++) 
			city.safeRoute(i,sc.nextInt());			   // Set Route safety
	
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	   	city.setLChild(i,sc.nextInt()); // Set Left Child
	    city.setRChild(i,sc.nextInt()); // Set Right Child
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	  sc.nextInt();sc.nextInt();
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
