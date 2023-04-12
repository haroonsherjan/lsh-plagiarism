/** Class for a tree node
 */
class MyNode {
    private int item;         //item represents the "label" 
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
    
	public MyNode(int item, int index) {  //constructor
		this.item = item;
		leftChildIndex = 2 * index + 1;
		rightChildIndex = 2 * index + 2;
	}

	public int getItem() {    //some methods below
		return item;
	}

	public void setItem(int i) {
	    item = i;
	}

	public int getLeftChildIndex() {
	    return leftChildIndex;
	}

	public int getRightChildIndex() {
		return rightChildIndex;
	}

	public void setLeftIndex(int i) {
	    leftChildIndex = i;
	}

	public void setRightIndex(int i) {
	    rightChildIndex = i;
	}
}

/** Class for a binary tree ADT
 */
public class MyTree {
    
    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;               //here, use "size" to represent the index of next item, which is to be inserted.

    public MyTree() {     //constructor
		myTree[0] = new MyNode(0, 0);
		size++;
	}

	public void insert(int item) {   //insert next item, index is set to be current "size"
        myTree[size] = new MyNode(item, size);
		size++;
	}

	public String getRelationship(int item1, int item2) {   //get the relationship of two labelled items
        int index1 = getIndex(item1);    //first, get the indexs of two items 
		int index2 = getIndex(item2);
		//five cases
	    if (myTree[index1].getLeftChildIndex() == index2 || myTree[index1].getRightChildIndex() == index2)
			return "ANCESTOR";
	    else if (myTree[index2].getLeftChildIndex() == index1 || myTree[index2].getRightChildIndex() == index1)
			return "DESCENDANT";
		else if (((index1 - 1) / 2) == ((index2 - 1)/2)) {
		    if (index1 < index2)
				return "LEFT SIBLING";
			else
				return "RIGHT SIBLING";
		}
		else
			return "NONE";			 
	}

	public int getIndex(int item) {        //get the index in array of a labelld item
        for (int i = 0; i < size; i++) {
	        if (myTree[i].getItem() == item)
                return i;
		}
		return -1;
	}
}
