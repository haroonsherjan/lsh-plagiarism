/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
	public MyNode(int left, int right){
		setChildIndex(left, right);
	}// end constructor
	
	public void setChildIndex(int left, int right){
		leftChildIndex = left;
		rightChildIndex = right;
	}// end setChildIndex

    public int getLeftChild(){
		return leftChildIndex;
	}// end getLeftChildIndex

	public int getRightChild(){
		return rightChildIndex;
	}// end getRightChildIndex

}// end MyNode

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

    public void insert(int left, int right, int label){
	// insert the pair of children for the labed node
		myTree[label] = new MyNode(left, right);
		size++;
	}// end insert

	public String relation(int a, int b){
	// determine the relationship between A and B
		if (checkLeftSibling(a,b))
			return "LEFT SIBLING";
		else if (checkRightSibling(a,b))
			return "RIGHT SIBLING";
		else if (checkDescendant(a,b))
			return "DESCENDANT";
		else if (checkAncestor(a,b))
			return "ANCESTOR";
		else
			return "NONE";
	}//end relation
	
	private boolean checkLeftSibling(int a, int b){
	// check whether a is the left child and b is the right child for a certain node
		for(int i = 0; i<size; i++)
			if ((myTree[i].getLeftChild()==a)&&(myTree[i].getRightChild()==b))
				return true;
		return false;
	}//end checkLeftSibling

	private boolean checkRightSibling(int a, int b){
	// check whether a is the right child and b is the left child for a certain node
		return checkLeftSibling(b, a);
	}//end checkRightSilbing

	private boolean checkAncestor(int a, int b){
	// check whether a is an ancestor of b
		if ((myTree[a].getLeftChild()==b)||(myTree[a].getRightChild()==b))
			return true;
		else if ((myTree[a].getLeftChild()==-1)&&(myTree[a].getRightChild()==-1))
			return false;
		else {
			boolean l = false, r = false;
			if (myTree[a].getLeftChild()!=-1)
				l = checkAncestor(myTree[a].getLeftChild(),b);
			if (myTree[a].getRightChild()!=-1)
				r = checkAncestor(myTree[a].getRightChild(),b);
			return (l||r);
		}//end else
	}//end checkDescendant

	private boolean checkDescendant(int a, int b){
	// check whether a is an descendant of b
		return checkAncestor(b,a);
	}//end checkAncestor

}// end MyTree

