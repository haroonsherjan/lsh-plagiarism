/** Class for a tree node
  */
class MyNode {
  
  // left child index in array
  int lCI;     
  // right child index in array
  
  int rCI;   
  
  // Constructor which initializes the left child and right child.
  public MyNode(int l, int r) {
    lCI = l;
    rCI = r;
  }
  
  //Accessors 
  public int getL() {
    return lCI;
  }
  
  public int getR()
  {
    return rCI;
  }
}

/** Class for a binary tree ADT
  */

public class MyTree {
  
  //Constant strings which denote the relationship between two nodes.
  public static final String ANCESTOR = "ANCESTOR";
  public static final String DESCENDANT = "DESCENDANT";
  public static final String LEFT_SIBLING = "LEFT SIBLING";
  public static final String RIGHT_SIBLING = "RIGHT SIBLING";
  public static final String NONE = "NONE";
  
  MyNode[] myTree;
  int size = 0; 
  
  // Initializes the tree to have a constant number of nodes.
  public MyTree(int numN) {
    myTree = new MyNode[numN];
  }
  
  //Inserts nodes into the tree 
  public void insert(int l, int r) {
    myTree[size] = new MyNode(l, r);
    size++;
  }
  
  //Determines the relationship between two node A and B.
  public String relationship(int A, int B)
  {
    if (isAncestor(A,B))
      return ANCESTOR;
    else if (isAncestor(B,A))
      return DESCENDANT;
    else if (isLS(A,B))
      return LEFT_SIBLING;
    else if (isLS(B,A))
      return RIGHT_SIBLING;
    else
      return NONE; 
  }
  
  //Returns true if A is an ancestor of B.
  private boolean isAncestor(int A, int B) {
    //Variables to determine whether node B is in A left subtree or right subtree.
    boolean isIL = false;
    boolean isIR = false;
    
    if (A==B) //Node with label B is in A subtree.
      return true;
    
    if (myTree[A].getL()!=-1) //Traverse the left subtree if it's not empty
      isIL = isAncestor(myTree[A].getL(),B);
    
    if (myTree[A].getR()!=-1) //Traverse the right subtree if it's not empty
      isIR = isAncestor(myTree[A].getR(),B);
    
    return isIL || isIR; //Return true when B is in either the right or left subtree of A.
  }
  
  //Return true if A is the left sibling of B.
  private boolean isLS(int A, int B) {
    //Go through nodes and determine whether there exists a node with A and B.
    for (int i = 0; i<size; i++)
    {
      if (myTree[i].getL()==A && myTree[i].getR()==B)
        return true;
    }
    
    return false;
  }
}
import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
  static Scanner s;
  static MyTree t;
  static String[] q; 
  
  // Reading tree
  
  public static void readTree () {
    // reading integer
    int z = s.nextInt();
    //Initialize tree with size z.
    t = new MyTree(z); 
    
    // loop to read pairs of children
    for (int i = 0 ; i < z ; i++) {
      int lC = s.nextInt();      
      int rC = s.nextInt();      
      
      t.insert(lC, rC); //Insert the node into the tree.
    }
  }
  
  //Read in query statements
  
  public static void readQuery () {
    
    int y = s.nextInt();
    q = new String[y];
    
    // loop to read pairs of children for query
    for (int i = 0 ; i < y ; i++) {
      int a = s.nextInt();      
      int b = s.nextInt();      
      
      q[i] = t.relationship(a, b); 
    }
  }
  
  public static void main(String[] args) {
    s = new Scanner(System.in);
    readTree();     
    readQuery();   
    
    for (int i = 0; i < q.length; i++)
    {
      System.out.println(q[i]); //Printing out result
    }
  }
}
