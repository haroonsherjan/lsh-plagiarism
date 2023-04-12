import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
	static MyTree citytree;
	static Query[] q;
    
    /** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	citytree = new MyTree(n);
	// read in tree, safety line
	for (int i=0;i<n;i++) {
	    int safe=sc.nextInt();			   // modify this line
	    citytree.setSafe(i,safe);
	}
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    int left=sc.nextInt();			   // modify this line
	    int right=sc.nextInt();
		citytree.setChild(i,left,right);// modify this line
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	q = new Query[m];
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    int a=sc.nextInt();			   // modify this line
	    int b=sc.nextInt();			   // modify this line
		q[i]=new Query(a,b);
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	for(int i=0;i<10;i++){
		if(safetravel(q[i].start,q[i].end))
			System.out.println("YES");
			else System.out.println("No");

    }
	}

	public static boolean safetravel(int i, int j){
		return citytree.safeToTwo(0,i,j);
	}
}

	class Query{
		int start;
		int end;
		public Query(int a,int b){
			start=a;
			end=b;
		}

}
