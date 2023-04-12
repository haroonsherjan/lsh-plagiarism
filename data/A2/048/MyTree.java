/** Class for a tree node

 */
class MyNode {
	int leftChildIndex = -1;			  // left child index in array
	int rightChildIndex = -1;          // right child index in array
	int index;
	int value;

	public MyNode(int value) {
		this.value = value;
	}

	public void setValue(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setIndex(int index){
		this.index = index;
	}

	public int getIndex(){
		return index;
	}
	
	public void setLeftChild(int left){
		leftChildIndex = left;
	}

	public int getLeftChild() {
		return leftChildIndex;
	}

	public void setRightChild(int right){
		rightChildIndex = right;
	}

	public int getRightChild() {
		return rightChildIndex;
	}
}

/** Class for a binary tree ADT
 */
public class MyTree {

	private final int MAX_NODES = 1000;
	MyNode[] myTree = new MyNode[MAX_NODES];
	private int count;

	public MyTree(){
	}

	public void insertLeftChild(int value){
		insertLeftChild(value, 0);
	}

	public void insertLeftChild(int value, int loc){
		if (myTree == null){
			myTree = new MyNode[1];
			myTree[0] = new MyNode(value);
		}
		else {
			if (myTree.length <= loc){
				MyNode[] newTree = new MyNode[myTree.length*2+1];

				for (int i=0; i<myTree.length; i++){
					newTree[i] = myTree[i];
				}
				myTree = newTree;
			}
			if (myTree[loc] == null){
				myTree[loc] = new MyNode(value);
			}
			else if (value < myTree[loc].getValue()){
				//insert(value, loc*2+1);
			}
			else if (value > myTree[loc].getValue()){
				//insert(value, loc*2+2);
			}
		}
	}

	public int position(int nodeValue) {
		indexing();
		return position(nodeValue,0);
	}

	private int position(int nodeValue, int loc){
		if (myTree == null || loc >= myTree.length || myTree[loc] == null){
			return -1;
		}
		if (myTree[loc].getValue() == nodeValue){
			return myTree[loc].getIndex();
		}
		else if (nodeValue < myTree[loc].getValue()){
			return position(nodeValue, loc*2+1);
		}
		else {
			return position(nodeValue, loc*2+2);
		}
	}

	private void indexing(){
		count = 1;
		indexing(0);
	}

	private void indexing(int loc){
		if (myTree == null || loc >= myTree.length || myTree[loc] == null){
			return;
		}

		indexing(loc*2+1);
		myTree[loc].setIndex(count);
		count++;
		indexing(loc*2+2);
	}

}
