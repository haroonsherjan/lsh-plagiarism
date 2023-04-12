import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
 static Scanner scanner;
 static MyTree tree;

 /** Read in the tree
  */
 public static void readTreeAndQueries () {
  // Read in the tree
  // Read in size of the tree
  int n = scanner.nextInt();
  tree = new MyTree(n);
  // read in tree, safety line
  for (int i=0;i<n;i++){
   tree.changeSafetyStatus(i, scanner.nextInt());
  }

  // loop to read pairs of children
  for (int i=0;i<n;i++)
   tree.changeNodeAttributes(i,scanner.nextInt(),scanner.nextInt());

  //Read in query statements
  // read in one integer
  int m = scanner.nextInt();
  // loop to read pairs of children for query
  for (int i=0;i<m;i++) {
   int start = scanner.nextInt();
   int end = scanner.nextInt();
   if (tree.safe(start,end)==true)
    System.out.println("YES");
   else
    System.out.println("NO");
  }
 }


 public static void main(String[] args) {
  scanner = new Scanner(System.in);
  readTreeAndQueries();       // read in the tree and queries
  //readQueries();    // read in the queries
 }
}
/* 
Class for a tree node
*/

import java.util.*;
class MyNode {
    boolean isSafe;      // is the city safe?
    int leftChild;     // left child index in array
    int rightChild;   // right child index in array
    private int parentIndex;

 //accessors and mutators
 public void setParentNode(int parent){
  parentIndex = parent;
 }

 public int getParentNode(){
  return parentIndex;
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
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;
    int root = 0;
    LinkedList <Integer> que;   //Queue for BFS

 /*
 Fill up the tree with the nodes and set the size of the tree
 Even more boring stuff
 */
 public MyTree(int n){
  for (int i = 0; i < n; i++)
   myTree[i] = new MyNode();
   size = n;
 }
 public void changeSafetyStatus(int node, int safe){
  myTree[node].isSafe = (safe == 1);
 }
 public void changeNodeAttributes(int node, int left, int right){
  myTree[node].leftChild = left;
  myTree[node].rightChild = right;
  if (left != -1)
   myTree[left].setParentNode(node);
  if (right != -1)
   myTree[right].setParentNode(node);
 }
 /*
 In this problem, we are given a tree. Therefore, given any nodes u and v, there is only one unique path from u to v.
 This is because a tree is acyclic and all the nodes are connected. The question asks whether it is possible to find a 
 "safe" path from nodes u to v. 

 The easiest way to solve this problem would be to view the binary tree as a graph instead of a binary tree and run BFS/DFS 
 on the tree. Personally I prefer coding BFS, hence I coded BFS. I used the binary tree structure as an adjacency list, where
 there is an edge from the current node to its left child, an edge from the current node to its right child and an edge from the 
 current node to its parent.

 After running BFS, I recreate the path using the array pre[] (which stores the predecessor of the node) and check whether the
 path is safe. The runtime for BFS is O(N) for every query (where N is the size of binary tree). Suppose there are M queries, then
 it will take O(MN) to run all M queries.
 */
 public boolean safe(int start, int end){
  int[] pre = new int[size];    //Stores who is the pre of the current node in the path
  boolean[] visited = new boolean[size]; //To store whether the particular node is visited
  que = new LinkedList <Integer>();
  //Start of BFS
  que.offer(new Integer(start));
  visited[start] = true;
  while (que.size()!=0){
   int u = que.poll();
   if (u == end)
    break;
   int left = myTree[u].leftChild;
   int right = myTree[u].rightChild;
   int parent = myTree[u].getParentNode();
   if (isFalse(left, visited)){
    visited[left] = true;
    que.offer(new Integer(left));
    pre[left] = u;
   }
   if (isFalse(right, visited)){
    visited[right] = true;
    que.offer(new Integer(right));
    pre[right] = u;
   }
   if (isFalse(parent, visited)){
    visited[parent] = true;
    que.offer(new Integer(parent));
    pre[parent] = u;
   }
  }
  int curnode = end;
  //If the path is safe, then logical and of all the nodes in the path will yield whether the path is safe
  boolean isSafe = myTree[start].isSafe;
  while (curnode != start){
   isSafe = myTree[curnode].isSafe && isSafe;
   curnode = pre[curnode];
  }
  return isSafe;
 }
 
 private boolean isFalse(int index, boolean[] visited) {
   return (index != -1 && visited[index] == false);
 }
}
