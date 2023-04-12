import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    
    /** Read in the tree
     */
    public static void readTree () {
	/// Read in the tree
	// read in one integer
	int n = sc.nextInt();
	// read in tree, safety line
    MyTree cities = new MyTree(n);       

	for (int i=0;i<n;i++) 
	    cities.myTree[i].setIsSafe(sc.nextInt()); 
	 
	// loop to read pairs of children
	for (int i=0;i<n;i++) {
		int left =sc.nextInt();
		int right=sc.nextInt();
	    cities.myTree[i].setLeft(left);
		cities.myTree[left].setParent(i);// modify this line
	    cities.myTree[i].setRight(right);
		cities.myTree[right].setParent(i);// modify this line
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    int a =sc.nextInt();			   // modify this line
	    int b =sc.nextInt();			   // modify this line
	    checkSafe(a,b);
	}
    }
    
    public static void main(String[] args) {
		//Finding the number of awards
    MyTree cities;
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();	// read in the queries
    }
	/*public static int findEnd(int a){
      int end;
	  while(a!=-1){
        end =a;
		a=cities.myTree[a].getParent();
	  }
	  return end;
	}*/
	public static void checkSafe(int a, int b){
      
	  int aEnd=a;                                 //trace up to find the first unsafe city of A root
	  while(a!=-1){
		aEnd =a;
       // a=cities.myTree[a].getParent();          //this line generate compilation error..don't know why??
     }
	  int bEnd=b;
      while(b!=-1){
	    bEnd =b;
	   // b=cities.myTree[a].getParent();
	  }
	  if(aEnd==bEnd) System.out.println("YES");     //if they have a common safe city return yes
	  else System.out.println("NO");
	}
}
