import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
	// make the following variable static so that we can create the tree when reading input
    static MyTree tree = new MyTree();
	static int[] first;
	static int[] second;
    /** Read in the tree
     */
    public static void readTree () {
	// read in one integer
	int n = sc.nextInt();
	int l,r ;
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
	    l = sc.nextInt();			   // modify this line
	    r = sc.nextInt();			   // modify this line
	    tree.add(l,r);
	}
	tree.setmother();
    }//construct the tree while reading the input;
    
    /** Read in query statements
     */
    public static int readQueries () {
	// read in one integer
	int m = sc.nextInt();
    first = new int[m];
	second = new int [m];
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    first[i]=sc.nextInt();			   // modify this line
	    second[i]=sc.nextInt();			   // modify this line
	}
	return m;
    }// store the commands in the array, return the array size to make the main method convenient
    public static boolean checkMother(int f, int s)
	{
	    if (tree.getMother(f)==s)
		{
		   return true;	
		}
		else if (tree.getMother(f)==-1)
		{
		   return false;	
		}
		else
		{
		   return checkMother(tree.getMother(f),s);	
		}
	}// use a recursive way to determine whether the second is the mother of first;
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	int num = readQueries();				// read in the queries
    for (int i=0; i<num; i++)
	{
	    if( tree.getRightsib(first[i])==second[i])
			System.out.println("LEFT SIBLING");
			//case of left
		else if ( tree.getRightsib(second[i])==first[i])
			System.out.println("RIGHT SIBLING");
			// right, just meaning the second is the left of first
		else if (checkMother(first[i],second[i]))
			System.out.println("DESCENDANT");
			// if second is mother of first, it is descendant
		else if (checkMother(second[i],first[i]))
			System.out.println("ANCESTOR");
			// if first is mother of second, it is ancestor
		else
			System.out.println("NONE");
	}//as only one posibility, make it else if;
    }
}
