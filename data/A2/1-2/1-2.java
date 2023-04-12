/*
 * Codes for Tree Node
 *
 *
 **/
class MyNode {

    public int left;			  
    public int right;		 
	public int parent;


	public MyNode() {
		this.left = -1;
		this.right = -1;
		this.parent = -1;
	}
}



public class MyTree {
    private final int MAX_NODES = 2000;
    MyNode[] myTree;
    int size;	

	public MyTree(int numNodes) {
		myTree = new MyNode[numNodes];
		
		for (int i=0;i<numNodes;i++) {
			myTree[i] = new MyNode();
		}
		
		size = numNodes;
	}

	public void add(int label, int left, int right) {
		myTree[label].left = left;
		myTree[label].right = right;
	}

	public void generateParents() {
		for(int i = 0; i< size; i++){
			if (myTree[i].left>0) myTree[myTree[i].left].parent=i;
			if (myTree[i].right>0) myTree[myTree[i].right].parent=i;
		}
		
	}

	public String checkRS(int a, int b) {
		if(isAncestor(a,b)) return "ANCESTOR";
		if(isDescendant(a,b)) return "DESCENDANT";
		if(isLeftSib(a,b)) return "LEFT SIBLING";
		if(isRightSib(a,b)) return "RIGHT SIBLING";
		return "NONE";
	}

	private boolean isLeftSib (int a, int b) {
		return myTree[myTree[a].parent].right == b;
	}

	private boolean isRightSib (int a, int b) {
		return myTree[myTree[a].parent].left == b;
	}

	private boolean isAncestor(int a, int b) {
		int parent = myTree[b].parent;
		while(parent!=-1) {
			if(parent==a) return true;
			parent = myTree[parent].parent;
		}
		return false;
	}

	private boolean isDescendant(int a, int b) {
		return isAncestor(b, a);
	}
}
/*
 * Codes for Tree Genealogy Driver.java
 *
 **/

import java.util.*;

public class TreeGenealogyDriver {
    static Scanner scanner;
	static MyTree myTree;

    public static void readTree () {

		int n = scanner.nextInt();
		myTree = new MyTree(n);
	
		for (int i=0;i<n;i++) {
		    myTree.add(i,scanner.nextInt(), scanner.nextInt());			  
		}
		myTree.generateParents();
    }
    

    public static void readQueries () {
	
		int s = scanner.nextInt();
	
		for (int i=0;i<s;i++) {
		    int x = scanner.nextInt();
		    int y = scanner.nextInt();
			System.out.println(myTree.checkRS(x, y));
		}
    }
    
    public static void main(String[] args) {
		scanner = new Scanner(System.in);
		readTree();				   
		readQueries();			
    }
}
