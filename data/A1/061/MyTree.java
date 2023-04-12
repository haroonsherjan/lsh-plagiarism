/** Class for a tree node
 */
class MyNode {
	// You may use this class if you'd like.  It may help you if you use
	// an array based implementation of a binary tree

	// you can add other variables if you'd like
	boolean isSafe;				  // is the city safe?
	int leftChildIndex;			  // left child index in array
	int rightChildIndex;		 // right child index in array
	int item;
	// fill in your accessor and mutator methods here
	// ...


	public MyNode(int newItem){
		//initialize tree node with item and no children
		item = newItem;
		leftChildIndex = -1;
		rightChildIndex = -1;
	}//end constructor

	public MyNode(int newItem, int left, int right){
		//initialize tree node with item and
		//left and right children node
		item = newItem;
		leftChildIndex = left;
		rightChildIndex = right;
	}//end  constructor

	public void setNode(int newItem){
		item = newItem;
	}

	public int getNode(){
		return item;
	}

	public void setLeft(int left){
		leftChildIndex = left;
	}

	public void setRight(int right){
		rightChildIndex = right;
	}

	public int getLeft(){
		return leftChildIndex;
	}

	public int getRight(){
		return rightChildIndex;
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
	String[] safeCity = new String[MAX_NODES];
	int size = 0;	// make sure to update this variable as needed
	protected int root = 0;
	protected int free;


	// fill in your ADT methods here
	// ...
	public MyTree(){
		//Initialize tree node with item and no children
		//root node is always 0.
		myTree[0].setNode = 0;
		//left child node is initialized to -1(null)
		myTree[2*0+1].setNode = -1;
		//right child node is initialized to -1(null)
		myTree[2*0+2].setNode = -1;
		size++; //size increase by 1, capital city is 0
	}

	//insert left child node of i-th element
	public void leftChild(int i, int left){
		myTree[2*i+1].setNode = left;
		if (left != -1)
			size++;//increase size if it is not null.
	}

	//insert right child node of i-th element
	public void rightChild(int i, int right){
		myTree[2*i+2].setNode = right;
		if (right != -1)
			size++; // increase size if it is not null.
	}

	//check if city is Safe and store into safeCity array
	public void safeCity(int i, int safeCity){
		if(safeCity == 0){
			safeCity[i] = "NO";
		}else if (safeCity == 1){
			safeCity[i] = "YES";
		}
	}

	public boolean checkSafeCity(int start, int end){
		isSafe = true;
		//check if start city and end city is unsafe
		if (safeCity[start].equals("NO")|| safeCity[end].equals("NO")){
			isSafe = false;
		}
		//check if end city is unsafe
		else {
			if (start < end){
				int curr = start;
				checkSafeCity(curr.getLeft(), end);
			} else if (start > end){
				checkSafeCity(curr.getRight, end);
			}
		}
		return isSafe;
	}
}
