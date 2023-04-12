/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // ...
	public MyNode(){
		leftChildIndex = -1;
		rightChildIndex = -1;
	}//end empty constructor

	public MyNode(int left, int right){
		leftChildIndex = left;
		rightChildIndex = right;
	}//end constructor

	public int getLeft(){
		return leftChildIndex;
	}//end getLeft

	public int getRight(){
		return rightChildIndex;
	}//end getRight

	public int setLeft(int left){
		return leftChildIndex = left;
	}//end setLeft

	public int setRight(int right){
		return rightChildIndex = right;
	}//end setRight
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
	public MyTree(){
	}//end default constructor

	public MyTree(int left, int right){
		myTree[size] = new MyNode(left, right);
		size++;
	}//end constructor

	public void buildTree(int left, int right){
		myTree[size] = new MyNode(left, right);
		size++;
	}//end buildTree

	public String findRelationship(int node1, int node2){
		if(ancestor(node1,node2))
			return "ANCESTOR";
	    else if(descendant(node1, node2))
			return "DESCENDANT";
	    else if(leftSibling(node1, node2))
			return "LEFT SIBLING";
		else if(rightSibling(node1, node2))
			return "RIGHT SIBLING";
		else
			return "NONE";
	}//end findRelationship

	public boolean ancestor(int n1, int n2){
		if(myTree[n1].getLeft() == n2 || myTree[n1].getRight() == n2)
			return true;
		else if(myTree[n1].getLeft() == -1 && myTree[n1].getRight() == -1)
			return false;
		else if(myTree[n1].getLeft() == -1 && myTree[n1].getRight() != -1)
			return ancestor(myTree[n1].getRight(), n2);
		else if(myTree[n1].getLeft() != -1 && myTree[n1].getRight() == -1)
			return ancestor(myTree[n1].getLeft(), n2);
		else
			return ancestor(myTree[n1].getLeft(), n2) || ancestor(myTree[n1].getRight(), n2);
	}//end ancestor

	public boolean descendant(int n1, int n2){
		return ancestor(n2, n1);
	}//end descendant

	public boolean leftSibling(int n1, int n2){
		int parent = findParent(n1);
		if(myTree[parent].getLeft() == n1)
			return myTree[parent].getRight() == n2;
		return false;
	}//end leftSibling

	public boolean rightSibling(int n1, int n2){
		return leftSibling(n2, n1);
	}//end rightSibling

	public int findParent(int node){
		if(node == 0)
			return 0;
		else {
	    	for(int i=0; i<size; i++)
		    	if(myTree[i].getLeft() == node || myTree[i].getRight() == node)
			    	return i;
		}//end else
		return 0;
	}//end findParent
}
