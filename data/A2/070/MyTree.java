/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	int item;

    // fill in your accessor and mutator methods here
    // ...
	public MyNode(){
	  leftChildIndex = -1;
	  rightChildIndex = -1;
	  item = -1;
	}

	public MyNode(int item1){
	  item = item1;
	}

	public MyNode(int left,int right){
	  leftChildIndex = left;
	  rightChildIndex = right;
	}

	public MyNode(int item1,int left,int right){
	  item = item;
	  leftChildIndex = left;
	  rightChildIndex = right;
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
    int index = 0;

    // fill in your ADT methods here
    // ...
	public MyTree(){
	  myTree[0] = new MyNode(0,-1,-1);
	  size = 1;
	}
	
	public void addItem(int left,int right){
	  if(left != -1 && right !=-1){
		int item = myTree[index].item;
		myTree[index] = new MyNode(item,1,2);
		myTree[index+1] = new MyNode(left,-1,-1);
		myTree[index+2] = new MyNode(right,-1,-1);
		size = size + 2;
	  }
	  else if(left != -1 && right == -1){
		int item = myTree[index].item;
		myTree[index] = new MyNode(item,1,-1);
		myTree[index+1] = new MyNode(left,-1,-1);
		size++;
	  }
	  else if(left == -1 && right != -1){
		int item = myTree[index].item;
		myTree[index] = new MyNode(item,-1,1);
	    myTree[index+1] = new MyNode(right,-1,-1);
  	    size++;
	  }
	  index++;
	}

	public String relation(int left1,int right1){
	  int leftIndex = -1, rightIndex = -1;
	  for(int i = 0 ; i < size ; i++){
	    if( myTree[i].item == left1) 
		  leftIndex = i;
		if( myTree[i].item == right1 )
		  rightIndex = i;
	  }
	  
	  if(isRightSibling(leftIndex,rightIndex))
		return "RIGHT SIBLING";
	  if(isLeftSibling(leftIndex,rightIndex))
		return "LEFT SIBLING";
	  if(isAncestor(leftIndex,rightIndex))
		return "ANCESTOR";
	  if(isDescendant(leftIndex,rightIndex))
		return "DESCENDANT";
	  else
		return "NONE";
    }

	private boolean isRightSibling (int left ,int right){
	  if( (left - right) == 1 ){
	    for(int i=0;i<left;i++){
		  if(myTree[i].leftChildIndex == right && myTree[i].rightChildIndex == left )
			return true;
		}
		return false;
	  }
	  else
		return false;
	}

	private boolean isLeftSibling (int left ,int right){
	  return isRightSibling(right,left);	
	}

	private boolean isAncestor(int left,int right){
	  if( left == right )
		return true;
	  if(left < right){
		if(isAncestor(myTree[left].leftChildIndex,right) || 
		   isAncestor(myTree[left].rightChildIndex,right) )
		  return true;
		else
		  return false;
	  }
	  else
		return false;
	}

	private boolean isDescendant(int left,int right){
	  return isAncestor(right,left);
	}
}
