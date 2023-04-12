import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
 import java.util.*;
public class TreeGenealogyDriver {
    static Scanner sc;
	private static int [][] arr;
	private static int [][] arrQueries;
    private static int verticalSize;
	private static int verticalSizeQueries;
	
	/** Read in the tree
     */
    public static void readTree () {
		// read in one integer
		int n = sc.nextInt();
		verticalSize = n;
	
		// initialize -1 for all position
		for(int c=0; c<n; c++){
			for(int d=0; d<2; d++){
				arr[c][d] = -1;
			}	
		}

		arr = new int [n][2];
		// loop to read pairs of children and insert into array
		for(int a=0; a<n; a++){
			for (int i=0;i<2;i++) {
	    		arr[a][i]= sc.nextInt();	// insert into 2D array
			}
		}
    }

	public static void createTree(int [][]arr){
		myTree trees = new myTree();
		// inserting into tree
		for(int y=0; y<verticalSize; y++){
			for(int z=0; z<2; z++){
				trees.insert(arr[y][z]);	
			}
		}
		
	
	}// end createTree

	public static void processQueries(){
		int c= verticalSizeQueries;
		int a=0;
		int b=0;

		while(c!=0){
			
			if(arrQueries[a][b] == arr[a][b])
				System.out.println("LEFT SIBLING");
			c--;
		}
	
	}

	public static int getSize(){
		return verticalSize;
	}
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
		int m = sc.nextInt();
		verticalSizeQueries = m;
		arrQueries = new int [m][2];
	// loop to read pairs of children for query and insert into array
		for(int x=0; x<m; x++){
			for (int i=0;i<2;i++) {
	    		arrQueries[x][i] = sc.nextInt(); // insert queries into 2D array
			}
		}
    }
    
    public static void main(String[] args) {
		sc = new Scanner(System.in);
		readTree();				   // read in the tree
		readQueries();				// read in the queries

		// process TreeNode
		processQueries();
    }
}
