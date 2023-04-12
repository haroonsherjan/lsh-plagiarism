import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    
    /** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	MyTree readTree = new MyTree(n);//---------------------

	// read in tree, safety line
	for (int i=0;i<n;i++)
	//	MyTree.readNode(i, sc.nextInt());//-----------------non-static
	    sc.nextInt();			   // modify this line
	
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    sc.nextInt();			   // modify this line
	    sc.nextInt();			   // modify this line
	}
    }
    
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
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
	//if(first[i].getItem() == 0 && last[i].getItem() == 0)
	//	return !isSafe;
	//else if(first[i] != last[i]){
		//
	//	}
	//else return isSafe;	
    }
}
