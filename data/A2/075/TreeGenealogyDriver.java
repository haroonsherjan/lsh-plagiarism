import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc; 
    static String read=""; 
    static String queries="";
	static int readSize=0;
	static int querySize=0;


    /** Read in the tree
     */
    public static void readTree () {
		// read in one integer
		int n = sc.nextInt();
		readSize = n;
		// loop to read pairs of children
		for (int i=0;i<n*2;i++) {
	  	   read += sc.nextInt();			   // modify this line
		}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
		// read in one integer
		int m = sc.nextInt();
		querySize = m;
		// loop to read pairs of children for query
		for (int i=0;i<m*2;i++) {
		    queries += sc.nextInt();			   // modify this line
		}
    }
    
    public static void main(String[] args) {
		sc = new Scanner(System.in);
		readTree();				   // read in the tree
		readQueries();				// read in the queries
	
		MyTree tree = new MyTree();
	
		for(int i=0; i<querySize*2; i++){
	
	 	//we are reading in m*2 inputs	 
		//int nextInput1	= queries.nextInt();
		//int nextInput2 = queries.nextInt();
		//tree.getRelation(nextInput1,nextInput2);  to process the queries
		 	
		}//end for
		
	// then process the queries ... fill in your calls below
    }
}
