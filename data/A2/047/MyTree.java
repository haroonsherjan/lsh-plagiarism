/** Class for a tree node
 */
class MyNode {
	// You may use this class if you'd like.  It may help you if you use
	// an array based implementation of a binary tree

	// you can add other variables if you'd like
	int leftChildIndex;			  // left child index in array
	int rightChildIndex;		 // right child index in array


	// fill in your accessor and mutator methods here
	public void setLeft(int x){
		leftChildIndex = x;
	}

	public void setRight(int x){
		rightChildIndex = x;
	}

	public int getLeft(){
		return leftChildIndex;
	}

	public int getRight(){
		return rightChildIndex;
	}

}//end class MyNode

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

	// fill in your ADT methods here
	public void addNode(int p, int left, int right){//p:parent,left:leftChildIndex,right:rightChildIndex
		myTree[p] = new MyNode();
		if(left !=-1){
			myTree[p].setLeft(left);
		}
		if(right !=-1){
			myTree[p].setRight(right);
		}
	}

	public void compare(int a, int b){
		if(isChild(a,b)){ 
			print(1);//b is a child of a
		}else if(isChild(b,a)){
			print(2);//a is a child of b
		}else{
			int p = searchParent(0,a);//p is the parent of a
			if(myTree[p].getLeft() == a &&myTree[p].getRight() ==b){
				print(3);//a is left sibling of b
			}else if(myTree[p].getLeft() == b && myTree[p].getRight() == a){
				print(4);//a is right sibling of b
			}else{
				print(5);//none
			}
		}
	}

	public boolean isChild(int p, int o){//p:parentIndex, o: objective MyNode index
		if(myTree[p].getLeft() == o ||myTree[p].getRight() == o){
			return true;
		}else{
			return (isChild(myTree[p].getLeft(),o) ||isChild(myTree[p].getRight(),o));
		}
	}

	public int searchParent(int p, int o){//p:parentIndex, o: objextive MyNode index
		if(myTree[p].getLeft() == o ||myTree[p].getRight() == o){
			return p;
		}else{
			if(myTree[p].getLeft() !=-1){
				p=myTree[p].getLeft();
				searchParent(p,o);
			}
			if(myTree[p].getRight() !=-1){
				p = myTree[p].getRight();
				searchParent(p,o);
			}
		}
		return -1;//this should never happen
	}//end searchParent

	public void print(int i){
		switch(i){
		case 1:
			System.out.println("ANCESTOR");
			break;
		case 2:
			System.out.println("DESCENDANT");	
			break;
		case 3:
			System.out.println("LEFT SIBLING");
			break;
		case 4:
			System.out.println("RIGHT SIBLING");
			break;
		case 5:
			System.out.println("NONE");
			break;
		default:
		}//end switch
	}


}//end class
