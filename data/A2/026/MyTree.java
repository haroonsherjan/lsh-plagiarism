/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree
	Integer item; 
    int left;        //leftchild index
	int right;       // rightchild index
	public MyNode(int x)
	{
		this.item =x;
		this.left = 0;
		this.right = 0;
	}
	public MyNode(int x, int y)
	{
		this.item = 0;
		this.left = x;
		this.right =y;
	} // end constructor


    // fill in your accessor and mutator methods here
    //for the root item
    public int getItem()
	{
		return item;
	}
	public void setItem(int x )
	{
		this.item = x;
	}
	//for leftchild
	public int getLeftIndex() 
	{
		return this.left;
	}
	public void setLeftIndex(int x)
	{
		this.left = x;
	}

	//for rightchild
	public int getRightIndex()
	{
		return this.right;
	}
	public void setRightIndex(int x)
	{
		this.right = x;
	}
}

/** Class for a binary tree ADT
 */
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed
    // fill in your ADT methods here
	public void buildTree(int x, int y)
	{
		if(size ==0)
		{
			myTree[0] = new MyNode(x,y); //when the array is empty, the first node is always have root=0
			if(x==-1& y!=-1)
			{
				size++;
				myTree[size]=new MyNode(y);
            } //when leftchild is null

			else if(x!=-1&y==-1)
			{
				size++;
				myTree[size] = new MyNode(x);
			}
			else if(x!=-1 & y!=-1)
		    {
				myTree[size+1] = new MyNode(x);
				myTree[size+2] = new MyNode(y);
				size=size+2;
			}
	}
     else
	 {
		int tempRoot = myTree[size-1].getItem();
		myTree[size-1] = new MyNode(x,y); //since in the constructor, the item is default to 0, so need to set the item seperately
		myTree[size-1].setItem(tempRoot);
        
		if(x==-1 & y!=-1)
		{
			size++;
			myTree[size] = new MyNode(y);
		} //when leftchild is null

		else if(x!=-1 & y==-1)
		{
			size++;
			myTree[size] = new MyNode(x);
		} //when rightchild is null
		else if(x!=-1 & y!=-1)
		{
			myTree[size+1] = new MyNode(x);
			myTree[size+2] = new MyNode(y);
			size=size+2;
		}//when both children are nor null
		}//end else
	 }//end buildTree
	


	public void processTree(int x, int y)
	{
		//this method is to find out the relationship between x and y
		// if x and y are both children of an item, then they are either LEFT SIBLING or RIGHT SIBLING
		//check through the array, if index of x is larger than that of y, x y is LEFT SIBLING
		//
	}//end preocessTree
}//end
