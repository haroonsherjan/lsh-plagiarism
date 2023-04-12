import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */

import java.util.*;

public class TreeGenealogyDriver {
    static Scanner sc;
    /** Read in the tree
     */

    public static MyTree readTree () {
		// read in one integer
		int n = sc.nextInt();
		// loop to read pairs of children
		int[] temp = new int[n*2];
		for (int i=0;i<2*n;i++) {
	    	temp[i] = sc.nextInt();
		}
		return new MyTree(temp);
    }
    
    /** Read in query statements
     */
    public static void readQueries (MyTree tree) {
		// read in one integer
		int m = sc.nextInt();
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
	    	System.out.println(tree.checkRelation(sc.nextInt(),sc.nextInt()));
		}
    }
    
    public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		MyTree t = readTree();				   // read in the tree
		readQueries(t);				// read in the queries

		// then process the queries ... fill in your calls below
    }//end main
}//end TreeGenealogyDriver
