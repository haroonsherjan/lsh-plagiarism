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
	bNode root2 = new bNode();
	class bNode{
		bNode left, right;
		int value;
		public bNode(){}
		public bNode(int value){
			this.value = value;	
		}
	}
	
	public void insert(int value){
		insert(root2, value);
	}

	public void insert(bNode node, int value){
		if(value < node.value){
			if(node.left != null){
				insert(node.left, value);				
			}else{
				node.left = new bNode(value);
			}

		}else if(value < node.value){
			if(node.right != null){
				insert(node.right, value);
		}else{
			node.right = new bNode(value);


			}
		}
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
	MyTree(){}
//node constructor
	Node root = new Node();
	class Node{
		Node left;
		Node right;
		int value;
		public Node(){}
		public Node(int value){
			this.value = value;
		}
	}
//insert the nodes into the trees
	public void insert(int value){
		insert(root, value);
	}

	public void insert(Node node, int value){
			if(node.left != null){
				insert(node.left, value);
			}else{
				node.left = new Node(value);
			}
			
			if(node.right != null){
				insert(node.right, value);
			}else{
				node.right = new Node(value);
			}
	}
	//print trees
	public void printTree(){
		printTree(root);
	}
	public void printTree(Node node){
		if(node != null){
			printTree(node.left);
			System.out.println(node.value);
			printTree(node.right);
		}

	}
	//check safe/unsafe
	public void safe(int first, int second){
		safe(root, first, second);
	}
	public void safe(Node node, int first, int second){
		if(node != null){
			safe(node.left, first, second);
			System.out.println("Safe");

			safe(node.right, first, second);
		}
	}
}

