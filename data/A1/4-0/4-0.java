import java.util.*;

public class CitiesDriver{

	public static boolean[] safeCity;
	public static int[] parentCity;
	
	public static void main(String[] args){
	
		// Read the number of cities and set safe or not...
		Scanner sc = new Scanner(System.in);
		int totalCities = sc.nextInt();
		safeCity = new boolean[totalCities];
		for (int i = 0; i < totalCities; i++){
			if (sc.nextInt() == 1)
				safeCity[i] = true;
			else
				safeCity[i] = false;
		}
		
		// Set the parent city of a city
		parentCity = new int[totalCities];
		for (int i = 0; i < totalCities; i++){
			parentCity[i] = -1;
		}
		for (int i = 0; i < totalCities; i++){
			int left = sc.nextInt();
			int right = sc.nextInt();
			if (left != -1)
				parentCity[left] = i;
			if (right != -1)
				parentCity[right] = i;
		}
		
		// Solve each query
		int totalQuery = sc.nextInt();
		for (int i = 0; i < totalQuery; i++){
			int start = sc.nextInt();
			int end = sc.nextInt();
			if (SolveQuery(start, end))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	
	// Solve a Query, return if and only if there is a safe path from start to end (inclusive) or end to start (inclusive), by going to the parent city
	public static boolean SolveQuery(int start, int end){
		if (start == -1 || end == -1) return false;
		if (!safeCity[start] || !safeCity[end]) return false;
		if (start == end) return true;
		if (SolveQuery(parentCity[start], parentCity[end]) || SolveQuery(start, parentCity[end]) || SolveQuery(parentCity[start], end)) return true;
		
		return false;
	}
	
}