/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int left;			  // left child index in array
    int right;		 // right child index in array
	
    // fill in your accessor and mutator methods here
    // ...
	
	//constructor
	protected MyNode (){
		isSafe = true;
		left = -1;
		right = -1;
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
    MyNode[] myTree;
    int size = 0;	// make sure to update this variable as needed

    // fill in your ADT methods here
    // ...

	//constructor
	public MyTree (int n){
		myTree = new MyNode[MAX_NODES];
		size = n;
		for (int i = 0; i < n; i++){
			myTree[i]=new MyNode ();
		}
	}
	
	// to specify safety of each city
	public void markSafety(int position, int x) {
		if (x==0){
			myTree[position].isSafe = false;	
		}
	} 

	// to set the left and right of each node
	public void markLeftRight (int position, int x, int y) {
		myTree[position].left = x;
		myTree[position].right = y;
	}

	// to check if this travel is safe
	public boolean checkSafety (int x, int y) {
	// check if x and y are safe
		if (myTree[x].isSafe == false || myTree[y].isSafe == false){
			return false;
		}

		else {
			MyNode[] arrX = new MyNode[size];
			MyNode[] arrY = new MyNode[size];

			// travel from x to 0, record in arrX, if y found on the way, stop travelling
			
			
			/*	int currX = x;
				int i = 0;
				boolean searchComplete = false;
				while (!searchComplete && currX < size){
					int j = 0;
					boolean found = false;
					while (!found){
						if (myTree[j].left==currX){
							arrX[i]=myTree[j];
							found=true;
							currX = i;
						}
						j++;
					}
					i++;		
				}//end while
			*/
			
	
			// travel from y to 0, record in arrY, if x found on the way, stop travelling
		
			// check arrX and arrY, if all safe, return safe
		}
		return false;
		}

	


}
