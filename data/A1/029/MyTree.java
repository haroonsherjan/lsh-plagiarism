/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    public MyNode(int i){
		if (i==1){
			isSafe = true;
		}
		else{
			isSafe = false;
		}
	}

	public void setLeftRight(int left, int right){
		leftChildIndex = left;
		rightChildIndex = right;
	}

	public boolean getSafe(){
		return isSafe;
	}

	public int getLeft(){
		return leftChildIndex;
	}

	public int getRight(){
		return rightChildIndex;
	}
}

/** Class for a binary tree ADT
 */
public class MyTree {

    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed

    public MyTree(int size){
		this.size = size;
	}

	public void queueSafe(int i, int safe){
		myTree[i] = new MyNode(safe);
	}

	public void setChildren (int i, int left, int right){
		myTree[i].setLeftRight(left, right);
	}

	public int findParent(int child){
		for (int i=0; i<size; i++){
			if((myTree[i].getLeft())==child||(myTree[i].getRight())==child){
				return i;
			}
		}
		return child;
	}	
	
	public boolean safeNot(int a, int b){
		MyNode curr;
		curr = myTree[a];
		int parent = a;
		boolean safeA;
		while(curr!=myTree[0]){
			safeA =curr.getSafe();
			if(safeA== false){
				return false;
			}
			parent = findParent(parent);
			curr = myTree[parent];
		}
		curr = myTree[b];
		parent = b;
		boolean safeB;
		while(curr!=myTree[0]){
			safeB = curr.getSafe();
			if(safeB==false){
				return false;
			}
			parent = findParent(parent);
			curr = myTree[parent];
		}
		return true;
	}
}
