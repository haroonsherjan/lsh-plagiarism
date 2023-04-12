import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
	MyTree tree = new MyTree();
    /** Read in the tree
     */
    public static void readTree () {
	// read in one integer
	int n = sc.nextInt();
	int pos = 1; //keep track of the position in the array for insertion

	// loop to read pairs of children
	for (int i=0;i<n;i++) {
		 tree.insert(sc.nextInt(), pos);
	  	 pos++;
	  	 tree.insert(sc.nextInt(), pos);	
	  	 pos++;
		}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    tree.processQuery(sc.nextInt(), sc.nextInt());		
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
