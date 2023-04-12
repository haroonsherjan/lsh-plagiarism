import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;

    public static void readTree (MyTree tree, int n) {
	for (int i=0;i<n;i++) {
		int x = sc.nextInt();
		int y = sc.nextInt();
		tree.myTree[i] = new MyNode(x, y);
		}
    }
    
    public static void readQueries (MyTree tree) {
	int m = sc.nextInt();
	for (int i=0;i<m;i++) {
		int x = sc.nextInt();
		int y = sc.nextInt();
	    tree.check(x,y);
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	int n = sc.nextInt();
	MyTree tree = new MyTree(n);
	readTree(tree, n);
	readQueries(tree);
    }
}
