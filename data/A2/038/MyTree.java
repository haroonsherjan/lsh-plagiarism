/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
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
    int [] myTree = new int[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed
    
    // fill in your ADT methods here
    public MyTree() {
	   myTree[0] = 0;
	   size = 1;
    }
	
   public int get(int index) {
	   return myTree[index];
   }
   
   public int[] getMyTree() {
       return myTree;
   }

   public void setSize(int size) {
       this.size = size;
   }

   public void set(int index, int item) {
	  myTree[index] = item;
   }

   public String checkRelationship(int left, int right) {
	  if ((left+1 == right)&&(this.sameLevel(left, right))) {
         return "LEFT SIBLING";
	  }
	  else if ((left-1 == right)&&(this.sameLevel(left,right))) {
         return "RIGHT SIBLING";
	  }
      else if ((left<right)&&(!this.sameLevel(left,right))) {
		  return "ANCESTOR";
      }
      else if ((left>right)&&(!this.sameLevel(left,right))) {
          return "DESCENDANT";
	  }
	  else {
		  return "NONE";
      }

   }
   

   public boolean sameLevel(int left, int right) {
	   double range = 2;
	   if (left == 1 && right == 2) {
		   return true;
	   }
	   for (int i = 1; range<size; i++) {
		   range *= 2;
           if ((left> range/2 && right<=range) || (left<= range && right>range/2)) {
			  return true;
		   }
	   }
       return false;
  }
}
