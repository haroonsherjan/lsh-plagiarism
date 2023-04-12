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

	MyTree tree = new MyTree();

	int leftInput = 0;
	int rightInput = 0;

	for (int i=0;i<n;i++) {
	    leftInput = sc.nextInt();			   // modify this line
	    rightInput = sc.nextInt();             // modify this line

		
		tree.insertLeft(leftInput);
		tree.insertRight(rightInput);

		
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer

	int queryLeft = 0;
	int queryRight = 0;

	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	   queryLeft =  sc.nextInt();			   // modify this line
	   queryRight = sc.nextInt();			   // modify this line

//	   tree.query(queryLeft, queryRight);


	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
