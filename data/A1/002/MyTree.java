/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // ...

	public MyNode( int i ) {
		if( i == 0 ) {
			isSafe = false;
		} else 
			isSafe = true;
	}
    
	//accessors
	public int getLeft(){
		return leftChildIndex;
	}

	public int getRight(){
		return rightChildIndex;
	}
	
	//mutators
	public void setLeft(int left){
		this.leftChildIndex = left;
	}

	public void setRight (int right){
		this.rightChildIndex = right;
	}

	public boolean isSafe(){
		return isSafe;
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

	//insert the cities
	public void insert (int n, int leftIndex, int rightIndex){
		myTree[size] = new MyNode(n);
		myTree[size].setLeft(leftIndex);
		myTree[size].setRight(rightIndex);
		size++;
	}
	
	//use recursive methods to find result
	public boolean queries(int depature, int arrive){
		if (depature != arrive){
			return queries(getParent(depature), 0)&& queries(getParent(arrive), 0)&& myTree[depature].isSafe && myTree[arrive].isSafe;
		} else return myTree[depature].isSafe;
	}

	/*public boolean allSafe(int depature, int root){
		if (departure == root){
			return myTree[0].isSafe;
		} else 
			return myTree[departure].isSafe && allSafe(getParent(depature), myTree[0]);
	}*/

	//method to find the parents of the city
	public int getParent(int city){
		for (int i = city;  i >=0; i --){
			if(myTree[i].getRight() == city || myTree[i].getLeft() == city){
				return i;
			}
		}
		//return 0 if no parent, meaning this city is the root
		return 0;
	}
}
