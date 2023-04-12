/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int[] elem;
    boolean isSafe;				  // is the city safe?
    int lc;			  // left child index in array
    int rc;		 // right child index in array

    public MyNode()
	{
		elem = new int[2];
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
    int size = 0;

	public void setNode(int index, int city, int safe)
	{
		myTree[index].elem[0] = city;
		myTree[index].elem[1] = safe;
		size++;
	}

    // check the route connecting cities is safe
	public boolean safe(int start, int end)
	{
		return true;
		// bascially my concept is to check the level
		// of the starting and ending city. if they are
		// not on the same level, increase the lower level
		// to the higher level, then check whether they are
		// at the same node. If not, continue to move up
		// the level until there are at the same node.
		// Whenever they move from level to level, they will
		// check whether the city is safe or not by looking
		// at elem[1].
	}

	public int calLevel(int index)
	{
		return 0;
		// find the level of respective city
	}

}

