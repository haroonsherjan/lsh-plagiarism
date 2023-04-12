/** Class for a tree node
 */

import java.util.*;
 
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    /*int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	*/
	private MyNode left;
	private MyNode right;
	private int value;

	public MyNode(int v)
	{
		left=null;
		right=null;
		value=v;
	}

	public MyNode getLeft()
	{
		//Go left
		return left;
	}

	public MyNode getRight()
	{
		//Go right
		return right;
	}

	public void setLeft(MyNode node)
	{
		//Point left to the next node
		left=node;
	}

	public void setRight(MyNode node)
	{
		//Point right to the next node
		right=node;
	}

	public int getValue()
	{
		return value;
	}
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

	//Using reference based to build a tree.

	private MyNode root;
	//private int count;
	ArrayList<String> printList=new ArrayList<String>();

	//constructor
	public MyTree()
	{
		root=new MyNode(0);
	}

    /*private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed
	*/
    // fill in your ADT methods here
    // ...

	//Add left of the parent
	public void add(int value)
	{
		add(value, root);
	}

	private void add(int value, MyNode node)
	{
		boolean isLeft=false;//transverse left and right
		if(node.getLeft()==null)  //if it is null, add a new MyNode(value)
		{
			node.setLeft(new MyNode(value));
			//isLeft=true;
		}
		else if ((node.getRight()==null))
		{
			node.setRight(new MyNode(value));
			//isLeft=false;
		}
		else if (node.getLeft()!=null)  //If it is not a null, transverse left or right.
		{
			add(value,node.getRight());
		}
		else if (node.getRight()!=null)
		{
			add(value,node.getLeft());
			//isLeft=false;
		}
	}

	public void queryTree(int A, int B)
	{
		queryTree(A,B,root, null);
	}

	private void queryTree(int A, int B, MyNode current, MyNode parent)
	{
		//Find the value of A, follow by B and check the surrounding A have number matches B
		//Then find the relationship of A and B
		//If A is not found, transverse the tree
		if(current.getValue()==A)
		{
			checkStatus(A, B, current, parent);
		}
		else if (current.getValue()!=A)
		{
			//transverse to left. If cannot go left, then go right;
			if (current.getLeft()!=null)
				queryTree(A, B, current.getLeft(), current);
			else if (current.getLeft()==null)
				return;  //return if cannot go left
			else if (current.getRight()!=null)
				queryTree(A,B, current.getRight(), current);
			else if (current.getRight()==null)
				return; //return if cannot go right
		}
	}

	//check the relationship of A and B
	private void checkStatus(int A, int B, MyNode current, MyNode parent)
	{
		//Check the status of A and B
		//This is done by finding the surrounding A such that B can be it Ancestor, Descendant, Left or Right Sibling of A
		if((current.getLeft().getValue()==B) || (current.getRight().getValue()==B))
		{
			//if current has left or right child, then it has a descendant.
			printList.add("DESCENDANT");
		}
		else if ((parent.getLeft().getValue()==A) && (parent.getRight().getValue()==B))
		{
			//if parent has left and right children, then it is left sibling. What is A related to B
			printList.add("LEFT SIBLING");
		}
		else if((parent.getLeft().getValue()==B) && (parent.getRight().getValue()==A))
		{
			//if parent has left and right children, then it is right sibling. What is B related to A
			printList.add("RIGHT SIBLING");
		}
		else if ((parent.getLeft().getValue()==A) || (parent.getRight().getValue()==A))
		{	
			//If current has a parent, then parent is a ancestor of current.
			printList.add("ANCESTOR");
		}
	}

	public void print()
	{
		for(int i=0;i<printList.size();i++)
		{
			System.out.println(printList.get(i));
		}
	}
}
