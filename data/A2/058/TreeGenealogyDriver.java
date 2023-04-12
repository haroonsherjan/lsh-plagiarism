import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
    static MyTree tree;
    /** Read in the tree
     */
    public static void readTree () {
	// read in one integer
	int n = sc.nextInt();
	// loop to read pairs of children
	int[] tempTree = new int[n*2+1];
	tempTree[0] = 0;//root of the tree

    tree = new MyTree(tempTree.length);
	for (int i=1;i<n;i+=2) {
	    tempTree[i] = sc.nextInt();
		tempTree[i+1] = sc.nextInt();
	}
    tree.setTreeArray(tempTree);
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	   int a = sc.nextInt();
	   int b = sc.nextInt();
	   //compare and print out the relationship of both a and b
	   System.out.println(tree.checkRelation(a, b));
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries    
    }
}
