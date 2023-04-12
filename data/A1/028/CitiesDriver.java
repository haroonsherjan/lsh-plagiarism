import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
	static ArrayList<MyNode> storeCities = new ArrayList<MyNode>();
    /** Read in the tree
     */
	static MyNode root;
	static MyTree travel = new MyTree(root);
	static int size;
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt() + 1;
	size = n;
	// read in tree, safety line
	for (int i=0;i<n;i++)
	{
		storeCities.add(i, new MyNode(sc.nextInt(),i));
	}			   // modify this line

	// loop to read pairs of children
	for (int i=0;i<n;i++) {
		MyNode temp = storeCities.get(i);
		int left = sc.nextInt();
		int right = sc.nextInt();
		if(left != -1)
		{
		temp.setLeft(storeCities.get(left));
		}// modify this line

		if(right != -1){
		temp.setRight(storeCities.get(right));
		}                        // modify this line
		storeCities.set(i,temp);
	}
	root = storeCities.get(0);
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
		int start = sc.nextInt();			   // modify this line
	    int end = sc.nextInt();			   // modify this line
		if(start < size && end < size ){
		System.out.println(travel.safeRoute(storeCities.get(start), storeCities.get(end)));
		}else
		{
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
