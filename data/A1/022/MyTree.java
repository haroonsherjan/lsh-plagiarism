/** Class for a tree node
 */
import java.util.*;

class Node 
{
    int isSafe;				  // is the city safe?1 is yes, 0 is no
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;     // right child index in array
	int parent = -1;

    public MyNode(int left, int right, int isSafe)
	{
		setLeft(left);
		setRight(right);
		setSafe(isSafe);
	}

	public MyNode(int isSafe)
	{
		setSafe(isSafe);
	}

	public int getLeft()
	{
		return leftChildIndex;
	}
	public int getRight()
	{
		return rightChildIndex;
	}
	public int getSafe()
	{
		return isSafe;
	}
	public int getParent()
	{
		return parent;
	}

	public void setLeft(int l)
	{
		leftChildIndex = l;
	}
	public void setRight(int r)
	{
		rightChildIndex = r;
	}
	public void setSafe(int s)
	{
		isSafe = s;
	}
	public void setParent(int p)
	{
		parent = p;
	}
}




/** Class for a binary tree ADT
 */
public class MyTree {

    ArrayList<Node> tree = new ArrayList<Node>();

	public void addNode(Node n)
	{
		tree.add(n);
	}

	public void travel(int city1, int city2)
	{
		if (canTravel(city1, city2))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	public boolean canTravel(int city1, int city2)
	{
		boolean flag = true;
		while (tree.get(city1).getParent() != 0)
	}
}
