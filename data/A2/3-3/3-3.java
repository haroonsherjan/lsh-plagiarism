/*****************************/
/* Class for a tree node
 */
/*****************************/
class MyNode {
  
  int left;     // left child index in array
  int right;   // right child index in array
  
  // Constructor which initializes the left child and right child.
  public MyNode(int inLeft, int inRight) {
    this.left = inLeft;
    this.right = inRight;
  }
  
  //Accessors for the left child and right child.
  public int getLeft() {
    return left;
  }
  
  public int getRight() {
    return right;
  }
} 

/*****************************/
/* Class for a binary tree ADT
 */
/*****************************/
public class MyTree {
  
  // Constant strings which denote the relationship between two nodes.
  public static final String AN = "ANCESTOR";
  public static final String DES = "DESCENDANT";
  public static final String L_SIB = "LEFT SIBLING";
  public static final String R_SIB = "RIGHT SIBLING";
  public static final String NONE = "NONE";
  
  MyNode[] myTree;
  int size = 0; // The size of the tree.
  
  // Constructor 
  public MyTree(int inSize) {
    myTree = new MyNode[inSize];
  } 
  
  // Inserts into the tree a node with right and left children.
  public void insert(int inLeft, int inRight) {
    myTree[size] = new MyNode(inLeft, inRight);
    size++;
  } 
  
  // Returns true if node with label A is an ancestor of the node with label B.
  private boolean isAncestor(int A, int B) {
    boolean isInLeft = false;
    boolean isInRight = false;
    
    // Node B = Node A -> return true
    if (A==B) {
      return true;
    }
    
    // Traverse the left subtree if it's not empty
    if (myTree[A].getLeft()!=-1) {
      isInLeft = isAncestor(myTree[A].getLeft(),B);
    }
    
    // Traverse the right subtree if it's not empty
    if (myTree[A].getRight()!=-1) {
      isInRight = isAncestor(myTree[A].getRight(),B);
    }
    
    return isInLeft || isInRight;
  } 
  
  // Returns true if node with label A is the left sibling of the node with label B.
  private boolean isLeftSibling(int A, int B) {
    // Iterate through every node
    for (int i = 0; i<size; i++) {
      if (myTree[i].getLeft()==A && myTree[i].getRight()==B) {
        return true;
      }
    }
    
    return false;
  } 
  
  // Determines the relationship between two node with label A and B.
  public String relationship(int A, int B) {
    if (isAncestor(A,B))          return AN;
    else if (isAncestor(B,A))     return DES;
    else if (isLeftSibling(A,B))  return L_SIB;
    else if (isLeftSibling(B,A))  return R_SIB;
    else                          return NONE; 
  } 
  
} 
import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
  static Scanner sc;
  static MyTree tree;
  static String[] query; // Array to store the results of each query.
  
  /* Read in the tree */
  public static void readTree () {
    // read in one integer
    int n = sc.nextInt();
    tree = new MyTree(n); // Initialize a tree with size n.
    
    // loop to read pairs of children
    for (int i=0;i<n;i++) {
      int leftChild = sc.nextInt();      
      int rightChild = sc.nextInt();      
      
      tree.insert(leftChild, rightChild); // Insert the node into the tree.
    }
  }
  
  /* Read in query statements */
  public static void readQueries () {
    // read in one integer
    int n = sc.nextInt();
    query = new String[n];
    
    // loop to read pairs of children
    for (int i=0;i<n;i++) {
      int nodeA = sc.nextInt();      
      int nodeB = sc.nextInt();      
      
      query[i] = tree.relationship(nodeA, nodeB); // Store the result
    }
  } 
  
  /* Main method */
  public static void main(String[] args) {
    sc = new Scanner(System.in);
    readTree();       // read in the tree
    readQueries();    // read in the queries
    
    for (int i = 0; i<query.length; i++) {
      System.out.println(query[i]); // Print out the resultn
    }
  }
  
}
