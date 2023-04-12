import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */

public class TreeGenealogyDriver
{
    public static void main(String[] args) 
	{
	  Scanner sc = new Scanner(System.in);
	  sc = new Scanner(System.in);
	  MyTree newTree = new MyTree();
      int n = sc.nextInt();// read in the tree
	  for(int i=0; i<n; i++)
      {
	    int left = sc.nextInt();
	    int right = sc.nextInt();
	    newTree.insert(left,right);
	   }

	   int m = sc.nextInt();
	   for(int i=0; i<m; i++)				        // read in the queries
       {
		 int l = sc.nextInt();
		 int r = sc.nextInt();
		 newTree.deRelation(l,r);
	   }
    }
}
