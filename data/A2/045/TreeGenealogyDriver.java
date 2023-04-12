import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
	static MyTree aTree;

    /** Read in the tree
     */
    public static void readTree () {
		// read in one integer
		int n = sc.nextInt();

		aTree = new MyTree();
		// loop to read pairs of children
		for (int i=0;i<n;i++) {
	    	int leftChild = sc.nextInt();			   // modify this line
	    	int rightChild = sc.nextInt();			   // modify this line
		
			aTree.insert(i, leftChild, rightChild);
	
		}//end for

	//iaTree.printTree();
    }//end readTree
    
    /** Read in query statements
     */
    public static void readQueries () {
		// read in one integer
		int m = sc.nextInt();
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
	    	int node1 = sc.nextInt();			   // modify this line
	    	int node2 = sc.nextInt();			   // modify this line
	
			//print ancestor is node2 is a child of node1
			if(aTree.getNode(node1).isMyChild(aTree.getNode(node2)))		
				System.out.println("ANCESTOR");
			//print descendant if node 2 is a parent of node1
			else if(aTree.getNode(node1).isMyParent(aTree.getNode(node2)))
				System.out.println("DESCENDANT");
			//if node1's parent has node2 as a child
			else if (aTree.getParent(node1).isMyChild(aTree.getNode(node2))) {
				//check to see which num is bigger - bigger means right and vice versa
				if(aTree.getNode(node1).getNum() < aTree.getNode(node2).getNum())
					System.out.println("LEFT SIBLING");
				else
					System.out.println("RIGHT SIBLING");
			}
			else 
				System.out.println("NONE");
			
		}
    }
    
    public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		readTree();				   // read in the tree
		readQueries();				// read in the queries
		// then process the queries ... fill in your calls below
	}
}
