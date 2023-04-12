/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    MyNode(int l,int r){
	 setLeft(l);
	 setRight(r);
	 }
	
	// fill in your accessor and mutator methods here
    
	public int getLeft(){return leftChildIndex;}
	public int getRight(){return rightChildIndex;}
	public void setLeft(int l){leftChildIndex=l;}
	public void setRight(int r){rightChildIndex=r;}
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
    public void insert(MyNode n){
		myTree[size]=n;
		size++;
		}
    public String findRelationship(int i, int j){
		if(myTree[i].getLeft()==j||myTree[i].getRight()==j)return "ANCESTOR";
	    else if(myTree[j].getLeft()==i||myTree[j].getRight()==i)return "DESCENDANT";
		int aoi=findAncestor(i);
        int aoj=findAncestor(j);
		if(aoi==aoj&&myTree[aoi].getLeft()==i) return "LEFT SIBLING";
		else if(aoi==aoj&&myTree[aoi].getRight()==i) return "RIGHT SIBLING";
		else return "NONE";
		}
    public int findAncestor(int i){
		for(int j=0;j<size;j++)
            if(myTree[j].getLeft()==i||myTree[j].getRight()==i)
			   return j;
		return -1;
		}
	 
}
