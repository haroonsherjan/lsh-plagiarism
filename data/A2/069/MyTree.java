/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    private int leftChildIndex;			  // left child index in array
    private int rightChildIndex;		  // right child index in array
    private int ancestorIndex;            //ancestor index in array

    public MyNode(int left, int right, int ancestor) {
        leftChildIndex = left;
        rightChildIndex = right;
        ancestorIndex = ancestor;
    }

    //method returns the right child index
    public int getRight() {
        return rightChildIndex;
    }

    //method returns the left child index
    public int getLeft() {
        return leftChildIndex;
    }

    //method return the ancestor index
    public int getAncestor() {
        return ancestorIndex;
    }

}

/** Class for a binary tree ADT
 */
public class MyTree {

    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed

    public void addNode(int leftIndex, int rightIndex, int ancestorIndex) {
        myTree[size++] = new MyNode(leftIndex, rightIndex, ancestorIndex);
    }

    //method prints the relationship between node A and node B
    public void getRelationship(int nodeA, int nodeB) {  

        //since each element in myTree contains the index of its children
        if (myTree[nodeA].getRight() == nodeB || myTree[nodeA].getLeft() == nodeB){
            System.out.println("ANCESTOR");
            return;
        } 
        else {
            int ancestor = myTree[nodeA].getAncestor();
            //since each element in myTree contains the index of its left and right child
            if (myTree[ancestor].getLeft() == nodeA && myTree[ancestor].getRight() == nodeB) {
                System.out.println("LEFT SIBLING");
                return;
            }
            else if(myTree[ancestor].getLeft() == nodeB && myTree[ancestor].getRight() == nodeA) {
                System.out.println("RIGHT SIBLING");
                return;
            }
            else if(myTree[nodeA].getAncestor() == nodeB) {
                System.out.println("DESCENDANT");
                return;
            }
            else {
                System.out.println("NONE");
                return;
            }
        }
    }




}
