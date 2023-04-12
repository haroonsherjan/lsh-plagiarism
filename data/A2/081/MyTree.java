/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

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
	private int size;
	public MyNode[] myTree;
	public MyTree(){
      MyNode[] myTree = new MyNode[MAX_NODES];
	}
	public MyTree(int n){
       MyNode[] myTree = new MyNode[n];	// make sure to update this variable as needed
       size = n;
	   for(int i = 0;i<n;i++){
		   myTree[i] = new MyNode();
	   }
    }
    public void check(int a ,int b){
		if(checkParent(a,b)){
			System.out.println("DESCENDANT");
		}
        else 
		   if(checkSibling(a,b)){
			System.out.println("LEFT SIBLING");
		}
		else
		  if(checkSibling(b,a)){
			System.out.println("RIGHT SIBLING");
		  }
		else
			System.out.println("NONE");
    }
    //check sibling of 2 node
    public boolean checkSibling(int a,int b){
		 for(int i = 0;i<size;i++){
	     	  if(myTree[i].leftChildIndex == a && myTree[i].rightChildIndex == b)
		     	 return true;
	     }
		 return false;
    }
	// return the parent of a node
    public int find(int leaf){
	   int next = 0;
	   for(int i = 0;i <size;i++){
		   if(myTree[i].leftChildIndex == leaf || myTree[i].rightChildIndex == leaf)next = i;
	   return next;
	   }
	   return -1;
	}
	//check the ancestor of 2 nodes
	public boolean checkParent(int a,int b){
		int c = find(a);
		for(int i = 0;i<size;i++){
			if(c==b)return true;
            else return checkParent(c,b);
		}
		return false;
    }
}
