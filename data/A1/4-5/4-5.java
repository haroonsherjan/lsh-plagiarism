import java.util.*;

public class CitiesDriver{

 public static boolean[] safe;
 public static int[] parent;
 
 public static void main(String[] args){
 
  // Read the number of cities and set safe or not...
  Scanner sc = new Scanner(System.in);
  
  int total = sc.nextInt();
  safe = new boolean[total];
  
  for (int i = 0; i < total; i++){
   
    if (sc.nextInt() == 1)
    safe[i] = true;
   else
    safe[i] = false;
  }
  
  // Set the parent city of a city
  parent = new int[total];
  for (int i = 0; i < total; i++){
   parent[i] = -1;
  }
  for (int i = 0; i < total; i++){
   int left = sc.nextInt();
   int right = sc.nextInt();
   if (left != -1)
       parent[left] = i;
      if (right != -1)
      parent[right] = i;
   
  }
  
  // Solve each query
  int totalQuery = sc.nextInt();
  
  for (int i = 0; i < totalQuery; i++){
   int start = sc.nextInt();
   int end = sc.nextInt();
   if (Query(start, end))
    System.out.println("YES");
   else
    System.out.println("NO");
  }
 }
 
 // Solve a Query, return if and only if there is a safe path from start to end (inclusive) or end to start (inclusive), by going to the parent city
 public static boolean Query(int start, int end){
  if ((start == -1 || end == -1) || (!safe[start] || !safe[end])) return false;
  if ((start == end) || (Query(parent[start], parent[end]) || Query(start, parent[end]) || Query(parent[start], end))) return true;
  
  return false;
 }
 
}