import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
	static Scanner sc;

    /** Read in the tree
     */
    public static void readTree (MyTree myTree) {
		// read in one integer
		int n = sc.nextInt();
		
		// loop to read pairs of children
		for (int i=0;i<n;i++) {
	    	myTree.insert(sc.nextInt(), sc.nextInt(),i);
    	}// end for
	}// end readTree
    
    /** Read in query statements
     */
    public static void Queries (MyTree myTree) {
		// read in one integer
		int m = sc.nextInt();
		
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
	    	System.out.println(myTree.relation(sc.nextInt(),sc.nextInt()));
		}// end for
    }// end readQueries
    
    public static void main(String[] args) {
		sc = new Scanner(System.in);
		MyTree myTree = new MyTree();

		readTree(myTree);				   // read in the tree
		Queries(myTree);				// read in the queries

    }// end main
}// end TreeGenealogyDriver
