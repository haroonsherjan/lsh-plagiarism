public class MyTree {
    private int size; 
 private int[] left;
 private int[] right;

 public MyTree(int n){
  size = n;
  right = new int[n];
  left = new int[n];
 }//end constructor

 //initialize the left and right array
 public void addSome(int index, int l, int r){
  right[index] = r;
  left[index] = l;
 }//end add

 //check whether a and b are siblings, 
 //if so, print the result and return true.
 public boolean checkSibling(int a, int b){
  for(int i = size-1; i >= 0; i --){
   if(left[i] == -1 || right[i] == -1) ;
   else {
    if(left[i] != a && right[i] != b && left[i] == b && right[i] == a){
     System.out.println("RIGHT SIBLING");
     return true;
    }
    else if(left[i] == a && right[i] == b){
     System.out.println("LEFT SIBLING");
     return true;
    }//end if
   }//end if
  }//end for
  return false;
 }//end checkSibling

 //check whether a is b's ancestor,
 //if so, return true
 public boolean checkAncestor(int a, int b){
  if(left[a] == b || right[a] == b){
   return true;
  }
  else if(left[a] != -1 && right[a] != -1){
   return checkAncestor(left[a], b) || checkAncestor(right[a], b);
  }
  else if(left[a] != -1){
   return checkAncestor(left[a], b);
  }
  else if(right[a] != -1){
   return checkAncestor(right[a], b);
  }
  else{
   return false;
  }//end if
 }//end checkAncestor

 //check whether a is b's descendant
 //if so, return true
 public boolean checkDescendant(int a, int b){
  //checkDescendant is just the reverse of checkAncestor
  return !checkAncestor(b, a);
 }//end checkDescendant
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
   tree.addSome(i, sc.nextInt(), sc.nextInt());
  }//end for

  //read the number of queries
  n = sc.nextInt();
  //determine the relationship of a and b
  for(int i = 0; i < n; i ++){
   a = sc.nextInt();
   b = sc.nextInt();
   relative = true;
   if(tree.checkSibling(a,b)){
    relative = false;
   }
   else if(!tree.checkDescendant(a,b)){
    System.out.println("DESCENDANT");
    relative = false;
   }
   else if(tree.checkAncestor(a,b)){
    System.out.println("ANCESTOR");
    relative = false;
   }//end if
   if(relative){
    System.out.println("NONE");
   }//end if
  }//end for
 }//end main
}//end TreeGenealogyDriver
