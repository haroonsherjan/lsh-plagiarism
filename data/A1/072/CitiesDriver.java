import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    static MyTree tree;
    
    /** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	tree.setSize(n);
	// read in tree, safety line
	for (int i=0;i<n;i++) 
	{
		int safety = sc.nextInt();
		tree.setSafety(i,safety);
    }
	
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    int left = sc.nextInt();			   // modify this line
	    int right = sc.nextInt();			   // modify this line

		tree.setLeftIndex(i, left);
		tree.setRightIndex(i, right);
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	boolean safe = true;
	for (int i=0;i<m;i++) {
	    int startCity = sc.nextInt();			   // modify this line
	    int endCity = sc.nextInt();			   // modify this line

		 safe = tree.travel(startCity, endCity);
	
	if(safe)
	{
		System.out.println("YES");
	}
	else System.out.println("NO");
    }
	}
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	tree = new MyTree();
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
