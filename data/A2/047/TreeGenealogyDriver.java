import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
	static MyTree myTree = new MyTree();
    /** Read in the tree
     */
    public static void readTree () {
	// read in one integer
	int n = sc.nextInt();

	// loop to read pairs of children
	for (int i=0;i<n;i++) {
		myTree.addNode(i, sc.nextInt(), sc.nextInt());			   // modify this line
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    myTree.compare(sc.nextInt(), sc.nextInt());			   // modify this line
		}	
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ...fill in your calls below
    }
}
