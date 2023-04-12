import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
	MyTree t = new MyTree();

    /** Read in the tree
     */
    public static void readTree () {
	insert(0, root);
	// read in one integer
	int n = sc.nextInt();
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    int x = sc.nextInt();			   // modify this line
	    int y = sc.nextInt();			   // modify this line
		if (x == -1) {
			root.left.makeEmpty();
		}
		else {
			t.insert(x, root.left);
		}
		if (y == -1) {
			root.right.makeEmpty();
		}
		else {
			t.insert(y, root.right);
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
	    int a =  sc.nextInt();			   // modify this line
	    int b =  sc.nextInt();			   // modify this line
		check(a, b);// check if a and b has relationship or not
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

    }
}
