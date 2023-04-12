import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;

    /** Read in the tree
     */
    public static void readTree () {
	// read in one integer
	int n = sc.nextInt();
	// loop to read pairs of children
	for (int i=0;i<n;i++) {

		int left = sc.nextInt();
		int right = sc.nextInt();

		tree.setCurrentIndex(i);
	    tree.setLeft(sc.nextInt());
	    tree.setRight(sc.nextInt());
		}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();

	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    int A = sc.nextInt();
	    int B = sc.nextInt(); // where A is the ***** of B, denoting the relationship of A with B
		// where am i supposed to store this data?
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	MyTree tree = new MyTree(0, 0);
	readTree();				   // read in the tree
	readQueries();				// read in the queries === for what?!
	
	
    }

}
