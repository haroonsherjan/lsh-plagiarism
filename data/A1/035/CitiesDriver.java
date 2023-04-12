import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver 
{
    static Scanner sc;
	
    
    /** Read in the tree */
    public static void readTree (MyTree[] myTree)
	{
		/// Read in the tree
		// read in one integer
		int n = sc.nextInt();

		// read in tree, safety line
		for (int i=0; i<n; i++)
		{
	    	myTree[i].setCityState(sc.nextInt());			   // declaring cities safe or unsafe
			myTree[i].setCityNum(i);
		}

		// loop to read pairs of children
		for (int i=0;i<n;i++) 
		{
			int leftChild = sc.nextInt();
			int rightChild = sc.nextInt();

			if (leftChild != -1)
	    		myTree[i].setLeft(myTree[leftChild]);	// left child

			if (rightChild != -1)
	    		myTree[i].setRight(myTree[rightChild]);	// right child
		}
    }
    
    /** Read in query statements
     */
    public static void readQueries (MyTree myTree) 
	{
		// read in one integer
		int m = sc.nextInt();
		// loop to read pairs of children for query
		for (int i=0; i<m; i++)
		{
	    	int startCity = sc.nextInt();		   // Starting city
	    	int endCity = sc.nextInt();            // Destination city
			System.out.println(myTree.query(myTree, startCity, endCity));
	    }
    }
    
    public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		MyTree[] myTree = new MyTree[1000];
		readTree(myTree);				   // read in the tree
		readQueries(myTree[0]);				// read in the queries
    }
}
