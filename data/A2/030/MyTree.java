/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    private int value;// you can add other variables if you'd like
	private MyNode left;
	private MyNode right;
    //int leftChildIndex;			  // left child index in array
    //int rightChildIndex;		 // right child index in array

    public MyNode()
	{
		value = 0;
		left = null;
		right = null;
	}
	
	public MyNode(int value, MyNode left, MyNode right)
	{
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public MyNode getleft()
	{
		return this.left;
	}
	
	public MyNode get right()
	{
		return this.right;
	}
	
	public void setValue(int value)
	{
		this.value = value;
	}
	
	public void setleft(MyNode left)
	{
		this.left = left;
	}
	
	public void setright(MyNode right)
	{
		this.right = right;
	}// fill in your accessor and mutator methods here
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
    //int size = 0;// make sure to update this variable as needed
	private MyNode root;

    public MyTree()
	{
		root = new MyNode();
	}
	
	public void insert(MyNode root; int value; int value1)
	{
		if (value != -1)
		{
			root.setLeft(new MyNode(value, null, null);
		}
		if (value1 != -1)
		{
			root.setRight(new MyNode(value1, null, null);
		}
	}
	
	int classification = 0;
	public int relation(MyNode root1, MyNode root2)
	{
		if (root1.getLeft() == root2 || root1.getRight() == root2)
		{
			classification =1;
		}//ancestor
		else if (root2.getLeft() == root1 || root2.getRight() == root1)
		{
			classification = 2;
		}//descendant
		else if (root.getLeft() == root1 && root.getRight() == root2)
		{
			classification = 3;
		}//left sibling
		else if (root.getLeft() == root2 && root.getRight() == root1)
		{
			classification = 4;
		}//right sibling
	}
	
	if (classification == '0')
	{
		System.out.println("NONE");
	}
	else if (classification == '1')
	{
		System.out.println("ANCESTOR");
	}
	else if (classification == '2')
	{
		System.out.println("DESCENDANT");
	}
	else if (classification == '3')
	{
		System.out.println("LEFT SIBLING");
	}
	else if (classification == '4')
	{
		System.out.println("RIGHT SIBLING");
	}// fill in your ADT methods here
    // ...
}
