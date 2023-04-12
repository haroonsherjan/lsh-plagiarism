public class MyTree {
 
  private int size; 
 private int[] left;
 private int[] right;

 public MyTree(int n){
  size = n;
  left = new int[n];
  right = new int[n];
 }//end constructor

 //initialize the left and right array
 public void add(int index, int l, int r){
  left[index] = l;
  right[index] = r;
 }//end add

 //check whether a and b are siblings, 
 //if so, print the result and return true.
 
 public boolean Sibling(int a, int b){
  for(int i = 0; i < size; i ++){
   if(left[i] != -1 && right[i] != -1){
     
    if(left[i] == a && right[i] == b){
     System.out.println("LEFT SIBLING");
     return true;
    }
    else if(left[i] == b && right[i] == a){
     System.out.println("RIGHT SIBLING");
     return true;
    }//end if
   }//end if
  }//end for
  return false;
 }//end checkSibling

 //check whether a is b's ancestor,
 //if so, return true
 public boolean Ancestor(int a, int b){
  if(left[a] == b || right[a] == b){
   return true;
  }
  else if(left[a] != -1 && right[a] != -1){
   return Ancestor(left[a], b) || Ancestor(right[a], b);
  }
  else if(left[a] != -1){
   return Ancestor(left[a], b);
  }
  else if(right[a] != -1){
   return Ancestor(right[a], b);
  }
  else{
   return false;
  }//end if
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
  boolean relative;

  //initialize the tree
  tree = new MyTree(n);
  for(int i = 0; i < n; i ++){
   tree.add(i, sc.nextInt(), sc.nextInt());
  }//end for

  //read the number of queries
  n = sc.nextInt();
  //determine the relationship of a and b
  for(int i = 0; i < n; i ++){
   a = sc.nextInt();
   b = sc.nextInt();
   relative = false;
   
   if(tree.Sibling(a,b)){
    relative = true;
   }
   else if(tree.Ancestor(a,b)){
    System.out.println("ANCESTOR");
    relative = true;
   }
     else if(tree.Ancestor(b,a)){
    System.out.println("DESCENDANT");
    relative = true;
   }
 else
 {
  System.out.println("NONE");
 }

  }//end for
 }//end main
}//end TreeGenealogyDriver
