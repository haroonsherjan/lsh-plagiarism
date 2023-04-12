/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // ...
	public void setSafe(int x) {
		if( x== 1) {
			isSafe = true;
		}
		else 
			isSafe = false;
	}

	public void setLeft(int x) {
		x= leftChildIndex;
	}

	public void setRight(int x) {
		x = rightChildIndex;
	}

	public boolean getSafe() {
		return isSafe;
		}

		public int getLeft() {
			return leftChildIndex;
		}

		public int getRight() {
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


    //to check if node is on the left side of the tree or the right side so as to see if need to pass through the root to obtain path
    private boolean isLeft(int x) {
		for(int i = 0; i< size; i ++)
		{
			if(myTree[i].getLeft() == x) 
			{
				return true;
			}
		}
         return false;
	}

	private boolean isRight(int x) {
		for(int i = 0; i < size; i++)
		{
			if(myTree[i].getRight() == x)
			{
				return true;
			}
		}
		return false;
	 }

	 private int findRoot(int x) //to facilitate check
	 {
		 if(isLeft(x) == true)
		 {
			 for(int i = 0; i< size; i++)
			 {
				 if(myTree[i].getLeft() == x)
				 {
					 return i;
				 }
			 }
		 }

		 else
		 {
			 for(int i =0; i<size; i++)
			 {
				 if(myTree[i].getRight() == x)
				 {
					 return i;
				 }
			 }
		 }
		 return -1;
	 }
      
	 



	 public String check(int x, int y) // this method checks whether path is safe or not 
	 {
	//	int root = myTree.findRoot(x);
      //from root, start trancing the path down 
	  //split into 2 cases and do

	  //when it is check that both cities are on the left, or both are on the right,
	  //trance the path down, if there is an instance whereby boolean isSafe is not true, return "NO", else 
	  //return "YES"

	  //while if the two cities are not on the same side, trance both till they are at 
	  //the root that was found. if in between the trancing, theres an instance whereby boolean isSafe 
	  //is not true, return "NO" else return "YES"


      return "NO";
	 }



		


}
