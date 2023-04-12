import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Makesure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
	static MyTree cities = new MyTree();
    static int[] query1,query2;
    /** Read in the tree
     */
    public static void readTree () {
		// Read in the tree
		// read in one integer and assign it to the size of MyTree
		int n = sc.nextInt();
		cities.setSize(n);
		// read in tree, safety line
		for (int i=0;i<n;i++) 
			cities.setSafe(i,sc.nextInt());	// modify this line
	
		// loop to read pairs of children
		for (int i=0;i<n;i++) {
	    	cities.attachChild(i,sc.nextInt(),sc.nextInt());		   // modify this line
		}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
		// read in one integer
		int m = sc.nextInt();
		query1 = new int[m];
		query2   = new int[m];
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
	    	query1[i] = sc.nextInt();			   // modify this line
	    	query2[i] = sc.nextInt();			   // modify this line
		}
    }
    
    public static void main(String[] args) {
	    sc = new Scanner(System.in);
		readTree();				   // read in the tree
		readQueries();				// read in the queries
		// then process the queries ... fill in your calls below
        
    }
}
