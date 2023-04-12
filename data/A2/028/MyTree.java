/** Class for a binary tree ADT
 */
public class MyTree {
    private final int MAX_NODES = 1000;
    int[] myTree = new int[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed

	public void add(int N) {
		myTree[size]= N;
		size++;
	}

	public boolean isLeft(int indexA, int indexB) {
		if(indexA/2 == indexB/2 - 1)
			return true;
		else
			return false;
	}

	public boolean isRight(int indexA, int indexB){
		if(indexA/2 - 1 == indexB/2)
			return true;
		else
			return false;
	}

	public boolean isAncestor(int indexA, int indexB){
		if(indexA*2+1 < indexB)
			return true;
		else
			return false;
	}

	public boolean isDescendant(int indexA, int indexB){
		if(indexB*2+1> indexA)
			return true;
		else
			return false;
	}
}
