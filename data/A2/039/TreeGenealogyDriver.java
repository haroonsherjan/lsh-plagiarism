import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;

    /** Read in the tree
     */
    public static void readTree (MyTree ownTree) {
	// read in one integer

	int n = sc.nextInt();
	ownTree.setSize(n);

	// loop to read pairs of children
	for (int i=0;i<n;i++) 
	
		{
	    int left = sc.nextInt();			   // read leftIndex
	    int right = sc.nextInt();			   // read rightIndex
		ownTree.insert(i,left,right);
		}
    }
    
    /** Read in query statements
     */
    public static void readQueries (MyTree ownTree) {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    int first = sc.nextInt();			   // modify this line
	    int second = sc.nextInt();	
		// modify this line
		ownTree.check(first,second);
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	MyTree ownTree = new MyTree();	
	//This ownTree could be static like the scanner, but it is used 
	// very often, so I choose to put it as a parameter
	readTree(ownTree);				   // read in the tree
	readQueries(ownTree);				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
