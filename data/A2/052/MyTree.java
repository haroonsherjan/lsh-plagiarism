/** Class for a tree node
 */
class MyNode {
    private int num;
	private MyNode left;
	private MyNode right;
	private MyNode parent;

	//constructors
	public MyNode(){
		num = 0;
		left = null;
		right = null;
		parent = null;
	}

	public MyNode(int x){
		num = x;
		left = null;
		right = null;
		parent = null;
	}

	//Accessors
	public int getNum(){
		return num;
	}

	public MyNode getLeft(){
		return left;
	}

	public MyNode getRight(){
		return right;
	}

	public MyNode getParent(){
		return parent;
	}

	//Mutators
	public void setNum(int x){
		num = x;
	}

	public void setLeft(MyNode node){
		left = node;
	}

	public void setRight(MyNode node){
		right = node;
	}

	public void setParent(MyNode node){
		parent = node;
	}
}

/** Class for a binary tree ADT
 */
public class MyTree {
    private MyNode root;
	private int count;
	
	//constructors
	public MyTree(){
		root = null;
		count = 0;
	}
	
	public MyTree(MyNode node){
		root = node;
		count = 0;
	}

	//accessors
	public MyNode getRoot(){
		return root;
	}

	public int count(){
		return count;
	}

	//mutators
	public void setRoot(MyNode node){
		root = node;
	}

	public void setCount(int x){
		count = x;
	}

	//insert left of node
	public void insertLeft(MyNode parent, MyNode newNode){
		//if tree is empty
		if (parent == null){
			root = newNode;
		}
		else {
			parent.setLeft(newNode);
			newNode.setParent(parent);
		}
		count++;
	}
	
	//insert right of node
	public void insertRight(MyNode parent, MyNode newNode){
		//if tree is empty
		if (parent == null){
			root = newNode;
		}
		else {
			parent.setRight(newNode);
			newNode.setParent(parent);
		}
		count++;
	}
	
	//find the node which contain int x
	public MyNode search(int x, MyNode node){
		if (node.getNum() == x){
			return node;
		}
		else if (node.getNum() != x){
			search(x, node.getLeft());
			search(x, node.getRight());
		}
		//if cant find, return null
		return null;
	}

}
