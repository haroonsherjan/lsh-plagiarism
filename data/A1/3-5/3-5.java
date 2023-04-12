import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
	static Scanner sc;
	static MyTree tree;

	/** Read in the tree
	 */
	public static void readTree () {
		// Create MyTree with n nodes
		int nodes = sc.nextInt();
		tree = new MyTree(nodes);
		
		// Safety
		for (int i=0;i<nodes;i++){ 
			tree.updateSafe(i, sc.nextInt() == 1);
		}

		// loop to read pairs of children
		for (int i=0;i<nodes;i++) {
			tree.updateNode(i,sc.nextInt(),sc.nextInt());
		}
	}

	/** Read in query statements
	 */
	public static void readQueries () {
		// read in one integer
		int m = sc.nextInt();
		for (int i=0;i<m;i++) {
			if (tree.isPathSafe(sc.nextInt(),sc.nextInt()))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		readTree();				   // read in the tree
		readQueries();				// read in the queries
	}
}
/* 
Class for a tree node
*/

import java.util.*;
class MyNode {
    boolean safe = false;
    MyNode leftChild = null, rightChild = null, parent = null;
	int id;
	
	public MyNode(int id) {
		this.id = id;
	}
	
	// Mutators
	public void setSafe(boolean safe){
		this.safe = safe;
	}
	public void setLeft(MyNode node){
		leftChild = node;
	}
	public void setRight(MyNode node){
		rightChild = node;
	}
	public void setParent(MyNode node){
		parent = node;
	}
	
	//Accessors
	public int getId() {
		return id;
	}
	public MyNode getLeft(){
		return leftChild;
	}
	public MyNode getRight(){
		return rightChild;
	}
	public MyNode getParent(){
		return parent;
	}
	public boolean isSafe(){
		return safe;
	}
}
public class MyTree {

    private final int MAX_NODES = 1000;
    MyNode[] myTree;
    int size = 0;


	public MyTree(int n){
		myTree = new MyNode[n];
		for (int i = 0; i < n; i++)
			myTree[i] = new MyNode(i);
		size = n;
	}
	public void updateSafe(int node, boolean safe){
		myTree[node].setSafe(safe);
	}
	public void updateNode(int node, int left, int right){
		if (left != -1) {
			myTree[node].setLeft(myTree[left]);
			myTree[left].setParent(myTree[node]);
		}
		if (right != -1) {
			myTree[node].setRight(myTree[right]);
			myTree[right].setParent(myTree[node]);
		}
	}
	
	public boolean isPathSafe(int start, int end){
		boolean reply = false;
		
		MyNode curNode = myTree[start];
		
		ArrayList<MyNode> path = new ArrayList<MyNode>();
		while (curNode != null && curNode.isSafe()) {
			path.add(curNode);
			
			if (curNode.getId() == end) {
				return true;
			}
			
			curNode = curNode.getParent();
		}
		curNode = myTree[end];
		while (curNode != null && curNode.isSafe()) {
			if (path.indexOf(curNode) != -1) {
				return true;
			}
			curNode = curNode.getParent();
		}
		
		return reply;
	}
	
	public void PrintTree() {
        int tree_len = myTree.length - 1;
		for (int i = 0; i < tree_len; i++) {
			System.out.print(i + ":");
			if (myTree[i].getLeft() == null)
				System.out.print("NULL:"); 
			else 
				System.out.print(myTree[i].getLeft().getId() + ":");
			if (myTree[i].getRight() == null)
				System.out.println("NULL"); 
			else 
				System.out.println(myTree[i].getRight().getId());
		}
	}
}
