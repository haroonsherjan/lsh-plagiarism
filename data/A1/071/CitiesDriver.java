import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    MyTree tree;
    /** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	int safe;
	boolean s;
	// read in tree, safety line
	for (int i=0;i<n;i++){ 
	    safe = sc.nextInt();
			s = (safe == 1);
			tree.insert(i,s);
	}//insert the ith city
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    tree.get(i).setLeft(tree.get(sc.nextInt()));			   // set relationship between the nodes
	    tree.get(i).setRight(tree.get(sc.nextInt()));			   
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	int c1;
	int c2;
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    c1 = sc.nextInt();			   // modify this line
	    c2 = sc.nextInt();
		System.out.println(tree.isSafe(c1,c2));// find out whethere it is safe
	}
    }
    
    public static void main(String[] args) {
	tree = new MyTree();
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
