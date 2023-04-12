/** Class for a tree node
 */
class MyNode {
    int left;
    int right;
	
	public MyNode(int x, int y) {
		left = x;
		right = y;
	}
}

/** Class for a binary tree ADT
 */
public class MyTree {
    MyNode[] myTree;
	int arraySize;
	
	public MyTree(int x) {
		myTree = new MyNode[x];
		arraySize = x;
	}

	public void check(int x, int y) {
		if (isLeftSibling(x, y)) {
			System.out.println("LEFT SIBLING");
			return;
		}
		else if (isRightSibling(x, y)) {
			System.out.println("RIGHT SIBLING");
			return;
		}
		else if (isAncestor(x, y)) {
			System.out.println("ANCESTOR");
			return;
		}
		else if (isDescendant(x, y)) {
			System.out.println("DESCENDANT");
			return;
		}	
		else {
			System.out.println("NONE");
			return;
		}
	}

	private boolean isLeftSibling(int x, int y) {
		for (int i = 0; i < arraySize; i++) {
			if ((myTree[i].left == x && myTree[i].right == y)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isRightSibling(int x, int y) {
		for (int i = 0; i <arraySize; i++) {
			if((myTree[i].right == x && myTree[i].left == y)) {
				return true;
			}
		}
		return false;
	}
	
	//traverse every node in subtree of node x. if node y is in the subtree, return true.
	private boolean isAncestor(int x, int y) {
		if (x != -1) {
			if (x == y) {
				return true;
			}
			isAncestor(myTree[x].left, y);
			isAncestor(myTree[x].right, y);
		}
		return false;
	}
	
	//traverse every node in substree of node y. if node x is in the subtree, return true.
	private boolean isDescendant(int x, int y) {
		if(y != -1) {
			if (x == y) {
				return true;
			}
			isDescendant(myTree[y].left, x);
			isDescendant(myTree[y].right, x);
		}
		return false;
	}
}
