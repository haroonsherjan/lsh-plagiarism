import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    
    /** Read in the tree
     */
    public static void readTree (MyTree cities) {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	// read in tree, safety line
	for (int i=0;i<n;i++) 
	    cities.insertCityCondition(sc.nextInt());			   // modify this line
	
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    cities.insertLeftChild(sc.nextInt(), i);			   // modify this line
	    cities.insertRightChild(sc.nextInt(), i);			   // modify this line
		}	
    }
    
    /** Read in query statements
     */
    public static void readQueries (MyTree cities) {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	   cities.insertPath(sc.nextInt(), sc.nextInt());			   // modify this line
		}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	MyTree cities = new MyTree();
	readTree(cities);					// read in the tree
//	cities.print();
	readQueries(cities);				// read in the queries

	// then process the queries ... fill in your calls below
    	}
}
