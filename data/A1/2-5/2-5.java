import java.util.*;

/**
 * Driver class
 */

public class CitiesDriver {

    static Scanner scan;
    static MyTree myTree;

    // Read in the myTree
    public static void read_tree () {
  
  // Read in the myTree
  // read in one integer
  int num = scan.nextInt();
 
  myTree = new MyTree (num);

  // read in myTree, safety line
  for (int i = 0; i < num; i++) {
      myTree.setSafe(i,scan.nextInt());
  }
 
  // loop to read pairs of children
  for (int i = 0; i < num; i++) {
      myTree.setNode(i,scan.nextInt(),scan.nextInt());
  }

  //myTree.print();

    }
    
    // Read in query statements
    public static void read_Q () {
  
  // read in one integer
  int num2 = scan.nextInt();
  
  // loop to read pairs of children for query
  for (int i=0;i<num2;i++) {
      if (myTree.findpath(scan.nextInt(),scan.nextInt()))
    System.out.println("YES");
   else System.out.println("NO");
  }

    }
    
    public static void main(String[] args) {
  scan = new Scanner(System.in);
  read_tree();       // read in the myTree
  read_Q();    // read in the queries

    }

}
/** Class for a tree node
 */
class MyNode {

    boolean isSafe;      // is the city safe?
    int l;     // left child index in array
    int r;   // right child index in array

    public MyNode () {
  isSafe = true;
  l = -1;
  r = -1;
 }

 public int l () {
  return l;
 }

 public int r () {
  return r;
 }

 public boolean isSafe () {
  return isSafe;
 }

 public void setSafe (int n) {
  if (n == 0) isSafe = false;
  else if (n == 1) isSafe = true;
 }

 public void setLeft (int index) {
  l = index;
 }

 public void setRight (int index) {
  r = index;
 }

}

/** Class for a binary tree ADT
 */
public class MyTree {

    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;

 public MyTree (int n) {
  size = n;
  for (int i = 0; i < n; i++) {
   myTree[i] = new MyNode ();
  }
 }

 public void setSafe (int index, int status) {
  myTree[index].setSafe(status);
 }

 public void setNode (int index, int l, int r) {
  myTree[index].setLeft(l);
  myTree[index].setRight(r);
 }

 public void print () {
  print(myTree,0);
 }

 public boolean findpath (int from, int to) {
  if (!myTree[from].isSafe() || !myTree[to].isSafe()) {
   return false;
  }

  if (from == to) return true;

  if (directPath(from,to)) return true;

  if (directPath(to,from)) return true;

  if (directPath(0,from) && directPath(0,to)) return true;

  return false;
 }

 public boolean directPath (int index, int target) {
  if (index >= 0) {
   if (!myTree[index].isSafe()) return false;
   else {
    if (index == target) return true;

    if (directPath(myTree[index].l(),target)) return true;
    else return directPath(myTree[index].r(),target);
   }
  }

  return false;
 }

 public boolean search (int index, int target) {

  if (index >= 0) {
   if (index == target) return true;

   if (search(myTree[index].l(),target)) return false;
   else return search(myTree[index].r(),target);
  }

  return false;
 }

 public void print (MyNode[] tree, int index) {
  
  if (index >= 0) {
   print(tree,tree[index].l());

   System.out.print(index);
   if (!tree[index].isSafe()) System.out.print("*");
   System.out.print(" ");

   print(tree,tree[index].r());
  }

 }

}
