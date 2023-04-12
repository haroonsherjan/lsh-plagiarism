/** Class for a tree node
 
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
    
	public MyNode(int x, int y){
    leftChildIndex =x;
	rightChildIndex =y; 
	}
    
}
*/

/** Class for a binary tree ADT
 */
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation
 
	private int [] treeArray;
    private int size = 0;


	public MyTree(int x){
      treeArray = new int[x];
	}

    //accessor
    public void setTreeArray(int[] x){
      treeArray = x;
	}
	
	public int getLength(){
    return treeArray.length;
	}
    //check relationship then return  
    public String checkRelation(int x, int y){
		String result ="";
	if(checkLeftSibling(x,y)==true){
		 result = "LEFT SIBLING";
	 }
     else if(checkRightSibling(x,y)==true){
		 result = "RIGHT SIBLING";
	 }
	 else if(checkDescendant(x,y)==true){
		 result = "DESCENDANT";
	 }
	 else if(checkAncestor(x,y)==true){
		 result = "ANCESTOR";
	 }
	 else{
         result = "NONE";
	 }
	 return result;
	}

	private boolean checkLeftSibling(int a, int b){
		boolean left = false;
     for(int i = 1; i<getLength()-1; i++){
        //if the position of a and the next position of a is equal to b 
		//then a is left sibling of b
		if((treeArray[i] == a)&&(treeArray[i+1] == b)){
           left = true;
		   break;
		}
	 }
	 return left;
	}

    private boolean checkRightSibling(int a, int b){
      boolean right = false;
	  for(int j = 1; j<getLength()-1; j++){
         //if the position of a and the previous position of a is equal to b
		 // then a is right sibling of b
		 if(treeArray[j] == a && treeArray[j-1] ==b){
			 right = true;
			 break;
		 }
	  }
	  return right;
	}

	private boolean checkDescendant(int a, int b){
	boolean isDescendant =false;
	int loc = -1;
     //the ancestors can be their parent
	 //find the position of a, and check for b
	 for(int i = 0;i<getLength(); i++){
		 if(treeArray[i]== a){
			 loc = i;
			 break;
		 }
	 }
      //location parent of a is equal to curr postion -1 divide by 2
	  int locParent = (loc-1)/2;
	  while(locParent >= 0){
	  if(treeArray[locParent] == b){
        isDescendant = true;
	  }
	  else if(treeArray[locParent] != b){
        locParent = (locParent-1)/2;
	  }
	  }
	return isDescendant;	 
	}

	private boolean checkAncestor(int a, int b){
    boolean isAncestor = false;
	// b is descendent of a then a is ancestor of b
    if(checkDescendant(b, a)== true){
     isAncestor = true;
	}
	return isAncestor; 
	}
}
