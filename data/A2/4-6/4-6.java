public class MyTree {
  private int[] left;
  private int[] right;  
  private int size; 
 

 public MyTree(int a){
  size = a;
  left = new int[a];
  right = new int[a];
 }

 //initializing array
 public void add(int i, int l, int r){
  left[i] = l;
  right[i] = r;
 }

 // return true if a is b's ancestor
 public boolean isAncestor(int a, int b){
   boolean result = false;
  if(left[a] == b || right[a] == b){
   result = true;
  }
  else if(left[a] != -1 && right[a] != -1){
   return isAncestor(left[a], b) || isAncestor(right[a], b);
  }
  else if(right[a] != -1){
   return isAncestor(right[a], b);
  }
  else if(left[a] != -1){
   return isAncestor(left[a], b);
  }
  return result;
 }
 
 //return true if a and b are sibilings
 public boolean isSibling(int a, int b){
  for(int i = 0; i < size; i ++){
   if(left[i] != -1 && right[i] != -1){
    if(left[i] == a && right[i] == b){
     System.out.println("LEFT SIBLING");
     return true;
    }
    else if(left[i] == b && right[i] == a){
     System.out.println("RIGHT SIBLING");
     return true;
    }
   }
  }
  return false;
 }

 //return true if a is b's descendant
 public boolean isDescendant(int a, int b){
  return isAncestor(b, a);
 }
}
import java.util.*;

//
// Driver class, you may have to change it to fit your implementation
// Make sure you compile and run this class
//
public class TreeGenealogyDriver {
    public static void main(String[] args){
      
  Scanner sc = new Scanner (System.in);
  MyTree tree;
  boolean relative;
  int n = sc.nextInt(), a, b;

  //initializing tree
  tree = new MyTree(n);
  for(int i = 0; i < n; i++){
   tree.add(i, sc.nextInt(), sc.nextInt());
  }

  //reading # of queries
  n = sc.nextInt();
  
  //determining the relationship between a and b
  int i=0;
  while (i < n) {
   a = sc.nextInt();
   b = sc.nextInt();
   
   relative = false;
   
   if(tree.isSibling(a,b)) {
    relative = true;
   } else if(tree.isAncestor(a,b)) {
     System.out.println("ANCESTOR");
    relative = true;
   } else if(tree.isDescendant(a,b)) {
    System.out.println("DESCENDANT");
    relative = true;
   } else {
    System.out.println("NONE");
   }
   i++;
  }
 }
}
