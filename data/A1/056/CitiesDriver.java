import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    
    /** Read in the tree
     */
	public static void main(String[] args) {
	sc = new Scanner(System.in);
	MyTree tree = new MyTree();
	//readTree();				   // read in the tree
	//readQueries();				// read in the queries
    
	// then process the queries ... fill in your calls below
	

	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	// read in tree, safety line
	int[] arr = new int [n];
	for(int i=0;i<n;i++) 
	    arr[0]=sc.nextInt();			   // modify this line
	
	// loop to read pairs of children
	for(int i=0; i<n ;i++) {
        tree.addCity(i);

	}

	for(int i=0; i<n; i++){
		tree.safe(i,arr[0]);
	}
  
    
    /** Read in query statements
     */
    /*
	// read in one integer
	

	// in this lop i would call method which passes to MyTree 2 integers which are cities 
	  I did not have time to implement it
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    sc.nextInt();			   // modify this line
	    sc.nextInt();			   // modify this line
	}
	*/
}
}
