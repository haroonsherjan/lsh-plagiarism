/** Class for a tree node
 */
class MyNode {

    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	int nextInsertIndex = 1;

	int[] myNode = new int[1000];
	myNode[0] = 0;
}


/** Class for a binary tree ADT
 */
public class MyTree {
   
    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;
   
	for(int i=0; i<n; i++)
	{
   		 myTree[i] = myNode[i];
	}
}
