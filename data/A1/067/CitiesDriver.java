import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
//Finding the number of awards
    /** Read in the tree
     */MyTree city= new MyTree();
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	// read in tree, safety line
	for (int i=0;i<n;i++)
	{
	 int safeOrNt = sc.nextInt();// modify this line
	city.createNode(i);
}

	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	   int left =  sc.nextInt();			   // modify this line
	   int right =  sc.nextInt();			   // modify this line
		city.setchildren(i, left, right);
		}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	   int start =  sc.nextInt();			   // modify this line
	   int finish =  sc.nextInt();			   // modify this line
   		boolean safe = city.check(start, finish);
		if(safe)
			System.out.println("YES");
		else System.out.println("NO");
   }
}    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
