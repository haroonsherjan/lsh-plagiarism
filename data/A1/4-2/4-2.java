import java.util.*;

public class CitiesDriver{

 public static boolean[] sfC;
 public static int[] pC;
 public static Scanner sc;
 public static int aCs;
 public static void main(String[] args){
 
  sc = new Scanner(System.in);
  aCs = sc.nextInt();
  sfC = new boolean[aCs];
  for (int i = 0; i < aCs; i++){ if (sc.nextInt() == 1) sfC[i] = true; else sfC[i] = false;}
  
  traceTree();
  
  int totalQuery = sc.nextInt();
  for (int i = 0; i < totalQuery; i++){
   int start = sc.nextInt(); int end = sc.nextInt();
   if (SolveQuery(start, end)) System.out.println("YES"); else System.out.println("NO");
  }
 }
 
 public static void traceTree() {
  pC = new int[aCs];
  for (int i = 0; i < aCs; i++) pC[i] = -1;
  for (int m = 0; m < aCs; m++){
   int lt = sc.nextInt(); int rt = sc.nextInt();
   if (lt != -1) pC[lt] = m;
   if (rt != -1) pC[rt] = m;
  } 
 }
 
 public static boolean SolveQuery(int start, int end){
  if (start == -1 || end == -1) return false;
  if (!sfC[start] || !sfC[end]) return false;
  if (start == end) return true;
  if (SolveQuery(pC[start], pC[end]) || SolveQuery(start, pC[end]) || SolveQuery(pC[start], end)) return true;
  
  return false;
 }
 
}