/** Class for a tree node
 */
class MyNode {
	// You may use this class if you'd like.  It may help you if you use
	// an array based implementation of a binary tree

	// you can add other variables if you'd like
	// int leftChildIndex;			  // left child index in array
	// int rightChildIndex;		 // right child index in array

	//Creating using a reference implementation
	private int value;
	private int index;
	private MyNode left;
	private MyNode right;
	// fill in your accessor and mutator methods here

	public MyNode(){
		left = null; 
		right = null;
		value = 0;
		index = -1;
	}

	public MyNode(int value) {
		left = null; 
		right = null;
		this.value = value;
		this.index = -1;
	}

	public void setIndex(int Index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public MyNode getLeft() {
		return left;
	}

	public MyNode getRight() {
		return right;
	}

	public void setLeft(MyNode node) {
		left = node;
	}

	public void setRight(MyNode node) {
		right = node;
	}





	/** Class for a binary tree ADT
	 */
	public class MyTree {
		// You may want to use an array based implementation for 
		// your tree, or change this to another implementation

		// Note that this code and the driver code do not necessarily
		// match well -- you decide how you want these two parts to work
		// together.

		//private final int MAX_NODES = 1000;
		//MyNode[] myTree = new MyNode[MAX_NODES];
		//int size = 0;	// make sure to update this variable as needed

		// fill in your ADT methods here
		private MyNode root;
		private MyNode curr;
		public MyTree() {
			root = null;
			curr = root;
			pointer = root;
		}

		public void insert(int valueA) {
			if (valueA == -1) {
				curr.left = null;
			}

			if (root == null) {
				root = new MyNode(0);
		} else if{
			curr.left = valueA; 
			insert(valueB);
		} 
		}

		public void insert(int valueB) {
			if (valueB == -1) {
				curr.right = null;
			}
			if (root == null) {
				root = new MyNode(0);
			} else {
				curr.right = valueB;
                valueB = pointer;
			    node.getValue(valueA) = curr;
                insert(int valueA);
			}
		}

	//		public void insert(int value) {
	//			if(root == null) {
	//				root = new MyNode(value);
	//			} else {
	//				insert(value, root);
	//			}
	//		}
        


        public void getRelation() {
			if (curr.left == numA && curr.right == numB) {
				if (curr.right == numA) {
					System.out.println("RIGHT SIBLING");
				} else {
					System.out.println("LEFT SIBLING");
				}
			}

			if (curr == numA && curr.left == numB) {
				System.out.println("ANCESTOR");
			}

			if (curr == numA && curr.right == numB) {
				System.out.println("ANCESTOR");
			}

			if (curr == numB && curr.left == numA) {
				System.our.println("ANCESTOR");
			}

			if (curr == numB && curr.right == numA) {
				System.out.println("ANCESTOR");
			}

			}

 

	





	}
