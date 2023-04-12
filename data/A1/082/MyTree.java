/** Class for a tree node
 */
class MyNode
{
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	
	public MyNode(int safetyIndex, int leftChild, int rightChild)
	{
		isSafe = (safetyIndex == 1);
		leftChildIndex = leftChild;
		rightChildIndex = rightChild;
	}

	public boolean isSafe()
	{
		return isSafe;
	}

	public int getLeft()
	{
		return leftChildIndex;
	}

	public void setLeft(int left)
	{
		leftChildIndex = left;
	}

	public int getRight()
	{
		return rightChildIndex;
	}

	public void setRight(int right)
	{
		rightChildIndex = right;
	}
}

/** Class for a binary tree ADT
 */
public class MyTree
{
    private final int MAX_NODES = 1000;
    MyNode[] myTree;
    int size;	// make sure to update this variable as needed
	int free;

	public MyTree()
	{
		myTree = new MyNode[MAX_NODES];
		size = 0;
		free = 0;
	}

	public int size()
	{
		return size;
	}

	private boolean hasFreeSlot()
	{
		return (free == MAX_NODES);
	}

	public void addCity(int cityIndex, int cityStatus, int leftCity, int rightCity)
	{
		if (hasFreeSlot())
		{
			MyNode city = new MyNode(cityStatus, leftCity, rightCity);
			myTree[cityIndex] = city;
			size++;
		}
		//System.out.println(city.isSafe());
		//System.out.println(cityStatus + "," + leftCity +","+ rightCity);
	}
 
	public boolean checkRoute(int startCity, int endCity)
	{
		MyNode startPt = null;
		MyNode endPt = null;

		if (startCity == 0 && endCity == 0)
		{
			return myTree[0].isSafe();
		}
		else
		{
			if (startCity >= 0)
			{	
				startPt = myTree[startCity];
				
				if (!startPt.isSafe())
				{
					return false;
				}
			}

			if (endCity >= 0)
			{
				endPt = myTree[endCity];

				if (!endPt.isSafe())
				{
					return false;
				}
			}

			if (startCity == endCity)
			{
				return startPt.isSafe();
			}
			else
			{
				return checkRoute((startCity / 2) - 1, (endCity / 2) - 1);
			}
		}
	}
}
