/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;          // right child index in array
	int leftChild, rightChild;
	int label;
	int parentIndex;

    // fill in your accessor and mutator methods here
    // ...
	public MyNode(int l){
		label = l;
	}
	public MyNode(int left, int right){
		label = 0;
		leftChild = left;
		rightChild = right;
		leftChildIndex = 1;
		rightChildIndex = 2;
		
	}
	public MyNode(int i, int left, int right){
		label = i;
		leftChild = left;
		rightChild = right;
		leftChildIndex = 2 * i + 1;
		rightChildIndex = 2 * i + 2;
		parentIndex = (int) Math.floor((i-1)/2);
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
    public void constructTree(int i, int a, int b){
		if (size == 0) {
			myTree[0] = new MyNode(a, b);
			myTree[myTree[0].leftChildIndex] = new MyNode(a);
			myTree[myTree[0].rightChildIndex] = new MyNode(b);
			size++;
		}
		else{
		   myTree[i] = new MyNode(getIndex(i), a, b);
		   size++;
           myTree[myTree[i].leftChildIndex] = new MyNode(a);
           myTree[myTree[i].rightChildIndex] = new MyNode(b);

		}
	}
	public MyNode getNode(int i){
		for (int j = 0; j < size; j++){
			if (myTree[j].label == i) 
				return myTree[j];
		}
	}
	public int getIndex(int i){
		for (int j = 0; j < size; j++){
			if (myTree[j].label == i) return j;
		}
	}
	public String checkRela(int a, int b){
		if (getNode(a).parentIndex == getNode(b).parentIndex){
			if (a < b) return "LEFT SIBLING";
			else return "RIGHT SIBLING";
		}
		else if(isAncestor(a, b)) return "ANCESTOR";
		else if(isDescendant(a, b)) return "DESCENDANT";
		else return "NONE";
	}
	public boolean isAncestor(int a, int b){
		boolean isAn = false;
		while(b != 0 && !isAn){
			if (a == myTree[getNode(b).parentIndex].label)
				isAn = true;
			else
				b = myTree[getNode(b).parentIndex].label;
		}
		return isAn;
	}
	public boolean isDescendant(int a, int b){
		return isAncestor(b, a);
	}
}
