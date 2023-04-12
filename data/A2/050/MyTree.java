/** Class for a tree node
 */
class MyNode 
{
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // ...

}

/** Class for a binary tree ADT
 */
public class MyTree 
{
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.
	
	private TreeNode root;
	private int count;

/*	public void myTree()
	{
		root = 0;
	}
*/
	public void insert(int element)
	{
		insert(element, root);
	}

	private void insert(int element, TreeNode node)
	{
		if (element != -1)
		{
			if (root.getLeft() == null)
			{
				root.setLeft(new TreeNode(element));
			}
			else
			{
				root.setRight(new TreeNode(element));
			}
		}

	}

	public void search(int X, int Y)
	{
		search(X, Y, root);
	}

	public void search(int firstElement, int secondElement, TreeNode node)
	{
		//what i intended to do was actually search through the tree to find the elements and their relationship
		if ((node.getLeft().getValue() == firstElement) && (node.getRight().getValue() == secondElement))
		{
			System.out.println("LEFT SIBLING");
			//if the 1st element is on the left of the parent node and the 2nd element is on the right,
			//then the 1st element is the left sibling of the 2nd element.
		}
		else if ((node.getLeft().getValue() == secondElement) && (node.getRight().getValue() == firstElement))
		{
			System.out.println("RIGHT SIBLING");
			//if the 2nd element is on the left of the parent node and the 1st element is on the right,
			//then the 1st element is the right sibling of the 2nd element
		}
		else if ((node.getValue() == firstElement) && ((node.getLeft().getValue() == secondElement) || (node.getRight().getValue() == secondElement)))
		{
			System.out.println("ANCESTOR");
			//if the parent node is the 1st element and either the element on it's left or right is the 2nd element,
			//then the 1st element is the ancestor of the 2nd element
		}
		else if ((node.getValue() == secondElement) && ((node.getLeft().getValue() == firstElement) || (node.getRight().getValue() == firstElement)))
		{
			System.out.println("DESCENDANT");
			//if the parent node is the 2nd element and either the element on it's left or right is the 1st element
			//then the 1st element is the descendant of the 1st element
		}
		else
		{
			System.out.println("NONE");
			//if they have no relationship, it will print none
		}
	}

	class TreeNode
	{
		private int value;
		private int index;
		private TreeNode left;
		private TreeNode right;

		public TreeNode()
		{
			left = null;
			right = null;
			value = 0;
			index = -1;
		}

		public TreeNode(int value)
		{
			left = null;
			right = null;
			this.value = value;
			this.index = -1;
		}

		public int getValue()
		{
			return value;
		}

		public TreeNode getLeft()
		{
			return left;
		}

		public TreeNode getRight()
		{
			return right;
		}

		public void setLeft(TreeNode node)
		{
			left = node;
		}

		public void setRight(TreeNode node)
		{
			right = node;
		}
	}


/*    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed

    // fill in your ADT methods here
    // ...

	public void insert(int value)
	{
		insert(value,0);
	}

	public void insert(int value, int loc)
	{
		if (myTree == null)
		{
			myTree[0] = 0;
		}
		else
		{
			if (myTree[loc] == null)
			{
				myTree[loc] = value;
			}
			if (myTree.length < loc)
			{
				System.out.println("Out of space");
			}
		}
	}

	public void search(int element)
	{
		for (int i=0; i<myTree.length; i++)
		{
			
		}
	}*/
}
