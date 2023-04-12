import java.util.*;

public class CitiesDriver
{
    static MyTree tree;
    static Scanner sc;    
    public static void readTree ()   // Read in the tree
    {
		int t = sc.nextInt(); // read in one integer
        tree = new MyTree (t);// read in safety line
		for (int i = 0; i < t; i++) {
	    	tree.setSafe(i,sc.nextInt());
		}	
		for (int i = 0; i < t; i++) {
	    	tree.setNode(i,sc.nextInt(),sc.nextInt());
		}
    }
        
    public static void readQueries ()  // Read in query statements
	{
		int m = sc.nextInt(); // read in number
		for (int i=0;i<m;i++) { //read pairs of children
	    	if (tree.findpath(sc.nextInt(),sc.nextInt()))
				System.out.println("YES");
			else System.out.println("NO");
		}
    }
    
    public static void main(String[] args) {
		sc = new Scanner(System.in);
		readTree();				   // read in the tree
		readQueries();				// read in the queries
    }

}
class MyNode {

    boolean isSafe;//city safety
    int left;	   // left child id
    int right;	   // right child id

    public MyNode ()
    {
		left = -1;
		right = -1;
        isSafe = true;
	}

	public boolean isSafe ()
    {
		return isSafe;
	}
	public int right ()
    {
		return right;
	}
	public int left ()
    {
		return left;
	}



	public void setSafe (int in) {
		if (in == 1)
            {isSafe = true;}
        else if (in == 0)
            {isSafe = false;}
	}

	public void setRight (int in) {
		right = in;
	}
	public void setLeft (int in) {
		left = in;
	}
}


public class MyTree {
    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;

	public MyTree (int in) {
		size = in;
		for (int i = 0; i < in; i++) {
			myTree[i] = new MyNode ();
		}
	}

	public void setSafe (int id, int stat) {
		myTree[id].setSafe(stat);
	}

	public void setNode (int id, int l, int r) {
		myTree[id].setRight(r);
        myTree[id].setLeft(l);
	}

	public void print () {
		print(myTree,0);
	}

	public boolean findpath (int fr, int to) {
		if (!(myTree[fr].isSafe() && myTree[to].isSafe())) {
			return false;
		}
		if (fr == to) return true;

		if (directPath(fr,to)) return true;

		if (directPath(to,fr)) return true;

		if (directPath(0,fr) && directPath(0,to)) return true;

		return false;
	}

	public boolean directPath (int id, int target) {
		if (id >= 0) {
			if (!myTree[id].isSafe()) return false;
			else {
				if (id == target) return true;

				if (directPath(myTree[id].left(),target)) return true;
				else return directPath(myTree[id].right(),target);
			}
		}
		return false;
	}

	public boolean search (int id, int target) {

		if (id >= 0) {
			if (id == target) return true;

			if (search(myTree[id].left(),target)) return false;
			else return search(myTree[id].right(),target);
		}
		return false;
	}

	public void print (MyNode[] tree, int id) {
		
		if (id >= 0) {
			print(tree,tree[id].left());

			System.out.print(id);
			if (!tree[id].isSafe()) System.out.print("*");
			System.out.print(" ");

			print(tree,tree[id].right());
		}

	}

}
