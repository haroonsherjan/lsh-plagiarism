import java.util.*;


public class CitiesDriver {
 static Scanner sc;
 static CityTree tree;

 //Read input tree
 public static void cityCount () {
  // Read in the tree
  // Read in size of the tree
  int n = sc.nextInt();
  tree = new CityTree(n);   //Create CityTree with n nodes
  // read in tree, safety line
  for (int i=0;i<n;i++){ 
   int safe = sc.nextInt();
   tree.safetyCheck(i, safe);
  }

  // loop to read pairs of children
  for (int i=0;i<n;i++) {
   int left = sc.nextInt();
   int right = sc.nextInt();
   tree.updateCity(i,left,right);
  }
 }

 /** Read in input statements
  */
 public static void cityChildren () {

  int m = sc.nextInt();
  // loop to read pairs of children for query
  for (int i=0;i<m;i++) {
   int start = sc.nextInt();
   int end = sc.nextInt();
   if (tree.isPathSafe(start,end)==true)
    System.out.println("YES");
   else
    System.out.println("NO");
  }
 }

 public static void main(String[] args) {
  sc = new Scanner(System.in);
  cityCount();       // read in the tree
  cityChildren();    // read in the queries
 }
}
/* 
 Class for a tree node
 */

import java.util.*;
class CityNode {
  boolean safeCity;      // safety of city
  int leftChild;     // left child index in array
  int rightChild;   // right child index in array
  int parentIndex;
  
  //Accessors and mutators
  

  public int getParent(){
    return parentIndex;
  }
    
  public void setParent(int parent){
    parentIndex = parent;
  }
  
  public int getLeft(){
    return leftChild;
  }
  
  public void setLeft(int left){
    leftChild = left;
  }

  public int getRight(){
    return rightChild;
  }
    
  public void setRight(int right){
    rightChild = right;
  }

  public boolean getSafeStatus(){
    return safeCity;
  }
  
  public void setIsSafe(boolean safe){
    safeCity = safe;
  }
}

/** Class for a binary tree ADT
  */
public class CityTree {
  private final int MAX_NODES = 1000;
  CityNode[] cityTree = new CityNode[MAX_NODES];
  int size = 0;
  int root = 0;
  LinkedList <Integer> q;   //Queue for BFS
  
  /*
   Populate tree and set size of tree 
   */
  public CityTree(int n){
    for (int i = 0; i < n; i++)
      cityTree[i] = new CityNode();
    size = n; //set tree size
  }
  public void safetyCheck(int node, int safe){
    cityTree[node].setIsSafe(safe == 1);
  }
  public void updateCity(int node, int left, int right){
    cityTree[node].setLeft(left);
    cityTree[node].setRight(right);
    if (left != -1)
      cityTree[left].setParent(node);
    if (right != -1)
      cityTree[right].setParent(node);
  }
  
  public boolean isPathSafe(int start, int end){
    int[] pre = new int[size];    //stores previous node in path
    boolean[] visited = new boolean[size]; // mark node that is visited
    q = new LinkedList <Integer>();
    //Start of BFS
    q.offer(new Integer(start));
    visited[start] = true;
    while (q.size()!=0){
      int u = q.poll();
      if (u == end)
        break;
      int parent = cityTree[u].getParent();
      int left = cityTree[u].getLeft();
      int right = cityTree[u].getRight();
      
      if (parent != -1 && visited[parent] == false){
        visited[parent] = true;
        q.offer(new Integer(parent));
        pre[parent] = u;
      }
      if (left != -1 && visited[left] == false){
        visited[left] = true;
        q.offer(new Integer(left));
        pre[left] = u;
      }
      if (right != -1 && visited[right] == false){
        visited[right] = true;
        q.offer(new Integer(right));
        pre[right] = u;
      }
      
    }
    int nodeEnd = end;
    //if path is safe, then all nodes should be safe
    boolean safeCity = cityTree[start].getSafeStatus();
    while (nodeEnd != start){
      safeCity = cityTree[nodeEnd].getSafeStatus() && safeCity;
      nodeEnd = pre[nodeEnd];
    }
    return safeCity;
  }
}
