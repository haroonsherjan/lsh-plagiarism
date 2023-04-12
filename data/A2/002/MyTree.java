/** Class for a binary tree ADT
 */
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

    private final int MAX_NODES = 1000;
	private int root=-1; // index of the root
	private int free=0;   // index of next unused array location
                       
    MyNode[] myTree = new MyNode[MAX_NODES];
    
	public MyNode[] getMyTree() {
		return myTree;
	}
	
	// -1 is also inserted into the tree
	public void insert (int item) {
		if (root==-1) {
			root ++;
			myTree[free] = new MyNode(0);
			free++;
		}
		myTree[free] = new MyNode(item);
		free++;
	}

    // remark: the methods descendant, leftSib, rightSib, ancestor
	// read in the input a and b which are the indexes of number A and B respectively.

    private boolean isDes = false;
    private boolean done = false;
    
	public void descendant (int a, int b) {
		isDes = false;
		done = false;
		if (!done && b<free) {
			// if the encountered number is -1, ignore it
			if (myTree[b].getItem()==-1) 
				descendant(a,b+1);
				// three situations where a is descendant of b
				else if (b==0 || a==2*b+1 || a==2*b+2) {
					isDes = true;
				    done = true;
			    }
				// two situations where a is not descendant of b
				else if (a>=b || a<2*b+1) {
					isDes = false;
				    done = true;
			    }
				else if (a>2*b+2) 
					descendant(a,b+1);	
		}
		if (done&&isDes)
			System.out.println("DESCENDANT");
	}
    
	protected boolean isLeftSib = false;

	public void leftSibling (int a, int b) {
		isLeftSib = false;
		done = false;
		if (!done) {
			if (b%2==0 || a == 0 || b == 0) {  // b is even, no left sibling avail
				isLeftSib = false;
				done = true;
			}
			else if (a+1 == b) {
				isLeftSib = true;
				done = true;
			}
			else {
				isLeftSib = false;
				done = true;
			}
		}
		if (done&&isLeftSib)
			System.out.println("LEFT SIBLING");
	}
    
	protected boolean isRightSib = false;

	public void rightSibling (int a, int b) {
		isRightSib = false;
		done = false;
		if (!done) {
			if (b%2==1 || a == 0 || b == 0) { // b is odd, no right sibling avail
				isRightSib = false;
				done = true;
			}
			else if (a == b+1) {
				isRightSib = true;
				done = true;
			}
			else {
				isRightSib = false;
				done = true;
			}
		}
		if (done&&isRightSib)
			System.out.println("RIGHT SIBLING");
	}
    
	protected boolean isAnc = false;
	public void ancestor (int a, int b) {
		isAnc = false;
		done = false;
		if (!done && a < free) {
			if (myTree[a].getItem()==-1)
				ancestor(a+1,b);

			else if (a==0 || (a-1)/2 == b) {
				isAnc = true;
				done = true;
			}
			else if (a>=b) {
				isAnc = false;
				done = true;
			}
			else 
				ancestor(a+1,b);
		}
		if (done&&isAnc)
			System.out.println("ANCESTOR");
	}

	public void nothing (int a, int b) {
		descendant(a,b);
		ancestor(a,b);
		leftSibling(a,b);
		rightSibling(a,b);

		if (!isDes&&!isAnc&&!isLeftSib&&!isRightSib)
			System.out.println("NONE");
	}			
}

class MyNode {
	private int item;
	private int left;
	private int right; // index of left and right child of the item

	public MyNode (int i) {
		item = i;
		left = -1;
		right = -1;
	}

	public void setItem (int i) {
		item = i;
	}

	public int getItem () {
		return item;
	}

	public void setLeft (int l) {
		left = l;
	}

	public int getLeft () {
		return left;
	}

	public void setRight (int r) {
		right = r;
	}

	public int getRight () {
		return right;
	}
}
