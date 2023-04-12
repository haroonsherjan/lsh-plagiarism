import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    
    public static void main(String[] args) {
	int numNodes; // no of nodes
	MyTree tree = new MyTree(new MyNode(0)); // creating a tree with one node
	Scanner sc = new Scanner(System.in);

	numNodes = sc.nextInt();
	MyNode curr = tree.getRoot();

	//inserting nodes into the tree
	for(int i=0; i<numNodes; i++){
		int A = sc.nextInt();
		int B = sc.nextInt();
		tree.insertLeft(curr, new MyNode(A));
		tree.insertRight(curr, new MyNode(B));
	}
	int numQueries = sc.nextInt();
	for(int i=0; i<numQueries; i++){
		//read in data to compare relationship
		int A = sc.nextInt();
		int B = sc.nextInt();
		MyNode AA = tree.search(A, tree.getRoot());
		MyNode BB = tree.search(B, tree.getRoot());
		

		//compare AA and BB to see how they are related
		if (AA != null && BB != null){
			//if AA is an ancestor of BB
			if (BB.getParent() == AA){
				System.out.println("ANCESTOR");
			}
			//if AA && BB are siblings
			else if (AA.getParent() == BB.getParent()) {
				}
		}
	}
	}
}
