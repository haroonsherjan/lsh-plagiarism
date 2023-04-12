/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // ...
	public MyNode(int safe) {
		this(safe, -1, -1);
	}

	public MyNode(int safe, int left, int right) {
		isSafe = safe;
		leftChildIndex = left;
		rightChildIndex = right;
	}

	public int getSafe() {
		return isSafe;
	}

	public int getLeft() {
		return leftChildIndex;
	}

	public int getRight() {
		return rightChildIndex;
	}

	public void setSafe(int i) {
		isSafe = i;
	}

	public void setLeft(int i) {
		leftChildIndex = i;
	}

	public void setRight(int i) {
		rightChildIndex = i;
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

    // fill in your ADT methods here
    // ...
	public boolean isEmpty() {
		return size == 0;
	}

	public MyNode getNode(int i) {
		return myTree[i];
	}

	public void insert(MyNode newNode) {
		if(size < MAX_NODES)
		{
			myTree[size] = newNode;
			size++;
		}
	}

	public boolean travel(int start, int end) {
		if(myTree[start].isSafe == 0 || myTree[end].isSafe == 0)
		{
			return false;
		}
		if(start == end)
		{
			
			return true;
		}
		else
		{
			if(isChild(start, end) == 1)
				return true;
			else
			{
				int parent = findParent(start);
				if(parent != -1)
				{
					if(myTree[parent].isSafe == 0)
						return false;
					int right = myTree[parent].rightChildIndex;
					if(right != -1)
						return travel(right, end);
					else 
						return false;
				}
			}

		}
		return false;

	}

	public int isChild(int start, int end) {
		if(start == end)
		{
			return 1;
		}
		else
		{
			MyNode node = myTree[start];
			int left = node.leftChildIndex;
			int right = node.rightChildIndex;
			if(left != -1 && myTree[left].isSafe != 0 && isChild(left, end)== 1)
				return 1;
			else if(right != -1 && myTree[right].isSafe != 0)
				return isChild(right, end);
		}
		return -1;
	}

	public int findParent(int i) {
		for(int j = 0; j<size; j++)
		{
			if(myTree[j].leftChildIndex == i || myTree[j].rightChildIndex == i)
				return j;
		}
		return -1;
	}


}
