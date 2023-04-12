import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    //create all the array lists for storing all the input read
	static int [] cities;
	static int [] leftChild;
	static int [] rightChild;
	static int [] departCities;
	static int [] arriveCities;
	//initialize a Mytree instance
	static MyTree tree = new MyTree();

    /** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	// read in tree, safety line
	
	cities = new int [n];
	//read in the cities
	for (int i=0;i<n;i++) { 
	    cities[i] = sc.nextInt();
	}// modify this line
	
	// loop to read pairs of children
	leftChild = new int [n];
	rightChild = new int [n];
	for (int i=0;i<n;i++) {
	    leftChild [i] = sc.nextInt();			   // modify this line
	    rightChild [i] = sc.nextInt();			   // modify this line
	}
	
	//insert all the cities with their data into the mytree;
	// datas are like if they are safe or not, then its left city and right city
	for (int i =0; i < n; i++){
		tree.insert(cities[i], leftChild[i], rightChild[i]);
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query

	departCities = new int [m];
	arriveCities = new int [m];
	for (int i=0;i<m;i++) {
	    departCities [i] = sc.nextInt();			   // modify this line
	    arriveCities [i] = sc.nextInt();			   // modify this line
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries
	
	int numOfQueries = departCities.length;
	for (int i =0; i < numOfQueries ; i ++){
		boolean isSafe = tree.queries(departCities[i], arriveCities[i]);
		if (isSafe) {
			System.out.println("YES");
		} else System.out.println("NO");
	}
	// then process the queries ... fill in your calls below
    }
}
