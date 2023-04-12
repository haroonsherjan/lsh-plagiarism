/** Class for a tree node
 */
class MyNode 
{
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int elem;
    int leftChildIndex;		 // left child index in array
    int rightChildIndex;		 // right child index in array

	//int elem;
	//MyNode left;
	//MyNode right;

    // fill in your accessor and mutator methods here
    // ...
    /*public MyNode(int elem)
    {
    	this.elem = elem;
    	left = null;
    	right = null;
    }*/
    
    /*public MyNode()
    {
    	elem = 
    	leftChildIndex = ;
    	rightChildIndex = ;
    }*/
    
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

    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed
	int counter = 2;

	//MyNode root;

    // fill in your ADT methods here
    // ...
    
    /*public MyTree()
    {
    	root.elem = 0;
    }
    
    public setLeft(int elem)
    {
    	if (node == null)
    	{
    		root.left = new MyNode(elem);
    	}
    	else
    	{
    	}
    }
    
    public setRight(int elem)
    {
    	root.right = new MyNode(elem);
    }*/
    
    public MyTree()
    {
    	myTree[0].elem = 0;
    	myTree[0].leftChildIndex = 1;
    	myTree[0].rightChildIndex = 2;
    	size++;
    }
    
    public void add(int x)
    {
    	myTree[size].elem = x;
    	myTree[size].leftChildIndex = size * 2 + 1;
    	myTree[size].rightChildIndex = size * 2 + 2;
    	size++;
    }
}
