import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
	static MyTree tree;
	ArrayList<String> output = new ArrayList<String>(); //to store output


    /** Read in the tree
     */
    public static void readTree () {
	// read in one integer
	int n = sc.nextInt();
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
//	 tree.insert(sc.nextInt());			   // modify this line
//	  	System.out.println("input1 " + sc.nextInt());
//	 tree.insert(sc.nextInt());			   // modify this line
//	System.out.println("input2 " + sc.nextInt());
		int k = sc.nextInt();
		int l = sc.nextInt();
		tree.insert(k, l);
		}	
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	   int m = sc.nextInt();			   // modify this line
	   int n = sc.nextInt();			   // modify this line
	  output.add(tree.checkRelation(m, n));
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	tree = new MyTree();

	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below


	for(String s: output)
	{
		System.out.println(s);
	}
    }
}
