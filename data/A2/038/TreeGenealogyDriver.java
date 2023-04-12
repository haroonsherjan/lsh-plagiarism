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
	int index = 1;
	for (int i=0;i<n;i++) {
	    tree.set(index, sc.nextInt());			   // modify this line
	    tree.set(index+1, sc.nextInt());// modify this line
		index += 2;
	}
	return tree;
    }
    
    /** Read in query statements
     */
    public static int[] readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	int[]  queries = new int[m*2];
	int index = 0;
	for (int i=0;i<m;i+= 2) {
	   queries[index] = sc.nextInt();			   // modify this line
	   queries[index+1] =  sc.nextInt(); // modify this line
	}
	return queries;
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	MyTree tree = readTree();				   // read in the tree
	int[] queries = readQueries();            // read in the queries
	for (int i = 0; i< queries.length; i+=2) {
		int left = tree.getMyTree().indexOf(queries[i]);
		int right = tree.getMyTree().indexOf(queried[i+1]);
		tree.check(left, right);
    }
	// then process the queries ... fill in your calls below
    }
}
