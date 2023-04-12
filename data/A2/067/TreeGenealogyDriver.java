import java.util.*;

public class TreeGenealogyDriver 
{
    static Scanner sc;
	static MyTree T;

    // Read in the tree

    public static void readTree() 
	{
		// read in one integer
		int n = sc.nextInt();

		// loop to read pairs of children
		for (int i = 0; i < n; i++) 
		{
	    	T.insertChildren(i,sc.nextInt(),sc.nextInt());
		}
    }
    
    //  Read in query statements

    public static void readQueries() 
	{
		// read in one integer
		int m = sc.nextInt();

		// loop to read pairs of children for query
		for (int i = 0; i < m; i++) 
		{
			System.out.println(T.determineRelationship(sc.nextInt(),sc.nextInt()));
		}
    }
    
    public static void main(String[] args) 
	{
		sc = new Scanner(System.in);
		T = new MyTree();

		readTree();				   // read in the tree
		readQueries();				// read in the queries
    }
}
