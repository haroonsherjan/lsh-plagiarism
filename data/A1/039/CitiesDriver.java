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
	int[] safety = new int[n];
	int[] leftChildren = new int[n];
	int[] rightChildren = new int[n];
    
	// read in tree, safety line
	for (int i=0;i<n;i++) 
	   safety[i] =  sc.nextInt();			   // modify this line
	
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	   leftChildren[i] =  sc.nextInt();			   // modify this line
	   rightChildren[i] = sc.nextInt();			   // modify this line
	}//end for
    MyTree myTree = new MyTree(safety, leftChildren, rightChildren);
}//end readTree
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	int[] startCity = new int[m];
	int[] endCity = new int[m];
	for (int i=0;i<m;i++) {
	 int startCity[i] =   sc.nextInt();			   // modify this line
	 int endCity[i]  =  sc.nextInt();
                                                    // modify this line
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries
	
    
 
	// then process the queries ... fill in your calls below

	/
    }
}
