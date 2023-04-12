/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    public int key;               // to hold the key
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	public MyNode left;                                        // reference for left
	public MyNode right;                                       // reference for right

    // fill in your accessor and mutator methods here
    // ...
     public MyNode(int k){key = k; left=null; right = null;}
	 public static boolean find(MyNode T, int key){             // this method is to find areas which are not safe
		if (T==null)
			return false;
		else if(key == T.key)
			return true;
		else if (key<T.key)
			return find(T.left, key);
		else
			return find(T.right,key);
	 } // end of find method

	 public static int size(MyNode T){                           // this method returns the size 
	 	if(T==null)
			return 0;                                            // return 0 if T is null
		else
			return 1 + size(T.left) + size(T.right);             // return the size if T is not null
	}// end of size method
	public static MyNode insert(MyNode T, int key){               // to insert data
		if(T==null){
			return new MyNode(key);
		}
		else if(key <= T.key){
			T.left = insert(T.left, key);
			return T;
		}
		else {
			T.right= insert(T.right, key);
			return T;
		} // end static method MyNode insert

	} // end of insert method

/*	static int itemAt(MyNode curr, safe) // find position of unsafe areas
	{
	 if unsafe
		 return boolean value isSafe == false
		 else 
		 boolean value isSafe == true
	}
*/
/*        static int saferoute(...) 

             another method is to check the route torist should take,
             if hazardous return to root,
	         else if not hazardous proceed
		     else return null                                 */	
}// end of class MyNode


/** Class for a binary tree ADT
 */
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];                       // seting myTree to MAX_NODES ..1000
    int size = 0;	// make sure to update this variable as needed
	private MyNode head;                                           // reference the head
	public MyTree(){head = null;}                                  // end of constructor
	public boolean find(int key){return MyNode.find(head, key);}   // to find
	public void  insert(int key){head = MyNode.insert(head, key);} // to insert 
	public int size() {return MyNode.size(head);}// to return the size 
    // fill in your ADT methods here
    // ...
}// end of MyTree class


