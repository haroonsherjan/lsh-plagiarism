/** Class for a tree node
 */

import java.util.*;
class TreeNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    private TreeNode leftChild;			  // left child index in array
    private TreeNode rightChild;
	private int item;
	// right child index in array
	public TreeNode(int newItem){
		item = newItem;
		leftChild = null;
		rightChild = null;
	}
	public int getElement(){
		return item;
	}
	public TreeNode getLeft(){
		return leftChild;
	}
	public TreeNode getRight(){
		return rightChild;
	}
	public void setLeft(TreeNode left){
		leftChild = left;
	}
	public void setRight(TreeNode right){
		rightChild = right;
	}


    // fill in your accessor and mutator methods here
    // ...
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
	TreeNode root = new TreeNode(0);
	LinkedList<TreeNode> treeList = new LinkedList<TreeNode>();
	TreeNode curr = root;
	LinkedList treeList2 = new LinkedList();
    int size = 0;	// make sure to update this variable as needed
	int indexOfL =0 ;
	int indexOfR = 0;
	public MyTree(){}
	public void insert(int left, int right){
		treeList.add(new TreeNode(0));
		treeList2.add(left);
		treeList2.add(right);
		if(left != -1){
			treeList.add(new TreeNode(left));
			curr.setLeft(new TreeNode(left));
			size++;
			curr = treeList.get(size);
		}
		if(right != -1){
			treeList.add(new TreeNode(right));
			curr.setLeft(new TreeNode(right));
			size++;
			curr = treeList.get(size);
		}
	}
	public void label(int left, int right){
		for(int i = 0; i< treeList.size();i++){
			if(treeList.get(i).getElement() == left){
				indexOfL = i;
			}
			if(treeList.get(i).getElement() == right){
				indexOfR = i;
			}
		}
		boolean yesOrNot = false;
		TreeNode currL = treeList.get(indexOfL);
		TreeNode currR = treeList.get(indexOfR);

		while(currL.getLeft()!= null){
			if(currL.getLeft() !=null && currL.getLeft().getElement() == right){
				System.out.println("ANCESTOR");
				yesOrNot = true;
			}
			currL = currL.getLeft();
		}
		currL = treeList.get(indexOfL);
		while(currL.getRight()!=null){
			if( currL.getRight().getElement() == right){
				System.out.println("ANCESTOR");
				yesOrNot = true;
			}
			currL = currL.getRight();
		}
		while(currR.getLeft()!=null){
			if(currR.getLeft().getElement() == left){
				System.out.println("DESCENDANT");
				yesOrNot = true;
			}
			currR = currR.getLeft();
		}
		currR = treeList.get(indexOfR);
		while(currR.getRight() != null){
			if(currR.getRight().getElement() == left){
				System.out.println("DESCENDANT");
				yesOrNot = true;
			}
			currR = curr.getRight();
		}
		if(!yesOrNot){
			System.out.println("NONE");
		}
	}
}
