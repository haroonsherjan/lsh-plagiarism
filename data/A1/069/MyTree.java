/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int left;			  // left child index in array
    int right;		 // right child index in array
	
	public MyNode(boolean isSafe, int left, int right)
	{
		this.isSafe = isSafe;
		this.left = left;
		this.right = right;
	}//end constructor

    // fill in your accessor and mutator methods here
    // ...
	public boolean getSafe()
	{
		return isSafe;
	}

	public int getLeft()
	{
		return leftChildIndex;
	}

	public int getRight()
	{
		return rightChildIndex;
	}

	public void setSafe(boolean safe)
	{
		isSafe = safe;
	}

	public void setLeft(int leftChild)
	{
		left = leftChild;
	}

	public void setRight(int rightChild)
	{
		right = rightChild;
	}
	//end all accessor and mutator methods
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
    // ...
	public void insert(boolean isSafe, int left, int right)
	{
		myTree[size] = new MyNode(isSafe, left, right);
		size++;
	}//end insert

	public int[] searchPath(int a) //this method searches the path to city a from the root
	{
		int[] path = new int[size+1];//the last element records the length of the array
		path[size] = 0
		path[0] = a;
		int j = 1;
		for (int i = 0; i < size; i++)
		{
			if(myTree[i].getLeft() == a || myTree[i].getRight() == a)
			{
				path[j] = i;
				j++;
				path[size]++;
				if(i == 0)
				{
					break;
				}//end if
			}//end if
		}//end for
		return path;
	}//end method searchPath

	public int[] correctPath(int[] a, int[] b)
	{
		int[] cPath = new int[size+1];
		int connectA = 0;
		int connectB = 0;
		if (a[0] == b[0])
		{
			cPath[0] = a[0];
			cPath[size] = 1;
			return cPath;
		}//end if

		int count = 0;
		aEnd = a[size];
		bEnd = b[size];
		while (a[aEnd - 1 - count] == b[bEnd - 1 - count])
		{
			count++;
			if(a[aEnd - 1 - count] != b[bEnd - 1 - count]
			{
				connectA = aEnd - count;
				connectB = bEnd - count;
			}//end if
		}//end while
		System.arraycopy(a, 0, cPath, 0, connectA + 1);
		int j = connectA + 1;
		for (int i = connectB - 1; i >= 0; i--)
		{
			cPath[j] = b[i];
			j++;
		}
		cPath[size] = connectA + 1 + connectB
		return cPath;
	}//end method correctPath

	public boolean checkPath(int[] a)
	{
		
		for(int i = 0; i < a[size]; i++)
		{
			if(myTree[cPath[i]].getSafe == false)
			{
				return false;
			}
		}
		return true;
	}//end checkPath
}//end class





}
