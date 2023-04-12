import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;

    /** Read in the tree
     */
    public static MyTree readTree () {
	// read in one integer
	int n = sc.nextInt();
	// loop to read pairs of children
	MyTree tree = new MyTree();
	for (int i=0;i<n;i++) {
	    tree.constructTree(i, sc.nextInt(), sc.nextInt());			   // modify this line
	   			   // modify this line
	}
	  return tree;
    }
    
    /** Read in query statements
     */
    public static void readQueries (MyTree tree) {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    System.out.println(tree.checkRela(sc.nextInt(), sc.nextInt()));			   // modify this line
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);	   // read in the tree
	readQueries(readTree());				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
