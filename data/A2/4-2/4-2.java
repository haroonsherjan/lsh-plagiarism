public class MyTree {
 private int size; 
 private int[] lt;
 private int[] rt;

 public MyTree(int n){ size = n; lt = new int[n]; rt = new int[n]; }

 public void add(int index, int l, int r){ lt[index] = l; rt[index] = r; }
 public boolean ckAn(int a, int b){
  if(lt[a] == b || rt[a] == b) return true;
  else if(lt[a] != -1 && rt[a] != -1) return ckAn(lt[a], b) || ckAn(rt[a], b);
  else if(lt[a] != -1) return ckAn(lt[a], b);
  else if(rt[a] != -1) return ckAn(rt[a], b);
  else return false;
 }
 public boolean ckDs(int a, int b){ return ckAn(b, a); }
 public boolean ckSb(int node1, int node2){
  for(int k = 1; k <= size; k++){
   if(lt[k-1] != -1 && rt[k-1] != -1){
    if(lt[k-1] == node1 && rt[k-1] == node2){
     System.out.println("LEFT SIBLING");
     return true;
    }
    else if(rt[k-1] == node1 && lt[k-1] == node2){
     System.out.println("RIGHT SIBLING");
     return true;
  }}}
  return false;
 }}
import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    public static void main(String[] args){
  Scanner sc = new Scanner (System.in);
  int a, b, rel, n = sc.nextInt();
  MyTree tree = new MyTree(n);
  for(int i = 0; i < n; i ++) tree.add(i, sc.nextInt(), sc.nextInt());
  n = sc.nextInt();
  for(int i = 0; i < n; i ++){
   rel = 1; a = sc.nextInt(); b = sc.nextInt();
   if(tree.ckSb(a,b)) rel = 2;
   else if(tree.ckDs(a,b)){System.out.println("DESCENDANT");rel = 2;}
   else if(tree.ckAn(a,b)){System.out.println("ANCESTOR");rel = 2;}
   if(rel == 1) System.out.println("NONE");
}}}
