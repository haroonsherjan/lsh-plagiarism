import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
    static int[][] tree;
    static int[][] queries;

    /** Read in the tree
     */
    public static void readTree () {
	// read in one integer
	int n = sc.nextInt();
        tree = new int[n][2];

	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    tree[i][0] = sc.nextInt();			   // modify this line
	    tree[i][1] = sc.nextInt();			   // modify this line
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
        queries = new int[m][2];
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	   queries[i][0] = sc.nextInt();			   // modify this line
	   queries[i][1] = sc.nextInt();			   // modify this line
	}
    }
    
    public static void main(String[] args) {
        final int ANCESTOR = 0;
        final int DESCENDANT = 1;
        final int LEFT_SIBLING = 2;
        final int RIGHT_SIBLING = 3;
        final int NONE = 4;
        int relationship;
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
        for (int i=0; i<queries.size; i++){
            relationship = findRelationship(queries[i][0], queries[i][1]);
            switch(relationship){
                case 0: 
                       System.out.println("ANCESTOR");
                       break;
                case 1:
                       System.out.println("DESCENDANT");
                       break;
                case 2:
                       System.out.println("LEFT SIBLING");
                       break;
                case 3:
                       System.out.println("RIGHT SIBLING");
                       break;
                case 4:
                       System.out.println("NONE");
                       break;
            }             
        }
    }
    
    public static int findRelationship(int a, int b){
        int[] A = findPath(a);
        int[] B = findPath(b);
        int sizeA = A.size;
        int sizeB = B.size;
        int size = sizeA < sizeB ? sizeA : sizeB;

        for (int i=0; i<size; i++){
            if (A[sizeA-1-i] != B[sizeB-1-i]){
                if (A[sizeA-1-i] == a){              //a,b are siblings 
                    if (tree[A[sizeA-i]][0] == a)    //a is the leftchild
                        return 2;
                    else                             //a is the rightchild
                        return 3;
                } 
                else                                 //no relationship between a and b 
                    return 4;
            }
        }    

        if (sizeA > sizeB) 
            return 1;                                //a is the descendant of b
        else 
            return 0;                                //a is the ancestor of b 
    }

    public static int[] findPath(int node){
      int[] path = new int[(int)Math.log(tree.size)];
      int size = 0;
      
      path[size++] = node;
      while (node != 0){
          boolean find = false;
          for (int i=0; !find && i<tree.size; i++){
              if (tree[i][0] == node || tree[i][1] == node){
                  path[size++] = node;
                  node = i;
                  find = true;
              }
          }
      }
      return path; 
    }
}
