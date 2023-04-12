import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
	static Scanner sc;
	static MyTree Cities = new MyTree();
	/** Read in the tree
	 */
	public static void readTree () {
		/// Read in the tree
		// read in one integer
		int n = sc.nextInt();
		// read in tree, safety line
		int[] safety = new int[n]; // store all the safety values
		for (int i=0;i<n;i++){ 
			safety[i] = sc.nextInt();
		}

		// insert root node first (no parent, safety[0], key value 0)
		Cities.insert(-1, safety[0], 0);

		// loop to read pairs of children
		//int parent = 0; // track parent array index value
		// parent array index value is = i
		for (int i=0;i<n;i++) {
			int left = sc.nextInt();
			int right = sc.nextInt();
			
			// insert left child first
			if (left != -1) // city exists
				Cities.insert(i, safety[left],left);
			else // insert an empty city
				Cities.insert(i, 0, -1);
			
			// insert right child
			if (right != -1)
				Cities.insert(i, safety[right], right);
			else
				Cities.insert(i,0,-1);
			
		//	index++;
		}
	}
	/** Read in query statements
	 */
	public static void readQueries () {
		// read in one integer
		int m = sc.nextInt();
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
			int start = sc.nextInt();			   
			int end = sc.nextInt();
			if (Cities.isSafeRoute(start,end)){
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		readTree();				   // read in the tree
		readQueries();				// read in the queries

	}
}
