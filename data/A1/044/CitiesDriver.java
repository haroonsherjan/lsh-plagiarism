import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver extends MyTree {
    static Scanner sc;
    MyNode[] myTree;
    /** Read in the tree, storing leftChildIndex, rightChildIndex, and safety for each node in the myTree array
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	// read in tree, safety line
	for (int i=0;i<n;i++) 
	    		   // modify this line
	 //   myTree[i].setSafety = sc.nextInt(); //set the safety index for each node in the myTree array
	// loop to read pairs of children
	
	for (int j=0;j<n;j++) {
	// myTree[j].setLeft = sc.nextInt();			   // modify this line
	// myTree[j].setRight =  sc.nextInt();			   // modify this line
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
//	readTree();				   // read in the tree
//	readQueries();				// read in the queries
    int startingPoint = sc.nextInt();
 	int destination = sc.nextInt();
//  travel(startingPoint, destination)  //method from ADT MyTrees to check whether if the journey is safe or not    
	//read the next line of query if there is any, then if there is, perform travel method again
    }
}
