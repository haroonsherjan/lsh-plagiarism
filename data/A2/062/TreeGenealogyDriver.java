import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;

    /** Read in the tree
     */
	MyListTree lt;

    public static void readTree () {
	// read in one integer
	int n = sc.nextInt();
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    int firstNo = sc.nextInt();			   // get the 1st integer(left)
	    int secNo = sc.nextInt();			   // get the 2nd integer(right)
		lt.insert(firstNo,secNo);              // call the insert method
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    int firstNo = sc.nextInt();			   // get the 1st num of the pair
	    int secNo = sc.nextInt();			   // get the 2nd num of the pair
		relation(firstNo,secNo);            // call the relation method
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	lt = new MyListTree();
	readTree();				   // read in the tree
	readQueries();				// read in the queries
    }
}
