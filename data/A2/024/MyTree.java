public class MyTree
{
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    private final int MAX_NODES = 1000;
    MyTree [] tree = new MyTree[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed
	private MyTree parent, leftChild, rightChild;
	private MyTree current, temp;
	private int element;

	public MyTree()
	{
	}

	public MyTree(int x)
	{
		element = x;
	}

	public int getEle()
	{
		return this.element;
	}

	public int getParent()
	{
		return this.parent.getEle();
	}

	public int getLeftChild()
	{
		return this.leftChild.getEle();
	}

	public int getRightChild()
	{
		return this.rightChild.getEle();
	}

	public void add(int root, int x, int y)
	{
		if (root == 0)
		{
			MyTree node = new MyTree(root);
			tree[size] = node;
			size++;
		}
		for (int i=0; i<size; i++)
		{
			if (tree[i].getEle() == root)
			{
				current = tree[i];
				if (x > 0)
				{
					current.addLeft(x);
					size++;
				}	
				if (y > 0)
				{
					current.addRight(y);
					size++;
				}
			}
		}
	}

	public void addLeft(int x)
	{
		MyTree node1 = new MyTree(x);
		tree[size] = node1;
		node1.setParent(current);
		setLeftChild(node1);
	}

	public void addRight(int x)
	{
		MyTree node1 = new MyTree(x);
		tree[size] = node1;
		node1.setParent(current);
		setRightChild(node1);
	}

	public void setParent(MyTree node)
	{
		parent = node;
	}

	public void setLeftChild(MyTree node)
	{
		leftChild = node;
	}

	public void setRightChild(MyTree node)
	{
		rightChild = node;
	}

	public void relation(int x, int y)
	{
		for (int i=0; i<size; i++)
		{
			temp = tree[i];
			if (temp.getEle() == x)
			{
				if (temp.getParent() == y)
				{
					System.out.println("DESCENDANT");
				}
				else if (temp.getLeftChild() == y || temp.getRightChild() == y)
				{
					System.out.println("ANCESTOR");
				}
				else
				{
					checkSibling(x, y);
				}
			}
		}
	}

	public void checkSibling(int x, int y)
	{
		MyTree temp1=null, temp2=null;
		int count1=0, count2=0;
		for (int i=0; i<size; i++)
		{
			if (tree[i].getEle() == x)
			{
				temp1 = tree[i];
				count1 =i;
			}
			if (tree[i].getEle() == y)
			{
				temp2 = tree[i];
				count2 = i;
			}
		}
		//check whether same parent
		if (temp1.getParent() == temp2.getParent())
		{
			if (count1 > count2)
			{
				System.out.println("RIGHT SIBLING");
			}
			else 
			{
				System.out.println("LEFT SIBLING");
			}
		}
		else
		{
			System.out.println("NONE");
		}
	}
}
