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
	public static void readTree (MyTree myTree) 
	{
		myTree.setSize(sc.nextInt());
		myTree.setNode(sc);
	}
	/** Read in query statements
	 */
	public static void readQueries (MyTree myTree) 
	{
		// read in one integer
		int m = sc.nextInt();
		String output = "";
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) 
		{
			output += myTree.checkNode(sc.nextInt(),sc.nextInt());
			output += '\n';
		}

		System.out.print(output);
	}

	public static void main(String[] args) 
	{
		sc = new Scanner(System.in);
		MyTree myTree = new MyTree();
		readTree(myTree);
		readQueries(myTree);	// read the queries and print output
	}
}
