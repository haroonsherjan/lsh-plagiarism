/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    private int isSafe;				          // 1 = safe, 0 = not safe
    private MyNode leftChild;			      // left child of the tree
    private MyNode rightChild;		          // right child of the tree
	int city; 

    // fill in your accessor and mutator methods here
    // ...

	public MyNode(int newCity){
	    // initializes tree node with item and no children
    	city = newCity;
		leftChild = null;
		rightChild = null;
	} // end constructor

	public MyNode (int newCity, MyNode left, MyNode right){
       // initializes tree node with item and the left and right children references.
	   city = newCity;
	   leftChild = left;
	   rightChild = right;
	} // end constructor

	public int getCity() {
		// returns the city field
		return city;
	} // end getCity

	public void setCity(int newCity){
		// sets the city field to the new value newCity
		city = newCity;
	} // end setCity

	public MyNode getLeft() {
		// returns the reference to the left child
		return leftChild;
	} // end getLeft

	public void setLeft(MyNode left) {
		//sets the left child reference to the left
		leftChild = left;
	} // end setLeft

	public MyNode getRight() {
		// returns the reference to the right child
		return rightChild;
	}

	public void setRight (MyNode right) {
		// sets the right child reference to the right 
		rightChild = right;
	} // end setRight

	public int getSafe() {
		// returns 1 if safe, 0 if not safe
		return isSafe;
	} // end getSafe

	public void setSafe(int safe) {
		// sets 1 if safe, 0 if not safe
		isSafe = safe;
	} // end setSafe

} // end MyNode

/** Class for a binary tree ADT
 */
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

	protected MyNode root;

    public MyTree() {
		root = null;
	} // end default constructor

	public MyTree(MyNode[] city){
		// initialize the root of the tree
		root = city[0];
	} // end MyTree constructor

    public void attachLeft(MyNode[] city, int node){
		// attach the left child of the root
		if (node == -1){
			// if node is -1, set left child to null
			root.setLeft(null);
		}else{
			root.setLeft(city[node])
		}
	} // end attachLeft

	public void attachRight(MyNode[] city, int node){
		// attach the right child of the root
		root.setRight(city[node])
	} // end attachRight

    // fill in your ADT methods here
    // ...
}
