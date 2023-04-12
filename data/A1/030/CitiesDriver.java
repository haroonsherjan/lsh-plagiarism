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
	    safety[i] = sc.nextInt();			   // modify this line
	
	
	// loop to read pairs of children
	MyTree cities = new MyTree();
	for (int i=0;i<n;i++) {
		
		// read in the nodes into cities
		cities.MyTree[j] = j;
		cities.MyTree[2*j+1].setLeftChildIndex(sc.nextInt());			    // leftChild of j
	    cities.MyTree[2*j+2].setRightChildIndex(sc.nextInt());			    // rightChild of j
		
	}

	// assign the isSafe boolean into the individual Nodes
	// by default, all Nodes are declared safe
	if (safety[0] == 0)
		cities.MyTree[0].setIsSafe(false);

	for(int i=1; i< n + 1; i++)
	{
		switch (safety[i])
		{
			case '0': cities.MyTree[2*i + 1].setIsSafe(false); 
			break;
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
