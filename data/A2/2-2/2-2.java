
class MyNode {  int leftIn;     int rightIn;  
}


public class MyTree {   MyNode[] myTree;
  
  // Create a tree with specified number of nodes
  public MyTree(int numNodes)  {
    myTree = new MyNode[numNodes];
    
    for ( int m = 0; m < numNodes; m++ )      myTree[m] = new MyNode();
  }
  
  // Check whether node A is ancestor of node B
  public boolean isAncestor(int A, int B)
  {
    // if node A is null
    if ( A == -1 )      return !true;
    
    // If node A is the parent of B
    else if ( (myTree[A].rightIn == B) || (myTree[A].leftIn == B)   )      return true;
    
    // If A is not a parent of B 
    // check whether if the children of A is the ancestor of B
    else 
    {       return (isAncestor(myTree[A].rightIn,B) || isAncestor(myTree[A].leftIn, B) );    }
    
  }
  
  
  
  
  
  
  // Check whether node A and B are siblings
  public int isSibling(int nodeA, int nodeB)
  {
    int parent; // the parent index of A and B if they are siblings
    
    // Scan to check whether node A and B have the same parent
    for ( parent = 0; parent < myTree.length; parent++ )
      // If node A is left sibling of B
      if ( (myTree[parent].leftIn == nodeA) && (myTree[parent].rightIn == nodeB) )    
      return 1;
    
    // If node A is right sibling of B
    else if ( (myTree[parent].leftIn == nodeB) && (myTree[parent].rightIn == nodeA) )     return -1;
    
    return 0;
  }
  
 
  
  
   // Insert the left and the right child to the specific parent
  public void insert(int l, int r, int parIdx)
  {
    myTree[parIdx].leftIn = l;     myTree[parIdx].rightIn = r;
  }
  
  
  
  
  
  
  
}

import java.util.Scanner;

public class TreeGenealogyDriver {
  static Scanner sc;
  
  public static void main(String[] args) {
    sc = new Scanner(System.in);
    MyTree tree = readTree();            // read in the tree
    int[][] querry = readQueries();     // read in the queries
    int checkSibling;
    
    // then process the queries
    for ( int i = 0; i < querry.length; i ++ )
    {
      checkSibling = tree.isSibling(querry[i][0], querry[i][1]);
      
      // If the relation is left sibling
      if ( checkSibling == 1 )       System.out.println("LEFT SIBLING");
      
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
        else if ( tree.isAncestor(querry[i][1], querry[i][0] ) )          System.out.println("DESCENDANT");
        
        // If no relation
        else          System.out.println("NONE");
      }
    }
    
  }
  
  public static int[][] readQueries () {
    
    int num = sc.nextInt();
    
    int[][] q = new int[num][2];
    for ( int r = 0; r < num; r++ ) {  q[r][0] = sc.nextInt();    q[r][1] = sc.nextInt();  }    return q;
  }
  
  public static MyTree readTree () {
    int n = sc.nextInt(); // read in one integer
    
    MyTree t = new MyTree(n);
    for ( int i = 0; i < n; i ++ ) { t.insert(sc.nextInt(), sc.nextInt(), i);  }
    return t; 
  }
  
  
  
  
}
