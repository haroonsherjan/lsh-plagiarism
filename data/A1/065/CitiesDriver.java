import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
	static Scanner sc;


	/** Read in the tree
	 */
	public static void readTree () {
		/// Read in the tree
		// read in one integer
		MyTree tree = new MyTree();
		int n = sc.nextInt();
		// read in tree, safety line
		for (int i=0;i<n;i++)
		{
			int safe = sc.nextInt();	// modify this line
			tree.setSafe(i, safe);

		}	
		// loop to read pairs of children
		for (int i=0;i<n;i++) {
			int left = sc.nextInt();			   // modify this line
			int right = sc.nextInt();			   // modify this line
			tree.setLR(i, left, right);

		}
	}

	/** Read in query statements
	 */
	public static void readQueries () {
		// read in one integer
		int m = sc.nextInt();
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
			int a = sc.nextInt();			   // modify this line
			int b = sc.nextInt();			   // modify this line
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		readTree();				   // read in the tree
		readQueries();				// read in the queries


		// then process the queries ... fill in your calls below
	}
}
