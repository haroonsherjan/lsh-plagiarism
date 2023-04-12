/** Class for a tree node
 */
class TreeNode {
    public int item = 0;
	public TreeNode left = null;
	public TreeNode right = null;

	public TreeNode (int value) {
		item = value;
		left = null;
		right = null;
	}

	public TreeNode (int value, TreeNode leftchild, TreeNode rightchild) {
		item = value;
		left = leftchild;
		right = rightchild;
	}
}

/** Class for a binary tree ADT
 */
public class MyTree {
    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

    private final int MAX_NODES = 1000;
    int size = 0;	// make sure to update this variable as needed

	TreeNode root;

	public MyTree(int rootItem) {
		root = new TreeNode(rootItem);
	}

	public void insert(int x) {
		insertAux(x, root);
	}

	int count = 1;

	private TreeNode insertAux(int x, TreeNode T) {
		if(T == null) {
			return new TreeNode(x);
		}

		else if(T.left == null) {
			T.left = insertAux(x, T.left);
		}

		else if(T.right == null) {
			T.right = insertAux(x, T.right);
		}

		return T;
	}

	public void inorder() {
		inorderAux(root);
	}

	private void inorderAux(TreeNode T) {
		if(T != null) {
			inorderAux(T.left);
			System.out.print(T.item + " ");
			inorderAux(T.right);
		}
	}


}
