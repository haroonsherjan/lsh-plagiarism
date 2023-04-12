import java.util.Scanner;

public class CitiesDriver {
	static Scanner sc;
    /*
    public static void readTree () {
		// Read in the tree
		// read in one integer
		int n = sc.nextInt();
		// read in tree, safety line
		for (int i=0;i<n;i++) 
		    sc.nextInt();			   // modify this line
	
		// loop to read pairs of children
		for (int i=0;i<n;i++) {
		    sc.nextInt();			   // modify this line
		   	sc.nextInt();			   // modify this line
		}
    }
    
    public static void readQueries () {
		// read in one integer
		int m = sc.nextInt();
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
		    sc.nextInt();			   // modify this line
	   		sc.nextInt();			   // modify this line
		}
    }*/
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);

		MyTree mt = new MyTree();
		// Read in the tree
		int n = sc.nextInt();
		// read in tree, safety line
		int temp = 0;
		for (int i=0;i<n;i++) {
			temp = sc.nextInt();
			System.out.println("checked");
			if(temp == 0) mt.myTree[i].setSafety(false);
			if(temp == 1) mt.myTree[i].setSafety(true);
		}
	
		// loop to read pairs of children
		for (int i=0;i<n;i++) {
			if(i == 0) {
				mt.myTree[i].setValue(0);
				//mt.size = 0;
			}

		    int tempLeft = sc.nextInt();
		   	int tempRight = sc.nextInt();

			if(tempLeft != -1) {
				mt.myTree[i].setLeft(tempLeft);
			}
			if(tempRight != -1) {
				mt.myTree[i].setRight(tempRight);
			}
			if((tempLeft != -1 || tempRight != -1) && (i > 0)) {
				mt.myTree[i].setValue(mt.myTree[i - 1].getValue());
			}
		}
		/*
		for(int i = 0; i < n; i++) {
			System.out.println("Value = " + mt.myTree[i].getValue());
			System.out.println("Left = " + mt.myTree[i].getLeft());
			System.out.println("Right = " + mt.myTree[i].getRight());
			System.out.println("****************************");
		}*/

		// Read in query statements
		int m = sc.nextInt();
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
		    sc.nextInt();
	   		sc.nextInt();
		}
    }
}
