/** Class for a tree node
*/
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // ...
	class MyNode()
	{
		isSafe = false;
		leftCHildIndex = -1;
		rightChildIndex = -1;
	}

	public void setLeft(int left)
	{
		leftChildIndex = left;
	}

	public void setRight(int right)
	{
		rightChildIndex = right;
	}

	public int getLeft()
	{
		return this.leftChildIndex;
	}

	public int getRight()
	{
		return this.rightChildIndex;
	}

	public boolean isSafe()
	{
		return this.isSafe;
	}

	public void setSafety(int safeOrNt)
	{
		if(safeOrNt = 1)
			this.isSafe = false;
		else if(safeOrNt = 0)
			this.isSafe = true;
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

	public void create(int pos)
	{
		MyNode node = new MyNode();
		myTree[pos] = node;
	}

	public void safeOrNt(int position, int safeOrNt)  //position is position of element in array, safeOrNt is either -1 or 0
	{
		myTree[position].setSafety(safeOrNt);
	}

	public void setchildten(int pos, int left,int right)
	{
		myTree[pos].setLeft(left);
		myTree[pos].setRight(right);
	}

	public boolean check(int start, int finish, int index)
	{
		if(start==finish)//if both the same city, city is safe
			return true;
		boolean checkstart = checkpath(start);     // check from 0 to start
		boolean checkfinish = checkpath(finish);	//check from 0 to finish
		if(checkstart && checkfinish)			//if both paths are safe there is a safety path to each other
			return true;
		else return false;
	}
	public boolean checkpath(int index, int start)
	{
		if(index ==start && myTree[index].isSafe()) //if reach the index we want to be at
			return true;
			else return false;
		if(tree[index].getLeft()!=-1&&tree[index].getRight()!=-1 &&myTree[index].isSafe())  //if there are 2 children, check both child path
			return checkpath(myTree[index].getLeft(),  start) && check path(myTree[index].getRight(), start);
		else if(tree[index].getLeft()==-1 && tree[index].getRight()==-1)      //no children end of path
			return tree[index].isSafe();
		else if(tree[index].getLeft()!=-1 && tree[index].getRight()==-1)	//has only left path, continue from left
			return checkpath(myTree[index].getLeft(), start);
		else if(tree[index].getRight()!=-1&&tree[index].getLeft()==-1)		//has one right path, continue from right
			return checkpath(myTree[index].getRight(), start);
	return false;
	}
    // fill in your ADT methods here
    // ...
}
