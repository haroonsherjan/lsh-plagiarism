/* Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    public int left;     // left child index in array
    public int right;   // right child index in array
    public int parent;
    // fill in your accessor and mutator methods here
    // ...
 public MyNode() {
  this.right = -1;
  this.parent = -1;
  this.left = -1;
 }
}

/** Class for a binary tree ADT
 */
public class MyTree {
    private final int MAX_NODES = 500;
    MyNode[] myTree;
    int size; // make sure to update this variable as needed

 public MyTree(int numNodes) {
  myTree = new MyNode[numNodes];
  int j = 0;
  while (j < numNodes) {
   myTree[j] = new MyNode();
   j++;
  }
  size = numNodes;
 }

 public void addNode(int label, int left, int right) {
  myTree[label].left = left;
  myTree[label].right = right;
 }

 public void generateParents() {
  int i = 0;
  while (i < size) {
   if (myTree[i].left>0)
     myTree[myTree[i].left].parent=i;
   if (myTree[i].right>0)
     myTree[myTree[i].right].parent=i;
   i++;
  }
 }

 public String checkRelation(int a, int b) {
  if(isAncestor(a,b))
    return "ANCESTOR";
  else if(isAncestor(b, a)) //reverse
    return "DESCENDANT";
  else if (myTree[myTree[a].parent].right == b)
    return "LEFT SIBLING";
  else if (myTree[myTree[a].parent].left == b)
    return "RIGHT SIBLING";
  else
    return "NONE";
 }

 private boolean isAncestor(int a, int b) {
  int parent = myTree[b].parent;
  while(parent!=-1) {
   if(parent==a) return true;
   parent = myTree[parent].parent;
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
    static Scanner scanner;
    static MyTree myTree;

    // Read in the tree along with entering queries
    public static void readTreeAndQueries () {
      // read in one integer
      int n = scanner.nextInt();

      myTree = new MyTree(n);
      // loop to read pairs of children
      for (int i=0;i<n;i++)
        myTree.addNode(i,scanner.nextInt(), scanner.nextInt());
      myTree.generateParents();

      //Read in query statements
      int m = scanner.nextInt(); //read 1 int size
      // loop to read pairs of children for query
      for (int i=0;i<m;i++)
        System.out.println(myTree.checkRelation(scanner.nextInt(), scanner.nextInt()));
    }
    
    public static void main(String[] args) {
      scanner = new Scanner(System.in);
      readTreeAndQueries();       // read in the tree
    }
}
