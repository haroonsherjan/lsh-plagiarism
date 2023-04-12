import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
	static Scanner sc;
	static MyTree tree;
    /** Read in the tree
     */
    public static void readTree () {
	    // read in one integer
	    int n = sc.nextInt();
		tree = new MyTree();
	    // loop to read pairs of children
	    for (int i=0;i<n;i++)
	        tree.add(i, sc.nextInt(), sc.nextInt());
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	    // read in one integer
	    int m = sc.nextInt();
	    // loop to read pairs of children for query
	    for (int i=0;i<m;i++) {
	        int first = sc.nextInt();
			int second = sc.nextInt();
			System.out.println(tree.relation(first, second));
	    }
    }
    
    public static void main(String[] args) {
	    sc = new Scanner(System.in);
	    readTree();				   // read in the tree
	    readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
