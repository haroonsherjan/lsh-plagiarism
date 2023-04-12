import java.util.*;

/**
 * Driver class
 * 
 */
public class CitiesDriver {
    static Scanner sc;
	static MyTree map;
    
    /** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	map = new MyTree(n);
	for (int i=0;i<n;i++) {
	    map.insertIsSafe(i,sc.nextInt());
	}
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    map.insertLeft(i,sc.nextInt());			 
	    map.insertRight(i,sc.nextInt());			  
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    int from = sc.nextInt();			   
	    int to = sc.nextInt();
		if (!map.isSafe(to)) {
			System.out.println("NO");
		}
		if (map.travelFor(from, to) != -1) {
			if (map.travelFor(from, to) == 1) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		else if (map.travelBack(from, to) != -1) {
			if (map.travelBack(from, to) == 1) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		else {
			if (map.travelBack(to, from) == 1) {
				System.out.print("YES");
			}
			else {
				System.out.print("NO");
			}
		}
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

    }
}
