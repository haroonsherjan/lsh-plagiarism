public class MyTree {
  private int numberOfNode; 
  private int[] leftChild;
  private int[] rightChild;
  
  public MyTree(int n){
    numberOfNode = n;
    leftChild = new int[n];
    rightChild = new int[n];
  }//end constructor
  
  //initialize the leftChild and rightChild array
  public void add(int index, int l, int r){
    leftChild[index] = l;
    rightChild[index] = r;
  }//end add
  
  //check whether a and b are siblings, 
  public boolean checkSibling(int a, int b){
    for(int i = 0; i < numberOfNode; i ++){
      if(!(leftChild[i] == -1 || rightChild[i] == -1)){
        if(!(leftChild[i] != a || rightChild[i] != b)){
          System.out.println("LEFT SIBLING"); // is leftChild sibling!
          return true;
        }
        
        else if(leftChild[i] == b && rightChild[i] == a){
          System.out.println("RIGHT SIBLING"); // is rightChild sibling!
          return true;
        }//end if
      }//end if
    }//end for
    return false;
  }//end checkSibling
  
    //check whether a is b's descendant
  public boolean checkDescendant(int a, int b){
    return checkAncestor(b, a);
  }//end checkDescendant

  //check whether a is b's ancestor,
  public boolean checkAncestor(int a, int b){
    if(leftChild[a] == b || rightChild[a] == b){
      return true;
    }
    else if(leftChild[a] != -1 && rightChild[a] != -1){
      return checkAncestor(leftChild[a], b) || checkAncestor(rightChild[a], b);
    }
    else if(leftChild[a] != -1){
      return checkAncestor(leftChild[a], b);
    }
    else if(rightChild[a] != -1){
      return checkAncestor(rightChild[a], b);
    }
    
    return false;
  }//end checkAncestor
}//end MyTree

import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
  
  public static void main(String[] args){
    Scanner sc = new Scanner (System.in);
    MyTree tree;
    int n = sc.nextInt();
    int a, b;  //pair of nodes
    
    //initialize the tree
    tree = new MyTree(n);
    
    for(int i = 0; i < n; i ++){
      tree.add(i, sc.nextInt(), sc.nextInt());
    }//end for
    
    //read the number of queries
    n = sc.nextInt();
    
    //determine the relationship of a and b
    for(int j = 0; j < n; j++){
      a = sc.nextInt();
      b = sc.nextInt();
      
      if(tree.checkSibling(a,b)){
        continue;
      }
      
      else if(tree.checkAncestor(a,b)){
        System.out.println("ANCESTOR");
        continue;
      }
      
      else if(tree.checkDescendant(a,b)){
        System.out.println("DESCENDANT");
        continue;
      }//end if
      
      System.out.println("NONE");
      
    }//end for
    
  }//end main
  
}//end TreeGenealogyDriver
