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
	// read in one integer
	int n = sc.nextInt();
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    int left = sc.nextInt();
	    int right = sc.nextInt();
		tree.insert(left);
		tree.insert(right);
	}
	}
    
	
    /** Read in query statements
     */
	static int[] queries;
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	int a,b;
	queries = new int[m*2];
	for (int i=0;i<m;i++) {
	    a = sc.nextInt();
	    b = sc.nextInt();
        queries[2*i] = a;
		queries[2*i+1] = b;
	}
    }
    
	static MyTree tree = new MyTree();
    public static void main(String[] args) {
		sc = new Scanner(System.in);
		readTree();				   // read in the tree
		readQueries();				// read in the queries
        process(queries);
    }
    
	// get the index of number A and B, say a and b respectively, 
	// call MyTree methods descendant, ancestor, isLeftSibling, isRightSibling and nothing
	// to check the relationship between A and B
	public static void process (int[] q) {
		// a and b are indexes of A and B respectively
		// initialize a,b,A,B
		int A=-1;
		int B=-1;
		int a=-1;
		int b=-1;

		for (int i=0; i<q.length; i=i+2) {
			A = q[i];
	        B = q[i+1];
			// get the index of A and B in the array myTree
			for (int j=0; j<tree.getMyTree().length; j++) {
				if (A==tree.getMyTree()[j].getItem())
					a = j;
					if (B==tree.getMyTree()[j].getItem())
						b = j;
			}

			tree.descendant(a,b);
			tree.ancestor(a,b);
			tree.leftSibling(a,b);
			tree.rightSibling(a,b);
			tree.nothing(a,b);
		}
		
	}
}
