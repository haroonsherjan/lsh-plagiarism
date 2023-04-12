import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver 
{
    static Scanner sc;
	static MyTree country = null;
    
    /** Read in the tree
     */
    public static void readTree () 
	{
	/// Read in the tree
	// read in one integer
		int n = sc.nextInt();
	// read in tree, safety line
		int[] safetyLine = new int[n];
		for (int i=0; i<n; i++)
		{
		    safetyLine[i] = sc.nextInt();
		}


		MyNode[] nodeArray = new MyNode[n];
		for (int i=0; i<n; i++)
		{
			nodeArray[i] = new MyNode(n, safetyLine[i]);
		}

		for (int i=0; i<n; i++) 
		{
	    	int temp1 = sc.nextInt();		
	    	int temp2 = sc.nextInt();
			if(temp1 == -1)
			{
				nodeArray[i].leftChild = null;
			}
			else
			{
				nodeArray[i].leftChild = nodeArray[temp1];
				nodeArray[i].leftChild.parent = nodeArray[i];
			}
			if (temp2 == -1)
			{
				nodeArray[i].rightChild = null;
			}
			else
			{
				nodeArray[i].rightChild = nodeArray[temp2];
				nodeArray[i].rightChild.parent = nodeArray[i];
			}
		}
		country = new MyTree(nodeArray);
	}
    
    /** Read in query statements
     */
    public static void readQueries () 
	{
	// read in one integer
		int m = sc.nextInt();
	// loop to read pairs of children for query
		for (int i=0;i<m;i++) 
		{
	    	int temp1 = sc.nextInt();	
	    	int temp2 = sc.nextInt();
			System.out.println(country.SafeToGo(temp1,temp2));
		}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				 
	readQueries();			

    }
}
