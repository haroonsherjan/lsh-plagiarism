import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;

    /** Read in the tree
     */
    public static void readTree(MyTree myTree) {
		// read in one integer
		int n = sc.nextInt();
	
		// loop to read pairs of children	
		for (int i=0;i<n;i++) {
	    	myTree.setNode(sc.nextInt(), sc.nextInt(), i);
		}
    }
    
    /** Read in query statements
     */
    public static void readQueries(MyTree myTree) {
		// read in one integer
		int m = sc.nextInt();
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();

			if (myTree.isAncestor(a, b)) {
				System.out.println("ANCESTOR");
			}

			else if (myTree.isDescendant(a, b)) {
				System.out.println("DESCENDANT");
			}
			
			else if (myTree.isLeftSibling(a, b)) {
				System.out.println("LEFT SIBLING");
			}

			else if (myTree.isRightSibling(a, b)) {
				System.out.println("RIGHT SIBLING");
			}
	    	
			else {
				System.out.println("NONE");	
			}
		}
    }
    
    public static void main(String[] args) {
		sc = new Scanner(System.in);
		MyTree myTree = new MyTree();
		readTree(myTree);				   // read in the tree
		readQueries(myTree);			   // read in the queries
	
	}
}
