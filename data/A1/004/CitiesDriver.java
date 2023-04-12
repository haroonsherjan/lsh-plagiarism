import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    static MyTree mt;
    /** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	// read in tree, safety line
	for (int i=0;i<n;i++) {
	   int safety=sc.nextInt();
       mt.updateSafety(i,safety);}
	
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	   int left=sc.nextInt();			  
	   int right=sc.nextInt();
	   mt.updateChild(i,left,right);
	  }
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    int start=sc.nextInt();			  
	    int end=sc.nextInt();
		boolean exist=mt.safePath(start,end);
		if(exist==true)
			System.out.println("Yes");
	    else System.out.println("No");
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	mt=new MyTree();
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
