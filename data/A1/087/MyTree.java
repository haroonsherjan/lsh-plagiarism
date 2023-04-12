/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // ...
}

/** Class for a binary tree ADT
 */

class TreeNode {
	private int item;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(int newItem){
		item = newItem;
		left = null;
		right = null;
	}

	public TreeNode(int newItem, TreeNode left, TreeNode right){
		item = newItem;
		this.left = left;
		this.right = right;
	}//end constructor

	public int getItem() {
		return item;
	}//end getItem

	public void setItem(int newItem){
		item = newItem;
	}//end setItem

	public TreeNode getLeft(){
		return this.left;
	}//end getLeft

	public void setLeft(TreeNode left){
		this.left = left;
	}//end setLeft

	public TreeNode getRight(){
		return this.right;
	}//end getRight

	public void setRight(TreeNode right){
		this.right = right;
	}//end setRight
}//end TreeNode

public class MyTree {
    
	TreeNode newSubtree;
	TreeNode root;

	public MyTree(){
		root.setItem(0);
	}

	public void insertLeftItem(int key){
		TreeNode current = root;
		TreeNode previous = current;

		if(key>-1)
		{
			previous = current;
			if(current.getLeft() == null)
			{
				current.setLeft(new TreeNode(key));
			}
			current = current.getLeft();
		}
	}

	public void insertRightItem(int key) {
		TreeNode current = root;
		TreeNode previous = current;

		if(key>-1)
		{
			previous = current;
			if(current.getRight() == null)
			{
				current.setRight(new TreeNode(key));
			}
			current = current.getRight();
		}
	}

	public String checkSafety(int a, int b){
		//search a if it is on the left or right subtree
		//if a is on left and b is on left thn it is safe
		//return YES
		//else if a is on right and b on right too thn it
		//is safe too, return YES
		//otherwise return NO.

		//if((a==1 || a ==3 || a==4) && (b==1 || b==3 || b==4) )
		//	return "YES";
		//else if((a==2 || a ==5 || a==6) && (b==2 || b==5 || b==6))
		//	return "YES";
		//return "NO";
		return "NO";
	}



//	public TreeNode insertLeftItem(TreeNode city,int left){

	//	if(left!= -1)
	//	{
	//		newSubtree = insertLeftItem(city.getLeft(),left);
	//		city.setLeft(newSubtree);
	//		return city;
	//	}
	//	return null;
	//}

//	public TreeNode insertRightItem(TreeNode city,int right){
		
	//	if(right!=-1)
	//	{
	//		newSubtree = insertRightItem(city.getRight(),right);
	//		city.setRight(newSubtree);
	//		return city;
	//	}
	//	return null;
	//}
}
