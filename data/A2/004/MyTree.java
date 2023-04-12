/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
    int motherIndex;
	//constructor
	public MyNode()
	{
	   leftChildIndex = -1;
	   rightChildIndex= -1;
	   motherIndex = -1;
	}
	//mutators
	public void setLeft(int a)
	{
	   	leftChildIndex=a;
	}
	public void setRight(int b)
	{
	    rightChildIndex = b;	
	}
	public void setMother(int c)
	{
	    motherIndex = c;	
	}
	//accessors
	public int getLeft()
	{
	    return leftChildIndex;	
	}
	public int getRight()
	{
	   return rightChildIndex;	
	}
	public int getMother()
	{
	   return motherIndex;	
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
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed
    // constructor
    public MyTree()
	{
	    size =0;
	}
	//add a new node
	public void add(int l, int r)
	{
	    myTree[size] = new MyNode();
		myTree[size].setLeft(l);
		myTree[size].setRight(r);
		size++;
	}
	// set the mother
	public void setmother()
	{
	    for (int i=0; i<size; i++)
		{
		    if(myTree[i].getLeft()>=0)
			{
			   myTree[myTree[i].getLeft()].setMother(i);	
			}
            if (myTree[i].getRight()>=0)
			{
			   myTree[myTree[i].getRight()].setMother(i);
			}
		 }
	}
    //accessor method to get the mother node;
	public int getMother(int m)
	{
		return myTree[m].getMother();
	}
    // get the rightsib of a node
	public int getRightsib(int l)
	{
		return myTree[myTree[l].getMother()].getRight();
	}
}
