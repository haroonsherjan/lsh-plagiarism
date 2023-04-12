/** Class for a tree node
 */
class MyNode 
{    
    boolean isSafe;
	int value;
	MyNode parent = null;
    MyNode leftChild = null;
    MyNode rightChild = null;
	
	public MyNode(int val, int safety)
	{
		value = val;
		if (safety == 1)
		{
			isSafe = true;
		}
		else
		{
			isSafe = false;
		}
	}
	/*public addLeftChild(int val, int safety)
	{
		leftChild = new MyNode(val, safety);
		leftChild.parent = this;
	}
	public addRightChild(int val, int safety)
	{
		rightChild = new MyNode(val, safety);
		rightChild.parent = this;
	}*/


}

/** Class for a binary tree ADT
 */
public class MyTree 
{
    private final int MAX_NODES = 1000;
    MyNode[] nodeArray;
	MyNode root;

	public MyTree(MyNode[] nodeArray)
	{
		this.nodeArray = nodeArray;
		root = nodeArray[0];
	}
	public String SafeToGo(int a, int b)
	{
		String returnVal = "YES";
		
		//NO TIME TO FINISH CODING!!! sighs.. =(
		
		/*MyNode temp1 = nodeArray[a];
		MyNode temp2 = nodeArray[b];
		while(temp1 != root)
		{
			if (!temp1.isSafe)
			{
				return "NO";
			}
			else
			{
				temp1 = temp1.parent;
			}
		}*/
		return returnVal;
	}

}
