import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;

    /** Read in the tree
     */
    MyTree tree;
	public static void readTree () {
	// read in one integer
	int n = sc.nextInt();
    tree  = new MyTree(n);
	// loop to read pairs of children
	int l = 0;
	int r = 0;
	for (int i=0;i<n;i++) {
	   l =  sc.nextInt();              // modify this line
		
	   r =  sc.nextInt();              // modify this line

		MyNode node = new MyNode(l,r);
		tree.setTreeNode(i,node);
        
	}
	for(int i=0;i<n;i++)
	{
		tree.getTreeNode(i).getLeft().setParent(i);
		tree.getTreeNode(i).getRight().setParent(i);
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	   int x =  sc.nextInt();			   // modify this line
	   int y =  sc.nextInt();			   // modify this line

       if(tree.isAncestor(x,y))
	   {
		   System.out.println("ANCESTOR");
	   }
	   else if(tree.isDescendant(x,y))
	   {
		   System.out.println("DESCENDANT");
	   }
	   else if(tree.isLeftSibling(x,y))
	   {
		   System.out.println("LEFT SIBLING");
	   }
	   else if(tree.isRightSibling(x,y))
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
	readQueries();             // read in the queries

	// then process the queries ... fill in your calls below
    }
}
