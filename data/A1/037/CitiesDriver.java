import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    static MyTree cities = new MyTree();
    /** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	cities.setSize(n);
    
	// read in tree, safety line
	for (int i=0;i<n;i++){ 
		cities.setNode(i,new MyNode());
	    int safe = sc.nextInt();
		if (safe == 1){
			cities.setSafe(i,true);
		}
		else if(safe == 0){
			cities.setSafe(i,false);
		}
		// modify this line
	}
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    int left = sc.nextInt();			   // modify this line
	    int right = sc.nextInt();              // modify this line
		cities.setChild(i,left,right);
	}
    } // end readTree
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    int start = sc.nextInt();			   // modify this line
	    int end = sc.nextInt();			   // modify this line
		boolean isSafe = checkSafe(start, end);
		if(isSafe)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
    } // end readQueries
    
	public static boolean checkSafe(int start, int end){
	
		int start1 = start; // record the initial start city
		int end1 = end; // record the initial end city
		while(start != 0){
			if(!(cities.getNode(start).getSafe())){ // visited city is not safe
				return false;
				
			}
			if(start == end1)  // find a safe path from start to end
				return true;
			start = cities.findAn(start);
		}
	
		while(end != 0){
			if(!(cities.getNode(end).getSafe())) // visited city is not safe
				return false;
			if(end == start1){  // find a safe path from end to start
				return true;
		}
			end = cities.findAn(end);
		}
		
		if(start == 0 && end == 0) {
			if (!(cities.getNode(0).getSafe())) // when start and end are 0 and city 0 is not safe
				return false;
		}
		return true;
	}
	

    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
