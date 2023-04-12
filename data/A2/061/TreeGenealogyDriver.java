import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
	static Scanner sc;
	static MyNode[] myTree;
	int leftChild = 0, rightChild = 0, num1 = 0, num2 = 0;

	/** Read in the tree
	 */
	public static void readTree () {
		// read in one integer
		int n = sc.nextInt();
		
		// loop to read pairs of children
		for (int i=0;i<n;i++) {
			// read in left child
			leftChild = sc.nextInt();              // modify this line
			//read in right child
			rightChild = sc.nextInt();			   // modify this line
			myTree.insert(leftChild, rightChild);
		}
	}

	/** Read in query statements
	 */
	public static void readQueries () {
		// read in one integer
		int m = sc.nextInt();
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
			num1 = sc.nextInt();			   // modify this line
			num2 = sc.nextInt();			   // modify this line
			System.out.println(myTree.relation(num1, num2));
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		readTree();				   // read in the tree
		readQueries();				// read in the queries

		// then process the queries ... fill in your calls below
	}
}
