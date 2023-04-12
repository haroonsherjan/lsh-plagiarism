
/** Class for a binary tree ADT
 */
public class MyTree {


    private final int MAX_NODES = 1000;
    private int size;
	private int[][] arrayTree = new int[size][3];
    

	public MyTree(int s){
		arrayTree = new int[s][3];
		arrayTree[0][0] = 0;
	    size = s;
	}
	
    public void setParent(int value, int xCord){
		arrayTree[xCord][0] = value;
	}

	//return the index of the number as a parent in the first column
	public int parentIndex(int i){
		for (int j = 0 ; j < size; j++){
			if(arrayTree[j][0] == i){
				return j;
			}
		}
		return -1;
	}

	public void setLeft(int xCord, int child){
		
		arrayTree[xCord][1] = child;

	}

	public void setRight(int xCord, int child){

		arrayTree[xCord][2] = child;

	}

	public int getRight(int xCord){

		return arrayTree[xCord][1];

	}

	public int getLeft(int xCord){

		return arrayTree[xCord][2];

	}

	public int getParent(int x){

		for ( int i = 0; i < size; i++ ){
			for ( int j = 1; j < 3; j++ ){
				if (arrayTree[i][j] == x)
				return arrayTree[i][0];
			}
		}
        
		return -1;
	
	}

	public int getXcord(int a){

		for ( int i = 0; i < size; i++ ){
			for ( int j = 1; j < 3; j++ ){
				if (arrayTree[i][j] == a)
					return i;
			}
		}

		return -1;

	}
	
	public int getYcord(int a){

		for ( int i = 0; i < size; i++){
			for ( int j = 1; j < 3; j++){
				if (arrayTree[i][j] == a)
					return j;
			}
		}

		return -1;

	}

	
	public boolean isLeftSlibing(int x, int y){
		return (getParent(x) == getParent(y) && getYcord(x) == 1);
	}

	public boolean isRightSlibing(int x, int y){
		return (getParent(x) == getParent(y) && getYcord(x) == 2);
	}

    public boolean isDescendant(int x , int y){
		if (y == 0) return true;
        if (x == 0) return false;
		
		int ancestor = getParent(x);

		while(ancestor != 0){
			
			if(ancestor == y){
				return true;
			}

			ancestor = getParent(ancestor);

		}

		return false;
	}
    

	public boolean isAncestor(int x, int y){
        if (x == 0) return true;
		if (y == 0) return false;
		
		int ancestor = getParent(y);

		while(ancestor != 0){

			if(ancestor == x){
				return true;
			}

			ancestor = getParent(ancestor);

		}

		return false;

	}

	public boolean isNone(int x, int y){
		 
		if(isLeftSlibing(x,y)&& isRightSlibing(x,y) && isDescendant(x,y) && isAncestor(x,y) == false)
			return true;

	    return false;

	}

}




