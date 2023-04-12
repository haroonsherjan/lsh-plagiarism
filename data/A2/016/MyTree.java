/** Class for a tree node
 */
class MyNode {
    Comparable element;
	MyNode left;
	MyNode right;

	MyNode(Comparable theElement) {
		element = theElement;
		left = right = null;
}

/** Class for a binary tree ADT
 */
public class MyTree {
	 public MyTree() {
		 root = null;
	 }

	 public void insert(Comparable x) {
		 root = insert(x, root);
	 }//construct tree
	 
	 public void makeEmpty() {
		 root = null;
	 }//make the node empty(for -1 input)

	 protected MyNode insert(Comparable x, MyNode t) {
		 if (t== null)
			 t = new MyNode(x);
		 
	 }


    // fill in your ADT methods here
    // ...
	public void check(int x, int y) {
		 if ( ) {
			 System.out.println("ANCESTOR");
		 }
		 else if () {
			 System.out.println("DESCENDANT");
		 }
		 else if () {
			 System.out.println("LEFT SIBLING");
		 }
		 else if () {
			 System.out.println("RIGHT SIBLING");
		 }
		 else {
			 System.out.println("NONE");
		 }
}
}
protected MyNode root;
