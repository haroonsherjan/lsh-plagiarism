/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		  // right child index in array

	//Constructor
	MyNode(int index1,int index2){
	  leftChildIndex = index1;
	  rightChildIndex = index2;
	}

    // fill in your accessor and mutator methods here
    int leftChildIndex(){
	  return leftChildIndex;
	}

	int rightChildIndex(){
	  return rightChildIndex;
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

    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed

    //Constructor
    MyTree(MyNode[] inputTree,int size){
	  myTree = inputTree;
	  this.size = size;
	}
    // fill in your ADT methods here
	// This methos returns the relation between the input nodes
    String getRelation(int a,int b){
	  MyNode nodeA = myTree[a];
	  MyNode nodeB = myTree[b];
	  if(isAncestor(a,b))
		  return "ANCESTOR";
	  else if(isAncestor(b,a))
		  return "DESCENDANT";
	  else if(isLeftSibling(a,b))
		  return "LEFT SIBLING";
	  else if(isLeftSibling(b,a))
		  return "RIGHT SIBLING";
	  else
		  return "NONE";
	}

    // This method checks that whether nodeA is an ancestor of nodeB
	// which also means that nodeB is a descent of nodeA
	boolean isAncestor(int a,int b){
	 if(a<0)
		 return false;
	 MyNode nodeA = myTree[a];
	 MyNode nodeB = myTree[b];
	 if(nodeA.leftChildIndex == b||nodeA.rightChildIndex == b)
		 return true;
	 else 
		 return isAncestor(nodeA.leftChildIndex,b)||isAncestor(nodeA.rightChildIndex,b);
	}

    // This method checks that whether nodeA is the left sibling of nodeB
	// which also means that nodeB is the right sibling of nodeA
	boolean isLeftSibling(int a,int b){
	 for(int i=0;i<size;i++){
	   //Two nodes are siblings means that their index are respectively the leftChildIndex and rightChildIndex of a certain node.	 
	   if(myTree[i].leftChildIndex==a&&myTree[i].rightChildIndex==b)
		   return true;
	 }
	 return false;
	}
}
