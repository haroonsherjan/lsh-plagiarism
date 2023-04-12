/** Class for a tree node
 */
 import java.util.*;
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree
 
    // you can add other variables if you'd like
    int index;                    //city's number
	boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
   //constructor
   public MyNode(int index,int binarySafe,int left,int right)
   {
		this.index=index;
		if (binarySafe==1)
			isSafe=true;
        else isSafe=false;
		leftChildIndex=left;
		rightChildIndex=right;
   }//end constructor
   //acessor
   public boolean isSafe()
   {
	return isSafe;
	   }
	public int getLeft()
	{
	return leftChildIndex;
	}
	public int getRight()
	{
    return rightChildIndex;
	}
	public int getIndex()
	{
	return index;
	}
//mutator
   public void setRight(int index)
   {
	rightChildIndex=index;
   }
   public void setLeft(int index)
   {
	leftChildIndex=index;
   }
//helper method to check whether one of the two nodes are child of the other
    public boolean isleftChild(int index)
	{
	 return (this.leftChildIndex==index);	
    }
	public boolean isRightChild(int index)
	{
		return(this.rightChildIndex==index);
	}
	public boolean isChild(int index)
	{
		return (this.isleftChild(index)||this.isRightChild(index));
	}
}//end of MyNode class

/** Class for a binary tree ADT
 */
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed
	MyNode root;
	public MyTree()
	{
	root=myTree[0];
	}
	//This method checks whether the path between two nodes is safe or not, safe--true
	public boolean isSafePath(int city1,int city2)
	{
		boolean flag=true;
	if(myTree[city1].isChild(city2)||myTree[city2].isChild(city1))
		return (myTree[city2].isSafe()&&myTree[city1].isSafe());
	else 
	{
		MyNode node=findCommonAncestor(0,city1,city2);
	    MyNode[] path=findPath(myTree[city1],myTree[city2],node);
		flag=safePath(path);
	}
	return flag;
	}
	//This method helpes to find the nearest common ancestor
	protected MyNode findCommonAncestor(int index,int node1,int node2)
	{
	  return null;//BUG!!
	}
	//This methods puts all the nodes from node1 to node2 to its commonAncestor
	protected MyNode[] findPath(MyNode node1,MyNode node2,MyNode commonAns)
	{
	MyNode[] nodes=new MyNode[1000];
	return nodes;	
    }
	//This method checks the nodes along the path whether it is safe
	protected boolean safePath(MyNode[] node)
	{
	  for(int i=0;i<node.length;i++)
	  {
		if(node[i]!=null&&!node[i].isSafe())
			return false;
	  }
      return true;
    }
    // fill in your ADT methods here
    // ...
}
