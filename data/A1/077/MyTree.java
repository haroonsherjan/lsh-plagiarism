/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;      // is the city safe?
    int leftChild;     // left child index in array
    int rightChild;   // right child index in array
    
    public MyNode(int safe)
    {
      if(safe == 0)
      {
        isSafe = false;
      }
      else if(safe == 1)
      {
        isSafe = true;
      }
    }
    
    public void setLeft(int left)
    {
      leftChild = left;
    }
    
    public void setRight(int right)
    {
      rightChild = right;
    }
    
    public boolean getSafe()
    {
      return isSafe;
    }

	public int getLeft()
	{
		return leftChild;
	}

	public int getRight()
	{
		return rightChild;
	}

    // fill in your accessor and mutator methods here
    // ...
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
    int size = 0; // make sure to update this variable as needed
    
    public MyTree()
    {
      ;
    }
    
    public void setSafe(int safe)
    {
      myTree[size] = new MyNode(safe);
      
      size++;
    }

	public void resetSize()
	{
		size = 0;
	}
    
    public void setChildren(int left, int right)
    {  
      myTree[size].setLeft(left);
      
      myTree[size].setRight(right);

	  size++;
    }
    
    public void checkSafe(int start, int end)
    {
      if(start == end)
      {
        if(myTree[start].getSafe() == true)
        {
          System.out.println("YES");
        }
        else
        {
          System.out.println("NO");
        }
      }
      else
      {
        if(myTree[start].getSafe() == false | myTree[end].getSafe() == false)
        {
          System.out.println("NO");
        }
        else
		{
			;
		}
      }
    }

	private int findStart(int end)
	{
		int returned = -1;

		for(int i = 0; i < size; i++)
		{
			if(myTree[i].getLeft() == end | myTree[i].getRight() == end)
			{
				returned = i;
			}
		}

		return returned;
	}
}
