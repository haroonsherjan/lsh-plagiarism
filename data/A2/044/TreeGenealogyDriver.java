import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
   // static Scanner sc;
    
	//I changed the structure of the original Driver class
	//in order to put the two seperate methods together in one method,
	//so that they can share the new created "MyTree" directly
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

    /** Read in the tree
     */
   // public static void readTree () {

    // read in one integer
	int n = sc.nextInt();
	// loop to read pairs of children
	int node1;
	int node2;
	MyTree tree = new MyTree();
	for (int i=0;i<n;i++) {
	    node1 = sc.nextInt();			   // modify this line
	    node2 = sc.nextInt();              // modify this line
		tree.buildTree(node1, node2);
	}
   
    //after read in the tree
    
    /** Read in query statements
     */
   // public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	int n1;
	int n2;
	for (int i=0;i<m;i++) {
	    n1 = sc.nextInt();			   // modify this line
	    n2 = sc.nextInt();			   // modify this line
		System.out.println(tree.findRelationship(n1, n2));
	}
    }//end main
    
    /*public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }*/
}//end class
