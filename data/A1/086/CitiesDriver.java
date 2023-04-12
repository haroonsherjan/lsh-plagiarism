import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    
    /** Read in the tree
     */
    public static MyTree readTree () {
	/// Read in the tree
	// read in one integer

    //ArrayList<Integer> temp = new ArrayList<Integer>(); //storing the safe and unsafe countries
    	
	int n = sc.nextInt();
	int temp[] = new int[n];
	
	// read in tree, safety line
	for (int i=0;i<n;i++) 
	{
	    temp[i] = (sc.nextInt());			   // modify this line
	}

    MyTree tree = new MyTree (0, temp[0]);
	// loop to read pairs of children
	
	for (int i=1;i<n;i++) {
	   tree.insert(sc.nextInt(), temp[i]);			   // modify this line
	   tree.insert(sc.nextInt(), temp[i]);			   // modify this line
		}


		return tree;
    }
    


    /** Read in query statements
     */
    public static void readQueries (MyTree tree) {
	// read in one integer
	int m = sc.nextInt();
    	

 	int safeTemp = 0;
	
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    
		sc.nextInt();
		sc.nextInt();			   // modify this line
	    			   // modify this line
		
		
		}



    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	MyTree tree = new MyTree();

	tree = readTree();				   // read in the tree
	readQueries(tree);				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
