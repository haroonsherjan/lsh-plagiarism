import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;

    /** Read in the tree
     */
    public static MyTree readTree () {
    // read in one integer
    int n = sc.nextInt();
    int leftChild = 0;
    int rightChild = 0;
    // array nodes to keep track of the nodes provided
    int[] nodes = new int[n];
    // as stated, first node is always 0
    nodes[0] = 0;
    int counter = 1;
	MyNode newNode = new MyNode();
    MyTree newTree = new MyTree();
    // loop to read pairs of children
    for (int i=0;i<n;i++) {
        leftChild = sc.nextInt();			   // modify this line
        if (leftChild != -1)
        {
          nodes[counter] = leftChild;
          newNode.setLeftChildIndex(counter);
          counter++;
        }
        else
          newNode.setLeftChildIndex(-1);
        rightChild = sc.nextInt();			   // modify this line
        if (rightChild != -1)
        {
          nodes[counter] = rightChild;
          newNode.setRightChildIndex(counter);
          counter++;
        }
        else
          newNode.setRightChildIndex(-1);
        newNode.setMyValue(nodes[i]);
        newTree.addNode(newNode);
    }
    return newTree;
    }
    
    /** Read in query statements
     */
    public static void readQueries (MyTree newTree) {
    // read in one integer
    int m = sc.nextInt();
    int a = 0;
    int b = 0;
    // loop to read pairs of children for query
    for (int i=0;i<m;i++) {
        a = sc.nextInt();			   // modify this line
        b = sc.nextInt();			   // modify this line
        // print relationship
        System.out.println(newTree.getRelationship(a,b));
    }
    }
    
    public static void main(String[] args) {
    sc = new Scanner(System.in);
    MyTree newTree = readTree();				   // read in the tree
    readQueries(newTree);				// read in the queries

    // then process the queries ... fill in your calls below
    }
}
