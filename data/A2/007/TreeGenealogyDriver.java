import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;

    /** Read in the tree
     */
    public static void readTree (MyTree myTree) {
	// read in one integer
	int n = sc.nextInt();
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    int left = sc.nextInt();			   // modify this line
	    int right = sc.nextInt();			   // modify this line
		myTree.insert(i,left,right);
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries (MyTree myTree) {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
		try
		{
		int state = myTree.relationship(sc.nextInt(),sc.nextInt());
	    if (state==1)
			System.out.println("ANCESTOR");
		else if (state==2)
			System.out.println("DESCENDANT");
		else if (state==3)
			System.out.println("LEFT SIBLING");
		else if (state==4)
			System.out.println("RIGHT SIBLING");
		}
		catch (ArrayIndexOutOfBoundsException)
		{
			sc.nextInt();
			sc.nextInt();
			System.out.println("NONE");
		}
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	MyTree myTree = new MyTree();
	readTree(myTree);				   // read in the tree
	readQueries(myTree);				// read in the queries
    }
}
