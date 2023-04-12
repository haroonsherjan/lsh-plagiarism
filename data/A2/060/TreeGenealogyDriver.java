import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
	static MyTree treeList;
    /** Read in the tree
     */
    public static void readTree () {
	// read in one integer
		int n = sc.nextInt();
	// loop to read pairs of children
		for (int i=0;i<n;i++) {
	    	int left=sc.nextInt();			   // modify this line
	    	int right=sc.nextInt();			   // modify this line
			
			treeList.add(left);			   // add to the left side of the parent
			treeList.add(right);		   // add to the right side of the parent
		}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
		int m = sc.nextInt();
	// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
	    	int A=sc.nextInt();			   // modify this line
	    	int B=sc.nextInt();			   // modify this line

			treeList.queryTree(A,B);
		}
    }
    
    public static void main(String[] args) {
		sc = new Scanner(System.in);
		treeList=new MyTree();
		readTree();				   // read in the tree
		readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
		
		treeList.print();			//print the list of the tree relationship after it has done the query.
    }
}
