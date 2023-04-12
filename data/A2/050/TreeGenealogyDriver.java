import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver 
{
    static Scanner sc;
	static MyTree myTree;
    /** Read in the tree
     */
    public static void readTree () 
	{
		// read in one integer
		int n = sc.nextInt();
		// loop to read pairs of children
		int A = 0;
		int B = 0;
		myTree = new MyTree();

		for (int i=0;i<n;i++) 
		{
	   		A = sc.nextInt();			   // modify this line
	   		B = sc.nextInt();			   // modify this line
	   
	   		myTree.insert(A);
			myTree.insert(B);
			//first create the tree and insert in the elements
		}
    }
    
    /** Read in query statements
     */
    public static void readQueries () 
	{
		// read in one integer
		int m = sc.nextInt();
		// loop to read pairs of children for query
		int X = 0;
		int Y = 0;
		for (int i=0;i<m;i++) 
		{
	    	X = sc.nextInt();			   // modify this line
	    	Y = sc.nextInt();			   // modify this line

			myTree.search(X,Y);
			//we first need to search through the tree to see where the 2 elements are in the first place
		}
    }
    
    public static void main(String[] args) 
	{
		sc = new Scanner(System.in);
		readTree();				   // read in the tree
		readQueries();				// read in the queries

	// then process the queries ... fill in your calls below

		
    }
}
