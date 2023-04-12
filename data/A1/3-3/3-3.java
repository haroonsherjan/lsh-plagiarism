import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
  static Scanner sc;
  static MyTree tree;
  
  /* Read in the tree */
  public static void readTree () {
    // Create MyTree with n nodes
    int nodes = sc.nextInt();
    tree = new MyTree(nodes);
    
    // Safety
    for (int i=0;i<nodes;i++){ 
      tree.updateSafe(i, sc.nextInt() == 1);
    }
    
    // loop to read pairs of children
    for (int i=0;i<nodes;i++) {
      tree.updateNode(i,sc.nextInt(),sc.nextInt());
    }
  }
  
  /* Read in query statements */
  public static void readQueries () {
    // read in one integer
    int m = sc.nextInt();
    for (int i=0;i<m;i++) {
      if (tree.isPathSafe(sc.nextInt(),sc.nextInt())) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
  
  /* Main method */
  public static void main(String[] args) {
    sc = new Scanner(System.in);
    readTree();       // read in the tree
    readQueries();    // read in the queries
  }
}
/* 
 Class for a tree node
 */

import java.util.*;
class MyNode {
  int id;
  boolean safe;      
  MyNode left = null;
  MyNode right = null;
  MyNode parent = null;
  
  public MyNode(int inputId) {
    id = inputId;
  }
  
  // Mutators
  public void setParent(MyNode inputNode){
    parent = inputNode;
  }
  
  public void setRight(MyNode inputNode){
    right = inputNode;
  }
  
  public void setLeft(MyNode inputNode){
    left = inputNode;
  }
  
  public void setSafe(boolean inputStatus){
    safe = inputStatus;
  } 
  
  // Accessors
  public int getId() {
    return id;
  }
  
  public MyNode getParent(){
    return parent;
  }
  
  public MyNode getRight(){
    return right;
  }
  
  public MyNode getLeft(){
    return left;
  }
  
  public boolean isSafe(){
    return safe;
  }
}

/*******************************/ 
/* 
 * Class for a binary tree ADT
 */
/*******************************/
public class MyTree {
  // You may want to use an array based implementation for 
  // your tree, or change this to another implementation
  
  // Note that this code and the driver code do not necessarily
  // match well -- you decide how you want these two parts to work
  // together.
  
  private final int MAX_NODES = 1000;
  MyNode[] myTree;
  int size = 0;
  
  
  /* Fill up the tree with the nodes and set the size of the tree */
  public MyTree(int n){
    myTree = new MyNode[n];
    for (int i=0; i<n; i++) {
      myTree[i] = new MyNode(i);
    }
    size = n;
  }
  
  /* Update the safe/unsafe status of a node */
  public void updateSafe(int index, boolean status){
    myTree[index].setSafe(status);
  }
  
  /* Set the children of a node */
  public void updateNode(int nodeIndex, int leftIndex, int rightIndex){
    if (leftIndex != -1) {
      myTree[nodeIndex].setLeft(myTree[leftIndex]);
      myTree[leftIndex].setParent(myTree[nodeIndex]);
    }
    if (rightIndex != -1) {
      myTree[nodeIndex].setRight(myTree[rightIndex]);
      myTree[rightIndex].setParent(myTree[nodeIndex]);
    }
  }
  
  // Check if the path from Start to End (inclusive) is safe
  public boolean isPathSafe(int start, int end){
    
    MyNode curNode = myTree[start];
    
    // Use path to record the safe path to the root from the start
    ArrayList<MyNode> path = new ArrayList<MyNode>();
    while (curNode != null && curNode.isSafe()) {
      path.add(curNode);
      
      // If end is within the path, return true;
      if (curNode.getId() == end) {
        return true;
      }
      
      curNode = curNode.getParent();
    }
    
    // Check if the safe path to the root from the end intercept with "path"
    curNode = myTree[end];
    while (curNode != null && curNode.isSafe()) {
      if (path.indexOf(curNode) != -1) {
        return true;
      }
      curNode = curNode.getParent();
    }
    
    // Else, the path is not safe
    return false;
  }
  
  // Print the tree
  public void PrintTree() {
    // For each node in the tree:
    for (int i = 0; i < myTree.length; i++) {
      System.out.print(i + ":");
      // Print left child
      if (myTree[i].getLeft() == null) {
        System.out.print("NULL:"); 
      } else {
        System.out.print(myTree[i].getLeft().getId() + ":");
      }
      // Print right child
      if (myTree[i].getRight() == null) {
        System.out.println("NULL"); 
      } else {
        System.out.println(myTree[i].getRight().getId());
      }
    }
  }
  
}
