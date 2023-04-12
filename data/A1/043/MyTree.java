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
}

//USAGE BEGINS BELOW


/** Class for a binary tree ADT
 */
public class MyTree {
	private int parent;
	private int lChild;
	private int rChild;
	private int status;

	public MyTree() {
		this.parent = 0;
		this.lChild = 0;
		this.rChild = 0;
		this.status = 0;
	}

	// mutators

	public void setParent(int p) {
		parent = p;
	}

	public void setLChild(int l) {
		lChild = l;
	}

	public void setRChild(int r) {
		rChild = r;
	}

	public void setStatus(int s) {
		status = s;
	}

	// accessor(s)

	public int getStatus() { return this.status; }

	public int getParent() { return this.parent; }

	// method(s)

	public boolean determine(int start, int destination) {
		
		MyTree nodeStart = myTree[start];
		MyTree nodeEnd = myTree[destination];
		int status;

		if (start==destination) {
			status = nodeStart.getStatus();
			if (status==1) return true;
			else return false;
		}

		else {
			while (start!=0) {
				status = nodeStart.getStatus();
				if (status==0) return false;  // once u hit a city that is unsafe, return unsafe and quit method
				determine(nodeStart.getParent(), 0);
			}

			while (destination!=0) {
				status = nodeEnd.getStatus();
				if (status==0) return false;
				determine(nodeEnd.getParent(), 0);
			}

			return true;
			}
	} // end of method determine
} // end of class MyTree
