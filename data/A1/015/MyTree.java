/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    private int isSafe;				  // is the city safe?
    private int leftChildIndex;			  // left child index in array
    private int rightChildIndex;		 // right child index in array
    
    
    
	// creates the array for all the cities and stores the data such as leftChildIndex & rightChildIndex
    public MyNode(int left, int right,int safety){
		   
		   leftChildIndex=left;
		   rightChildIndex=right;
           isSafe= safety;

	} // end constructor
    
   

   // returns the right hand side of the respective city node
   public int getRightCity(int num){

	   return rightChildIndex;
   } 


   //returns the left hand side of the respective city node
   public int getLeftCity(int num){

	   return leftChildIndex;
   }

   public int isSafe(){
 
     return  isSafe;
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
    
	public MyTree(){
    
         myTree[0]= new MyNode(0, 0,0);
    
    }

	public void setCities(int cityNum, int left, int right, int safety){

		myTree[cityNum]=new MyNode(left,right,safety);
	}
    
   public boolean isSafety(int num){

   if(myTree[num].isSafe()== 0){
	   return true;
   }
   return false;
  }
}
