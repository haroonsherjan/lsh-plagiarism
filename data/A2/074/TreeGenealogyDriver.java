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
			MyTree tree = new MyTree();
	// loop to read pairs of children
		for (int i=0;i<n;i++) {
	    	int left = sc.nextInt();			   // modify this line
	    	int right = sc.nextInt();	// modify this line
			tree.insert(left, right);
		}
	}
    
    /** Read in query statements
     */
   	public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	MyTree tree2 = new MyTree();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    int left = sc.nextInt();			   // modify this line
	    int right = sc.nextInt();
		tree2.label(left,right);// modify this line
		}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
