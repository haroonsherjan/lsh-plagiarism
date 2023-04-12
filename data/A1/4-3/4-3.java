import java.util.*;

public class CitiesDriver{

	public static boolean[] isCitySafe;
	public static int[] parentCity;
	
	public static void main(String[] args){
	
		// Read the number of cities and set safe or not...
		Scanner sc = new Scanner(System.in);
		int totalCities = sc.nextInt();
		isCitySafe = new boolean[totalCities];
		for (int i = 0; i < totalCities; i++){
			if (sc.nextInt() == 1)
				isCitySafe[i] = true;
			else
				isCitySafe[i] = false;
		}
		
		// Set the parent city of a city
		parentCity = new int[totalCities];
		for (int i = 0; i < totalCities; i++){
			parentCity[i] = -1;
		}
		for (int i = 0; i < totalCities; i++){
			int leftNode = sc.nextInt();
			int rightNode = sc.nextInt();
			if (leftNode != -1)
				parentCity[leftNode] = i;
			if (rightNode != -1)
				parentCity[rightNode] = i;
		}
		
		// Solve each query
		int totalQuery = sc.nextInt();
		for (int i = 0; i < totalQuery; i++){
			int start = sc.nextInt();
			int end = sc.nextInt();
			if (checkRoute(start, end))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	
	// Solve a Query, return if and only if there is a safe path from start to end (inclusive) or end to start (inclusive), by going to the parent city
	public static boolean checkRoute(int from, int to){
		if (from == -1 || to == -1) return false;
		if (!isCitySafe[from] || !isCitySafe[to]) return false;
		if (from == to) return true;
		if (checkRoute(parentCity[from], parentCity[to]) || checkRoute(from, parentCity[to]) || checkRoute(parentCity[from], to)) return true;
		
		return false;
	}
	
}