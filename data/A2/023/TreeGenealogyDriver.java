
import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
	static MyNode[] tree;
/** Read in the tree
     */
    public static void readTree () {
	// read in one integer
	int a;
	int b;
	int n = sc.nextInt();
	tree = new MyNode[2*n+1];
	for (int i = 0; i < 2*n+1; i++)
	{
		tree[i] = new MyNode();
	}
	tree[0].setItem(0);
	// loop to read pairs of children
	for (int i=1;i<2*n+1;i++) {
		tree[i].setItem(sc.nextInt());
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	int a;
	int b;
	int index = 0;
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    a = sc.nextInt();			   
	    b = sc.nextInt();

		for (int j = 0; j < tree.length; j++)
		{
			if (tree[j].getItem() == a)
			{
				index = j;
				break;
			}
		}
		if (tree[2*index+1].getItem() == b || tree[2*index+2].getItem() == b)
		{
			System.out.println("ANCESTOR");
		}
		else if (tree[(index-1)/2].getItem() == b)
		{
			System.out.println("DESCENDANT");
		}
		else if (index % 2 == 1 && tree[index+1].getItem() == b)
		{
			System.out.println("LEFT SIBLING");
		}
		else if (index % 2 == 0 && tree[index-1].getItem() == b)
		{
			System.out.println("RIGHT SIBLING");
		}
		else
		{
			System.out.println("NONE");
		}
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
