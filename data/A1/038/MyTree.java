/** Class for a tree node
 */

import java.util.*;
class MyNode {

	boolean isSafe;				  // is the city safe?
	int leftIndex = -1;			  // left child index in array
    int rightIndex = -1;		 // right child index in array
	int parent = -1;
	
	public MyNode(int safety) {
		setSafety(safety);
	}

	public MyNode(int l, int r) {
		leftIndex = l;
		rightIndex = r;
	}

	public void setLeft(int l) {
		leftIndex = l;
	}

	public void setRight(int r) {
		rightIndex = r;
	}

	public int getLeft() {
		return leftIndex;
	}

	public int getRight() {
		return rightIndex;
	}

   	public boolean isSafe() {
		return isSafe;
	}

	public void setSafety(int safe) {
		if(safe == 0) {
			isSafe = false;
		}
		else if (safe == 1) {
			isSafe = true;
		}
	}

	public void setParent(int p){
		parent = p;
	}

	public int getParent() {
		return parent;
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

    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed
	int current = 0; //int to aid addition of new nodes

	public MyTree(int s) {
		size = s;
	}

	public void addSafety(int[] safety) {
		for(int i=0; i<safety.length; i++) {
			myTree[i] = new MyNode(safety[i]);
		}
	}

	private MyNode getRoot() {
		return myTree[0];
	}

	public void addNode(int left, int right) {
		myTree[current].setLeft(left);
		myTree[current].setRight(right);
		if(left!=-1) {
			myTree[left].setParent(current);
		}
		else if(right != -1) {
			myTree[right].setParent(current);
		}
		current++;
	}

	public boolean isSafe(int start, int end) {
		int commonIndex = getCommonIndex(start,end);
		if(subTreeIsSafe(commonIndex,start) && subTreeIsSafe(commonIndex,end)) {
			return true;
		}
		else return false;
	}

	private boolean subTreeIsSafe(int start, int end) {
		if(start == end && myTree[start].isSafe()) {
			return true;
		}
		else if(!myTree[start].isSafe() || !myTree[end].isSafe()) {
			return false;
		}
		else if(myTree[start].getLeft() == -1) {
			return subTreeIsSafe(myTree[start].getRight(), end);
		}
		else if(myTree[start].getRight() == -1 ) {
			return subTreeIsSafe(myTree[start].getLeft(), end);
		}
		return true;
	}

	private int getCommonIndex(int start, int end) {
		LinkedList<Integer> path1 = new LinkedList<Integer>();
		int index1 = start;
		int index2 = end;
		while(index1!=0) {
			index1 = myTree[start].getParent();
			path1.add(index1);
			start = index1;
		}
		while(index2!=0) {
			index2 = myTree[end].getParent();
			if(path1.contains(index2)) {
				return index2;
			}
			else { 
				end = index2;
			}
		}
		return 0;
	}
}
