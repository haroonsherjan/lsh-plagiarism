/** Class for a tree node
 */
class MyNode {
    
    private int cityNumber;
	private MyNode leftChild;         // left child
	private MyNode rightChild;        // right child
	private MyNode parent;            // parent node 
	private int isSafe;               // if isSafe is 1, city is safe. otherwise, not safe
	private static int size = 0;      // size is the number of cities 

    public MyNode(int k) {
		cityNumber = size;
		leftChild = null;
		rightChild = null;
		parent = null;
		isSafe = k;
		size++;
	} // end default constructor
	
	public int getCityNumber() {
		return cityNumber;
	} // end method getCityNumber

	public MyNode getLeft() {
		return leftChild;
	} // end method getLeft

	public MyNode getRight() {
		return rightChild;
	} // end method getRight

	public MyNode getParent() {		
		return parent;
	} // end method getParent

	public int isSafe() {			// returns 1 if city is safe, otherwise returns 0
		return isSafe;
	} // end method isSafe
} // end class MyNode 

/** Class for a binary tree ADT
 */
public class MyTree {
	
	MyNode capitalCity;
    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed

    public int isSafe (int a, int b) {
		if (a == b) {
			return 1;
		}
		else {
			return 0;
		}
	} // end method isSafe
} // end class MyTree
