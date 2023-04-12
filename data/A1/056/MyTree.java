/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe= false;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;          // right child index in array
	int city;

	public MyNode(int newCity){
		this(newCity,-1,-1);
	}// end of constructor

	public MyNode(int newCity, int left, int right){
		city = newCity;
		leftChildIndex = left;
		rightChildIndex = right;
		//isSafe = safe;
	}// end of constructor

	public int getLeft(){
		return leftChildIndex;
	}// end of getLeft

	public int getRight(){
		return rightChildIndex;
	}//end of getRight

	public boolean isSafe(){
		return isSafe;
	}//end of isSafe

    public int getCity(){
		return city;
	}// end of getCity

	public void setCity(int newCity){
		city = newCity;
	}// end of setCity

	public void setLeft(int left){
		leftChildIndex = left;
	}// end of setLeft

	public void setRight(int right){
		rightChildIndex = right;
	}// end of setRihgt
	
	public void setSafe(boolean s){
		isSafe = s;
	}// end of setSafe
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
    MyNode[] myTree;
    int size;	// make sure to update this variable as needed

    public MyTree(){
		myTree = new MyNode[MAX_NODES];
        size = 0;
	}// end of constructor

	
	public void safe(int index, int s){
		if(s==0)
		  myTree[index].setSafe(false);
		else
	      myTree[index].setSafe(true);
	}// end of safe

	public void addCity(int newCity){
			 MyNode city = new MyNode(newCity);
			 city.setLeft(2*newCity+1);
             city.setRight(2*newCity+2);
			 myTree[size]=city;
			 size++;
	}

	/* Basically idie is that i have constructed a tree which will have cityes and 
	I already marked them which is safe or not safe
	in my last method which is checkSafe(int city1, city2) i will finda first 
	departure city by serching method  and when i find it, i search  first left
	subtree if cant find i will search right subtree untill hit destination. If I
	on my way any unsafe city i just return "NO". Third case if i cannot find in
	two directins left and right i will travers to parent by index (index - 1)/2.
	At last stage if I cannot find any city i will return NO.*/
}
