import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
	static Scanner sc;

	/** Read in the tree
	 */

	static MyTree tree = new MyTree();


	public static void readTree () {
		/// Read in the tree
		// read in one integer
		int n = sc.nextInt();
		// read in tree, safety line
		for (int i=0;i<n;i++){
			int safeIndex = i;
			tree.safeCity(safeIndex, sc.nextInt());// modify this line
		}
		// loop to read pairs of children
		for (int i=0;i<n;i++) {
			tree.leftChild(i, sc.nextInt());			   // modify this line
			tree.RightChildt(i, sc.nextInt());			   // modify this line
		}
	}

	/** Read in query statements
	 */

	public static void readQueries () {
		// read in one integer
		int m = sc.nextInt();
		static String[] safeRoute = new String[m];
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
			//check if route is safe from start city to end city inclusive
			if (tree.checkSafeCity(sc.nextInt(), sc.nextInt()){
					safeRoute[i] = "YES";
					}else {
					safeRoute[i] = "NO";
					// modify this line
					}
					}
					}

					public static void main(String[] args) {
					sc = new Scanner(System.in);
					readTree();				   // read in the tree
					readQueries();				// read in the queries

					// then process the queries ... fill in your calls below
					//print out the answer for each query
					for (int i = 0; i < safeRoute.length; i++){
					System.out.println(safeRoute[i]);
					}
					}
					}
