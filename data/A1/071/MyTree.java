/** Class for a tree node
 */
class myNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean safe;				  // is the city safe?
    myNode leftChild;			  // left child index in array
    myNode rightChild;		 // right child index in array
	
	public myNode(boolean safe){
		this.safe = safe;
		this.leftChild = null;
		this.rightChild = null;
	}

	public boolean isSafe(){
		return this.safe;
	}
	public void setSafe(boolean safe){
		this.safe = safe;
	}
	public myNode getLeft(){
		return this.leftChild;
	}
	public void setLeft(myNode node){
		this.leftChild = node;
	}
	public myNode getRight(){
		return this.rightChild;
	}
	public void setRight(myNode node){
		this.rightChild = node;
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
	boolean[] path;
    private final int MAX_NODES = 1000;
    myNode[] myTree = new myNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed

    // fill in your ADT methods here
    // ...
	public MyTree(){
	}

	public void insert(int n, boolean safe){
		myTree[n] = new myNode(safe);
	}

	public myNode get(int index){
		return myTree[index];
	}

	public boolean isSafe(int c1, int c2){ //find out whethere the path is safe
		path = new boolean[MAX_NODES];
		size = 0;
		if(isThere(get(c1),get(c2))){
			findPath(get(c1),get(c2));
		}
		else if(isThere(get(c2),get(c1))){
			findPath(get(c2),get(c1));
		}
		else{
			findPath(get(0),get(c1));
			findPath(get(0),get(c2));
		}
		for(int i=0;i<size;i++){
			if(!path[i]) return false;
		}
		return true;
	}
	
	public boolean isThere(myNode c1, myNode c2){ // check if c2 is a descendent of c1
		if(c1 == c2) return true;
		if(c1 == null) return false;
		return isThere(c1.getLeft(), c2) || isThere(c1.getRight(), c2);
	}

	public boolean findPath(myNode c1, myNode c2){
		//find a path from c1 to c2, output path[] which is a list of 
		//passing-by cities with 0 or 1 to represent whether it's safe
		if(c1 == c2) return true;
		if(c1 == null) return false;

		if(findPath(c1.getLeft(),c2) || findPath(c1.getRight(),c2)){
			path[size] = c1.isSafe();
			size++;
			return true;
		}
		else{
			return false;
		}
	}
}	
