
import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
	private static MyTree mytree;
    
    /** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	// read in tree, safety line
	
	ArrayList<Integer> temp = new ArrayList<Integer>();   // temp storage for indicating safe/unsafe cities
	for (int i=0;i<n;i++) 
	    temp.add(sc.nextInt());			   // read isSafe/unsafe input into temp array
	
	mytree = new MyTree(n);	
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    int left = sc.nextInt();			   // read leftchild
	    int right = sc.nextInt();			   // read rightchild
		mytree.insert(i, temp.get(i), left, right);
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    int start = sc.nextInt();			   // read start city
	    int end = sc.nextInt();			   // read end city
		if (mytree.checkQueries(start, end)) 
			System.out.println("YES");
		else
			System.out.println("NO");
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
