/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    //int leftChildIndex;			  // left child index in array
    //int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // ...
}

/** Class for a binary tree ADT
 */
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

    //private final int MAX_NODES = 1000;
    //MyNode[] myTree = new MyNode[MAX_NODES];
    //int size = 0;	// make sure to update this variable as needed

    // fill in your ADT methods here
    // ...

	class TreeNode {
		public int value;
		public TreeNode left;
		public TreeNode right;
	}

	private TreeNode root;

	public void insert (int x) {root=insertNode(x, root);}
	protected TreeNode insertNode (int value, TreeNode root) {
		
		while (value != -1 ) {   //-1 returns nothing
			if (root.left==null && root.right==null) {   //There is only one root in the tree with no children
				root.left=new TreeNode();
			    root.left.value=value;
			}
		    else if (root.left!=null && root.right==null) {   //When the first left child is inserted
			    root.right=new TreeNode();
			    root.right.value=value;
		    }
		    else if (root.left!=null && root.right!=null) {   //Subsequent addition of the left child
			    insert(value, root.left);
		    } 
		    else {   //Subsequent addition of the right child
			    insert(value, root.right);
		    }
		}
	}

	protected void size(TreeNode root) {
		return 1+size(root.left)+size(root.right);
	}
	
	public int position (int x) {root=nodePosition(root, x)}  //Finding the position of the integer.
	protected int nodePosition (TreeNode root, int x) {
		int size=0;
		size+=size(root.left)+size(root.right);
		return size;
	}

	public void print(int x) {
		//The 2 positions found are being compared using inorder traversal. 
		//If the first position is smaller than the second position by 2, their relationship is RIGHT SIBLING. 
		//If the 2nd position is smaller than the 1st position by two numbers, their relationship is LEFT SIBLING. 
		//If the first position is smaller than the second postion and both of them are identified in the left subtree of the root, their relationship is ANCESTOR and if both of them are in the right subtree, their relationship is DESCENDANT.     
}
}

