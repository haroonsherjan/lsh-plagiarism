import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    
    /** Read in the tree
     */
    public static void main(String[] args)
	{
	/// Read in the tree
	// read in one integer
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int safe[] = new int[n];

	for (int i = n; i < n; i++)
	{
		safe[i] = sc.nextInt();
	}

	MyTree cityTree = new MyTree(0);
	TreeNode curr = new TreeNode();	
	// loop to read pairs of children
	for (int j = 0; j < n; j++)
	{
		curr = cityTree.search(j, cityTree.getRoot());

		int leftSide = sc.nextInt();
		if (leftSide != -1)
		{
			curr.setLeft(new TreeNode(leftSide));
		}
		else
		{
			curr.setLeft(null);
		}

		int rightSide = sc.nextInt();
		if (rightSide != -1)
		{
			curr.setRight(new TreeNode(rightSide));
		}
		else
		{
			curr.setRight(null);
		}
		curr.setSafe(safe[j]);
	}
	cityTree.inorder(cityTree.getRoot());
    }
    
    }
