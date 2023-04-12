/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    private int leftChildIndex;			  // left child index in array
    private int rightChildIndex;		 // right child index in array
    private int myValue;

    // fill in your accessor and mutator methods here
    // ...
    public void setLeftChildIndex(int anIndex)
    {
      leftChildIndex = anIndex;
    }

    public void setRightChildIndex(int anIndex)
    {
      rightChildIndex = anIndex;
    }

    public void setMyValue(int aValue)
    {
      myValue = aValue;
    }

    public int getLeftChildIndex()
    {
      return leftChildIndex;
    }

    public int getRightChildIndex()
    {
      return rightChildIndex;
    }

    public int getMyValue()
    {
      return myValue;
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

    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed

    // fill in your ADT methods here
    public MyTree()
    {
      size = 0;
    }

    public void addNode(MyNode aNode)
    {
      myTree[size] = aNode;
      size++;
    }

    public String getRelationship(int a, int b)
    {
      //check ancestor
      if (isAncestor(a,b))
        return("ANCESTOR");
      //check descendant
      if (isDescendant(a,b))
        return("DESCENDANT");
      //check left sibling
      if (isLeftSibling(a,b))
        return("LEFT SIBLING");
      // check right sibling
      if (isRightSibling(a,b))
        return ("RIGHT SIBLING");

      // no relationship found
      return "NONE";
    }

    public boolean traverseTree(int anIndex, int b)
    {
      if (myTree[anIndex].getMyValue() == b)
        return true;
      if (myTree[anIndex].getLeftChildIndex() == -1 && myTree[anIndex].getRightChildIndex() == -1)
      {
        // no more children
        return false;
      }
      else
      {
        if (myTree[anIndex].getLeftChildIndex() != -1 && myTree[anIndex].getRightChildIndex() == -1)
        {
          // no right child
          return traverseTree(myTree[anIndex].getLeftChildIndex(), b);
        }
        else
        if (myTree[anIndex].getLeftChildIndex() == -1 && myTree[anIndex].getRightChildIndex() != -1)
        {
          // no left child
          return traverseTree(myTree[anIndex].getRightChildIndex(), b);
        }
        else
        {
          // have left and right child
          //if (traverseTree(myTree[an]))
        }
      }
      return false;
    }

    public boolean isAncestor(int a, int b)
    {
      int indexOfA = 0;
      for (int i = 0; i < size; i++)
      {
        if (myTree[i].getMyValue() == a)
          indexOfA = i;
      }
      
      return false;
    }

    public boolean isDescendant(int a, int b)
    {
      return false;
    }

    public boolean isLeftSibling(int a, int b)
    {
      return false;
    }

    public boolean isRightSibling(int a, int b)
    {
      return false;
    }
}
