import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    
    /** Read in the tree
     */
  public static void readTree ( MyTree t) {

	// read in one integer
	int n = sc.nextInt();
	
	// read in tree, safety line
    
	int[] s = new int[n];
	for (int i=0;i<n;i++){

	   s[i] = sc.nextInt();   
	   } //store the safety line

	// loop to read pairs of children
	for (int i=0;i<n;i++) {
		int[] a = new int[2];
	    a[0]=sc.nextInt();			   
	    a[1]=sc.nextInt();
      t.addNode(a,s[i]);
		
	} //construct the tree
 }
    
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	MyTree tree = new MyTree();
	readTree(tree);// read in the tree
	int m = sc.nextInt();
	for(int i=0;i<m;i++){
       int a = sc.nextInt();
	   int b = sc.nextInt();
     if(tree.safePath(a,b) == true)
		 System.out.println("YES");
     else
		 System.out.println("NO");
	}
   
    }
}
