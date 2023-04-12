import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
     

    /** Read in the tree
     */
    public static void readTree () {
	
	int leftChild;
	int rightChild;
	
	// read in one integer
	int n = sc.nextInt();
	// loop to read pairs of children
	for (int i=0; i<n; i++) {
		leftChild = sc.nextInt();			   // modify this line
	    rightChild = sc.nextInt();			   // modify this line
		insert(i, leftChild, rightChild); // insert elements into tree
	}
	}
    
    /* Read in query statements
     */
    public static void readQueries () {
	
	int firstNode;
	int secondNode;
	
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    firstNode = sc.nextInt();			   // modify this line
	    secondNode = sc.nextInt();			   // modify this line
		System.out.println(relationship(firstNode, secondNode));
	}
    }
    
    public static void main(String[] args) {
	
	MyTree tree =  new MyTree();
	
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
