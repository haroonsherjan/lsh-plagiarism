import java.util.*;

class MyNode 
{	
	// represents the node of a binary tree in a reference based implementation

	private int element;	// element value
    private MyNode left;	// left child
    private MyNode right;	// right child

	private MyNode parent;	
		// I also store parent at each node to make future processing easier although it needs slightly more memory.

	// What follows are 4 routine accessor methods

	public int getElement()
	{
		return element;
	}

	public MyNode getLeft()
	{
		return left;
	}

	public MyNode getRight()
	{
		return right;
	}

	public MyNode getParent()
	{
		return parent;
	}

	// Also define 2 mutator methods for setting the children alone. 
		// Parent and element are already set when the node is created. So no accessor methods for them.

	public void setLeft(MyNode L)
	{
		left = L;
	}

	public void setRight(MyNode R)
	{
		right = R;
	}

	// constructor to create a new node

	public MyNode(int ele, MyNode L, MyNode R, MyNode P)
	{
		element = ele;
		left = L;
		right = R;
		parent = P;
	}
}

public class MyTree 
{
    private MyNode root;	// root of the binary tree

	public MyTree()
	{
		// define root with value 0

		root = new MyNode(0,null,null,null);
	}

	public void InOrderTraversal(MyNode startNode,int label,MyNode target)
	{
		// search the tree from the start node using in order traversal, looking for the given label
			// once the required node with the given label  is found, store it in the reference target

		if (startNode == null)
		{
			return;
		}

		InOrderTraversal(startNode.getLeft(),label,target);

		if (startNode.getElement() == label)
		{
			// that's it. The required node has been found

			target = startNode;
		}

		InOrderTraversal(startNode.getRight(),label,target);
	}

	public void insertChildren(int parentLabel, int leftChild, int rightChild)
	{
		// this node inserts child nodes with required labels on to a parent node specified by parentLabel

		if ((leftChild == -1) && (rightChild == -1))
		{
			// both are null. No need to insert anything.

			return;
		}

		// first find the parent node with the required label

		MyNode target = null;
		InOrderTraversal(root,parentLabel,target);

		// now target will hold the required parent node

		// define new left and right child nodes from the given values, provided they are not -1.

		MyNode leftNode = (leftChild != -1) ? new MyNode(leftChild,null,null,target) : null;
		MyNode rightNode = (rightChild != -1) ? new MyNode(rightChild,null,null,target) : null;

		// update the parent node's children to reflect the new information.

		target.setLeft(leftNode);
		target.setRight(rightNode);
	}

	public void getPathToRoot(MyNode N, ArrayList<MyNode> pathNodes)
	{
		// this method finds the path from a given node N all the way to the root of the binary tree
			// this path is stored in ArrayList pathNodes (initially assumed to be empty)

		// this is where having the parent field stored in every node is really useful.

		pathNodes.add(N);

		if (root == N)
		{
			return;
		}

		getPathToRoot(N.getParent(),pathNodes);
	}

	public String determineRelationship(int firstLabel, int secondLabel)
	{
		// this method determines the relationship between two given nodes in the tree, specified by their labels
			// it returns the relationship as required in the question

		// first get the nodes holding the specified labels

		MyNode firstNode = null;
		InOrderTraversal(root,firstLabel,firstNode);

		MyNode secondNode = null;
		InOrderTraversal(root,secondLabel,secondNode);
		
		// Now get the path of each node all the way to the root of the tree

		ArrayList<MyNode> firstNodePath = new ArrayList<MyNode>();
		getPathToRoot(firstNode,firstNodePath);

		ArrayList<MyNode> secondNodePath = new ArrayList<MyNode>();
		getPathToRoot(secondNode,secondNodePath);
		
		// now determine the relationship from the two paths obtained

		if ((firstNodePath.size() == 1) || (secondNodePath.contains(firstNode)))
		{
			return "ANCESTOR";
		}

		if ((secondNodePath.size() == 1) || (firstNodePath.contains(secondNode)))
		{
			return "DESCENDANT";
		}

		if (firstNodePath.get(1).getRight() == secondNode)
		{
			return "LEFT SIBLING";
		}

		if (firstNodePath.get(1).getLeft() == secondNode)
		{
			return "RIGHT SIBLING";
		}

		return "NONE";
	}
}
