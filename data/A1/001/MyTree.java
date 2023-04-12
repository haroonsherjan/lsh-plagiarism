/** Class for a tree node
 */
class MyNode {
    // A reference  based implementation of a binary tree

    boolean isSafe;         // is the city safe?
    int city;
    MyNode leftChild;			  // left child 
    MyNode rightChild;		 // right child
    

	public MyNode (int newCity) {
		//initializes tree node with city and no children
		city = newCity;
		leftChild = null;
		rightChild = null;
	}//end constructor
    
	public MyNode (int newCity, MyNode left, MyNode right) {
		city = newCity;
		leftChild = left;
		rightChild = right;
	}//end constructor

	public void setCity (int newCity) {
		city = newCity;
	}//end setCity

	public void setLeft (MyNode left) {
		//sets left child reference to left
		leftChild = left;
	}//end setLeft

	public void setRight (MyNode right) {
		//sets right child reference to right
		rightChild = right;
	}//end setRight

	public boolean setIsSafe (int flag) {  //according to flag value sets isSafe
		if (flag==0)
			return isSafe = false;
		else 
			return isSafe = true;
	}//end setIsSafe


}

/** Class for a binary tree ADT
 */
public class MyTree {
    private MyNode root;

	public MyTree (MyNode newRoot) {
          root = new MyNode (newRoot);
	}//end constructor 

	public MyTree (MyNode newRoot, MyNode left, MyNode right) {
       root = new MyNode (newRoot, left, right);
	}//end constructor

	public void attachLeft (int city) {
       root.setLeft(new MyNode (city, null, null));
	}//end attachLeft

    public void attachRight (int city) {
		root.setRight (new MyNode (city, null, null));
    }//end attachRight


}//end MyTree
