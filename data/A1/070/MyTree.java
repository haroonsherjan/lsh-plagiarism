/** Class for a tree node
 */
class MyNode {  
	public int city;
	public int safe;
    public MyNode left;
	public MyNode right;

	public MyNode(int c, int s)
	{
		city = c;
		safe = s;
	    left = null;
		right = null;
	}
}


/** Class for a binary tree ADT
 */
public class MyTree 
{
	MyNode root;

	public MyTree (int safe)
	{
		root = new MyNode(0,safe);
	}

    public MyNode find(int t , MyNode temp)
	{
		
		 if(temp.city == t)
			return temp;
	    else if(temp.left!=null)
			return find(t,temp.left);
		else if(temp.right!=null)
			return find(t,temp.right);
	    else
			return null;
	}

	public MyNode ffind(int t)
	{
		return find(t,root);
	}
	
	public void insert(int parent, MyNode t,int left)
	{
		MyNode temp = ffind(parent);
		if(left ==1)
			temp.left = t;
		else
			temp.right = t;
	}
    
	public boolean check(int t, int n)
	{
		MyNode temp =ffind(t);
		MyNode temp2 = ffind (n);
		MyNode curr = root;
		Boolean path1 =true;
		path1 = path1&&check2(curr.left,temp,temp2)||check2(curr.right,temp,temp2);
	    return path1;
	}
	public boolean check2(MyNode curr, MyNode temp, MyNode temp2)
	{
		if(curr == temp)
			return true;
		else if(curr == null)
			return true;
		else if(curr.safe ==0)
			return false;
		else
			return true;
	}
}
			



