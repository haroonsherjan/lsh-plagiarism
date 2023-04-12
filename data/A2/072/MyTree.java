/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    private int leftChildIndex;			  // left child index in array
    private int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // ...
	MyNode(){
		leftChildIndex=-1;
		rightChildIndex=-1;
	}
	MyNode(int left,int right){
		leftChildIndex=left;
		rightChildIndex=right;
	}
	public int getLeft(){
		return leftChildIndex;
	}
	public int getRight(){
		return rightChildIndex;
	}
	public void setLeft(int i){
		leftChildIndex=i;
	}
	public void setRight(int i){
		rightChildIndex=i;
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
	private int size;
    MyNode[] myTree = new MyNode[MAX_NODES];
    
	MyTree(){
	   size = 0;	// make sure to update this variable as needed
	}
	

    // fill in your ADT methods here
    // ...
    public void setNode(int left,int right){
		myTree[size].setLeft(left);
		myTree[size].setRight(right);
		size++;
	}
    
	public void compareNode(int a,int b){
		boolean i=sibling(a,b);
		boolean j=ancestor(a,b);
		boolean k=descendant(a,b);
		if(!(i&&j&&k)){
			System.out.println("NONE");
	    }

	}
    
	private boolean sibling(int a,int b){
       boolean isSibling= false;
	   int parent=findParent(a);
	   for(int i=0;i<size;i++){
		   if (myTree[i].getLeft()==a||myTree[i].getRight()==a)
      	{   
	   if (myTree[parent].getLeft()==b){
		   System.out.println("LEFT SIBLING");
		   isSibling=true;
	   }
	   if (myTree[parent].getRight()==b){
		   System.out.println("RIGHT SIBLING");
		   isSibling=true;
	   }
	  
    }
	   
	   }
	    return isSibling;
	}

	public int findParent(int i){
		 int parent=0;
         for(int j=0;j<size;j++){
		    if (myTree[j].getLeft()==i||myTree[j].getRight()==i){
		     parent=j;
		    }   
	     }
		 return parent;
    }

	private boolean ancestor(int a,int b){
		int ancestor=0;
        boolean isAncestor=false;
		if (b!=0){
		do{
		   ancestor=findParent(b);
		   if(a==ancestor){
			   System.out.println("ANCESTOR");
			   isAncestor=true;
		   }
		}while(ancestor>0);
		}
		return isAncestor;
	}
		
    private boolean descendant(int a,int b){
		int ancestor=0;
		boolean isDescendant=false;
		if(a!=0){
			do{
				ancestor = findParent(a);
				if(b==ancestor){
					System.out.println("DESCENDANT");
					isDescendant=true;
				}
			}while(ancestor>0);
		}
		return isDescendant;
	}

}
