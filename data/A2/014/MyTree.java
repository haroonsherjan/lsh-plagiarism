/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int left;			  // left child index in array
    int right;          // right child index in array
	int elem;
	int ancestor;

	public MyNode(int e, int a) {
		elem = e;
		ancestor = a;
		left = -1;
		right = -1;
	}

	public MyNode(int e) {
		elem = e;
		left = -1;
		right = -1;
	}

	public MyNode() {
		elem = -1;
		left = -1;
		right = -1;
	}

    // fill in your accessor and mutator methods here
    // ...

	public int getElem() {
		return elem;
	}

	public void setAnc(int i) {
		ancestor = i;
	}

	public void setElem(int i) {
		elem = i;
	}

	public void setLeft(int l) {
		left = l;
	}

	public void setRight(int r) {
		right = r;
	}

	public int getLeft() {
		return left;
	}

	public int getRight() {
		return right;
	}

	public int getAnc() {
		return ancestor;
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
	MyNode root = new MyNode(0);

	public MyTree() {
		myTree[0]  = root;
		size++;
	}

	public void add(int a, int b) {
		MyNode n = myTree[a];
		n.setElem(b);
		size++;
	}

	public MyNode get(int i) {
		return myTree[i];
	}

    // fill in your ADT methods here
    
	public int index(int a) {
		int m = 0;
		for (int i = 0; i < myTree.length; i++) {
			MyNode o = myTree[i];
			if (o.getElem() == a) {
				m = i;
			}
		}
		return m;
	}

	public String relation(int a, int b) {
		MyNode first = myTree[index(a)];
		MyNode second = myTree[index(b)];

		if (second.getAnc() == index(a)) {
			return "ANCESTOR";
		}

		else if (first.getAnc() == index(b)) {
			return "DESCENDANT";

		}

		else if (first.getAnc() == second.getAnc()) {
			int k = first.getAnc();
			MyNode m = myTree[k];
			if (m.getLeft() == index(a)) {
				return "LEFT SIBLING";
			}
			else{
				return "RIGHT SIBLING";
			}
		}

		else {
			return "NONE";
		}
	} // end method relation
}
