import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    
    public static void main(String[] args){
    /** Read in the tree
     */
     Scanner sc = new Scanner(System.in);
	// read in one integer
	int n = sc.nextInt();
	MyTree fam = new MyTree(n);
   
	// loop to read pairs of children
   	for (int i=0;i<n;i++) {
		fam.myTree[i].leftChildIndex = sc.nextInt();			   // modify this line
	    fam.myTree[i].rightChildIndex =  sc.nextInt();			   // modify this line
   	}
    
     /** Read in query statements
     */
   
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
    for (int i=0;i<m;i++) {
	     int a = sc.nextInt();			   // modify this line
	     int b = sc.nextInt();
	     fam.check(a,b);
   }
}
}
