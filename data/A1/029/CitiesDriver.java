import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
	static MyTree flightTree;
    
    /** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	flightTree = new MyTree(n);

	// read in tree, safety line
	for (int i=0;i<n;i++){ 
	    int safe = sc.nextInt();
		flightTree.queueSafe(i, safe);
	}
	
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    int left = sc.nextInt();
	    int right = sc.nextInt();
		flightTree.setChildren(i, left, right);
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    int a= sc.nextInt();			   
	    int b= sc.nextInt();
		boolean safe= flightTree.safeNot (a, b);
		if(safe == true){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
