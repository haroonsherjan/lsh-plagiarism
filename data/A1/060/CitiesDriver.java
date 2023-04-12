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
	for (int i=0;i<n;i++) 
	{
	int[] safeStatus = new int[n];
	 safeStatus[i] =  sc.nextInt();			   // modify this line
	}
	// loop to read pairs of children

	int[] child = new int[16];
	
	for (int i=0;i<n;i++) {
	 
	 child[i]  =   sc.nextInt();			   // modify this line
	  			   // modify this line
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	int[] route = new int[m*2];
	for (int i=0;i<m;i++) {
	 route[i] =   sc.nextInt();			   // modify this line
	 	   // modify this line
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	MyTree cities = new MyTree(safeStatus,child);
	
	for(int j=0;j<(route.length)/2;j++){
	boolean status =  cities.getRoute(route[i],route[i+1]);

	if(status)
	{
		System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
			}
	}
	
	// then process the queries ... fill in your calls below
    }
}
