import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    
    /** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int N = sc.nextInt();
	// read in tree, safety line
	
	private static MyTree[] myTree = new MyTree[N];

	for (int i=0;i<N;i++) 
		myTree[i].setStatus(sc.nextInt());
	
	// loop to read pairs of children
	for (int i=0;i<N;i++) {
		int l = sc.nextInt();      // the left child of the current node
		int r = sc.nextInt(); 	   // the right child of the current node
		if (i==0) myTree.setParent(null);
		else myTree[i].setParent((i-1)/2);
		MyTree node1 = myTree[2i+1];
		node1.setLChild(l);
		MyTree node2 = myTree[2i+2];
		node2.setRChild(r);
	  	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int M = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<M;i++) {
	    int startCity = sc.nextInt();
		int endCity = sc.nextInt();

		boolean ans = myTree.determine(startCity, endCity);

		if (ans) 
			System.out.println("YES");
		else
			System.out.println("NO");
	} 
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
