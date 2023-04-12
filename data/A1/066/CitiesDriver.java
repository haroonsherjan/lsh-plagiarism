import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    static MyTree cities;
    
    /** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	cities.setSize(n);
	
	// read in tree, safety line
	for (int i=0;i<n;i++){
		n = sc.nextInt();
		if(n == 0) 
	    	cities.myTree[i].setIsSafe(false);
	    else
	    	cities.myTree[i].setIsSafe(true);
	}
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
		n = sc.nextInt();
	    cities.myTree[i].setLeftChildIndex(n);
	    n = sc.nextInt();
	    cities.myTree[i].setRightChildIndex(n);			   
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
		int a,b;
	    a = sc.nextInt();			   // modify this line
	    b = sc.nextInt();			   // modify this line
	    
	    cities.shortestRoute(a, b);
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	MyTree cities = new MyTree();
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
