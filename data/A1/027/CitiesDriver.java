import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
 static	int[] [] b;
 static	int[] p;
 static int n;   
 static int[][]q;
/** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
     n = sc.nextInt();
	// read in tree, safety line
	int[] p=new int[n];
	int[][] b=new int[n][2];
	for (int i=0;i<n;i++) 
	  p[i]=sc.nextInt();			   // modify this line
	
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	  b[i][0]=  sc.nextInt();			   // modify this line
	  b[i][1]=  sc.nextInt();			   // modify this line
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	q=new int[m][2];
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	   q[i][0]= sc.nextInt();			   // modify this line
	   q[i][1]= sc.nextInt();			   // modify this line
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries
    MyTree tree=new MyTree(n,p,b);
      
   
	// then process the queries ... fill in your calls below
 
	
	}
}
