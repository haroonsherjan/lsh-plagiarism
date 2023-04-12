/** Class for a tree node
 */
class Node {
	// Finding the number of awards
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    private int city;
	private Node left;
	private Node right;

	public Node(int c){
		city = c;
		left = null;
		right = null;
		isSafe = true;
	}

	public Node(int c, Node l, Node r){
		city = c;
		left = l;
		right = r;
		isSafe = true;
	}

	public Node getLeft(){
		return left;
	}

	public Node getRight(){
		return right;
	}

	public int getCity(){
		return city;
	}

	public boolean isSafe(){
		return isSafe;
	}

	public void setLeft(Node l){
		left = l;
	}

	public void setRight(Node r){
		right = r;
	}

	public void setCity(int c){
		city = c;
	}
}

/** Class for a binary tree ADT
 */
public class MyTree {

    private Node root;
	private int size = 0;
	private int currCity = 0;

	public MyTree(){
		root = null;
	}

	public void newRoot(){
		root = new Node(0);
		size++;
	}

	public void insertLeftChild(int c, Node n){
		// inserts a new left child to node n
		if(c != -1){
			Node newNode = new Node(c);
			n.setLeft(newNode);
			size++;
		}
	}

	public void insertRightChild(int c, Node n){
		// insert a new right child to node n
		if(c != -1){
			Node newNode = new Node(c);
			n.setRight(newNode);
			size++;
		}
	}

	public boolean hasNoChildren(Node n){
		// returns true if node n has no children
		if(n.getLeft() == null && n.getRight() == null){
			return true;
		}
		else{
			return false;
		}
	}

	public Node insert(int a, int b, Node curr){
		// insert a new node
		if(hasNoChildren(curr) == true){
			insertLeftChild(a, curr);
			insertRightChild(b, curr);
		}
		else{
			// curr node has children
			if(curr.getLeft().getLeft() == null){
				curr = curr.getLeft();
				return insert(a, b, curr);
			}
			else{
				curr = curr.getRight();
				return insert(a, b, curr);
			}
		}
		return curr;
	}

	public void isSafe(int i, Node n){
		if(i == 0){
			n.isSafe = false;
		}
		else{
			n.isSafe = true;
		}
	}

	public boolean findPath(Node a, Node b){
		Node curr = a;
		if(curr.getLeft() !=  null && curr.getLeft().isSafe == true){
			return findPath(curr.getLeft(), b);
		}
		else if(curr.getRight() != null && curr.getRight().isSafe == true){
			return findPath(curr.getRight(), b);
		}
		else if(curr == b){
			return true;
		}
		else{
			return false;
		}
	}
}
