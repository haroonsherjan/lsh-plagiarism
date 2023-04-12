/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int item;
	boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
     MyNode left;
	 MyNode right;
    // fill in your accessor and mutator methods here
    // ...
    MyNode(int root,int [] p, int[][] b)
    {  item=root;
		if(p[root]==0)
	    isSafe=false;
	   else
	    isSafe=true;	   
        leftChildIndex=b[root][0];
		rightChildIndex=b[root][1];
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
	MyNode root;
    // fill in your ADT methods here
    // ...
	MyTree(int N, int[] p, int[][]b)
	{
	for(int i=0; i<N;i++)

    myTree[i]=new MyNode(i,p,b);
    TreeBuild(myTree[0]);
	}
  void    TreeBuild(MyNode root){
	  if(root!=null)
     {		  
	  if(root.leftChildIndex!=-1)
	   root.left=myTree[root.leftChildIndex];
       else
	   root.left=null;	   
	   if(root.rightChildIndex!=-1)
	   root.right=myTree[root.rightChildIndex];
	   else
	   root.right=null;	   
	   TreeBuild(root.left);
	   TreeBuild(root.right);
	  }	
	  	
		}
}
