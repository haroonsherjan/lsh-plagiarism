import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;

    /** Read in the tree
     */
    public static void readTree (MyTree tree) {
	// read in one integer
	int n = sc.nextInt();
	// loop to read pairs of children
		for (int i=0;i<n;i++) {
			tree.add(sc.nextInt());			   // modify this line
	    	tree.add(sc.nextInt());			   // modify this line
		}
    }
    
    /** Read in query statements
     */
    public static int getIndex(int index, MyTree tree){
		for(int i=0; i < tree.myTree.length; i++){
			if (tree.myTree[i] == index)
				return i;
		}
		return -1;
	}
	
	public static void readQueries (MyTree tree) {
		// read in one integer
		int m = sc.nextInt();
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
	    	int A = getIndex(sc.nextInt(), tree);			   // modify this line
	    	int B = getIndex(sc.nextInt(), tree);			   // modify this line
			if (tree.isRight(A, B))
				System.out.println("RIGHT SIBLING");
			else if (tree.isLeft(A,B))
				System.out.println("LEFT SIBLING");
			else if (tree.isAncestor(A,B))
				System.out.println("ANCESTOR");
			else if (tree.isDescendant(A,B))
				System.out.println("DESCENDANT");
			else
				System.out.println("NONE");
		}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	MyTree tree = new MyTree();
	readTree(tree);				   // read in the tree
	readQueries(tree);				// read in the queries
    }
}
