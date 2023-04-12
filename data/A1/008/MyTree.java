/** Class for a tree node
 */
class MyNode {

    // Data members
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
    
   

	//constructor
    public MyNode(int l,int r,int s){
	  leftChildIndex = l;
	  rightChildIndex=r;
	  isSafe = (s == 1);
	}

	public int getLeft(){
   return leftChildIndex;
  }
   
   public int getRight(){
	 return rightChildIndex;
	}

	public boolean testSafe(){
	  return isSafe;
	}
  
   public  void setSafety(int s){
     isSafe = (s == 1);
   }

   public void setLeft(int l){
     leftChildIndex = l;
   }
   public void setRight(int r){
	   rightChildIndex =r;
   }

}//end of class MyNode

/** Class for a binary tree ADT
 */
public class MyTree {
  
    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;
	int root;

    public MyTree(){
	 root = 0;
	} //constructor
    
    public void addNode(int[] a,int s){
	 myTree[size] = new MyNode(a[0],a[1],s);
	 size++;
	}  //add new node
   
   public int findParent(int k){
    for(int i = 0; i<size; i++ ){
	 if(myTree[i].getLeft()==k||myTree[i].getRight()==k)
		 return i;
	}
	 return -1;	 
	
   } //find the parent of the kth node

   public boolean safePath(int a,int b){

	 int  parent1;
	 int  parent2;
    
    parent1 = a;
    parent2 = b;

   while(parent1!=-1) { //not reach the root
	   if(parent1 == b && myTree[parent1].testSafe()==true){ //reach b and
		                                                 //b is safe
		   return true;
		   }

	   if(myTree[parent1].testSafe() == false )//reach an unsafe city
		   return false;
      
	  parent1 = findParent(parent1); 
     }

   while(parent2!=-1){
	   if(parent2 == a && myTree[parent2].testSafe()==true){
            return true;
		 }
			          
	   if(myTree[parent2].testSafe() == false )
			  return false;
	   parent2 = findParent(parent2);

   }
  
   return myTree[root].testSafe();  //all reach the root

   }
  }
    
