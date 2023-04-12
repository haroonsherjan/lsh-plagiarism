import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    
    /** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	// read in tree, safety line
	int safe;
	MyNode[] city;                 // instantiate an array of MyNode
	for (int i=0;i<n;i++) {
	   safe = sc.nextInt();        // 1 = safe, 0 = not safe
	   city[i] = new MyNode(i);    // initialize MyNode
	   city[i].setSafe(safe);      // set the node to safe or not safe
	}

	MyTree cityTree = new MyTree(MyNode[] city);

	// loop to read pairs of children
	int node1;
	int node2;
	for (int i=0;i<n;i++) {
		node1 = sc.nextInt()
	    cityTree.attachLeft(MyNode[] city, node1);			   // modify this line
	    node2 = sc.nextInt();			                        // modify this line
		cityTree.attachRight(MyNode[] city, node2);
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    sc.nextInt();			   // modify this line
	    sc.nextInt();			   // modify this line
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
