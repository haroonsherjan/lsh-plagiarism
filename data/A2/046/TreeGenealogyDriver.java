import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
	static Scanner sc;

	/** Read in the tree
	 */
	public static void readTree (MyTree tree) {
		// read in one integer
		int n = sc.nextInt();
		// loop to read pairs of children
		for (int i=0;i<n;i++) {
			int left = sc.nextInt();
			int right = sc.nextInt();
			tree.insert(left, right); // insert left and right child into the tree
		}
	}

	/** Read in query statements
	 */
	public static void readQueries (MyTree tree) {
		// read in one integer
		int m = sc.nextInt();
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			System.out.println(tree.relation(A, B));
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		MyTree tree = new MyTree();
		readTree(tree);				   // read in the tree
		readQueries(tree);				// read in the queries
	}
}
