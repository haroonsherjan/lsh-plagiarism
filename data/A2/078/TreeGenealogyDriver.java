import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);

	MyTree myTree = new MyTree();
	
	// read in the tree
	int n = sc.nextInt();
	for (int i=0; i<n; i++) {
		int left = sc.nextInt();
		int right = sc.nextInt();
		myTree.insertNode(i,left,right);
	}
	
	// read in the queries
	int m = sc.nextInt();
	for (int j=0; j<m; j++) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		myTree.checkRelationship(a,b);
	}
    }
}
