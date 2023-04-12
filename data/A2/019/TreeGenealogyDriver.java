import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
    static String s="";
    /** Read in the tree
     */
	static MyTree tree= new MyTree();

    public static void readTree () {
	// read in one integer
	int n = sc.nextInt();
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	   tree.insert(new MyNode(sc.nextInt(),sc.nextInt()));
	}
	}
       
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	 s=s+tree.findRelationship(sc.nextInt(),sc.nextInt())+"\n"; 			   
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries
    sc = new Scanner(s);
	while(sc.hasNext()){
		System.out.println(sc.nextLine());
	}
  	}
}
