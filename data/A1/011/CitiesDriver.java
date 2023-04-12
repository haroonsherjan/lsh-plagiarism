import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {

    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
   		MyTree cities = new MyTree();
    
		int n = sc.nextInt();

		for (int i=0;i<n;i++) {
	   		cities.add(i, sc.nextInt());     
		}	

		// loop to read pairs of children
		for (int i=0;i<n;i++) {
	 		cities.updateChildren(i, sc.nextInt(), sc.nextInt());			   
		}

        cities.updateParents();
	
		int m = sc.nextInt();
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
		   boolean safe = cities.determinSafety(sc.nextInt(), sc.nextInt());
		   if(safe == true) {

			   System.out.println("YES");
		   }

		   else {

			   System.out.println("NO");
		   }
		}


	// then process the queries ... fill in your calls below
    }
}
