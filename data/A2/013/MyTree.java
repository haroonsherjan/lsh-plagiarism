/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	int nodeIndex;               // the index of the node
    int nodeItem;           // the index of the node in array   
    int n;                  // use for checking the relationship
    //constructor
	 MyNode(int item,int leftIndex,int rightIndex ){
	
		nodeItem=item;
		leftChildIndex=leftIndex;
		rightChildIndex=rightIndex;
	}

    // fill in your accessor and mutator methods here
    // accessor for accessing the leftChildIndex
	int getLeftChildIndex(){
    return leftChildIndex;
	}
	int getRightChildIndex(){
	return rightChildIndex;
	}
    int getNodeItem(){
	return nodeItem;
	}
    

	// mutator for changing the rightChildIndex
	void setLeftChildIndex(int index){
		leftChildIndex=index;
	}
	void setRightChildIndex(int index){
	    rightChildIndex=index;
	}
	void setNodeItem(int item){
		nodeItem=item;
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

    // fill in your ADT methods here
    void buildTree(int item, int nodeIndex,int indexLeft
                                          ,int indexRight ){

	myTree[nodeIndex]=new MyNode(item,indexLeft,indexRight);
	size++;
	   }

     void checkRelationship(int item1, int item2 ){
    	 for(int i=0; i<size;i++){
        	if(myTree[i].getItem==item1){
             if((myTree[myTree[i].getLeftChildIndex]==item2)||
		     	(myTree[myTree[i].getRightChildIndex]==item2)){
			    n=0;  // when n=0; it is the ancestor
		     }
		    }
	         else if(myTree[i].getItem==item2){
		     	if ((myTree[myTree[i].getLeftChildIndex]==item1)||
			    	(myTree[myTree[i].getRightChildIndex]==item1)){
			  		n=1; // whenn=1; it it the descendant
				}
			}
       		 else if((i%2==1)&&(myTree[i]==item1)&&(myTree[i+1]==item2)){
				  n=2;   // when n=2, it is the left sibling
    	     }
			else if((i%2==1)&&(myTree[i]==item2)&&(myTree[i+1]==item1)){
			n=3; // when n=3, it it the right sibling
			}
			else{n=-1;};// no relationship
			printRelationship(n);
		  }
	 }
    void printRelationship(int n){
	   if (n==0){System.out.println("ANCESTOR");}
	   if (n==1){System.out.println("DESCENDANT");}
	   if (n==2){System.out.println("LEFT SIBLING");}
	   if (n==3){System.out.println("RIght SIBIIng");}
	   if (n==-1){System.out.println("NONE");}
     }
}
