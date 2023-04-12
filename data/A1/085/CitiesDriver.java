import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    
    /** Read in the tree
     */
    public static void readTree (MyTree cities) {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	// read in tree, safety line
	for (int i=0;i<n;i++)
	{
	    cities.insert(new MyNode(sc.nextInt()));
	}// modify this line
	
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    MyNode node = cities.getNode(i);
		node.setLeft(sc.nextInt());			   // modify this line
		
	    node.setRight(sc.nextInt());			   // modify this line
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries (MyTree cities) {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    int start = sc.nextInt();			   // modify this line
	    int end = sc.nextInt();
		if(start > end)
		{
			int temp = start;
			start = end;
			end = temp;
		}
		if(cities.travel(start, end))
			System.out.println("YES");
		else
			System.out.println("NO");
		// modify this line
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	MyTree cities = new MyTree();
	readTree(cities);				   // read in the tree
	readQueries(cities);				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
