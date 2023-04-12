import java.util.*;

   
public class CitiesDriver{ 
 public static void main(String[] args){
   
     boolean[] safeCity;
     int[] parentCity;

  //
  // Set if city is safe
  //
  Scanner scan = new Scanner(System.in); 
  int totalCities = scan.nextInt();
  safeCity = new boolean[totalCities];
  
  int j=0;
  while (j < totalCities){
   if (scan.nextInt()==1)
    safeCity[j] = true;
   else
    safeCity[j] = false;
   
   j++;
  }
  
  // Set city of parent
  parentCity = new int[totalCities];
  for (int i = 0; i < totalCities; i++){
   parentCity[i] = -1;
  }
  for (int i = 0; i < totalCities; i++){
   int left = scan.nextInt();
   int right = scan.nextInt();
   if (left != -1)
    parentCity[left] = i;
   if (right != -1)
    parentCity[right] = i;
  }
  
  //
  // Resolve query
  //
  int totalQuery = scan.nextInt();
  for (int i = 0; i < totalQuery; i++){
   int start = scan.nextInt();
   int end = scan.nextInt();
   if (SolveQuery(start, end, parentCity, safeCity))
    System.out.println("YES");
   else
    System.out.println("NO");
  }
 }
 
 //
 // return true when there is a safe path
 //
 public static boolean SolveQuery(int start, int end, int[] parentCity, boolean[] safeCity){
  if (start == -1 || end == -1) return false;
  if (!safeCity[start] || !safeCity[end]) return false;
  if (start == end) return true;
  if (SolveQuery(parentCity[start], parentCity[end], parentCity,safeCity) || SolveQuery(start, parentCity[end],parentCity,safeCity) || SolveQuery(parentCity[start], end,parentCity,safeCity)) return true;
  
  return false;
 }
 
}