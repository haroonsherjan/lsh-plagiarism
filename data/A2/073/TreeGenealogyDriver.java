import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    sc.nextInt();			   // modify this line
	    sc.nextInt();			   // modify this line
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	MyTree bt = new MyTree(0);

	int n = sc.nextInt();
	for(int i=0; i<n; i++) {
		int left = sc.nextInt();
		int right = sc.nextInt();
		bt.insert(left);
		bt.insert(right);
	}

	//readQueries();				// read in the queries
	//bt.inorder();
	// then process the queries ... fill in your calls below
    }
}
