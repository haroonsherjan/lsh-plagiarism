import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
	static MyTree t = new MyTree();
    
    /** Read in the tree
     */
    public static void readTree () {
		/// Read in the tree
		
		// read in one integer
		int n = sc.nextInt();
		// read in tree, safety line
		for (int i=0;i<n;i++)
		    t.setSafety(sc.nextInt());
		
		// loop to read pairs of children
		for (int i=0;i<n;i++) {
	    	t.insert(i, sc.nextInt(),sc.nextInt());
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
		sc = new Scanner(System.in);
		readTree();				   // read in the tree
		//readQueries();				// read in the queries

		// then process the queries ... fill in your calls below
  		
		System.out.println("YES");
		System.out.println("NO");
	}
}
