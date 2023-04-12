/** Class for a binary tree ADT
 */
public class TreeClass {
    private final int MAX_NODES = 1000;
    MyNode[] binTree = new MyNode[MAX_NODES];
    int size; 

 public TreeClass(int nodes) {
  binTree = new MyNode[nodes];
  for (int i=0;i<nodes;i++) {
   binTree[i] = new MyNode();
  }
  size = nodes;
 }

 public void add(int label, int left, int right) {
  binTree[label].left = left;
  binTree[label].right = right;
 }

 public void findParents() {  //find the parents of the node
  for(int i=0;i<size;i++) {
   if (binTree[i].left>0) binTree[binTree[i].left].parent=i;
   if (binTree[i].right>0) binTree[binTree[i].right].parent=i;
  }
 }

 public String nodeRSCheck(int a, int b) {
  if(ancestorCheck(a,b)) return "ANCESTOR";
  if(descendantCheck(a,b)) return "DESCENDANT";
  if(leftSibCheck(a,b)) return "LEFT SIBLING";
  if(rightSibCheck(a,b)) return "RIGHT SIBLING";
  return "NONE";
 }

 private boolean leftSibCheck (int a, int b) {
  return binTree[binTree[a].parent].right == b;
 }

 private boolean rightSibCheck (int a, int b) {
  return binTree[binTree[a].parent].left == b;
 }

 private boolean ancestorCheck(int a, int b) {
  int parent = binTree[b].parent;
  while(parent!=-1) {
   if(parent==a) return true;
   parent = binTree[parent].parent;
  }
  return false;
 }

 private boolean descendantCheck(int a, int b) {
  return ancestorCheck(b, a);
 }
}
import java.util.*;


public class TreeGenealogyDriver {
    static Scanner sc;
    static TreeClass tree;

    /** Read in the tree
     */
    public static void readTree () {
  // read in one integer
  int n = sc.nextInt();

  tree = new TreeClass(n);
  // loop to read pairs of children
  for (int i=0;i<n;i++) {
      tree.add(i,sc.nextInt(), sc.nextInt());      // modify this line
  }
  tree.findParents();
    }
    
  //Read inputs
    public static void readInput () {
  // read in one integer
  int x = sc.nextInt();
  // loop to read pairs of children for query
  for (int i=0;i<x;i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
   System.out.println(tree.nodeRSCheck(a, b)); //prints result to screen after checking relationship between nodes in query
  }
    }
    
    public static void main(String[] args) {
      sc = new Scanner(System.in);
      readTree();       // read in the tree
      readInput();      // read in the nodes and queries
    }
}
