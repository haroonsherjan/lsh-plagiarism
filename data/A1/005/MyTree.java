/** Class for a tree node
 */
class MyNode {
    // data field
    protected boolean isSafe;				  // input 1 means safe, 0 means not safe
    protected int leftChildIndex;			  // left child index in array
    protected int rightChildIndex;			  // right child index in array
	protected int parentIndex;

    // accessors
	// whether the city is safe
	public boolean isSafe(){
		return isSafe;
	}

	// to get the index of its left child
	public int getLeft(){
		return leftChildIndex;
	}

	// to get the index of its right child
	public int getRight(){
		return rightChildIndex;
	}

	// to get the index of its parent
	public int getParent(){
		return parentIndex;
	}

	// mutators
	// to set whether the city is safe
	public void setSafe(int i){
		if( i == 1 ){
			isSafe = true;
		}else if( i == 0 ){
			isSafe = false;
		}else{
			return;
		}
	}

	// to set its left child
	public void setLeft(int l){
		leftChildIndex = l;
	}

	// to set its right chid
	public void setRight(int r){
		rightChildIndex = r;
	}

	// to set its parent
	public void setParent(int p){
		parentIndex = p;
	}
}

/** Class for a binary tree ADT
 */
public class MyTree {
	// data field
    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
	int root;
    int size = 0;

    // constructor
	public MyTree(){
		root = 0;
	}
	
	// to set whether city of index i is safe
	public void setSafe(int i, int s){
		myTree[i].setSafe(s);
	}

	// to set left child of city of index i
	public void setLeft(int i, int l){
		myTree[i].setLeft(l);
		myTree[l].setParent(i);
	}

	// to set right child of city of index i
	public void setRight(int i, int r){
		myTree[i].setRight(r);
		myTree[r].setParent(i);
	}
	
	// method to determine whther it is safe to travel from start to end
	public boolean safeTravel(int start, int end){
		String s = path(start);
		String e = path(end);
		boolean trav = false;
		for(int i = 0; i < s.length(); i++){
			if(e.contains(s.charAt(i)+"")){
				trav = true;
			}
		}
		return trav;
	}

	// the path the visitor can go until reach the root or its parent city in unsafe
	public String path(int i){
		String s = new String("");
		while((i != 0)&&(myTree[i].isSafe())){
			s = i + s;
			i = myTree[i].getParent();
		}
		return s;
	}

	// output whethe it is safe to travel from start to end
	public void travel(int start, int end){
		if(safeTravel(start, end)){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
}
