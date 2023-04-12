/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int index;
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    MyNode(){
    	index = 0;
    	isSafe = false;
    	leftChildIndex = -1;
    	rightChildIndex = -1;
    }
    
    //Accessors & Mutators
    int getIndex(){return index;}
    boolean getIsSafe(){return isSafe;}
    int getLeftChildIndex(){return leftChildIndex;}
    int getRightChildIndex(){return rightChildIndex;}
    void setIsSafe(boolean safety){isSafe = safety;}
    void setLeftChildIndex(int newLeftChild){leftChildIndex = newLeftChild;}
    void setRightChildIndex(int newRightChild){rightChildIndex = newRightChild;}
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
    int[] inOrderTrans;
    
    //Accessors & Mutators
    void setSize(int newSize){size = newSize;}
    /*
    //The following code creates an Array to store an inOrder
    //representation of the Binary Tree
    int inOrder(MyNode T){
    	inOrder(myTree[T.getLeftChildIndex()]);
    	return T.getIndex();
    	inOrder(myTree[T.getRightChildIndex()]);
    }
    
    void createInOrder(MyNode T){
    	inOrderTrans = new int[size];
		for(int i = 0; i < size; i++)
			inOrderTrans[i] = inOrder(T);
    }
    */
    
    //Transversal from point "a" to point "b"
    boolean isRouteSafe(int a, int b){
    	while(a != b)
    	{
    			if(myTree[a].getLeftChildIndex() > -1)
    				return isRouteSafe(myTree[a].getLeftChildIndex(), b);
    			if(myTree[a].getRightChildIndex() > -1)
    				return isRouteSafe(myTree[a].getRightChildIndex(), b);
    	}
    	return myTree[a].getIsSafe();
    }
    
    //Because there are several ways of tranversing from city to city
    //we need to find the shortest route.
	void shortestRoute(int a,int b){
	//Searches the tree for cases where it has to transverese to the left or right
		//case 1: b is a sub tree of a
		//case 2: b is not a sub tree of a
	}
}
