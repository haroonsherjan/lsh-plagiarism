import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;

    /** Read in the tree
     */
    public static MyTree readTree () {
	// read in one integer
	int n = sc.nextInt();
	MyNode[] tree = new MyNode[n];// Creat a new tree of MyNode
	int left,right;               //Left and right child index

	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    left = sc.nextInt();			   // modify this line
	    right = sc.nextInt();              // modify this line
		tree[i] = new MyNode(left,right);  // Add the new node into the tree 
	}
	return new MyTree(tree,n);             // Return specified tree
    }
    
    /** Read in query statements
     */
    public static void readQueries (MyTree aTree) {
	// read in one integer
	int m = sc.nextInt();
	int intA,intB;
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    intA = sc.nextInt();			   // modify this line
	    intB = sc.nextInt();               // modify this line
		System.out.println(aTree.getRelation(intA,intB)); // Find out the relation between the two nodes and print it
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	MyTree aTree = readTree();				   // read in the tree
	readQueries(aTree);				           // read in the queries and print the result

	// then process the queries ... fill in your calls below

    }
}
