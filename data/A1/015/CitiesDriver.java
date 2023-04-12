import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    static int [] safetyLevel;
    static int rightCity;
	static int leftCity;

    /** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
    MyTree tree = new MyTree();

    // read in one integer
	int n = sc.nextInt();

	// read in tree, safety line
	for (int i=0;i<n;i++){ 
	   safetyLevel[n]= sc.nextInt();			   
	}

	// loop to read pairs of children
	for (int i=0;i<n;i++) {

	    leftCity= sc.nextInt();			   
	    rightCity= sc.nextInt();
		tree.setCities(i, leftCity,rightCity,safetyLevel[i]);
	  }   

    }

    
    /** Read in query statements
     */
    public static void readQueries () {
    
	int origin[];
	int destination[];

	// read in one integer
	int m = sc.nextInt();
	
	origin=new int[m];
	destination=new int[m];

	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
  	   origin[i]= sc.nextInt();			   // modify this line
	   destination[i]= sc.nextInt();
	}   
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    
  
}
}
