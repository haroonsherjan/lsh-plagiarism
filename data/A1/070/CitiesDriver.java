import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
    
    /** Read in the tree
     */
    public static void readTree () 
	{
	  int n = sc.nextInt();
	  int[] safe = new int[n];
	  int[] node = new int[n];
	  int[] left = new int[n];
	  int[] right = new int[n];
	 
	  for(int i=0;i<n;i++)
		  safe[i] = std.nextInt();

      int size = 1;
	  node[0]=0;
      for (int i=1;i<2*n+1;i++)
	  {
		  int temp = sc.nextInt();
		  if(temp!=-1)
		  {
			  node[size] = temp;
			  size++;
		  }
		  if(i%2==1)
		  left[(i-1)/2]= temp;
		  else
	      right[(i-2)/2] = temp;
	  }
		
	  MyTree tr = new MyTree(safe[0]);
	  for(i=1;i<n;i++)
	  {
		  MyNode temp = new MyNode(node[i],safe[i]);
		  boolean flag = true;
		  int parent=-1;
		  int left =1;
		  for(int j =0; j<n&&flag;j++)
		  {
			  if(node[i] == left[j])
			  {
				  flag = false;
				  parent = j;
			  }
		  }
		  if(flag)
		  {
			  left = 0;
			  for(int j = 0;j<n&&flag;j++)
			  {
				  if(node[i]==right[j])
					 {
						 flag = false;
						 parent = j;
					 }
			  }
		   }

		   tr.insert(parent,left,temp);
	  }
	}



    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	 //   sc.nextInt();			   // modify this line
	   // sc.nextInt();
		if(tr.check(sc.nextInt(),sc.nextInt()))
			System.out.println("YES");
		else
			System.out.println("NO");// modify this line
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
