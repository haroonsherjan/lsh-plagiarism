import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */

public class CitiesDriver {
    static Scanner sc;
    
    /** Read in the tree
     */
    public static void readTree (MyTree tree) {
	    int n = sc.nextInt();
		int[] temp = new int[1000];
      	for (int i=0;i<n;i++)
    	{
	    	int num = sc.nextInt();
	        temp[i] = num;
    	}
	    tree.setNode(0, 0, temp[0]);
		int tempIndex = 0;
    	for (int i=1;i<2*n;i++) {
    	    int city = sc.nextInt();			  

			if (city != -1)
				tree.setNode(i, city, temp[++tempIndex]);
		    else
				tree.setNode(i, city, -1);
		}
    }
    
    // Read in query statements
    public static void readQueries (MyTree tree) {
    	// read in one integer
    	int m = sc.nextInt();
    	for (int i=0;i<m;i++) {
	    	int start = sc.nextInt();
	    	int end = sc.nextInt();
    		if (tree.safe(start, end))
			{
				System.out.println("YES");
			}
			else
				System.out.println("NO");
    	}   
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	MyTree tree = new MyTree();
	readTree(tree);				   // read in the tree
	readQueries(tree);				// read in the queries
    }
}
