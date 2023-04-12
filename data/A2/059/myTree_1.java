class TreeNode {
	protected int number;
	protected TreeNode left;
	protected TreeNode right;

	TreeNode(int num){
		this(num, null, null);	
	}

	TreeNode(int num, TreeNode n1, TreeNode n2){
		number = num;
		left = n1;
		right = n2;
	}
}// end TreeNode


class myTree{
	private final int MAX_NODES = 1000;
	TreeNode [] MyTree = new TreeNode[MAX_NODES];
	TreeNode root;
	private int size = 0;;

	myTree(){
		root = new TreeNode(0);// 0 is always the parent root
		size++;
	}

	public void insert(int number){
		if(root==null){
			root = insert(root,number);	
		}else if(number==-1){
			//do nothing
		}
	}// end insert

	private TreeNode insert(TreeNode node, int number){
		TreeNode temp = node;

		if(number == temp.number)
			return temp;
		else if(number<temp.number){
			if(temp.left!=null){
				temp.left = insert(temp.left, number);	
			}else{
				temp.left = new TreeNode(number);
				size++;
			}// end if
		}// end else if
		else if(number>temp.number){
			if(temp.right!=null){
				temp.right = insert(temp.right,number);
			}else{
				temp.right = new TreeNode(number);
				size++;
			}
		}// end else if
		return temp;
	}
}// end myTree
