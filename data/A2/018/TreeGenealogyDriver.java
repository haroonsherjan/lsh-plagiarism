import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    
    public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);

	  // read in the tree
	  int n = sc.nextInt();
	  MyTree tree = new MyTree(n);
	  //loop to read pairs of children
	  for(int i=0;i<n;i++)
		  tree.addNode(i,sc.nextInt(),sc.nextInt());
		  //add a tree node into the array myTree
		  //left child and then right child
	 
	 // read in the queries
     int m = sc.nextInt();
	 for(int i=0;i<m;i++)
		 System.out.println(tree.test(sc.nextInt(),sc.nextInt()));
		 //left child first and then right child
	 }
}
