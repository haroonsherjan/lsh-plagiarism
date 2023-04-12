import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
	int[] safeStatusArray = new safeStatusArray[1000];
    
    /** Read in the tree
     */
    public static void readTree () 
	{
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	// read in tree, safety line
	for (int i=0;i<n;i++) 
	    {
			int safeStatus = sc.nextInt();
			safeStatusArray[i] = safeStatus;            //inserting the safe status of each city into an array 
		}
	
	// loop to read pairs of children
	for (int i=0;i<n;i++) 
	{
	    int leftChildIndex = sc.nextInt();
		if (leftChildIndex != -1)
		{
			myNode[nextInsertIndex] = leftChildIndex;               //inserting indexes into MyNode array if city exists
			nextInsertIndex = nextInsertIndex + 1;
		}

	    int rightChildIndex = sc.nextInt();
		if (rightChildIndex != -1)
		{
			myNode[nextInsertIndex] = leftChildIndex;                //insering indexes into MyNode array if city exists
			nextInsertIndex = nextInsertIndex + 1;
		}
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
