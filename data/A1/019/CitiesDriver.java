import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
   // static Scanner sc;
    
    /** Read in the tree
     */
    // MyTree tree = new MyTree();

   /* public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	// read in tree, safety line
	for (int i=0;i<n;i++) 
	    tree[i].setSafe(sc.nextInt());		    	// modify this line
		
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	   tree[i].setLeft( sc.nextInt());			   // modify this line
	   tree[i].setRight( sc.nextInt());			   // modify this line
	}
    } */
    
    /** Read in query statements
     */
   /* public static void readQueries () {
	// read in one integer
	int m = sc.nextInt(); 
	int[] firstCity = new int[m];
	int[] secondCity = new int[m];
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    firstCity[i] = sc.nextInt();			   // modify this line
	    secondCity[i] = sc.nextInt();			   // modify this line
	}
    } */
    
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	MyTree tree = new MyTree();

	//readTree();				   // read in the tree
	//readQueries();				// read in the queries
    /// Read in the tree
    // read in one integer
      int n = sc.nextInt();
	  // read in tree, safety line
     for (int i=0;i<n;i++)
	 {
        tree.myTree[i].setSafe(sc.nextInt()); 
		tree.size++;                                         // modify this line
     }
	    // loop to read pairs of children
     for (int i=0;i<n;i++) {
	       tree.myTree[i].setLeft( sc.nextInt());             // modify this line
		   tree.myTree[i].setRight( sc.nextInt());            // modify this line
	 }
       // read in one integer
	     int m = sc.nextInt();

		 int[] firstCity = new int[m];
         int[] secondCity = new int[m];

		 // loop to read pairs of children for query
        for (int i=0;i<m;i++) {
			firstCity[i] = sc.nextInt();               // modify this line
			secondCity[i] = sc.nextInt();              // modify this line
			}


	String[] result = new String[firstCity.length];

	// then process the queries ... fill in your calls below
   for(int i = 0; i < firstCity.length;i++) 
   {
    String temp = tree.check(firstCity[i], secondCity[i]);
    result[i] = temp;

    }

	for(int i=0; i < result.length; i++) 
	{
		System.out.println(result[i]);
	}


}
}
