/** Class for a tree node
 */
class MyNode
{
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    private boolean isSafe;				// is the city safe?
										// isSafe = true if city is safe
										// isSafe = false if city is not safe
    private int left;					// left child index in array
    private int right;					// right child index in array

	// Constructors
	public MyNode(boolean safe, int l, int r)
	{
		isSafe = safe;
		left = l;
		right = r;
	} // end constructor

	// Accessors
	public boolean getSafety()
	{
		return isSafe;
	} // end getSafety

	public int getLeft()
	{
		return left;
	} // end getLeft

	public int getRight()
	{
		return right;
	} // end getRight

	// Mutators
	public void setLeft(int l)
	{
		left = l;
	} // end setLeft

	public void setRight(int r)
	{
		right = r;
	} // end setRight
} // end class MyNode

/** Class for a binary tree ADT
 */
public class MyTree
{
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

	// We are given that the root is always at the index 0.

	private final int MAX_NODES = 1000;
	int size = 0;
	MyNode[] myTree;

	// This constructor is used to create the tree.
	public MyTree(int[] safety, int[] left, int[] right)
	{
    	myTree = new MyNode[MAX_NODES];

		int n = safety.length;	// Number of cities

		// For loop to create the tree
		for (int i = 0; i < n; i++)
		{
			boolean safe;

			if (safety[i] == 0)
				safe = false;
			else
				safe = true;

			myTree[i] = new MyNode(safe, left[i], right[i]);
			size++;
		} // end for loop
	} // end constructor
	
	// This method tests whether it is safe to travel from city A to city B and
	// returns true if it is safe and false otherwise.
	// A path from A to B is considered unsafe if any of the nodes in the path
	// (the two terminal cities included) is unsafe.
	// We are given that A and B will not reference non-existing cities.

	public boolean isSafeTravelling(int cityA, int cityB)
	{
		boolean isItSafe = true;	// Used to check whether it is safe to travel
									// from city A to city B
									// True if safe
									// False if not
		
		// If either the starting city or the ending city is unsafe, then the
		// entire journey is unsafe.
		// So, we don't have to go through the entire path to find out safety.
		// We confirm here itself that it is unsafe and return false (UNSAFE).

		if (!myTree[cityA].getSafety() || !myTree[cityB].getSafety())
		{
			isItSafe = false;
			return isItSafe;
		} // end if statement
	
		if (cityA == cityB)
		{
			if (myTree[cityA].getSafety())
				return true;
			else
				return false;
		} // end if

		boolean isSafe1 = traverse(cityA, 0);
		boolean isSafe2 = traverse(cityB, 0);
		
		if (isSafe1 && isSafe2)
			isItSafe = true;
		else
			isItSafe = false;

		return isItSafe;
	} // end isSafeTravelling

	private boolean traverse(int x, int root)
	{
		if (root != -1)
		{
			if (!myTree[root].getSafety() || (x == root && !myTree[x].getSafety()))
				return false;

			boolean value = traverse(x, myTree[root].getLeft());
			if (!value)
				return value;
				
			else
				value = traverse(x, myTree[root].getRight());

			return value;
		} // end if

		return true;
	} // end traverse
} // end class MyTree
