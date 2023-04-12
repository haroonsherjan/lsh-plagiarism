////////////////////////////////////////////////////////
//
// Lab: 09 Ex2
// 
// MyTree class, referenced-based implementation
//
////////////////////////////////////////////////////////

public class MyTree
{
	private IntNode root;

	// Constructor
	public MyTree(IntNode n)
	{
		root = n;
	}

	// Check Tree
	// Precondition: Input to integers a & b to check for relation of nodes
	// PostCondition: Print the relation of nodes either "ANCESTOR" "DESCENDANT"
	//                "LEFT SIBLING" "RIGHT SIBLING" OR "NONE". Returns nothing.
	public void checkTree(int a, int b)
	{
		boolean found = check(root, a, b);

		if(!found)
			System.out.println("NONE");
	}

	// Recursive method to traverse tree and check tree nodes
	private boolean check(IntNode curr, int a, int b)
	{
		if(curr != null)
		{
			{
				// Check for left/right Siblings
				if( curr.getLeft() != null && curr.getRight() != null && curr.getLeft().getItem() == a && curr.getRight().getItem() == b )
                {
					System.out.println("LEFT SIBLING");
					return true;
				}
				if( curr.getLeft() != null && curr.getRight() != null && curr.getRight().getItem() == a && curr.getLeft().getItem() == b )
				{
					System.out.println("RIGHT SIBLING");
					return true;
				}

				// Check Ancestor
				if( curr.getLeft() != null && curr.getItem() == a && curr.getLeft().getItem() == b )
				{
					System.out.println("ANCESTOR");
					return true;
				}
                if (curr.getRight() != null &&  curr.getItem() == a && curr.getRight().getItem() == b )
				{
					System.out.println("ANCESTOR");
					return true;
				}

				// Check Descendant
				if( curr.getLeft() != null && curr.getLeft().getItem() == a && curr.getItem() == b )
				{
					System.out.println("DESCENDANT");
					return true;
				}
				if(curr.getRight() != null && curr.getRight().getItem() == a && curr.getItem() == b )
				{
					System.out.println("DESCENDANT");
					return true;
				}
				
				// If none found, continue searching
				boolean found = false;
				found = check(curr.getLeft(), a, b);

				// If found, stop searching
				if(found)
					return true;

				// Else, continue searching the right side of tree
				found = check(curr.getRight(), a, b);
				return found;
			}
		}
		// Returns false of tree is empty
		return false;
	}
}   // end MyTree class

class IntNode
{
	private int item;
	private IntNode left;
	private IntNode right;

	// Constructor
	public IntNode(int x)
	{
		item = x;
		left = right = null;
	}

	// Item
	public void setItem(int x) { item = x; }
	public int getItem() { return item; }

	// Left
	public void setLeft(IntNode n) { left = n; }
    public IntNode getLeft() { return left; }

	// Right
	public void setRight (IntNode n) { right = n; }
	public IntNode getRight() { return right; }

}  // end IntNode class
