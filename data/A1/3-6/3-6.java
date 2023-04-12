import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */

public class CitiesDriver {
 static Scanner s;
 static MyTree t;

 // Reading query statements
 
 public static void readQuery () {
  // read in one integer
  int n = s.nextInt();
  for (int i = 0 ; i < n ; i++) {
   if (t.isPathSafe(s.nextInt(),s.nextInt()))
    System.out.println("YES");
   else
    System.out.println("NO");
  }
 }
 
 // Reading the tree
 
 public static void readTree () {
  
// Creating MyTree t with n nodes
  int n = s.nextInt();
  t = new MyTree(n);
  
  for (int i = 0 ; i < n ; i++) { 
   t.updateS(i, s.nextInt() == 1);
  }

// loop to read pairs of children
  for (int i = 0 ; i < n ; i++) {
   t.updateN(i,s.nextInt(),s.nextInt());
  }
 }


 public static void main(String[] args) {
  s = new Scanner(System.in);
  // reading the tress
  readTree();
  // reading the queries
  readQuery();    
 }
}
/* 
Class for a tree node
*/

import java.util.*;

class MyNode {
    int id;
    boolean isSafe;      
    MyNode p = null;  // parent node
    MyNode lC = null; // left child node
    MyNode rC = null; // right child node

 
 public MyNode(int id) {
  this.id = id;
 }
 
 // Creating Mutators
 
 public void setIsSafe(boolean isSafe){
  this.isSafe = isSafe;
 }
 
  public void setP(MyNode n){
  p = n;
 }
  
 public void setL(MyNode n){
  lC = n;
 }
 
 public void setR(MyNode n){
  rC = n;
 }

 
 // Accessors
 
 public int getId() {
  return id;
 }
  public MyNode getP(){
  return p;
 }
 public MyNode getLC(){
  return lC;
 }
 public MyNode getRC(){
  return rC;
 }

 public boolean isSafe(){
  return isSafe;
 }
}

/** Class for a binary tree ADT
 */
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

    private final int MAX_NODES = 1000;
    MyNode[] myTree;
    int size = 0;

 /*
 Filling up tree with the nodes and set the size of the tree
 */
 public MyTree(int n){
  myTree = new MyNode[n];
  for (int i = 0; i < n; i++)
   myTree[i] = new MyNode(i);
  size = n;
 }
 
 /* To update safe data in specific node */
 public void updateS(int n, boolean s){
  myTree[n].setIsSafe(s);
 }
 
 /* Setting the left, right child of a node */
 public void updateN(int n, int l, int r){
  if (l != -1) {
   myTree[n].setL(myTree[l]);
   myTree[l].setP(myTree[n]);
  }
  if (r != -1) {
   myTree[n].setR(myTree[r]);
   myTree[r].setP(myTree[n]);
  }
 }
 
 // Check if the path from Start to End (inclusive) is safe
 public boolean isPathSafe(int start, int end){
  boolean reply = false;
  
  MyNode curNode = myTree[start];
  
  // Use path to record the safe path to the root from the start
  ArrayList<MyNode> path = new ArrayList<MyNode>();
  while (curNode != null && curNode.isSafe()) {
   path.add(curNode);
   
   // If end is within the path, return true;
   if (curNode.getId() == end) {
    return true;
   }
   
   curNode = curNode.getP();
  }
  
  // Check if the safe path to the root from the end intercept with "path"
  curNode = myTree[end];
  while (curNode != null && curNode.isSafe()) {
   if (path.indexOf(curNode) != -1) {
    return true;
   }
   curNode = curNode.getP();
  }
  
  return reply;
 }
 
 // Printing the tree
 public void PrintTree() {
  for (int i = 0; i < myTree.length; i++) {
   System.out.print(i + ":");
   if (myTree[i].getLC() == null)
    System.out.print("NULL:"); 
   else 
    System.out.print(myTree[i].getLC().getId() + ":");
   if (myTree[i].getRC() == null)
    System.out.println("NULL"); 
   else 
    System.out.println(myTree[i].getRC().getId());
  }
 }
}
