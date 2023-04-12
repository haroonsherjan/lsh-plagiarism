/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	int index;
	
	
    // fill in your accessor and mutator methods here
	/*
	MyNode(int i )
	{
		index= i;
	}
	*/
	// ...
 	void setSafe(int num)
	{
		if(num == 1)
		{
			isSafe = true;
		}
		else //0
			isSafe = false;
	}
	void setLeft(int index)
	{
		leftChildIndex = index;
	}
	void setRight(int index)
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
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed
	/*
		from the given input, then firstly have to find the path. we could only go right left or parent
		have to traverse the tree to find the path.
		could like save the path down then check the validity of each path whether it is safe
	*/
    // fill in your ADT methods here
    // ...
	//checking what is the path
	boolean searchPath(int start, int dest)
	{
		int parent;
		int left;
		int right;
		boolean flag;
		flag = myTree[start].isSafe;

		parent = (start -1)/2;
		left = start*2 +1;
		right = start*2 +2;

		if(start == dest)
		{
			return myTree[start].isSafe;
		}
		//checking on the left child
		else if(myTree[start].leftChildIndex!= -1) //if there exists
		{
			if(left != dest)
			return searchPath( left, dest);
			else
				return myTree[left].isSafe;
		}

		//checking on right child
		else if(myTree[start].rightChildIndex !=-1) //if it exists
		{
			if(right == dest)
				return myTree[right].isSafe; //index for the right child
			return searchPath(right, dest);
		}
		
		//checking on the parent node
		else if (( parent>0)&&(start != parent)) //not at the root
		{
			if(parent== dest)
			return myTree[parent].isSafe;
			else if(myTree[parent].rightChildIndex == start) //if right child is where u come from then go to the left
			{
				return searchPath( myTree[parent].leftChildIndex, dest);
			}
		}
	
		else
			return myTree[dest].isSafe;
		return flag;
	}

	MyNode get(int i)
	{
		return myTree[i];
	}
/*	
	//building the tree
	MyNode builder (int l, int r) //left and right index
	{
		MyNode p = null;
		if(l<= r)
		{
			p = new MyNode();
			int m = (l+r)/2;
			p.left = builder(l, m-1);//build left subtree
			p.right = builder(m+1, r);//build right sub tree
			}
			return p;
	}
*/	

}

