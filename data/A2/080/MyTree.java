/** Class for a tree node}

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
	public MyTree()
	{
		myTree[0] = MyNode(0, -1, -1);
		size++;
	}
	public void insert(int left, int right)
	{
			myTree[size-1].setLeft(size);
			myTree[size].setNum(left);
			myTree[size-1].setRight(size+1);
			myTree[size+1].setNum(right);
			size += 2;
	}
			
	public int index(int i)//find the true position in the array (those with value -1 are not considered true elements)
	{
		int count = 0;
		for(int k = i; k >= 0; k--)
		{
			if(MyTree[index] != -1)
			{
				count++;
			}
		}
		return count;
	}
	public String relation(int i1, int i2)//find the two elements in the array (those with value -1 are also considered true elements)
	{
		int count1 = 0;
		int count2 = 0;
		while(MyTree[count1] != i1)
		{
			count1++;
		}
		while(MyTree[count2] != i2)
		{
			count2++;
		}
		return "relation";
	}




	//************************************************************
	class MyNode
	{
	    private int index;
		private int left;
		private int right;
		public MyNode(int i)
		{
			index = i;
			left = -1;
			right = -1;
		}
		public MyNode(int i, int l, int r)
		{
			index = i;
			left = l;
			right = r;
		}
		public int getIndex()
		{
			return index;
		}
		public int getLeft()
		{
			return left;
		}
		public int getRight()
		{
			return right;
		}
		public void setIndex(int i)
		{
			index = i;
		}
		public void setLeft(int i)
		{
			left = i;
		}
		public void setRight(int i)
		{
			right = i;
		}


	}


}
