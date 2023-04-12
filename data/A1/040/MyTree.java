/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int isSafe;				  // is the city safe?
    int left;			  // left child index in array
    int right;		 // right child index in array
    int parent;
    
	//constructors
	public MyNode(){
     left=-1;
	 right=-1;
	 parent=-1;
	 isSafe=0;
	}

	//methods
	public int getLeft(){
      return left;
	}

	public int getRight(){
      return right;
	}

	public int getParent(){
      return parent;
	}
	
	public int getIsSafe(){
      return isSafe;
	}

	public void setLeft(int l){
      left=l;
	}

	public void setRight(int r){
      right=r;
	}

	public void setParent(int p){
      parent=p;
	}

	public void setIsSafe(int s){
      isSafe= s;
	}
}
   //Finding the number of awards

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
    public MyTree(){
	}
	public MyTree(int n){
      myTree = new MyNode[n];
	  size=n;
	}
}
