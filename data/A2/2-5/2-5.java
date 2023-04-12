/** This is the class for a tree node
 */
class MyNode {

    int leftIndex;     // left child index in array
    int rightIndex;   // right child index in array

}

/** Class for a binary tree ADT
 */
public class MyTree {

    MyNode[] myTree;
 
 // Create a tree with specified number of nodes
 public MyTree(int numOfNodes)
 {
  myTree = new MyNode[numOfNodes];

  for ( int i = 0; i < numOfNodes; i ++ )
   myTree[i] = new MyNode();
 }

 // Insert the left and the right child to the specific parent
 public void insert(int left_child, int right_child, int parIn)
 {
  myTree[parIn].leftIndex = left_child;
  myTree[parIn].rightIndex = right_child;
 }

 // Check whether node A and B are siblings
 // If yes, check node A is right sibling or left sibling of node B
 // return 0 if they are not siblings
 // return 1 if A is left sibling of B
 // return -1 if A is right sibling of B
 public int isSibling(int a, int b)
 {
  int parent; // the parent index of A and B if they are siblings
  
  // Scan to check whether node A and B have the same parent
  for ( parent = 0; parent < myTree.length; parent++ )
   // If node A is left sibling of B
   if ( (myTree[parent].leftIndex == a) && (myTree[parent].rightIndex == b) )    
   return 1;

   // If node A is right sibling of B
   else if ( (myTree[parent].leftIndex == b) && (myTree[parent].rightIndex == a) )
   return -1;
  
  return 0;
 }

 // Check whether node A is ancestor of node B
 public boolean isAncestor(int a, int b)
 {
  // if node A is null
  if ( a == -1 )
   return false;

  // If node A is the parent of B
  else if ( (myTree[a].leftIndex == b) || (myTree[a].rightIndex == b) )
  return true;
  
  // If A is not a parent of B check whether if the children of A is the ancestor of B
  else 
  {
   return (isAncestor(myTree[a].leftIndex, b) || isAncestor(myTree[a].rightIndex,b));
  }
 }
}
import java.util.*;


public class TreeGenealogyDriver {
    static Scanner scan;

    /** Read in the tree
     */
    public static MyTree read_tree () 
 {
  // read in one integer
  int n = scan.nextInt();

  // Creat a new tree with n nodes
  MyTree myTree = new MyTree(n);
 
  // loop to read pairs of children
  for ( int i = 0; i < n; i ++ ) 
      myTree.insert(scan.nextInt(), scan.nextInt(), i);

  return myTree; 
    }
    
    /** Read in query statements
     */
    public static int[][] read_Q () 
 {
  // read in one integer
  int m = scan.nextInt();

  int[][] q = new int[m][2];

  // loop to read pairs of children for query
  for ( int i = 0; i < m; i ++ ) 
  {
      q[i][0] = scan.nextInt();    
      q[i][1] = scan.nextInt();     
  }

  return q;
    }
    
    public static void main(String[] args) 
 {
  scan = new Scanner(System.in);
  MyTree myTree = read_tree();            // read in the tree
  int[][] q = read_Q();     // read in the queries
  int siblingChecking;

  // then process the queries
  for ( int i = 0; i < q.length; i ++ )
  {
   siblingChecking = myTree.isSibling(q[i][0], q[i][1]);
   
   // If the relation is left sibling
   if ( siblingChecking == 1 )
   {
    System.out.println("LEFT SIBLING");
   }
   
   // If the relation is right sibling
   else if ( siblingChecking == -1 )
   {
    System.out.println("RIGHT SIBLING");
   }

   // If the 2 nodes are not siblings
   // check whether they have ancestor descendant relation 
   else
   {
    // If the relation is ancestor
    if ( myTree.isAncestor(q[i][0], q[i][1]) )
     System.out.println("ANCESTOR");

    // If the relation is descendant 
    else if ( myTree.isAncestor(q[i][1], q[i][0] ) )
     System.out.println("DESCENDANT");

    // If they have no relation
    else
     System.out.println("NONE");
   }
  }

    }
}
