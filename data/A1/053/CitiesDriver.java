import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    
    /** Read in the tree
     */
    public static void readTree (MyTree tree) {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	// read in tree, safety line
	for (int i=0;i<n;i++)  {
	   int temp =  sc.nextInt();// modify this line
       MyNode tempNode;
	   if(temp==0) {
		   tempNode = new MyNode(false);
	   }
	   else 
		   tempNode = new MyNode(true);
	   tree.add(tempNode);
	}

	
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    int left =  sc.nextInt();			   // modify this line
	    int right = sc.nextInt();			   // modify this line
		tree.get(i).setLeft(left);
		tree.get(i).setRight(right);
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries (MyTree tree) {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    int start = sc.nextInt();			   // modify this line
	    int end = sc.nextInt();			   // modify this line
        System.out.println(tree.isSafe(start,end)); 
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	MyTree tree = new MyTree();
	readTree(tree);				   // read in the tree
	readQueries(tree);				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
