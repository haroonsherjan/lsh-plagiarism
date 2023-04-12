import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    
    public static void readTree (MyTree tree) {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	// read in tree, safety line
	int [] safe = new int [n];
	for (int i=0;i<n;i++) {
	    safe[i] = sc.nextInt();	
	}
	
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
		tree.addNode(i, safe[i],sc.nextInt(),sc.nextInt());			   // modify this line
	}
    } // end readTree
    
    /** Read in query statements
     */
    public static void readQueries (MyTree tree) {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	   String result =  tree.checkPath(sc.nextInt(),sc.nextInt());
	   System.out.println(result);
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	MyTree newTree = new MyTree();
	readTree(newTree);				   // read in the tree
	readQueries(newTree);				// read in the queries

    } // end main
}
