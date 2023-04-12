import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
	static MyTree tree;
    
    /** Read in the tree
     */
    public static void readTree () {
		int n = sc.nextInt();
		tree = new MyTree(n);
		int[] safety = new int[n];
		for (int i=0;i<n;i++) { 
		    int safe = sc.nextInt();			   // modify this line
			safety[i] = safe;
		}
		tree.addSafety(safety);
		int left,right;
		for (int i=0;i<n;i++) {
		    left = sc.nextInt();			   // modify this line
		    right = sc.nextInt();			   // modify this line
			tree.addNode(left,right);
		}
	}
    
    /** Read in query statements
     */
    public static void readQueries () {
		int m = sc.nextInt();
		int start,end;
		for (int i=0;i<m;i++) {
			start = sc.nextInt();			   // modify this line
	    	end = sc.nextInt();			   // modify this line
			if(tree.isSafe(start,end)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
    }
    
    public static void main(String[] args) {
		sc = new Scanner(System.in);
		readTree();				   // read in the tree
		readQueries();				// read in the queries
	}
}
