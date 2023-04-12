import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
	static MyTree tree = new MyTree();
    static MyNode mn = new MyNode();
	/** Read in the tree
     */
static	int ai[];// = new ai[255];
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
   int ai[] =  new int[n];
// read in tree, safety line
	for (int i=0;i<n;i++){ 
	  // mn.insert(sc.nextInt());			   // modify this line
			ai[i] = sc.nextInt();		//add cities into array
	}
	// loop to read pairs of children
	//insert nodes into trees
	for (int i=0;i<n;i++) {
	    tree.insert(sc.nextInt());			   // modify this line
	    tree.insert(sc.nextInt());			   // modify this line
	}
    }
    
    /** Read in query statements
     */

	//read the queries
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
//	tree.printTree();
	int sarray1[] = new int[m];	//save 1st city into array
	int sarray2[] = new int[m];	//save 2nd city
	for (int i=0;i<m;i++) {
		sarray1[i] = sc.nextInt(); 
		sarray2[i] = sc.nextInt();
	}
   		for(int i = 0; i < m; i++){
			tree.safe(sarray1[i], sarray2[i]);
			
		}
   }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
