import java.util.Scanner;

/**
 * Driver class
 */

public class CitiesDriver {

    static Scanner scan;
    static MyTree tree;
    
    public static void main(String[] args) {
      scan = new Scanner(System.in);
      readTree();       // read in the tree
      readQueries();    // read in the queries
    }

    // Read in the tree
    public static void readTree () {
      int a = scan.nextInt();   // read in one integer
      tree = new MyTree (a);

      for (int it = 0; it < a; it++) {   // read in tree, safety line
        tree.setSafe(it,scan.nextInt());
      }
 
      for (int it = 0; it < a; it++) {   // loop to read pairs of children
        tree.setNode(it,scan.nextInt(),scan.nextInt());
      }
    }
    
    // Read in query statements
    public static void readQueries () {
      int m = scan.nextInt();   // read in one integer
  
      for (int i = 0; i < m; i++) {   // loop to read pairs of children for query
        if (tree.findpath(scan.nextInt(), scan.nextInt())){
          System.out.println("YES");
        } else System.out.println("NO");
      }

    }
    
}
/** Class for a tree node
 */
class MyNode {

    boolean isSafe;      // flag
    int left;     // left child index in array
    int right;   // right child index in array

    public MyNode () {
      isSafe = true;
      left = -1;
      right = -1;
    }

    public int left () {
      return left;
    }

    public int right () {
      return right;
    }

    public boolean isSafe () {
      return isSafe;
    }

    public void setSafe (int p) {
      if (p == 0) isSafe = false;
      else if (p == 1) isSafe = true;
    }

    public void setLeft (int index) {
      left = index;
    }

    public void setRight (int index) {
      right = index;
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

    public void setNode (int index, int left, int right) {
      myTree[index].setLeft(left);
      myTree[index].setRight(right);
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

          if (directPath(myTree[index].left(),target)) return true;
          else return directPath(myTree[index].right(),target);
        }
      }
      return false;
    }

    public boolean search (int index, int target) {

      if (index >= 0) {
        if (index == target) return true;

        if (search(myTree[index].left(),target)) return false;
        else return search(myTree[index].right(),target);
      }

      return false;
    }

    public void print (MyNode[] tree, int index) {
  
      if (index >= 0) {
        print(tree,tree[index].left());

        System.out.print(index);
        if (!tree[index].isSafe()) System.out.print("*");
        System.out.print(" ");

        print(tree,tree[index].right());
      }

    }

}
