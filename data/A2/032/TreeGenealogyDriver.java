import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
	static MyTree tree = new MyTree();

    /** Read in the tree
     */
    public static void readTree () {
	// read in one integer
	int n = sc.nextInt();
	int left, right;
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    left = sc.nextInt();			   // modify this line
	    right = sc.nextInt();			// modify this line
		tree.add(i, left, right); // add children to the tree at specified index
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	int A, B;
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    A = sc.nextInt();			   // modify this line
	    B = sc.nextInt();			   // modify this line
		tree.processQuery(A, B); // process query for relationship between A & B
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

    }
}
