import java.util.*;

public class CitiesDriver {
    static Scanner sc;
	static MyTree mt = new MyTree();
    
    /** Read in the tree
     */
    public static void readTree () {
		// Read in the tree
		// read in one integer
		int n = sc.nextInt();
		// read in tree, safety line
		for (int i=0;i<n;i++){
		    int safety = sc.nextInt();
			mt.setSafe(i, safety);
		}

		// loop to read pairs of children
		for (int i=0;i<n;i++) {
		    int l = sc.nextInt();
			mt.setLeft(i,l);
			int r = sc.nextInt();
			mt.setRight(i,r);
		}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
 		// read in one integer
		int m = sc.nextInt();
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
		    int start = sc.nextInt();
	   		int end = sc.nextInt();
			mt.travel(start,end);
		}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries
    }
}
