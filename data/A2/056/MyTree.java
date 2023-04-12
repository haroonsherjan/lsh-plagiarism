/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
    int value;
    
    // Constructor
	public MyNode(int value){
		this.value = value;
	}

    // Accessor
	public int getLeftChild(){
		return leftChildIndex;
	}

	public int getRightChild(){
		return rightChildIndex;
	}
    
	public int getValue(){
		return value;
	}

    // Mutator
	public void setLeftChild(int index){
		leftChildIndex = index;
	}

	public void setRightChild(int index){
		rightChildIndex = index;
	}

	public void setValue(int value){
		this.value = value;
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

    //  Insert root into the tree
	// @param value the item to insert
	
    public void insertRoot(){
       
       myTree[0] = new MyNode(0);
	   myTree[0].setLeftChild(1);
	   myTree[0].setRightChild(2);
	   size++;
	}
    
   // insert left and right child into tree
	public void insert(int left, int right){
		   
		   /* not required
			// extend array size if array size full
			if(myTree.length <= size){
				MyNode[] newTree = new MyNode[myTree.length*2+1];

				for(int i=0; i<myTree.length; i++){
					newTree[i] = myTree[i];
				}
				myTree = newTree;
			}*/


            // insert left child into array
			myTree[size] = new MyNode(left);
			myTree[size].setLeftChild(-1);
			myTree[size].setRightChild(-1);
            size++;

			// insert right child into array
			myTree[size] = new MyNode(right);
			myTree[size].setLeftChild(-1);
			myTree[size].setRightChild(-1);            
			
            size++;

		
	}

	public String queries(int left, int right){
       return compare(find(left),find(right)); 
	}

	private int find(int value){
       for(int i=0; i<size; i++){
		   if(myTree[i].getValue() == value)
			   return i;
        }
       return -1;
	}

	private String compare(int leftPos, int rightPos){
       
		if(rightPos - leftPos == 1)
			return "LEFT SIBLING";
		else if(rightPos - leftPos == 1)
			return "RIGHT SIBLING";

		// recursive find parent of righChild
		// if leftChild - rightchild == 0
		// return ANCESTOR
		else if((rightPos-1)/2 == leftPos)
			return "ANCESTOR";
		// recursive find the descendant of leftchild
		// if leftchild - rightchild = 0
		// return descendant
		else if((leftPos-1)/2 == rightPos)
			return "DESCENDANT";
		else
			return "NONE";
	}

	private void inOrder(){
	}

	private void levelOrder(){
	}

	private void preOrder(){
	}

	private void postOrder(){
	}

}
