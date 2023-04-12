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

	public MyNode(int i) {
		if(i == 1)
			isSafe = true;
		else
			isSafe = false;
			} // end MyNode constrcutor

	public void setIsSafe(int s) {
		if(s == 1)
			isSafe = true;
		else
			isSafe = false;
	} // end setIsSafe mutator

	public void setLeftChildIndex(int i) {
		leftChildIndex = i;
	} // end setLeftCHildindex mutator

	public void setRightChildIndex(int i) {
		rightChildIndex = i;
	} // end setRightCHildIndex mutator

	public boolean getIsSafe() {
		return isSafe;
	} // end getISSafe accessor
	
	public int getLeftChildIndex() {
		return leftChildIndex;
	} // end getLeftCHild accessor

	public int getRightChildIndex() {
		return rightChildIndex;
	} // end getRightChild accessor
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
	public MyTree() { }

	public void insertCityCondition(int i) {
		myTree[size] = new MyNode(i);
		size++;
		} // end insertCityCondition method
	
	public void insertLeftChild(int i, int index) {
		myTree[index].setLeftChildIndex(i);
		} // end insertLeftCHild method

	public void insertRightChild(int i, int index) {
		myTree[index].setRightChildIndex(i);
		} // end insertRightChild method

	public void insertPath(int startIndex, int endIndex) {
		if(checkIndex(startIndex) && checkIndex(endIndex)) {
//			int newStartIndex = getParentIndex(startIndex); 
//			int newEndIndex = getParentIndex(endIndex);
		}
		else 
			System.out.println("NO");	// path is unsafe
		}
	

//	public int getParentIndex(int i) {
//		for(int k = 0; k < size; k++) {
//			if (myTree[k].getLeftChildIndex() == i)
//				return k;
//			else if(myTree[k].getRightChildIndex() == i)
//				return k;
//			} // end for loop
//		} // end getParentIndex method

	public boolean checkIndex(int i) {
		return myTree[i].getIsSafe();
		} // end check Index method
}	
//	public void print() {
//		for(int i = 0; i < size; i++) {
//			System.out.println(myTree[i].getIsSafe() + " " +  myTree[i].getLeftChildIndex() + " " + myTree[i].getRightChildIndex());
//		} 
//	}

