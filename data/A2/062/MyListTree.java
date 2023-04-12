public class MyListTree{
	private TreeNode root;
	int compareA, compareB;
	
	public MyListTree(){
		root = null;
	}

	public void insert(int value1,int value2){
		if(root==null){
			root = new TreeNode(0);
		}
		else{
			insert(value1,value2,root);
		}
	}

	private void insert(int value1, int value2, TreeNode node){   // building the Tree
		if(node.getLeft()== null){                                // start from left
		  if(value1 != 1){
		    	node.setLeft(new TreeNode(value1));
		  }
	      else if(value1 == -1){
			  node.setLeft(null);
		  }
		  if(value2 != 1){
			  node.setRight(new TreeNode(value2));
		  }
		  else if(value2 == -1){
			  node.setRight(null);
		  }
		}
		else if(node.getLeft() != null){                           // if there is a node at the left
			insert(value1,value2, node.getLeft());                 // insert after seeing the null node at left
		}
		else if(node.getRight() != null){                          // if there is a ndoe at the right
			insert(value1,value2, node.getRight());                // insert after seeing the null node at right
		}
	}

	public void relation(int A, int B){                          
	    relation(A,B,root);
	}

	private void relation(int A, int B, TreeNode node){        //return the relationship between pairs of nodes
        //case 1: Left Sibling
		if(node.getLeft() !=null && node.getRight() !=null){
			compareA = node.getLeft().getValue1();
		    compareB = node.getRight().getValue2();
			if(compareA == A && compareB == B){
				System.out.println("LEFT SIBLING");
			}
			else
				System.out.println("NONE");
		}
	    else{
			node.setLeft(node.getLeft());
			node.setRight(node.getRight());
			relation(A,B,node);
		}
		//case 2: Ancestor
		//case 3: Descendant
	}

}

class TreeNode{
	private TreeNode left,right;
	private int value1, value2, root;

	public TreeNode(int root){
		left=null;
		right=null;
		this.root=root;
	}
	public TreeNode(int value1, int value2){
		left=null;
		right=null;
		this.value1 = value1;
		this.value2 = value2;
	}

	public int getValue1(){
		return value1;
	}
	public void setValue1(int value1){
		this.value1 = value1;
	}
	public int getValue2(){
		return value2;
	}
	public void setValue2(int value2){
		this.value2 = value2;
	}
	public TreeNode getLeft(){
		return left;
	}
	public TreeNode getRight(){
		return right;
	}
	public void setLeft(TreeNode node){
		left = node;
	}
	public void setRight(TreeNode node){
		right = node;
	}
}
