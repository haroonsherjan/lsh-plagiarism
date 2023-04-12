import java.util.*;

/**
 * Driver class
 */

public class CitiesDriver {

    static Scanner scanner;
    static CityTree tree;

    // Read in the tree
    public static void readTree () {
  
  // Read in the tree

  int n = scanner.nextInt();
 
  tree = new CityTree(n);

  // read in tree, safety line
  for (int i = 0; i < n; i++) {
      tree.setSafe(i,scanner.nextInt());
  }
 
  // loop to read pairs of children
  for (int i = 0; i < n; i++) {
      tree.setNode(i,scanner.nextInt(),scanner.nextInt());
  }

  

    }
    
    // Read in query statements
    public static void readQueries () {
  
  // read in one integer
  int m = scanner.nextInt();
  
  // loop to read pairs of children for query
  for (int i=0;i<m;i++) {
      if (tree.findpath(scanner.nextInt(),scanner.nextInt()))
    System.out.println("YES");
   else System.out.println("NO");
  }

    }
    
    public static void main(String[] args) {
  scanner = new Scanner(System.in);
  readTree();       // read in the tree
  readQueries();    // read in the queries

    }

}
/** Class for a tree node
 */
class TreeNode {
  int li;    // left child index in array
  int ri;   // right child index in array
  boolean isSafe;      // is the city safe?
    

  public TreeNode () {
  isSafe = true;
  li = -1;
  ri = -1;
 }

   public boolean isSafe () {
  return isSafe;
 }
  
  public int right () {
  return ri;
 } 
  
 public int left () {
  return li;
 }


 public void setLeft (int index) {
  li = index;
 }

 public void setRight (int index) {
  ri = index;
 }
 
 
 public void setSafe (int n) {
  if (n == 0) isSafe = false;
  else if (n == 1) isSafe = true;
 }



}

/** Class for a binary tree ADT
 */
public class CityTree {

    private final int MAX_NODES = 1000;
    TreeNode[] citTree = new TreeNode[MAX_NODES];
    int size = 0;

 public CityTree (int n) {
  size = n;
  for (int i = 0; i < n; i++) {
   citTree[i] = new TreeNode ();
  }
 }

 public void setSafe (int index, int status) {
  citTree[index].setSafe(status);
 }

 public void setNode (int index, int left, int right) {
  citTree[index].setLeft(left);
  citTree[index].setRight(right);
 }

 public void print () {
  print(citTree,0);
 }

 public boolean findpath (int from, int to) {
  if (!citTree[from].isSafe() || !citTree[to].isSafe()) {
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
   if (!citTree[index].isSafe()) return false;
   else {
    if (index == target) return true;

    if (directPath(citTree[index].left(),target)) return true;
    else return directPath(citTree[index].right(),target);
   }
  }

  return false;
 }

 public boolean search (int index, int target) {

  if (index >= 0) {
   if (index == target) return true;

   if (search(citTree[index].left(),target)) return false;
   else return search(citTree[index].right(),target);
  }

  return false;
 }

 public void print (TreeNode[] tree, int index) {
  
  if (index >= 0) {
   print(tree,tree[index].left());

   System.out.print(index);
   if (!tree[index].isSafe()) System.out.print("*");
   System.out.print(" ");

   print(tree,tree[index].right());
  }

 }

}
