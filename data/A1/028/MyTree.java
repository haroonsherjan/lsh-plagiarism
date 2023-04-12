/** Class for a tree node
 */
class MyNode {

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    MyNode left;			  // left child index in array
    MyNode right;		 // right child index in array
	int cityNum;

    // fill in your accessor and mutator methods here
	public MyNode(int i, int num)
	{
		if(i == 1)
		{
			isSafe = true;
		}else if (i == 0)
		{
			isSafe = false;
		}
		left = null;
		right = null;
		cityNum = num;
	}

	public void setLeft(MyNode left)
	{
		this.left = left;
	}

	public  void setCityNum(int num)
	{
		cityNum = num;
		}
	public void setRight(MyNode right)
	{
		this.right = right;
	}

	public MyNode getLeft()
	{
		return left;	
	}

	public MyNode getRight()
	{
		return right;
	}

	public boolean getSafe()
	{
		return isSafe;
	}
	public int getCityNum()
	{
		return cityNum;
	}

}

/** Class for a binary tree ADT
 */
public class MyTree {
	MyNode root;

	public MyTree(MyNode root)
	{
		this.root = root;
	}

	public String safeRoute(MyNode current, MyNode end)
	{
		String safety;
		String leftSide;
		String rightSide;
		if(current.getCityNum() == end.getCityNum()){

			if(!current.getSafe())
			{
				return "NO";
			}else
			{
				return "YES";
			}

		}else if(current.getLeft()!= null && current.getRight() !=null)
		{
			leftSide = safeRoute(current.getLeft(), end);
			rightSide = safeRoute(current.getRight(), end);
			if(leftSide.equals("YES") || rightSide.equals("YES"))
			{
				return "YES";
			}else
			{
				return "NO";
			}
		}else if(current.getLeft()!= null && current.getRight() ==null )
		{
			return safeRoute(current.getLeft(), end);
		}else if(current.getLeft()== null && current.getRight() !=null)
		{
			return safeRoute(current.getRight(), end);
		}else{
			return "NO";
		}
	}
}
