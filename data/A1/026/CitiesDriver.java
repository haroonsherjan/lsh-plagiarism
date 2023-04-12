import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    
    /** Read in the tree
     */
    public static void readTree (MyTree myTree) {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	// read in tree, safety line
	for (int i=0;i<n;i++) 
	    myTree.add(sc.nextInt());
	
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
		int l = sc.nextInt();
		int r = sc.nextInt();
	    myTree.get(i).setLeft(l);
	    myTree.get(i).setRight(r);
		if (l > 0)
			myTree.get(l).setParent(i);
	    if (r > 0)
		    myTree.get(r).setParent(i);
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries (MyTree myTree) {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    if (myTree.canTravel(sc.nextInt(), sc.nextInt()))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	MyTree myTree = new MyTree();
	readTree(myTree);				   // read in the tree
	readQueries(myTree);				// read in the queries
    }
}
