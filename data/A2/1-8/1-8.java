class MyNode {

  private int left;     // left child index in array
  private int right;   // right child index in array
  private int parent;
  
  public int getLeft() {
    return this.left;
  }
  
  public int getRight() {
    return this.right;
  }
  
  public int getParent() {
    return this.parent;
  }
  
  public void setLeft(int left) {
    this.left = left;
  }
  
  public void setRight(int right) {
    this.right = right;
  }
  
  public void setParent(int parent) {
    this.parent = parent;
  }
  
  public MyNode() {
    this.left = -1;
    this.right = -1;
    this.parent = -1;
  }
}

public class MyTree {
  private final int MAX_NODES = 1000;
  MyNode[] myTree;// = new MyNode[MAX_NODES];
  int size; // make sure to update this variable as needed
  
  public MyTree(int numNodes) {
    myTree = new MyNode[numNodes];
    for (int i=0;i<numNodes;i++) {
      myTree[i] = new MyNode();
    }
    size = numNodes;
  }
  
  public void add(int label, int left, int right) {
    myTree[label].setLeft(left);
    myTree[label].setRight(right);
  }
  
  public void generateParents() {
    for(int i=0;i<size;i++) {
      if (myTree[i].getLeft() > 0) {
        myTree[myTree[i].getLeft()].setParent(i);
      }
      if (myTree[i].getRight() > 0) {
        myTree[myTree[i].getRight()].setParent(i);
      }
    }
  }
  
  public String checkRS(int a, int b) {
    if(isAncestor(a,b)) {
      return "ANCESTOR";
    }
    if(isDescendant(a,b)) {
      return "DESCENDANT";
    }
    if(isLeftSib(a,b)) {
      return "LEFT SIBLING";
    }
    if(isRightSib(a,b)) {
      return "RIGHT SIBLING";
    }
    return "NONE";
  }
  
  private boolean isLeftSib (int a, int b) {
    return myTree[myTree[a].getParent()].getRight() == b;
  }
  
  private boolean isRightSib (int a, int b) {
    return myTree[myTree[a].getParent()].getLeft() == b;
  }
  
  private boolean isAncestor(int a, int b) {
    int parent = myTree[b].getParent();
    while(parent!=-1) {
      if(parent==a) {
        return true;
      }
      parent = myTree[parent].getParent();
    }
    return false;
  }
  
  private boolean isDescendant(int a, int b) {
    return isAncestor(b, a);
  }
}
import java.util.*;

public class TreeGenealogyDriver {
  static Scanner sc;
  static MyTree myTree;
  
  public static void readTree () {
   
    int n = sc.nextInt();
    
    myTree = new MyTree(n);
    // loop through
    for (int i=0;i<n;i++) {
      myTree.add(i,sc.nextInt(), sc.nextInt());      // modify this line
    }
    myTree.generateParents();
  }
  
  /** Read in query statements
    */
  public static void readQueries () {
    // read in one integer
    int m = sc.nextInt();
    // loop to read pairs of children for query
    for (int i=0;i<m;i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      System.out.println(myTree.checkRS(a, b));
    }
  }
  
  public static void main(String[] args) {
    sc = new Scanner(System.in);
    readTree();       // read in the tree
    readQueries();    // read in the queries
  }
}
