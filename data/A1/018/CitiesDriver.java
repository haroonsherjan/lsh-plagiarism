import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    
    /** Read in the tree
     */
    public static void readTree () {

	int n = sc.nextInt();
	// read in tree, safety line

	int [] safety = new int[n];
	int count = 0;

	int inputLine = sc.nextLine();

	while(count < safety.length){
		int input = inputLine.nextInt();
		safety[count] = input;
		count++;
	}

	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    int a = sc.nextInt();			   // modify this line
	    int b = sc.nextInt();			   // modify this line
		tree.insert(a, b);
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();

	for (int i=0;i<m;i++) {
	    sc.nextInt();			   // modify this line
	    sc.nextInt();			   // modify this line
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below

    }
}
