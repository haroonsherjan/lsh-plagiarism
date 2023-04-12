import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
	public static MyTree cities;
	public static int[][] queries;

    static Scanner sc;
    
    /** Read in the tree
     */
    public static void readTree () {
		/// Read in the tree
		// read in one integer
		int n = sc.nextInt();
		// read in tree, safety line
		
		int[] safePath = new int[n];
		for (int i=0; i<n; i++) safePath[i] = sc.nextInt();
		
		cities = new MyTree(n);
		// loop to read pairs of children
		
		for (int i=0; i<n; i++) {
			int j = sc.nextInt();
			int k = sc.nextInt();
			cities.insert(new MyNode(i, j, k));   // i = city, j = leftNode, k = rightNode
		}

		cities.setSafe(safePath);
	}
    
    /** Read in query statements
     */
    public static void readQueries () {
		// read in one integer
		int m = sc.nextInt();
		// loop to read pairs of children for query
		
		queries = new int[m][2];

		for (int i=0; i<m; i++) {
			queries[i][0] = sc.nextInt();
			queries[i][1] = sc.nextInt();
		}
	}
    
    public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		readTree();				   // read in the tree
		readQueries();       // read in the queries

		// to check queries
		for(int i=0; i<queries.length; i++) {
			int city1 = queries[i][0];   //assigning city 1
			int city2 = queries[i][1];   //assigning city 2

			if(cities.checkSafe(city1, city2)) System.out.println("YES");   //Checks if it is safe
			else System.out.println("NO");
		}
	}
}
