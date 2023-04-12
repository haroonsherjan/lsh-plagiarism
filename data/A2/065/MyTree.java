/** Class for a tree node
 */
class MyNode {
	// You may use this class if you'd like.  It may help you if you use
	// an array based implementation of a binary tree

	// you can add other variables if you'd like
	int leftChildIndex;			  // left child index in array
	int rightChildIndex;		 // right child index in array

	// fill in your accessor and mutator methods here
	// ...

	public MyNode(int i, int j)
	{
		leftChildIndex = i;
		rightChildIndex = j;
	}

	public int getLeft()
	{
		return leftChildIndex;
	}

	public int getRight()
	{
		return rightChildIndex;
	}

	public void setLeft(int i)
	{
		leftChildIndex = i;
	}

	public void setRight(int i)
	{
		rightChildIndex = i;
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
	int[] store;
	int index = 0;
	//	store[index] = 0; //set 0 as the root of the tree
	//	index++;

	public MyTree()
	{
	}



	// fill in your ADT methods here
	// ...



	public void insert(int i, int loc)
	{
		//		if(store[0] == -1)
		//		{
		//			store[0] = 0;
		//			index++;
		//			System.out.println("if");
		//		}
		//		else
		//		{
		//			store[index] = i;
		//			this.index++;
		//			System.out.println("else");
		//		}




		if(myTree[0] == null)
		{
			myTree[0] = 0; 
		}
		else
		{ 
			//add a new node with left and right child
			myTree[size] = new MyNode(i, j);
			//increase the size for next one
			size++;
		}


	}


		public void checkRelation(int i, int j)
		{
			//go through all the value in the array and find the index of the 2 values needed
			int indexI;
			int indexJ;

			for(int n: myTree)
			{
				if(store[n] == i)
				{
					indexI = n;
				}
				else if(store[n] == j)
				{
					indexJ = n;
				}
			}

			//left [(2*i) + 2]
			//right [(2*i) + 1]
			//parent [(i-1) / 2]


			

			int leftIndex = getLeft();
			int rightIndex = getRight();
			
			if(leftIndex == my)
			{
				
			}

		}

	}
