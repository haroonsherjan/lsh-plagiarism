/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    boolean isSafe;				  // is the city safe?
	int element; 				  // element of the node
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

	// default constructor 
	public MyNode (){
	}
	// constructor to initialise the node 
	public MyNode (int item, boolean safe, int left, int right){
		element = item;
		isSafe = safe;
		leftChildIndex = left;
		rightChildIndex = right;
	}
	// get the safe state for this node
	public boolean getSafeState (){
		return isSafe;
	}
	// set the safe state for this node
	public void setSafeState (boolean safe){
		this.isSafe = safe;
	}
	// return the left child index
	public int getLeftChild (){
		return this.leftChildIndex;
	}
	// return the right child index
	public int getRightChild (){
		return this.rightChildIndex;
	}
	//  set right child index
	public void setRightChild (int right){
		this.rightChildIndex = right;
	}
	// set left child index
	public void getLeftChild (int left){
		this.leftChildIndex = left;
	}
	// return the element of this node
	public int getItem (){
		return this.element;
	}
} // end class MyNode

/** Class for a binary tree ADT
 */
public class MyTree {

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed
	
	// default constructor
	public MyTree (){
	}
	
	// to check if the tree is empty
	public boolean isEmpty(){
		return size == 0;
	}
	
	// construct the binary tree by adding 1 node at a time
	public void addNode (int item, int safe,int leftChild, 
						int rightChild){
		boolean isSafe = (safe == 1)? true:false;
		myTree[size++] = new MyNode (item,isSafe,leftChild,rightChild);
	}
	
	// check the path from the start city to the destination city
	// return "YES" if path is safe to visit otherwise return "NO" 
	public String checkPath(int start, int end){
		// to make sure that both are safe to visit
		if (!myTree[start].getSafeState() || 
			!myTree[end].getSafeState()){
			return "NO";
		}
		// if the end city is a left child or right child of start city
		if (myTree[start].getLeftChild() == end || 
			myTree[start].getRightChild() == end){
			return "YES";
		}
		// no visit are made
		if (start == end){
			if (myTree[start].getSafeState())
				return "YES";
		}
		else{
			// traversing back to the root node from the end city
			int parentOfEnd = (end-1)/2;
			int parentOfStart = (start-1)/2;
				
			if (!myTree[parentOfStart].getSafeState() || 
				!myTree[parentOfEnd].getSafeState()){
				return "NO";
			}
			// reach the same parent node of the cities
			if ( parentOfStart == parentOfEnd){
				if (!myTree[parentOfStart].getSafeState())
					return "NO";
				else
					return "YES";
			}
			// traverse all the way up to the root node
			while (parentOfStart != 0 || parentOfEnd != 0 ){
				
				parentOfEnd = (parentOfEnd-1)/2;
				parentOfStart = (parentOfStart-1)/2;

				if (!myTree[parentOfStart].getSafeState() || 
					!myTree[parentOfEnd].getSafeState()){
					return "NO";
				}

				if ( parentOfStart == parentOfEnd){
					if (!myTree[parentOfStart].getSafeState())
						return "NO";
					else
						return "YES";
				}
			}
		}
		return "NO";		
	}

} // end class MyTree
