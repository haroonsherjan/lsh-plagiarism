import java.util.*;

public class CitiesDriver {
  static Scanner sc;
  static MyTree tree;
  
  public static void readTree () {
    int n = sc.nextInt();
    tree = new MyTree(n);
    for (int i=0;i<n;i++){ 
      int safe = sc.nextInt();
      
      if (safe == 1) {
        tree.setIsSafe(i, true);
      }
      else {
        tree.setIsSafe(i, false);
      }
    }
    for (int i=0;i<n;i++) {
      int left = sc.nextInt();
      int right = sc.nextInt();
      tree.updateNode(i,left,right);
    }
  }
  
  public static void readQueries () {
    
    int m = sc.nextInt();
    for (int i=0; i < m; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      if (tree.isPathSafe(start,end)==true)
        System.out.println("YES");
      else
        System.out.println("NO");
    }
  }
  
  public static void main(String[] args) {
    sc = new Scanner(System.in);
    readTree();
    readQueries();
  }
}import java.util.*;
class MyNode {
  boolean isSafe;        
  int leftChildIndex;    
  int rightChildIndex;    
  int parentIndex;
  
  //Setter getter
  public void setIsSafe(boolean safe){
    isSafe = safe;
  }
  public void setLeftNode(int left){
    leftChildIndex = left;
  }
  public void setRightNode(int right){
    rightChildIndex = right;
  }
  public void setParentNode(int parent){
    parentIndex = parent;
  }
  public int getLeftNode(){
    return leftChildIndex;
  }
  public int getRightNode(){
    return rightChildIndex;
  }
  public int getParentNode(){
    return parentIndex;
  }
  public boolean getIsSafe(){
    return isSafe;
  }
}

public class MyTree {
  
  private final int MAX_NODES = 1000;
  MyNode[] myTree = new MyNode[MAX_NODES];
  int size = 0;
  int root = 0;
  LinkedList <Integer> q;
  
  public MyTree(int n){
    for (int i = 0; i < n; i++) {
      myTree[i] = new MyNode();
    }      
    size = n;
  }
  
  public void setIsSafe(int node, boolean safe) {
    myTree[node].setIsSafe(safe);
  }
  
  public void updateNode(int node, int left, int right){
    myTree[node].setLeftNode(left);
    myTree[node].setRightNode(right);
    if (left != -1)
      myTree[left].setParentNode(node);
    if (right != -1)
      myTree[right].setParentNode(node);
  }
  
  public boolean isPathSafe(int start, int end){
    int[] pre = new int[size];    
    boolean[] visited = new boolean[size];
    q = new LinkedList <Integer>();
    
    q.offer(new Integer(start));
    visited[start] = true;
    while (q.size()!=0){
      int u = q.poll();
      if (u == end)
        break;
      int left = myTree[u].getLeftNode();
      int right = myTree[u].getRightNode();
      int parent = myTree[u].getParentNode();
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