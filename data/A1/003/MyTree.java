/** Class for a tree node
 */
 
// This class is actually MyNode class although it is called MyTree

public class MyTree {

    // data field
	public int city;         // id of the city
    public boolean isSafe;	 // is the city safe?
    public int leftIndex;    // left child index in array
    public int rightIndex;   // right child index in array
	
	// constructor
	public MyTree( int id) {
		city = id;
		isSafe = false;
		leftIndex = -1;
		rightIndex = -1;
	}
} // end MyNode class
