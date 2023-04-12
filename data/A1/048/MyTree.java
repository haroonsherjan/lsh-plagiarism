/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    MyNode leftChildIndex;			  // left child in the tree
    MyNode rightChildIndex;		 // right child index in the tree
	int city;             

    //MyNode constructor
	public MyNode(int newCity){
		city = newCity;
		leftChildIndex = null;
		rightChildIndex = null;
	}

	public MyNode(int newCity, MyNode left, MyNode right){
		city = newCity;
		leftChildIndex = left;
		rightChildIndex = right;
	}

	//accessor
	public int getItem(){
		return city;
	}

	public MyNode getLeft(){
		return leftChildIndex;
	}

	public MyNode getRight(){
		return rightChildIndex;
	}

	//mutator
	public void setItem(int newCity){
		city = newCity;
	}

	public void setLeft(MyNode left){
		leftChildIndex = left;
	}

	public void setRight(MyNode right){
		rightChildIndex = right;
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
    boolean [] myTree = new boolean [MAX_NODES];
    int size = 0;	// make sure to update this variable as needed
	
	//intialize the boolean array as all false
	public void initialize (){
		for (int i = 0; i < MAX_NODES; i++){
			myTree [i] = false;
		}
	}

    // fill in your ADT methods here
    // indicate whether a city is safe
	public  void setSafety(int cityIndex, int safety){
		if (safety == 1){
			myTree [cityIndex] = true;
		}
		else {
			myTree [cityIndex] = false;
		}
	}
}

