import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver
{
	static Scanner sc;
	static int[] safety;	// Array to hold safety of cities
	static int[] left;	    // Array to hold left children
	static int[] right;     // Array to hold right children
	static int[] cityA;		// Array to hold starting cities
	static int[] cityB; 	// Array to hold ending cities

	/** Read in the tree
	 */
	public static void readTree ()
	{
		/// Read in the tree

		// read in one integer - the number of cities in the country
		int n = sc.nextInt();

		// read in tree, safety line
		safety = new int[n];

		for (int i = 0; i < n; i++) 
			safety[i] = sc.nextInt();			   // Safety of City i

		left = new int[n];
		right = new int[n];

		// loop to read pairs of children
		for (int i = 0; i < n; i++)
		{
			left[i] = sc.nextInt();			   // Left child of City i
			right[i] = sc.nextInt();		   // Right child of City i
		} // end for loop
	} // end readTree

	/** Read in query statements
	 */
	public static void readQueries()
	{
		// read in one integer
		int m = sc.nextInt();

		cityA = new int[m];
		cityB = new int[m];

		// loop to read pairs of children for query
		for (int i = 0; i < m; i++)
		{
			cityA[i] = sc.nextInt();			   // Starting city for query i
			cityB[i] = sc.nextInt();			   // Ending city for query i
		} // end for loop
	} // end readQueries

	public static void main(String[] args)
	{
		sc = new Scanner(System.in);
		readTree();				   // read in the tree
		readQueries();				// read in the queries

		// then process the queries ... fill in your calls below
		MyTree tree = new MyTree(safety, left, right);		
		
		// Processing the queries
		for (int i = 0; i < cityA.length; i++)
		{
			boolean isSafe = tree.isSafeTravelling(cityA[i], cityB[i]);
		
			if (isSafe)
				System.out.println("YES");
			else
				System.out.println("NO");
		} // end for loop
	} // end main
} // end class CitiesDriver
