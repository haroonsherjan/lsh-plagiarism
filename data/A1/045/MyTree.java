/** Class for a tree node
 */
class Node {

    // you can add other variables if you'd like
    boolean isSafe;	// is the city safe?
    int left;  // left child index in array
    int right; // right child index in array
	int parent;	// parent index in array
    int key; // key index of node

	// Constructor
	Node(int par,int safeness, int keyvalue){
		parent = par;
		left = 2*par + 1;
		right = 2*par + 2;
		if (safeness == 1)
			isSafe = true;
		else
			isSafe = false;
		key = keyvalue;
	}

	public void setSafe(boolean safe){
		isSafe = safe;
	}
	public void setLeft(int i){
		left = i;
	}
	public void setRight(int i){
		right = i;
	}
	public void setParent(int i){
		parent = i;
	}

	public int getKey(){
		return key;
	}
	public int getParent(){
		return parent;
	}
	public boolean isSafe(){
		return isSafe;
	}
}

/** Class for a binary tree ADT
 */
public class MyTree {
    private final int MAX_NODES = 1000;
    Node[] myTree = new Node[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed

	// insert node with its parent, safeness and i-th key value
	public void insert(int parent, int safeness, int key){
		// insert node at the last empty location in the array
		myTree[size] = new Node(parent, safeness, key);
		size++; // increase size of array
	}
	
	// test route safety from start to end destination
	public boolean isSafeRoute(int start, int end){
		int startIndex = 0;
		int endIndex = 0;
		
		// Find the index location of start and end
		int i = 0;
		while (startIndex == 0 || endIndex == 0){
			if (myTree[i].getKey() == start){
				startIndex = i;
			}
			if (myTree[i].getKey() == end){
				endIndex = i;
			}
			i++;
		}
		
		// try traverse from endIndex to root
		// see if it meets startIndex
		do {
			// if this current city is not safe
			// route is definitely not safe
			if(!myTree[endIndex].isSafe()){
				return false;
			}
			
			// go up 
			endIndex = myTree[endIndex].getParent();
			
			if (endIndex == startIndex)
				break;
		} while (endIndex != 0);

		// now try traverse from start to root
		do {
			if(!myTree[startIndex].isSafe()){
				return false;
			}

			startIndex = myTree[startIndex].getParent();

			if (startIndex == endIndex)
				break;
		} while (startIndex != 0);

		// since now both indexes meet
		// and no return value given
		// they must be safe
		return true;
	}
}
