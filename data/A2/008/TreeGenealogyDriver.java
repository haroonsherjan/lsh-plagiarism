import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;

    /** Read in the tree
     */
    public static void readTree () {
	// read in one integer
	int n = sc.nextInt();
	int[] allLeftChild = new int[n];
	int[] allRightChild = new int[n];
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	   int leftChild =  sc.nextInt();	   // leftChild
	   allLeftChild[i] = leftChild;
	   int rightChild =  sc.nextInt();			   // RightChild
	   allRightChild[i] = rightChild;
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	int[] nodeA = new int[m];
	int[] nodeB = new int[m];
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    int node1 =  sc.nextInt();     // what is Node 1's relationship to Node 2?
		nodeA[i] = node1;
	    int node2 = sc.nextInt();
		nodeB[i] = node2;
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();                // read in the tree
	MyTree tree = new MyTree(0, allLeftChild[0], allRightChild[0]);
	for(int i = 1; i < n; i++)
	{
		int parent = 0;
		for(int a = 0; a < n; a++)
		{
			if(allLeftChild[a] == i){parent = a;}
			if(parent = 0)
			{
				if(allRightChild[a] == i)
				{parent = a;}
			}
		tree.insertNode(i,allLeftChild[i], allRightChild[i], parent);
	}
	readQueries(); // read in the queries
    }
}
}
