/** Class for a tree node
 */
import java.util.*;
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
	int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
    int root=0;

    // fill in your accessor and mutator methods here
    public MyNode(int left, int right)
	{
      leftChildIndex = left;
	  rightChildIndex = right;
	}

	public int getRoot()
	{
	  return root;
	}

	public void setRoot()
	{
	  root ++;
	}

	public int getLeft()
	{
      return leftChildIndex;
	}

	public int getRight()
	{
	  return rightChildIndex;
	}

	public void setLeft(int index)
	{
	  leftChildIndex = index;
	}

	public void setRight(int index)
	{
	  rightChildIndex = index;
	}
}

/** Class for a binary tree ADT
 */

public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

    private final int MAX_NODES = 1000;
    private ArrayList<MyNode> arr;

    // fill in your ADT methods here

	public MyTree()
	{
      arr = new ArrayList<MyNode> ();
	}
    
	public void insert(int left, int right)
	{
      MyNode node = new MyNode(left, right);
	  arr.add(node);
	  node.setRoot();
	  
	}

	public void deRelation(int L, int R)
    {
      for(int i=0; i<arr.size(); i++)
      {
	    if(arr.get(i).getLeft()==L && arr.get(i).getRight() == R)
	    {
	      System.out.println("LEFT SIBLING");
		  break;
		}
		else if(arr.get(i).getLeft()== R && arr.get(i).getRight() == L)
	    {
		  System.out.println("RIGHT SIBLING");
		  break;
		}
		else if(i==L && (arr.get(i).getLeft()==R || arr.get(i).getRight()==R))
	    {
		  System.out.println("ANCESTOR");
		  break;
		}
		else if(i==R && (arr.get(i).getLeft()==L || arr.get(i).getRight()==L))
		{
		  System.out.println("DESCENDANT");
		  break;
		}
		else
		{  
		   System.out.println("NONE");
		   break;
		}
	  }
	}

}  
