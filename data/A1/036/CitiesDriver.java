import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
	static MyTree cities;
	static int[] starts;
	static int[] ends;
    
    /** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	// read in tree, safety line
	cities = new MyTree();
	for (int i=0;i<n;i++) 
	{	
		cities.insert(i, new MyNode(sc.nextInt()));
//		System.out.println(cities.get(i).getSafe());
	}
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    cities.get(i).setLeft(sc.nextInt());			   // modify this line
	    cities.get(i).setRight(sc.nextInt());			   // modify this line
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	starts = new int[m];
	ends = new int[m];
	for (int i=0;i<m;i++) 
	{
	    starts[i]  = sc.nextInt();			   // modify this line
	    ends[i] = sc.nextInt();          // modify this line
    }
	}
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries
   	
	for(int i = 0; i < starts.length; i++)
	{
		if(starts[i] == ends [i])
		{
			if(cities.get(starts[i]).getSafe() == true)
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
		}
		else
		{
			//findCommonRoots(starts[i], ends[i]);returns array that is the path between start and end
			//
			//checkSafety(MyNode[] path ) if any of the values in the findCommonRoots is false, returns false
		}
	}
	//need to backtrack to common parent, than from common parent check the safety of the path. stuck when trying to backtrack. 
	//compilation error while trying to set parent. this is the most skeleton, workable piece.
    }
	
}
