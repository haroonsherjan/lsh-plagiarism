import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
 import java.util.*;
public class TreeGenealogyDriver {
    static Scanner sc;
	static ArrayList<Integer> query = new ArrayList<Integer>();
    static MyTree tree;
    /** Read in the tree
     */
    public static void readTree () {
	// read in one integer
	int n = sc.nextInt(); //num of Nodes in tree
	int[] data = new int[n];
	data[0] = 0;
	// loop to read pairs of children for each Node i
	for (int i=1;i<n;i++) {
	    data[i] = sc.nextInt();
	}
	tree = new MyTree(data);
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    query.add(sc.nextInt()); //add each int into arraylist query
		//Each int is the label of the node
	}//end for
    }//end readQueries
    
    public static void main(String[] args) 
	{
		sc = new Scanner(System.in);
		readTree();				   // read in the tree
		readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
	    //for each query, check the relationship by calling the methods
		for(int j=0; j<query.size()-2; j+=2)
		{
			//check each pair of int (each query)
			int x = query.get(j);
			int y = query.get(j+1);
			//check relationship of node x and node y
			String output = tree.checkRelationship(x,y);
			System.out.println(output);
		}

    }//end main
}
