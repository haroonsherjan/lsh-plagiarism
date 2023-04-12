import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;

    /** Read in the tree
     */
    public static void readTree () {	// read in one integer
	int n = sc.nextInt();  				// loop to read pairs of children
	
	MyTree t = new MyTree(n);			// instantiate and declare the size of the array
	
	for (int i=0;i<n;i++){
	
	int inLeft = sc.nextInt();
	int inRight = sc.nextInt();
	
//	   	t.setLeft(inLeft);				//input leftChildIndex			  
//	   	t.setRight(inRight);			//input rightChildIndex
	
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
    
    MyTree t = new MyTree();
	
	// read in one integer
	 int m = sc.nextInt(); 
	
	// loop to read pairs of children for query 
	for (int i=0;i<m;i++) {
	
	 int x = sc.nextInt();
	 int y = sc.nextInt();	    
	
	 System.out.print(t.checkRelation(x,y));
	
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
