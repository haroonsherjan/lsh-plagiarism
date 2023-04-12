
/** Class for a binary tree ADT
 */
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

    private final int MAX_NODES = 1000;
    int[] myTree = new int[MAX_NODES];
   
     
    // fill in your ADT methods here
    // ...
	public MyTree(){
		myTree[0] = 0;
	}
	void add(int i , int j){	
		myTree[myTree.length] = i;
		myTree[myTree.length] = j;
	}

	void Relationship(int i , int j){
		int IndexOfI = -1;
		int IndexOfJ = -1;
		for (int k = 0; k < myTree.length; k ++){
			if (myTree[k] == i){
				IndexOfI = k;
			}
			if (myTree[k] == j){
				IndexOfJ = k;
			}
		}

		if ((IndexOfI - 1)/2 == (IndexOfJ - 1) / 2){
			if (IndexOfI < IndexOfJ){
				System.out.println("LEFT SIBLING");
			}
			else {
				System.out.println("RIGHT SIBLING");
			}
		}

		else if (IndexOfI < IndexOfJ){
			int temp = IndexOfJ;
     		while(IndexOfI < (temp - 1) / 2){
	     		temp = (temp - 1) /2;
		    }
		    if (IndexOfI == (temp - 1)/2){
			    System.out.println("ANCESTOR");
		    }
		}

		else if (IndexOfI > IndexOfJ){
			int temp = IndexOfI;
			while(IndexOfJ < (temp - 1)/2){
				temp = (temp - 1)/2;
			}
			if (IndexOfJ == (temp - 1)/2){
				System.out.println("DESCENDANT");
			}
		}

		else {
			System.out.println("NONE");
		}
	}
}
	
				
		
