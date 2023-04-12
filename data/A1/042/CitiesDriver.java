import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
	MyNode node;
    
    /** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	// read in tree, safety line
	for (int i=0;i<n;i++)
	{
	    int safetyNum = sc.nextInt(); // to indicate the safety status
        //node = new MyNode(safetyNum);
	}
	
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    int leftChild = sc.nextInt();              // leftChild
		// MyNode left = new MyNode(leftChild);
	    int rightChild = sc.nextInt();			   // rightChild
		// MyNode right = new MyNode(rightChild);
		// node = new MyNode(0, left, right);
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    int direction1 = sc.nextInt();			   // indicate from which node 
	    int direction2 = sc.nextInt();			   // to which node
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
