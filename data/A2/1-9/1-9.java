/* Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree
    
    // you can add other variables if you'd like
    public int left, right, parent;     // left, right child index and parent index in array
    
    public MyNode() {
        this.left = -1;
        this.right = -1;
        this.parent = -1;
    }
}

/** Class for a binary tree ADT
  */
public class MyTree {
    MyNode[] myTree;
    int size; // make sure to update this variable as needed
    
    public MyTree(int numNodes) {
        myTree = new MyNode[numNodes];
        for (int i=numNodes;i>0;i--) {
            myTree[numNodes - i] = new MyNode();
        }
        size = numNodes;
    }
    
    public void add2Values(int label, int left, int right) {
        myTree[label].left = left;
        myTree[label].right = right;
    }
    
    public void generateParents() {
        for(int i=0;i<size;i++) {
            if (myTree[i].left>0) myTree[myTree[i].left].parent=i;
            if (myTree[i].right>0) myTree[myTree[i].right].parent=i;
        }
    }
    
    public String checkRS(int a, int b) {
        if(isAncestor(a,b)) return "ANCESTOR";
        if(isDescendant(a,b)) return "DESCENDANT";
        if(isLeftSib(a,b)) return "LEFT SIBLING";
        if(isRightSib(a,b)) return "RIGHT SIBLING";
        return "NONE";
    }
    
    private boolean isLeftSib (int a, int b) {
        return myTree[myTree[a].parent].right == b;
    }
    
    private boolean isRightSib (int a, int b) {
        return myTree[myTree[a].parent].left == b;
    }
    
    private boolean isAncestor(int a, int b) {
        int parent = myTree[b].parent;
        for (;;){
            if (parent == -1) break;
            if(parent==a) return true;
            parent = myTree[parent].parent;
        }
        return false;
    }
    
    private boolean isDescendant(int a, int b) {
        return isAncestor(b, a);
    }
}
import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
    static MyTree myTree;
   
    /** Read in the tree
      */
    public static void readTree () {
        // read in one integer
        int number = sc.nextInt();
        
        myTree = new MyTree(number);
        // loop to read pairs of children
        for (int i=number;i>0;i--) {
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();
            myTree.add2Values(number - i,temp1, temp2);      // modify this line
        }
        myTree.generateParents();
    }
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        readTree();       // read in the tree
        
        // read in one integer
        int number = sc.nextInt();
        // loop to read pairs of children for query
        for (int i=number; i > 0;i--) {
            System.out.println(myTree.checkRS(sc.nextInt(), sc.nextInt()));
        }
    }
}
