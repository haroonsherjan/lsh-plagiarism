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
	// create an array to store cities' states
	boolean[]safe = new boolean[n];
	for (int i=0;i<n;i++) {
	   if(sc.nextInt() == 0){ // modify this line
		   safe[i] = false;
	   }
	   else
		   safe[i] = true;
	}
	
	// loop to read pairs of children
	// create an array to store left and right child
	int[]array = new int[n*2];
	for (int i=0;i<n*2;i++) {
	   array[i] =  sc.nextInt();			   // modify this line
	}// end for
	// create 2 arrays left and child
	int[]left = new int[n];
	int right[] = new int[n];
	 int j = 0;
    for(int i=0; i<array.length; i++){
		// even index refers to left child
		// odd index refer to right child
       if(i%2 == 0){
		   left[j] = array[i];
	   }
	   else{
		   right[j] = array[i];
       }
	   j++;
	} // end for
    // after this line we have 3 arrays safe, left and right
	MyTree tree = new MyTree(n, safe, left, right); // create tree
}// end readTree
	

    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	// create an array to store paths
	int[]path = new int[m*2];
	for (int i=0;i<m*2;i++) {
	    path[i] =  sc.nextInt();			   // modify this line
	}

	// check if there is path first, then check if both are safe
	/*for(int i=0; i<m*2; i+=2){
		// check if there is any path between the cities
	    if (path[i+1] != tree.myTree.get(path[i]).getLeft() && path[i+1] != tree.myTree.get(path[i]).getRight()){
			System.out.println("NO");
        }
		else{ // there is a path
			// then check if both are safe
			if(tree.myTree.get(path[i]).isSafe() ==  false || tree.myTree.get(path[i+1]).isSafe() == false){
                System.out.println("NO");
			}
			else // both are safe
				System.out.println("YES");
		}
	} // end for
	*/
}// end readQueries
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
} // end class
