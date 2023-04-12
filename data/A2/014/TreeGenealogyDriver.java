import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;

	MyTree mT = new MyTree();

    /** Read in the tree
     */
    public static void readTree () {
	// read in one integer
	int n = sc.nextInt();
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    int r1 = sc.nextInt();			   // modify this line
	    int r2 = sc.nextInt();
		int n = mT.index(i);
		Node h = mT.get(n);
		h.setLeft(2n + 1);
		h.setRight(2n + 2);
		mT.get(h.getLeft()).setElem(r1);
		mT.get(h.getRight().setElem(r2);
		}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    int q1 = sc.nextInt();			   // modify this line
	    int q2 = sc.nextInt();
		System.out.println(mT.relation(q1, q2));
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
