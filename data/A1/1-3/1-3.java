import java.util.*;

public class CitiesDriver {
	static Scanner scanner;
	static MyTree tree;

	/** Read in the tree which contain the path of the cities
	 */
	public static void buildRoute() {
		// Read in the tree
		// Read in size of the tree
		int numOfCities = scanner.nextInt();
		tree = new MyTree(numOfCities);			//Create MyTree with n nodes

		// read in tree which is the cities that i going to travel, safety line
		for (int i=0;i<numOfCities;i++){
			int safe = scanner.nextInt();
			//Update the path to be safe
			tree.updateSafety(i, safe);
		}

		// loop to read pairs of children
		for (int i=0;i<numOfCities;i++) {
			int left = scanner.nextInt();
			int right = scanner.nextInt();
			tree.updateNode(i,left,right);
		}
	}

	/** Read in query statements which will check the route to and through the cities
	 */
	public static void enquireSafeRoutes() {
		// read in one integer
		int m = scanner.nextInt();
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			//check the path, if the path is safe, print yes if not print no
			if (tree.isPathSafe(start,end)==true)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		buildRoute();				   // read in the tree
		enquireSafeRoutes();			   // read in the queries
	}
}
/* 
Class for a tree node
*/

import java.util.*;
class MyNode {
    boolean isSafe;				  // is the city safe?
    int leftChild;			  // left child index in array
    int rightChild;		 // right child index in array
	int parent;

	public int getLeft(){
		return leftChild;
	}
	public int getRight(){
		return rightChild;
	}
	public int getParent(){
		return parent;
	}
	public boolean getIsSafe(){
		return isSafe;
	}
	public void setIsSafe(boolean safe){
		isSafe = safe;
	}
	public void setLeft(int left){
		leftChild = left;
	}
	public void setRight(int right){
		rightChild = right;
	}
	public void setParent(int parent){
		this.parent = parent;
	}
}




public class MyTree {
    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;
	int root = 0;
	LinkedList <Integer> q;			//Queue for BFS

	public MyTree(int n){
		for (int i = 0; i < n; i++)
			myTree[i] = new MyNode();
		size = n;
	}

	public void updateSafety(int node, int safe){
		myTree[node].setIsSafe(safe == 1);
	}

	public void updateNode(int node, int left, int right){
		myTree[node].setLeft(left);
		myTree[node].setRight(right);
		if (left != -1)
			myTree[left].setParent(node);
		if (right != -1)
			myTree[right].setParent(node);
	}


	public boolean isPathSafe(int start, int end){
		int[] pre = new int[size];				
		boolean[] visited = new boolean[size];	
		q = new LinkedList <Integer>();

		//Check if the start city is safe
		q.offer(new Integer(start));
		visited[start] = true;
		while (q.size()!=0){
			int u = q.poll();
			if (u == end)
				break;
			int left = myTree[u].getLeft();
			int right = myTree[u].getRight();
			int parent = myTree[u].getParent();
			if (left != -1 && visited[left] == false){
				visited[left] = true;
				q.offer(new Integer(left));
				pre[left] = u;
			}
			if (right != -1 && visited[right] == false){
				visited[right] = true;
				q.offer(new Integer(right));
				pre[right] = u;
			}
			if (parent != -1 && visited[parent] == false){
				visited[parent] = true;
				q.offer(new Integer(parent));
				pre[parent] = u;
			}
		}
		int curnode = end;
		
		boolean isSafe = myTree[start].getIsSafe();
		while (curnode != start){
			isSafe = myTree[curnode].getIsSafe() && isSafe;
			curnode = pre[curnode];
		}
		return isSafe;
	}
}
