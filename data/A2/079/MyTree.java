/** Class for a binary tree ADT
 */
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

	private int index1, index2;

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

    private final int MAX_NODES = 1000;
    int [] myTree = new int[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed

    // fill in your ADT methods here
    public void insert(int x, int y){
		myTree[size] = x;
		size++;
		myTree[size] = y;
		size++;
	}
	
	public String findRelation(int x, int y){
		for (int i=0; i<= myTree.length; i++){
			if (myTree[i]==x){
				index1 = i;
			}
			if (myTree[i]==y){
				index2 = i;
			}
		}
		int diff = index2-index1;
		if (diff==1){
			return "LEFT SIBLING";
		}
		else if (diff>=2){
			return "DESCENDANT";
		}
		else if (diff<=-2){
			return "ANCESTOR";
		}
		else if(diff==-1){
			return "RIGHT SIBLING";
		}
		else 
			return "NONE";
	}
}
