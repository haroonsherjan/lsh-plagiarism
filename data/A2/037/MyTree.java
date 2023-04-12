/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree
    int item;

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // ...
    public MyNode(int item,int left,int right) {
    	this.item = item;
    	this.left = left;
    	this.right = right;
    }
    
    public int getleft() {
    	return left;
    }
    
    public itn getRight() {
    	return right;
    }
    
    public int getItem() {
    	return item;
    }
    
    public void setItem(int item) {
    	this.item = item;
    }
    
    public void setLeft(int left) {
    	this.left = left;
    }
    
    public void setRight(int right) {
    	this.right = right;
    }
    
    public void set(int item,int left, int right) {
    	this.item = item;
    	this.left = left;
    	this.right = right;
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
    int root = 0; //root is always set to 0

    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed
	MyNode parent = new  MyNode(0,-1,-1);
    // fill in your ADT methods here
    // ...
    myTree[0] = new MyNode(0,-1,-1);//index 0 is the root
    size++;
    
    public void addLeft(int item) {
    	myTree[size].setItem(item);
    	size++;
    }
    
    public void addRight(int item) {
    	myTree[size].setItem(item);
    	size++;
    }
    
    public boolean  checkAncestor(int item1,int item2) {//check if item1 are ancestor of item2
    	int curr;
    	for(int i=0;i<myTree.size();i++) {
    		if(myTree[i] == item1) 
    			curr = i;
    	}
    	if(myTree[curr].getLeft() == item2 || myTree[curr].getRight() == item2)
    		return true;
    	else if(checkAncestor(item1,myTree[myTree.getLeft()]) == false)
    		checkAncestor(item1,myTree[myTree.getRight()]);
    	return false;
    }
    
    public boolean checkDescendant(int item1, int item2) {//check if item2 are ancestor of item1
    	checkAncestor(item2,item1);
    }
    public void relation(int item1,int item2) {
    	for(int i=0;i<myTree.size();i++) {
    		if(myTree[i].getLeft()= item1 && myTree[i].getRight() = item2) 
    			System.out.println("LEFT SINLING");
    		else if (myTree[i].getRight() = item1 && myTree[i].getLeft() = item2)
    			System.out.println("RIGHT SIBLING");
    		else if (checkAncestor(item1,item2))
    			System.out.println("ANCESTOR");
    		else if (checkDescendant(item1,item2))
    			System.out.println("DESCENDANT");
    		else
    			System.out.println("NONE");
    	}
    }
    			
}	
