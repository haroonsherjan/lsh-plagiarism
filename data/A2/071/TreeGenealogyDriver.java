import java.util.*;

public class TreeGenealogyDriver {
    static Scanner sc;
    
    /** Read in the tree
     */
    public static void readTree () {
	
	int n = sc.nextInt();
MyTree mt = new MyTree(n);
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
		
		mt.setLeft(i,sc.nextInt());
		mt.setRight(i,sc.nextInt());
	   	
		}

	int x = 1;
	for ( int i = 0; i < n; i++){
	    if (mt.getLeft(i)!= -1)
			mt.setParent(mt.getLeft(i),x++);
	    if (mt.getRight(i)!= -1)
			mt.setParent(mt.getRight(i),x++);
    }
}
		
    
    /** Read in query statements
     */
    public static void readQueries () {
   // read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    
		int x = sc.nextInt();
		int y = sc.nextInt();

/*     if(mt.isLeftSlibing(x,y))
			System.out.println("LEFT SIBLING");
	    if(mt.isRightSlibing(x,y))
			System.out.println("RIGHT SIBLING");
		if(mt.isAncestor(x,y))
			System.out.println("ANCESTOR");
		if(mt.isDescendant(x,y))
			System.out.println("DESCENDANT");
		if(mt.isNone(x,y))
			System.out.println("NONE");

*/
	}
   }
   
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries


    }
}

