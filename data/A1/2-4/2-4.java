
import java.util.*;

/**
 * Driver class
 */
public class CitiesDriver {

    static MyTree T;
    static Scanner sc;

    // Read in the tree
    public static void readTree() {

        // Read in the tree
        // read in one integer
        int n = sc.nextInt();

        T = new MyTree(n);

        // read in tree, safety line
        for (int i = 0; i < n; i++) {
            T.setSafe(i, sc.nextInt());
        }

        // loop to read pairs of children
        for (int i = 0; i < n; i++) {
            T.setNode(i, sc.nextInt(), sc.nextInt());
        }

    //tree.print();

    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        readTree();				   // read in the tree
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            if (T.findpath(sc.nextInt(), sc.nextInt())) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

/** Class for a tree node
 */
class MyNode {

    boolean isSafe;				  // is the city safe?
    int lChild;			  // left child index in array
    int rChild;		 // right child index in array

    public MyNode() {
        isSafe = true;
        lChild = -1;
        rChild = -1;
    }

    public int getLChild() {
        return lChild;
    }

    public int getRChild() {
        return rChild;
    }

    public boolean isSafe() {
        return isSafe;
    }

    public void setLChild(int index) {
        lChild = index;
    }

    public void setRChild(int index) {
        rChild = index;
    }

    public void setIsSafe(int n) {
        if (n == 0) {
            isSafe = false;
        } else if (n == 1) {
            isSafe = true;
        }
    }
}

/** Class for a binary tree ADT
 */
public class MyTree {

    private final int MAXN = 1000;
    MyNode[] myTree = new MyNode[MAXN];
    int size = 0;

    public MyTree(int n) {
        size = n;
        for (int i = 0; i < n; i++) {
            myTree[i] = new MyNode();
        }
    }

    public void setSafe(int index, int status) {
        myTree[index].setIsSafe(status);
    }

    public void setNode(int index, int left, int right) {
        myTree[index].setLChild(left);
        myTree[index].setRChild(right);
    }

    public void print() {
        print(myTree, 0);
    }

    public boolean findpath(int from, int to) {
        if (!myTree[from].isSafe() || !myTree[to].isSafe()) {
            return false;
        }

        if (from == to) {
            return true;
        }

        if (directPath(from, to)) {
            return true;
        }

        if (directPath(to, from)) {
            return true;
        }

        if (directPath(0, from) && directPath(0, to)) {
            return true;
        }

        return false;
    }

    public boolean directPath(int index, int target) {
        if (index < 0) {
            return false;
        }
        
        if (!myTree[index].isSafe()) {
            return false;
        } else {
            if (index == target) {
                return true;
            }

            if (directPath(myTree[index].getLChild(), target)) {
                return true;
            } else {
                return directPath(myTree[index].getRChild(), target);
            }
        }
    }

    public boolean search(int index, int target) {
        if (index < 0) {
            return false;
        }
        if (index == target) {
            return true;
        }

        if (search(myTree[index].getLChild(), target)) {
            return false;
        } else {
            return search(myTree[index].getRChild(), target);
        }


    }

    public void print(MyNode[] tree, int index) {
        if (index < 0) {
            return;
        }

        print(tree, tree[index].getLChild());

        System.out.print(index);
        if (!tree[index].isSafe()) {
            System.out.print("*");
        }
        System.out.print(" ");

        print(tree, tree[index].getRChild());

    }
}
