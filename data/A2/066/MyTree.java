/** Class for a tree node
 */

import java.util.*;

class MyNode {
    
    private int value;			  
    private MyNode right;
	private MyNode left;
	private MyNode parent;

	public MyNode (int value) {
		
		this.value = value;
		right = null;
		left = null;
		parent = null;
		
		}	

	public void setRight (MyNode right) {
		
		this.right = right;
		
		}
	
	public MyNode getRight () {
		
		return right;
		
		}

	public void setLeft (MyNode left) {
		
		this.left = left;
		
		}

	public MyNode getLeft () {
		
		return left;
		
		}

	public void setParent (MyNode parent) {
		
		this.parent = parent;
		
		}

	public MyNode getParent () {
		
		return parent;
		
		}	

	public int getValue () {
		
		return value;

		}	

}

/** Class for a binary tree ADT
 */
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

	int index;
	MyNode [] tree; 

    public MyTree () {
		
		tree = new MyNode[100];
		tree[0] = new MyNode(0);;
		index = 1;
		
		}

	public void insert (int value) {
		
		MyNode a = new MyNode (value);	
		a.setParent(tree[(index-1)/2]);
		tree[index] = a;
		index++;

		}

	public int position (int value) {
		
		int place = -1;

		for (int i = 0; i < tree.length; i++){
			
			if (tree[i].getValue() == value){
				
				place = i;
				
				}
			
			}

		return place;	
		
		}	

	public void check(int valueA, int valueB) {
		
		MyNode a = tree[position(valueA)];
		MyNode b = tree[position(valueB)];

		if (a.getParent().getValue() == b.getValue()) {
			
			System.out.println("DESCENDANT");
			
			}

		else if (b.getParent().getValue() == a.getValue()) {
			
			System.out.println("ANCESTOR");
			
			}

		else if (position(valueA) > position(valueB)) {
			
			System.out.println("RIGHT SIBLING");

			}

		else if (position(valueA) < position(valueB)) {
			
			System.out.println("LEFT SIBLING");
			
			}

		else {
			
			System.out.println("NONE");
			
			}	
			
			}	
	
	
}
