/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    private int data;
	private int leftChildIndex;			  // left child index in array
    private int rightChildIndex;		 // right child index in array
	private int parentIndex;

    // fill in your accessor and mutator methods here
    MyNode(int x,int parent)
	{
		data = x;
		leftChildIndex=-1;
		rightChildIndex=-1;
		parentIndex=parent;
	}

	int getData () {return data;}
	int getLeftIndex() {return leftChildIndex; }
	int getRightIndex() {return rightChildIndex; }
	int getParentIndex() {return parentIndex; }

	void setLeftIndex(int x) {leftChildIndex = x;}
	void setRightIndex(int x) {rightChildIndex = x;}
	void setParentIndex(int x) {parentIndex = x; }
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
    MyNode[] myTree;
    int size;	// make sure to update this variable as needed

    // fill in your ADT methods here
	MyTree()
	{
		myTree = new MyNode[MAX_NODES];
		size=1;
    	for (int i=0; i<MAX_NODES; i++)
			myTree[i] = new MyNode(-1,-1);
		myTree[0]=new MyNode(0,0);
	}

	void insert (int node,int left,int right)
	{
		int curr = node;
		if (left==-1 && right ==-1)
			return;
		else if (left!=-1 && right ==-1)
		{
			myTree[curr].setLeftIndex(size);
			size++;
			myTree[myTree[curr].getLeftIndex()]=new MyNode(left,curr);
		}
		else if (left==-1 && right !=-1)
		{
			myTree[curr].setRightIndex(size);
			size++;
			myTree[myTree[curr].getRightIndex()]=new MyNode(right,curr);
		}
		else
		{
			myTree[curr].setLeftIndex(size);
			size++;
			myTree[myTree[curr].getLeftIndex()]=new MyNode(left,curr);
			myTree[curr].setRightIndex(size);
			size++;
			myTree[myTree[curr].getRightIndex()]=new MyNode(right,curr);
		}
	}

	int find (int x)
	{
		for (int i=0;i<size;i++)
		{
			if (myTree[i].getData()==x)
				return i;
		}
		return -1;
	}

	int relationship (int left, int right)
	{
		//1 ancestor, 2 descendant, 3 left sibling, 4 right sibling, 5 none
		if (myTree[myTree[find(right)].getParentIndex()].getData()==left)
			return 1;
		else if (myTree[myTree[find(left)].getParentIndex()].getData()==right)
			return 2;
		else if (myTree[myTree[myTree[find(left)].getParentIndex()].getRightIndex()].getData() == right)
			return 3;
		else if (myTree[myTree[myTree[find(left)].getParentIndex()].getLeftIndex()].getData()== right)
			return 4;
		else
			return 5;
	}
}
