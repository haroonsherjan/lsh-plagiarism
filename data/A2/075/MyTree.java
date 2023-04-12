/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	int item;  //I know its extra to put this since the item = i, but I like it. HAHA
	
	
	public MyNode(int newItem){
		item = newItem;
		leftChildIndex = -1;
		rightChildIndex = -1;
	} // Constructor with only item
	
	public MyNode(int newItem, int left, int right){
		item = newItem;
		leftChildIndex = left;
		rightChildIndex = right;
	} // Constructor
	
	
	public int getItem(){
		return item;
	} // get back the item!
	
	public int getLeftChild(){
		return leftChildIndex;
	} //get wad's the left child
	
	public int getRightChild(){
		return rightChildIndex;
	} //get wad's the right child
	
	public void setItem(int newItem){
		item = newItem; 
	} //setting the content of Item
	
	public void setLeft(int left){
		leftChildIndex = left;
	}
	
	public void setRight(int right){
		rightChildIndex = right;
	}
	public int parentSearch(int target){
		int parent = 0;
		//implementation of method to find the parents of target
		return parent;
	}
	                                

	
	
    // fill in your accessor and mutator methods here
    // ...
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
    
    public MyTree(){
    	
    	for(int i=0; i<1000; i++){
	    	myTree[i]= new MyNode(i);	    	
    	} //initialize each element
    }
    
    public String getRelation(int first,int second){
    	
    	if(myTree[first].getLeftChild() == second || myTree[first].getRightChild() == second){
    		return "ANCESTOR";
    	 }  //If the 1st element has right or left child that is same as second, 1st is the ancestor of 2nd 
    	
    	if(myTree[second].getLeftChild() == first || myTree[second].getRightChild() == first){
    		return "DESCENDANT" ;
    	}
    	
    	if(myTree[myTree[first].parentSearch(first)].getRightChild() == second)
    		return "LEFT SIBLING";
    		
    	if(myTree[myTree[second].parentSearch(second)].getLeftChild() == first)
    		return "RIGHT SIBLING";
    		
    	else
    	return "NONE" ;
    }
    
    
}
