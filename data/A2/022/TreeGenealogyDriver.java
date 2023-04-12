import java.util.*;

public class TreeGenealogyDriver {
    static Scanner sc;
    static MyTree tree = new MyTree();  //construct a tree
    /** Read in the tree*/
    public static void readTree () {	
	   int n = sc.nextInt();	
       for (int i = 0; i < n; i++) {
	       tree.insert(sc.nextInt());	
	       tree.insert(sc.nextInt());			 
	   }
    }
    
    /** Read in query statements*/
    public static void readQueries () {
	    int m = sc.nextInt();
		int temp1, temp2;
	    for (int i = 0; i < m; i++) {
	        temp1 = sc.nextInt();	   
	        temp2 = sc.nextInt();
			System.out.println(tree.getRelationship(temp1, temp2));  //call function to get the result and output
	    }
    }
    
    public static void main(String[] args) {
	    sc = new Scanner(System.in);
	    readTree();				   // read in the tree
	    readQueries();				// read in the queries
    }
}
