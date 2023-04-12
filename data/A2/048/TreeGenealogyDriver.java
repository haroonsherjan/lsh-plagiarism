import java.util.*;



/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
	static Scanner sc;
	static int rightChild;
	static int leftChild;
	static int a;
	static int b;

	public static void readTree () {
		// read in one integer
		int n = sc.nextInt();
		// loop to read pairs of children
		for (int i=0;i<n;i++) {
			rightChild = sc.nextInt();
			leftChild = sc.nextInt();
		}
	}



	public static void readQueries () {
		// read in one integer
		int m = sc.nextInt();
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
			a = sc.nextInt();	
			b = sc.nextInt();	
		}
	}

	public static void main(String[] args) {
		MyTree T = new MyTree();
		MyNode N = new MyNode();
		sc = new Scanner(System.in);
		readTree();				
		readQueries();	

		for (int i=0; i<n; i++) {
			if (rightChild != -1){
				T = N.setValue(rightChild);
			}
			else {
				T = N.setValue(-1);
			}

			if (leftChild != -1) {
				T = N.setValue(leftChild);
			}
			else {
				T = N.setValue(-1);
			}
		}

		for (int i=0; i<m; i++){
		}



	}
}


