import java.util.*;

/** Class for a binary tree ADT
 */
public class MyTree 
{
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.
	
    private final int MAX_NODES = 1000;
    Integer myTree[] = new Integer[MAX_NODES];
    int size = 0;	

	// set the number of nodes...
	public void setSize(int x)
	{
		size = x;
	}
	
	// method to read in the nodes...
	public void setNode(Scanner sc)
	{
		// initialize the whole array to -1 first... 
		for (int x=0;x<MAX_NODES;x++)
			myTree[x] = -1;
		
		// 0 will always be the root
		myTree[0] = 0;
		int tempIndex;
		
		
		// populate the rest of the arrays
		for (int x=0;x<size;x++)
		{
			tempIndex = findNode(x);
			myTree[tempIndex*2+1] = sc.nextInt();
			myTree[tempIndex*2+2] = sc.nextInt();
		}
	}
	
	// method to check the relationship
	public String checkNode(int src,int trg)
	{
		String result = "NONE";

		// find the position of the source node
		int srcIndex = findNode(src);
		
		// check if any of the child is the target node
		if ((myTree[srcIndex*2+1]==trg || myTree[srcIndex*2+2]==trg))
			result = "ANCESTOR";

		// since java string constants have the same address
		// we'll check if the source node is NOT root and that
		// result's value hasn't been changed
		else if (result=="NONE" && srcIndex!=0)
		{
			// check if the parent is the target node
			if (myTree[(srcIndex-1)/2]==trg)
				result = "DESCENDANT";
			else
			{
				// determine whether the node is a left or right node
				// odd = left, even = right
				switch (srcIndex%2)
				{
					case 0:	// even, srcnode is a right node
					{
						if (myTree[srcIndex-1]==trg)
							result = "RIGHT SIBLING";
						break;
					}
					case 1:	// odd, srcnode is a left node
					{
						if (myTree[srcIndex+1]==trg)
							result = "LEFT SIBLING";
						break;
					}
				} // end switch
			} // end else
		} // end if(result=="NONE" && srcIndex!=0) 

		return result;
	}
	
	// method to find the position of the node in the array
	private int findNode(int element)
	{
		int nodeIndex = -1;
		for (int x=0;x<size*2;x++)
		{
			if (myTree[x]==element)
				nodeIndex = x;
		}
		return nodeIndex;
	}
}
