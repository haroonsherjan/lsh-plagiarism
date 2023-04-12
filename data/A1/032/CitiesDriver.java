import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {

	//data members
	static Scanner sc;
    MyTree [] PerilousCities; //all cities in the country
	int numCities;

	//constructor
	public CitiesDriver (int num) {
		numCities = num;
		PerilousCities = new MyTree[num];
		
		for (int i=0; i<numCities; i++)
			PerilousCities[i] = new MyTree();
	}
    
	/** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	// read in tree, safety line
	int cities[] = new int [n];
	for (int i=0;i<n;i++) 
	    cities[i] = sc.nextInt();			   // safety values of each city
		//starting from city 0 is stored in the corresponding positions in the array
	
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    sc.nextInt();			   // modify this line
	    sc.nextInt();			   // modify this line
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    sc.nextInt();			   // modify this line
	    sc.nextInt();			   // modify this line
	}
    }
    
    public static void main(String[] args) {
		sc = new Scanner(System.in);
		//readTree();				   // read in the tree
		//readQueries();				// read in the queries
		
		boolean safe;
		int num = sc.nextInt(); //get the number of cities

		int [] noChild = new int [num/2]; //indexes of cities without children
		
		int numNoChild=0; // number of cities with no children

		CitiesDriver cities = new CitiesDriver(num);

		//initialize the attributes of the cities
		for (int i=0; i<num; i++) {
			int leftChild=0, rightChild=0, isSafe=0, left=-1, right=-1;
			isSafe = sc.nextInt();
			if (isSafe == 0)
				safe = false;
				else safe = true;
			cities.PerilousCities[i].setSafety(safe);
			leftChild = sc.nextInt();
			rightChild = sc.nextInt();
			if (leftChild==-1 && rightChild==-1){
				noChild[numNoChild] = i;
				numNoChild++;
			}
			else {
				left = leftChild;
				cities.PerilousCities[left].setParent(i);
				cities.PerilousCities[i].setLeft(left);
				right = rightChild;
				cities.PerilousCities[right].setParent(i);
				cities.PerilousCities[i].setRight(right);
			}
		}

		
	}
	


}
