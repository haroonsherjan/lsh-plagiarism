/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
    //constructor
	public MyNode(int left, int right){
		leftChildIndex = left;
		rightChildIndex = right;
	}
	//accessor and mutator
	public int getLeft(){
		return leftChildIndex;
	}
	public int getRight(){
		return rightChildIndex;
	}

	public void setRight(int x){
		rightChildIndex= x;
	}
	public void setLeft(int x){
		leftChildIndex=x;
	}
    
}

/** Class for a binary tree ADT
 */
public class MyTree {
    
    //This code build the tree and test as well
	// it'll return the result to the driver to print

    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed
    

    public MyTree(int size){
		this.size = size;
		myTree = new MyNode[size];//build a tree of desired size
	}

	public void addNode(int index, int left, int right){
		myTree[index]= new MyNode(left,right); //add new node to the array
	}

	public String test(int label1, int label2){
		//to test the relationship between the two nodes
        if(leftSibling(label1,label2))
			return "LEFT SIBLING";
		else if(rightSibling(label1,label2))
			return "RIGHT SIBLING";
		else if(ancestor(label1,label2))
			return "ANCESTOR";
		else if(descendant(label1,label2))
			return "DESCENDANT";
		else
			return "NONE";
	}

	private boolean leftSibling(int label1, int label2){
        for(int i=0;i<size;i++){
			if(label1 == myTree[i].getLeft() && label2 == myTree[i].getRight())
				//if first label is a left child and the second label is the right child
				return true;
		}
		return false;
	}
	private boolean rightSibling(int label1,int label2){
        return leftSibling(label2,label1);
		//the reverse checking of leftSibling
	}
	private boolean ancestor(int label1, int label2){
       if(label1==-1 || (myTree[label1].getLeft()==-1 && myTree[label1].getRight()==-1))
		   return false;   //base case--when the label1 is null or a leaf node
	   
        for(int i=0;i<size;i++){
			if(label1==i &&(label2 == myTree[i].getLeft()||label2==myTree[i].getRight()))
				//if label2 is the child, and label1 is the ancestor
				return true;	
		}

		//else check whether label2 is a child of label1's children recursively
	   return ancestor(myTree[label1].getLeft(),label2) || ancestor(myTree[label1].getRight(),label2);
	}
	private boolean descendant(int label1, int label2){
		return ancestor(label2,label1);
		//reverse case of checking ancestor
	}

}
