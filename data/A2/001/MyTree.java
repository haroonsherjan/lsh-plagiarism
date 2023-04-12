import java.util.*;

class TreeNode{
	private int item;
	private int left;
	private int right;

	public TreeNode(int i){
		item = i;
		left = -1;
		right = -1;
	}

	public void setLeft(int i){
		left = i;
	}

	public void setRight(int i){
		right = i;
	}

	public int getLeft(){
		return left;
	}

	public int getRight(){
		return right;
	}

	public Relation getRelations(int a, int b){
		if (item != a && item != b){
			if (left == a && right == b){
				return new Relation(1);                       // If a is the left sibling of b.
			}else if(left == b && right == a){
				return new Relation(2);                       // If a is the right sibling of b.
			}
		}else if (item == a){                                 // If a is an ancestor of b.
			if (left == b || right == b){
				return new Relation(3);
			}
		}else if (item == b){                                 // If b is an ancestor of a.
			if (left == a || right == a){
				return new Relation(4);
			}
		}
		return new Relation(-1);                              // Otherwise.
	}
}

class Relation{
	private int ID = -1;

	public Relation(int id){
		ID = id;
	}

	public String toString(){
		if (ID == 1) return new String("LEFT SIBLING");
		if (ID == 2) return new String("RIGHT SIBLING");
		if (ID == 3) return new String("ANCESTOR");
		if (ID == 4) return new String("DESCENDANT");

		return new String("NONE");
	}

	public int getID(){
		return ID;
	}

	public void setID(int i){
		ID = i;
	}
}

public class MyTree {
    private TreeNode[] myTree;
	private int size;

    public MyTree(int size){
		this.size = size;
		myTree = new TreeNode[this.size];

		for (int i = 0; i < size; i++){
			myTree [i] = new TreeNode (i);
		}
	}

	public void setNode(int i, int left, int right){
		myTree [i].setLeft(left);
		myTree [i].setRight(right);
	}

	public String getRelation(int a, int b){
		LinkedList <Relation> myList = new LinkedList <Relation> ();

		for (int i = 0; i < size; i++){
			Relation myRelation = myTree[i].getRelations(a, b);
			
			if (myRelation.getID() == -1){
				if (findDecendent(a, b)) myRelation.setID(3);
				if (findDecendent(b, a)) myRelation.setID(4);
			}

			myList.add(myRelation);
		}

		while (!myList.isEmpty()){
			Relation aRelation = myList.removeFirst();

			if (aRelation.getID() != -1) return aRelation.toString();
		}

		return new String("NONE");
	}
/*

If there are more than one nodes between a and b. Recuisively find out whether a is an ancestor of b or vice versa.

*/

	private boolean findDecendent(int a, int b){
		if (b == myTree[a].getLeft() || b == myTree[a].getRight()) return true;

		if (myTree[a].getLeft() != -1){
			findDecendent(myTree[a].getLeft(), b);
		}

		if(myTree[a].getRight() != -1){
			findDecendent(myTree[a].getRight(), b);
		}

		return false;
	}
}
