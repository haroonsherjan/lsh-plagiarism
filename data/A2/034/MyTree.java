/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    public int item;
    int leftChildIndex;			 // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    public MyNode(int newItem){
    item = newItem;
    leftChildIndex = -1;
    rightChildIndex = -1;
    }//end constructor
    
    public MyNode(int newItem, int left, int right){
    item = newItem;
    leftChildIndex = left;
    rightChildIndex = right;
    }//end constructor
    
    public int getItem(){
    return item;
    }
    
    public void setItem(int newItem){
    item = newItem;
    }
    
    public int getLeft(){
    return leftChildIndex;
    }
    
    public void setLeft(int left){
    leftChildIndex= left;
    }
    
    public int getRight(){
    return rightChildIndex;
    }
    
    public void setRight(int right){
    rightChildIndex = right;
    }
    
}//end class MyNode



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
    String relation = ""; 
    
    // fill in your ADT methods here    	
    public MyTree(){
    }
    
    public MyTree(int n){
    myTree[0].setItem(0);
    size = n;
    }    
    
    //*****************************************************************
    public String checkRelation(int x, int y){
    if(y == myTree[(x-1)/2].getItem()){
    //if it is the parent, and not the root
    //(node-1)/2
    return relation = "ANCESTOR";
    }
    
    if(y == myTree[x*2 +1].getItem() || y == myTree[x*2 +2].getItem()){
    //if it is a child
    //to check left child (node*2 +1) or right child(node*2 +2)
    return relation =  "DESCENDENT";
    }
    
    if(y == myTree[(x-1)/2].getLeft()){
    //if it is the right sibling
    //check for the left child of the parent
    return relation =  "LEFT SIBLING";
    }
    
    if(y == myTree[(x-1)/2].getRight()){
    //if it is the left sibling
    //check for the right child of the parent
    return relation = "RIGHT SIBLING";
    }

    return "NONE";
    }// end checkRelation()
}
