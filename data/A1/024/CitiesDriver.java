import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver 
{
    static Scanner sc;
    
    /** Read in the tree
     */
    public static void readTree (MyTree tree, int n) 
	{
	// read in tree, safety line
	   for (int i=0;i<n;i++) 
		   tree.getTreeNode(i).setSafety(sc.nextInt());	
	// loop to read pairs of children
	   for (int i=0;i<n;i++) 
	   {
		   int left = sc.nextInt();
		   int right = sc.nextInt();
		   tree.getTreeNode(i).setLeft(left);
		   tree.getTreeNode(left).setParent(i);
	       tree.getTreeNode(i).setRight(right);
		   tree.getTreeNode(right).setParent(i);
	   }
    }
    
    /** Read in query statements
     */
    public static void readQueries (MyTree tree) 
	{
	// read in one integer
	   int m = sc.nextInt();
	// loop to read pairs of children for query
	   for (int i=0;i<m;i++) 
	   {
	       if (tree.isSafe(sc.nextInt(), sc.nextInt()))
	           System.out.println("Yes");
		   else
			   System.out.println("No");
	   }
    }
    
    public static void main(String[] args) 
	{
	    sc = new Scanner(System.in);
		int n = sc.nextInt();
		MyTree tree = new MyTree(n);
	    readTree(tree, n);				   // read in the tree
	    readQueries(tree);				// read in the queries
	// then process the queries ... fill in your calls below
    }

}
