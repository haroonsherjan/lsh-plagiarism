import java.util.*;

public class TreeGenealogyDriver {
    static Scanner sc;
    private static MyTree mt  = new MyTree();

    /** Read in the tree
     */
    public static void readTree () {

        // read in one integer
        int numNodes = sc.nextInt();

        // loop to read pairs of children
        int[] ancestorOfNode = new int[numNodes];    //contains the ancestor of each node
        ancestorOfNode[0] = -1;    //since node 0 does not have an ancestor
        int leftIndex, rightIndex;
        for (int i=0;i<numNodes;i++) {
            leftIndex = sc.nextInt();			   
            rightIndex = sc.nextInt();
            if (leftIndex != -1)
                ancestorOfNode[leftIndex] = i;    //since the current node processed would be an
            if(rightIndex != -1)                  //ancestor of its left and right child
                ancestorOfNode[rightIndex] = i;
            mt.addNode(leftIndex, rightIndex, ancestorOfNode[i]);
        }
    }

    /** Read in and process query statements
     */
    public static void readQueries () {
        // read in one integer
        int m = sc.nextInt();
        // loop to read pairs of children for query
        int nodeA, nodeB;
        for (int i=0;i<m;i++) {
            nodeA = sc.nextInt();	
            nodeB = sc.nextInt();	
            mt.getRelationship(nodeA, nodeB);
        }
    }

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        readTree();				   // read in the tree
        readQueries();				// read in the queries

    }
}
