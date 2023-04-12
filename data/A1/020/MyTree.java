/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
	boolean checked;
    int left;			  // left child index in array
    int right;		 // right child index in array
	int top;
	
	public MyNode() {
	} // dummy constructor

	public MyNode(boolean isSafe) {
		this(isSafe, -1, -1, -1);
	}
	
	public MyNode(boolean isSafe, int left, int right, int top) {
		this.isSafe = isSafe;
		this.left = left;
		this.right = right;
		this.top = top;
	} // end constructor

	void setSafe(boolean safe) {
		this.isSafe = safe;
	} 

	void setChecked(boolean check) {
		this.checked = check;
	}

	void setLeft(int l) {
		this.left = l;
	}

	void setRight(int r) {
		this.right = r;
	}

	void setTop(int t) {
		this.top = t;
	}

    // fill in your accessor and mutator methods here
    // ...
}

/** Class for a binary tree ADT
 */
public class MyTree {

    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;
	boolean routeIsSafe;

    public MyTree(int n) {
		this.size = n;
		for (int x=0; x<size; x++) {
			myTree[x] = new MyNode();
		} // end loop to create new nodes
	} // end myTree constructor

	public void setNodeSafe(int nodeNum, int safe) {
		if (safe == 0) {
			myTree[nodeNum].setSafe(false);
		} // set the node to unsafe if 0 is the input
		else {
			myTree[nodeNum].setSafe(true);
		} // else set to safe if 1 is input
	} // end setNodeSafe
	
	public void setChild(int nodeNum, int left, int right) {
		myTree[nodeNum].setLeft(left);
		if (myTree[nodeNum].left != -1) {
			myTree[left].setTop(nodeNum);
		} // sets the index for left child

		myTree[nodeNum].setRight(right);
		if (myTree[nodeNum].right != -1) {
			myTree[right].setTop(nodeNum);
		} // sets the index for right child
	} // end setChild

	public String safeRoute(int start, int end) {
		resetCheck(); // resets storage variable for checking
		checkRoute(start, end); // recursive call for routeChecking
		if (routeIsSafe == true) {
			return "YES";
		}
		else {
			return "NO";
		}
	} // end safeRoute
	
	private void checkRoute(int start, int end) {
		if (start == end) {
			routeIsSafe = true;
		} // base case if the end is reached. sets the boolean to safe route.
		
		if ((myTree[start].isSafe == true) && (myTree[start].top != -1)){
			if ((myTree[start].left != -1) && (myTree[myTree[start].left].checked != true)){
                 myTree[myTree[start].left].setChecked(true);
				 checkRoute(myTree[start].left, end);
			} // continues on the path if the left route is unchecked and avaliable

			if ((myTree[start].right != -1) && (myTree[myTree[start].right].checked != true)){
                 myTree[myTree[start].right].setChecked(true);
				 checkRoute(myTree[start].right, end);
			} // continues on the path if the right route is unchecked and avaliable

			if ((myTree[myTree[start].top].checked != true)) {
				myTree[myTree[start].top].setChecked(true);
				checkRoute(myTree[start].top, end);
			} // continues on the path if the top route is unchecked and avaliable
		}
	} // end recursive checking method checkRoute

	private void resetCheck() {
		routeIsSafe = false;
		for(int i=0; i<size; i++) {
			myTree[i].setChecked(false);
		}
	} // helper method to reset the boolean variable inside nodes that stores if it is checked
} // end MyTree
