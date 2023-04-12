import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver 
{
    static Scanner sc;

    /** Read in the tree
     */
	 /*
    public static void readTree () 
	{
		// read in one integer
		int n = sc.nextInt();
		// loop to read pairs of children
		for (int i=0;i<n;i++) 
		{	
	    	int leftChild = sc.nextInt();
	    	int rightChild = sc.nextInt(); 

			if (leftChild == -1 && rightChild != -1)
			{
				insert(rightChild);
			}

			else if (leftChild != -1 && rightChild == -1)
			{
				insert(leftChild);
			}
		}
    }*/
    
    /** Read in query statements
     */
	/*
    public static void readQueries () 
	{
		// read in one integer
		int m = sc.nextInt();
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) 
		{
	    	int A = sc.nextInt();			   // modify this line
	    	int B = sc.nextInt();			   // modify this line
		}
    }*/
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	
	MyTree myIntTree = new MyTree();
	myIntTree.setRoot(0);

	// to read and insert the integers into the tree
	int n = sc.nextInt();
	for (int i = 0; i < n ; i++)
	{
		int leftChild = sc.nextInt();
		int rightChild = sc.nextInt();

		if (leftChild == -1 && rightChild != -1)
			myIntTree.insert(rightChild); // inserts int to the right subtree 
		else if (leftChild != -1 && rightChild == -1)
			myIntTree.insert(leftChild); // inserts int to the left subtree
		else if (leftChild != -1 && rightChild != -1)
		{
			// inserts both integer into the tree
			myIntTree.insert(leftChild);
			myIntTree.insert(rightChild);
		}
	} // end for loop for readtree
	
	// to read the queries
	int m = sc.nextInt();
	for (int j = 0; j < m; j++)
	{
		int A = sc.nextInt();
		int B = sc.nextInt();
		myIntTree.relationship(A,B); // shows relationship between int A and int B
	} // end for loop for read queries

    }
}
