import java.util.*;

public class CitiesDriver{
  
  public static boolean[] cityIsSafe;
  public static int[] parentCity;
  
  public static void main(String[] args){
    
    // Read the number of cities and set safe or not...
    Scanner sc = new Scanner(System.in);
    int numberOfCities = sc.nextInt();
    cityIsSafe = new boolean[numberOfCities];
    
    for (int i = 0; i < numberOfCities; i++){
      if (sc.nextInt() == 0)
        cityIsSafe[i] = false;
      else
        cityIsSafe[i] = true;
    }
    
    // Set the parent city of a city
    parentCity = new int[numberOfCities];
    
    for (int i = 0; i < numberOfCities; i++){
      parentCity[i] = -1;
    }
    
    for (int i = 0; i < numberOfCities; i++){
      int leftChild = sc.nextInt();
      int rightChild = sc.nextInt();
      if (leftChild != -1)
        parentCity[leftChild] = i;
      if (rightChild != -1)
        parentCity[rightChild] = i;
    }
    
    // Solve each query
    int numberOfQueries = sc.nextInt();
    for (int i = 0; i < numberOfQueries; i++){
      int start = sc.nextInt();
      int end = sc.nextInt();
      if (CanTraverse(start, end))
        System.out.println("YES");
      else
        System.out.println("NO");
    }
  }
  
  // Solve a Query, return if and only if there is a safe path from start to end (inclusive) or end to start (inclusive), by going to the parent city
  public static boolean CanTraverse(int start, int end){
    if (start == -1 || end == -1 || !(cityIsSafe[start] && cityIsSafe[end])) 
      return false;

    if (start == end || CanTraverse(parentCity[start], parentCity[end]) || CanTraverse(start, parentCity[end]) || CanTraverse(parentCity[start], end))
      return true;

    
    return false;
  }
  
}