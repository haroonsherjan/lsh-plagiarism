/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int safety;				  // 0-unsafe, 1-safe
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
    int parent; //index of parent which is also the order of the parent node that is inserted into the array myTree
    public MyNode(int left, int right, int safetyIndex ){
	 leftChildIndex = left;
	 rightChildIndex = right;
     safety = safetyIndex;
	}//end constructor

	public void setLeft(int left){
		leftChildIndex = left;
	}
	public void setRight(int right){
		rightChildIndex = right;
	}
	public void setSafety (int safetyIndex){
		safety = safetyIndex;
	}
    
	public int getParent(){
		return parent;
	}//end getParent
	public int getLeft(){
		return leftChildIndex;
	}//end getLeft
    public int getRight(){
		return rightChildIndex;
	}//end getRight
	public int getSafetyIndex(){
		return safety;
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
    
//MyTree ADT methods

//  public static void travel(int startingPoint, int destination){
//  if(myTree[startingPoint].getLeft()== -1 && myTree[startingPoint].getRight == -1)     //it is a leaf
//  {
//   
//   if( myTree[startingPoint].getParent().getSafetyIndex() != 0){
//   
//   startingPoint == myTree[startingPoint.getParent(]); //now startingPoint is the index of the parent
//   if(myTree[startingPoint].getLeft != destination){
//    if(myTree[startingPoint].getRight!= destination{
//      myTree[startingPoint].getParent;
//      if(myTree[startingPoint].getParent == destination &&  myTree[startingPoint].getSafetyIndex() != 0){
//      System.out.println("YES");
        //Read in next line of query if there is any
//      }
//    }//end if
//   }//end if
//   
//   else{ //it is not a leaf, but any other node in the tree  
//   traverse(getRightIndex, getLeftIndex or getParent) through the tree to find a node with the index that is equal to the destination index.   
//   once there is a node with safety == 0 on the same path towards the destination , println "NO"  
//    }
}
