/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	
	MyNode(int x) {
		if (x==1)
			isSafe = true;
		else
			isSafe = false;
		leftChildIndex = -1;
		rightChildIndex = -1;
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
	private final int root = 0;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed

	void setSafety(int x) {
		myTree[size] = new MyNode(x);
		//System.out.println(size + ": " + myTree[size].isSafe);
		++size;
	}
	void insert(int index, int left, int right) {
		myTree[index].leftChildIndex = left;
		myTree[index].rightChildIndex = right;
		//System.out.println(index + ": " + myTree[index].leftChildIndex + " " + myTree[index].rightChildIndex);
	}

	boolean traverse(int start, int end) {
		return traverse(root, start, end);
	}

	boolean traverse(int index, int start, int end) {
		if (start==-1)
			return traverse(end, end, end) && myTree[index].isSafe;
		else if (end==-1)
			return traverse(start, start, start) && myTree[index].isSafe;
		else if (start==end)
			return myTree[index].isSafe;
		else if (myTree[index].leftChildIndex==end || myTree[index].rightChildIndex==end)
			return myTree[index].isSafe;
		
		/*
		else if (index<end) {
			if (myTree[index].leftChildIndex==end || myTree[index].rightChildIndex==end)
				return myTree[index].isSafe;
			else if 

		}
		*/
		//else if (start>end) {
		//	
		//}
		else
			return false;
	}

	
}
