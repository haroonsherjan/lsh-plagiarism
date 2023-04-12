import java.util.*;

public class CitiesDriver{

 public static boolean[] citySafe;
 public static int[] cityP;
 
 public static void main(String[] args){
 
  // Read the number of cities and set safe or not...
  Scanner sc = new Scanner(System.in);
  int noOfCities = sc.nextInt();
  citySafe = new boolean[noOfCities];
  for (int i = 0; i < noOfCities; i++){
   if (sc.nextInt() != 1)
    citySafe[i] = false;
   else
    citySafe[i] = true;
  }
  
  // Set the parent city of a city
  cityP = new int[noOfCities];
  for (int i = 0; i < noOfCities; i++){
   cityP[i] = -1;
  }
  for (int i = 0; i < noOfCities; i++){
   int left = sc.nextInt();
   int right = sc.nextInt();
   if (left != -1)
    cityP[left] = i;
   if (right != -1)
    cityP[right] = i;
  }
  
  // Solve each query
  int totalQuery = sc.nextInt();
  for (int i = 1; i <= totalQuery; i++){
   int start = sc.nextInt();
   int end = sc.nextInt();
   if (!SolveQuery(start, end))
    System.out.println("NO");
   else
    System.out.println("YES");
  }
 }
 // Solve a Query, return if and only if there is a safe path from start to end (inclusive) or end to start (inclusive), by going to the parent city
 public static boolean ssSolveQuery(int start, int end){
  if (start == -1 || end == -1) return false;
  if (!citySafe[start] || !citySafe[end]) return false;
  if (start == end) return true;
  if (SolveQuery(cityP[start], cityP[end]) || SolveQuery(start, cityP[end]) || SolveQuery(cityP[start], end)) return true;
  
  return false;
 }
 
 // Solve a Query, return if and only if there is a safe path from start to end (inclusive) or end to start (inclusive), by going to the parent city
 public static boolean SolveQuery(int start, int end){
  if (start != -1 && end != -1) ; else return false;
  if (citySafe[start] && citySafe[end]) ; else return false;
  if (start != end) ; else return true;
  if (!SolveQuery(cityP[start], cityP[end]) && !SolveQuery(start, cityP[end]) && !SolveQuery(cityP[start], end)) ; else return true;
  
  return false;
 }
 
}