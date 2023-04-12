import java.util.*;

public class TreeGenealogyDriver {
    static Scanner sc;
	static MyTree myTree;

    public static void readTree () {
		int N = sc.nextInt();
		LinkedList <Integer> myList = new LinkedList <Integer>();
		int left = -1;
		int right = -1;

		myTree = new MyTree(N);
		myList.add(0);

		for (int i = 0; i < N; i++) {

	    	left = sc.nextInt();
	    	right = sc.nextInt();

			int index = myList.removeFirst();
			myTree.setNode(index, left, right);

			if (left != -1) myList.add(left);
			if (right != -1) myList.add(right);
		}
    }

    public static void readQueries () {

		int M = sc.nextInt();

		if (M > 100) M = 100;

		for (int i=0;i<M;i++) {
	    	int a = sc.nextInt();
	    	int b = sc.nextInt();

			System.out.println(myTree.getRelation(a, b));
		}
    }
    
    public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		readTree();
		readQueries();
    }
}
