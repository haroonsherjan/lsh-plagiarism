import java.util.*;

public class CitiesDriver 
{
    static Scanner sc;
    
    /*
	 * Read in the tree
     */
    public static void readTree() 
	{
		// Read in the tree
		// Read in number of cities
		int n = sc.nextInt();
	
		// read in tree, safety line
		int[] safety = new int[n]; 
		for (int i=0; i<n; i++) 
			safety[i] = sc.nextInt();	        // 1: safe; 0: unsafe
	
		// loop to read pairs of children
		int[][] children = new int[n][2];
		for (int i=0; i<n; i++) 
		{
			children[i][0] = sc.nextInt();
			children[i][1] = sc.nextInt();
		}
    }
    

    /*
	 * Read in query statements
     */
    public static void readQueries() 
	{
		// number of queries
		int m = sc.nextInt();
		
		// loop to read pairs of children for query
		int[][] queries = new int[m][2];
		for (int i=0; i<m; i++) 
		{
			queries[i][0] = sc.nextInt();  // starting point
			queries[i][1] = sc.nextInt();  // destination
		}
    }
    

    public static void main(String[] args) 
	{
		sc = new Scanner(System.in);
		readTree();				   // read in the tree
		readQueries();			   // read in the queries

		boolean safe;

		if (safety[i] == 1)
			safe = true;
		else 
			safe = false;
		int j=0;
		while (j<2 && safe)
			for (int i=0; i<m; i++)
			{
				int parent = -1;
				int startingpoint = query[i][j];
				while (parent !=0 && safe)
				{
					for (int city=0; city<n; city++)
					{	
						for (int child=0; child<2; child++)
						{
							if (startingpoint == children[city][child])
								parent = city;
						}
					}
					startingpoint = parent;
					if (safety[startingpoint] == 1)
						safe = true;
					else
						safe = false;
				} 
			}
		if (safe)
			System.out.println("YES");
		else
			System.out.println("NO");
    }
}
