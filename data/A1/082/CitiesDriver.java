import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver
{
    static Scanner sc;
    static MyTree cityMap;

    /** Read in the tree
     */
    public static void readTree ()
	{
		/// Read in the tree
		// read in one integer
		int n = sc.nextInt();
		// read in tree, safety line;
		sc.nextLine();
		int[] cityStatus = new int[n] ;

		for (int i=0;i<n;i++)
		{
	   		cityStatus[i] = sc.nextInt();
		}

		// loop to read pairs of children
		for (int i=0;i<n;i++)
		{
	    	cityMap.addCity(i, cityStatus[i], sc.nextInt(), sc.nextInt());
		}
    }
    
    /** Read in query statements
     */
    public static void readQueries ()
	{
		// read in one integer
		int m = sc.nextInt();

		boolean isSafe = false;

		// loop to read pairs of children for query	
		for (int i=0;i<m;i++)
		{
			isSafe = cityMap.checkRoute(sc.nextInt(), sc.nextInt());

			if (isSafe)
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
		}
    }
    
    public static void main(String[] args)
	{
		sc = new Scanner(System.in);
		cityMap = new MyTree();

		readTree();				   // read in the tree
		readQueries();				// read in the queries
    }
}
