
// MyTree is a binary tree that contains consecutive integers from 0 to N-1 (both inclusive),
// where N is the size of the tree. Due to the very specific nature of MyTree, no array 
// of elements is required. 

public class MyTree {

    // Indices of the following 3 arrays are elements.
    // For example, leftChildOf[i] should be read as "the left child of element (node) 'i'" 

    private int[] leftChildOf;
    private int[] rightChildOf;
    private int[] parentOf;

    private static final int NONE = -1;

    // initialise MyTree with capacity N
    // Due to the very specific nature of MyTree, all elements are known once the capacity is specified.
    // However, the relationship between them is unknown.

    public MyTree (int N) {

        leftChildOf = new int[N];
        rightChildOf = new int[N];
        parentOf = new int[N];

        for (int i = 0; i < N; i++) {
            leftChildOf[i] = rightChildOf[i] = parentOf[i] = NONE;
        }

    }

    // defines the relationship between two nodes
    // contract: element must refer to an exisiting element in MyTree
    //           Both left and right  must either be an existing element in MyTree,
    //           or the constant NONE.

    public void set (int element, int left, int right) {

        leftChildOf[element] = left;
        rightChildOf[element] = right;
        if (left != NONE) parentOf[left] = element;
        if (right != NONE) parentOf[right] = element;

    }

    // contract: A and B must be existing elements in MyTree
    //           relationship returns a String that fills in the blank of
    //           "A is the _____ of B" if there exist a known relationship between them,
    //           and returns the String "NONE" otherwise. 

    public String relationship (int A, int B) {

        if (isAncestor(A,B)) {
            return "ANCESTOR";
        } else if (isAncestor(B,A)) {
            return "DESCENDENT";
        } else if (isSibling(A,B)) {
            int parent = parentOf[A];
            return ( (leftChildOf[parent]==A ? "LEFT" : "RIGHT") + " SIBLING");
        } else {
            return "NONE";
        }

    }

    // contract: A and B must be existing elements in MyTree
    //           isAncestor returns true if A is an ancestor (need not be direct) of B,
    //           and returns false otherwise.

    private boolean isAncestor (int A, int B) {

        for (int curr = parentOf[B]; curr != NONE; curr = parentOf[curr]) {
            if (curr==A) return true;
        }

        return false;

    }

    // contract: A and B must be existing elements in MyTree
    //           isSibling returns true if A is a sibling of B, and false otherwise
    //           For the purpose of this method, every element is treated to be a sibling of itself.

    private boolean isSibling (int A, int B) {

        return parentOf[A] == parentOf[B];

    }

}
