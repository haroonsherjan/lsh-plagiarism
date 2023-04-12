import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    
    public static void main(String[] args) {
        MyTree tree;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree = new MyTree(n);   //Create MyTree with n nodes
        // read in tree, safety line
        for (int i=n;i>0;i--){ 
            int safe = sc.nextInt();
            tree.updateSafety(n-i, safe);
        }
        
        // loop to read pairs of children
        for (int i=n;i>0;i--) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            tree.updateNode(left,right,n-i);
        }
        
        int start, end, number;
        
        // read in one integer
        number = sc.nextInt();
        
        // loop to read pairs of children for query
        for (int i=number;i>0;i--) {
            start = sc.nextInt();
            end = sc.nextInt();
            if (tree.isPathSafe(start,end)==true)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        
    }
}
/* 
 Class for a tree node
 */

import java.util.*;
class MyNode {
    boolean isSafe;      // is the city safe?
    int leftChildIndex, rightChildIndex, parentIndex;     // left child index in array
    
    //All the accessors and mutators
    //Boring stuff
    public int getLeft(){
        return leftChildIndex;
    }
    public int getRight(){
        return rightChildIndex;
    }
    public int getParent(){
        return parentIndex;
    }
    public boolean getIsSafe(){
        return isSafe;
    }
    public void setIsSafe(boolean safe){
        isSafe = safe;
    }
    public void setLeft(int left){
        leftChildIndex = left;
    }
    public void setRight(int right){
        rightChildIndex = right;
    }
    public void setParent(int parent){
        parentIndex = parent;
    }
}

/** Class for a binary tree ADT
  */
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation
    
    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.
   
    MyNode[] myTree ;
    int size = 0;
    int root = 0;
    LinkedList <Integer> queue;   //Queue for BFS
    
    /*
     Fill up the tree with the nodes and set the size of the tree
     Even more boring stuff
     */
    public MyTree(int n){
        myTree = new MyNode[n];
        for (int i = n; i > 0; i--)
            myTree[n-i] = new MyNode();
        size = n;
    }
    public void updateNode(int left, int right, int node){
        myTree[node].setLeft(left);
        myTree[node].setRight(right);
        if (right != -1)
            myTree[right].setParent(node);
        if (left != -1)
            myTree[left].setParent(node);
    }
    public void updateSafety(int node, int safe){
        myTree[node].setIsSafe(safe == 1);
    }
    
    public boolean isPathSafe(int start, int end){
        int[] pre = new int[size];    //Stores who is the pre of the current node in the path
        boolean[] visited = new boolean[size]; //To store whether the particular node is visited
        queue = new LinkedList <Integer>();
        
        //Start of BFS
        queue.offer(new Integer(start));
        visited[start] = true;
        while (queue.size()!=0){
            int u = queue.poll();
            if (u == end)
                break;
            int left = myTree[u].getLeft();
            int parent = myTree[u].getParent();
            int right = myTree[u].getRight();
            if (left != -1 && visited[left] == false){
                visited[left] = true;
                queue.offer(new Integer(left));
                pre[left] = u;
            }
            if (parent != -1 && visited[parent] == false){
                visited[parent] = true;
                queue.offer(new Integer(parent));
                pre[parent] = u;
            }
            if (right != -1 && visited[right] == false){
                visited[right] = true;
                queue.offer(new Integer(right));
                pre[right] = u;
            }
        }
        int curnode = end;
        //If the path is safe, then logical and of all the nodes in the path will yield whether the path is safe
        boolean isSafe = myTree[start].getIsSafe();
        while (curnode != start){
            isSafe = myTree[curnode].getIsSafe() && isSafe;
            curnode = pre[curnode];
        }
        return isSafe;
    }
}
