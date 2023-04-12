/** Class for a tree node
 */
class TreeNode {
  int li;    // left child index in array
  int ri;   // right child index in array

}

/** Class for a binary tree ADT
 */
public class MyTree {

    TreeNode[] myTree;
 
 // Create a tree with specified number of nodes
 public MyTree(int numNodes)
 {
  myTree = new TreeNode[numNodes];

  for ( int i = 0; i < numNodes; i ++ )
   myTree[i] = new TreeNode();
 }

 // Insert the left and the right child to the specific parent
 public void insert(int leftChild, int rightChild, int parIndex)
 {
  myTree[parIndex].li = leftChild;
  myTree[parIndex].ri = rightChild;
 }

 // Check whether node A and B are siblings
 // If yes, check node A is right sibling or left sibling of node B
 // return 0 if they are not siblings
 // return 1 if A is left sibling of B
 // return -1 if A is right sibling of B
 public int isSibling(int nodeA, int nodeB)
 {
  int parent; // the parent index of A and B if they are siblings
  
  // Scan to check whether node A and B have the same parent
  for ( parent = 0; parent < myTree.length; parent++ )
   // If node A is left sibling of B
   if ( (myTree[parent].li == nodeA) && (myTree[parent].ri == nodeB) )    
    return 1;

   // If node A is right sibling of B
   else if ( (myTree[parent].li == nodeB) && (myTree[parent].ri == nodeA) )
    return -1;
  
  return 0;
 }

 // Check whether node A is ancestor of node B
 public boolean isAncestor(int nodeA, int nodeB)
 {
  // if node A is null
  if ( nodeA == -1 )
   return false;

  // If node A is the parent of B
  else if ( (myTree[nodeA].li == nodeB) || (myTree[nodeA].ri == nodeB) )
   return true;
  
  // If A is not a parent of B 
  // check whether if the children of A is the ancestor of B
  else 
  {
   return (isAncestor(myTree[nodeA].li, nodeB) || isAncestor(myTree[nodeA].ri,nodeB));
  }
 }
}
import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner scanner;

    /** Read in the tree
     */
    public static MyTree readTree () 
 {
  // read in one integer
  int n = scanner.nextInt();

  // Creat a new tree with n nodes
  MyTree tree = new MyTree(n);
 
  // loop to read pairs of children
  for ( int i = 0; i < n; i ++ ) 
      tree.insert(scanner.nextInt(), scanner.nextInt(), i);

  return tree; 
    }
    
    /** Read in query statements
     */
    public static int[][] readQueries () 
 {
  // read in one integer
  int m = scanner.nextInt();

  int[][] querry = new int[m][2];

  // loop to read pairs of children for query
  for ( int i = 0; i < m; i ++ ) 
  {
      querry[i][0] = scanner.nextInt();    
      querry[i][1] = scanner.nextInt();     
  }

  return querry;
    }
    
    public static void main(String[] args) 
 {
  scanner = new Scanner(System.in);
  MyTree tree = readTree();            // read in the tree
  int[][] querry = readQueries();     // read in the queries
  int checkSibling;

  // then process the queries
  for ( int i = 0; i < querry.length; i ++ )
  {
   checkSibling = tree.isSibling(querry[i][0], querry[i][1]);
   
   // If the relation is left sibling
   if ( checkSibling == 1 )
   {
    System.out.println("LEFT SIBLING");
   }
   
   // If the relation is right sibling
   else if ( checkSibling == -1 )
   {
    System.out.println("RIGHT SIBLING");
   }

   // If the 2 nodes are not siblings
   // check whether they have ancestor descendant relation 
   else
   {
    // If the relation is ancestor
    if ( tree.isAncestor(querry[i][0], querry[i][1]) )
     System.out.println("ANCESTOR");

    // If the relation is descendant 
    else if ( tree.isAncestor(querry[i][1], querry[i][0] ) )
     System.out.println("DESCENDANT");

    // If they have no relation
    else
     System.out.println("NONE");
   }
  }

    }
}
