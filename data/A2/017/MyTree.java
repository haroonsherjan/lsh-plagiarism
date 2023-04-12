/* Class for a binary tree ADT*/
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.
	private int[] myTree;

	public MyTree(int capacity)
	{
    	myTree=new int[capacity];	int size = 0;
		myTree[0]=0;
	}

	public int[] array()
	{
		return myTree;
	}
}
