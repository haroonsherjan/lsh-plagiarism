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
	// read in tree, safety line
	boolean isSafe;
	int safety= 0;

	int MAX_NODES = 1000;
	 MyTree [] myTree = new MyTree[MAX_NODES];


	for (int i=0;i<n;i++) 
		
	    safety = sc.nextInt();// modify this line
		if (safety ==0){
			isSafe = false;
		}
		else {
			isSafe = true;
		}
		

	 

	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	   
	    
	    myTree[i].setLeft(sc.nextInt());			   // modify this line
	    myTree[i].setRight(sc.nextInt());			   // modify this line
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
    }
}
