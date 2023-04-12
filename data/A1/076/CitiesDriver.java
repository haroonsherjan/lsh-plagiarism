import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
	int[] safe;
	int[] leftChild;
	int[] rightChild;
	int[] parent;
    
    /** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	safe = new int[n];
	// read in tree, safety line
	for (int i=0;i<n;i++) 
	   safe[i] = sc.nextInt();			   // modify this line
	leftChild = new int[n];
	rightChild = new int[n];
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    leftChild[i] = sc.nextInt();			   // modify this line
	    rightChild[i] = sc.nextInt();			   // modify this line
	}
	parent[0] = null;
	for (int i = 1; i< n; i++){
		for(int j = 0; j<n; j++)
			if(leftChild[j] == i || rightChild[j] == i)
				parent[i] = j;
	}
    }
    
    /** Read in query statements
     */
 
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	   int a = sc.nextInt();			   // modify this line
	   int b = sc.nextInt();               // modify this line
	   if(a == b && safe[a] == 1)
		   System.out.println("YES");
	   else{
		   int A = a;
		   int B = b;
		   boolean print = false;
		   do
		   {
			  a = parent[a];
			  b = parent[b];
			  if (safe[a] != 1 || safe[b] != 1){
				  System.out.println("NO");
				  print = true;
				  break;
			  }
			  if (b == A || a == B){
				  System.out.println("YES");
				  print = true;
				  break;
			  }


		   }while (parent[a] != null || parent[b] != null);
		   if (parent[a] == null && parent[b] == null && !print)
			   System.out.println("YES");
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
