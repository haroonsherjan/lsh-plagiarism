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
	int[] safety = new int[n];
	for (int i=0;i<n;i++)
	{
	    safety[i] = sc.nextInt();			   // modify this line
	} //end for loop
	
	// loop to read pairs of children
	int[] childL = new int[n];
	int[] childR = new int[n];
	for (int i=0;i<n;i++) {
	    childL[i] = sc.nextInt();			   // modify this line
	    childR[i] = sc.nextInt();			   // modify this line
	} //end for loop
	} //end readTree
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	int[] queryS = new int[m];
	int[] queryE = new int[m];
	for (int i=0;i<m;i++) {
	    queryS[i] = sc.nextInt();			   // modify this line
	    queryE[i] = sc.nextInt();			   // modify this line
	} //end for loop
    } //end readQueries
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    } //end main
}
