import java.util.*;

/**
 * This is the driver class for the Perlilous Cities Lab
 */
public class CitiesDriver {
    static Scanner sc;
	MyTree tree = new MyTree();
    
    /** Read in the tree
     */
    public static void readTree ()
	{
	

		/// Read in the tree
		// read in one integer
		int	n = sc.nextInt();
		// read in tree, safety line
		for (int i=0;i<n;i++) 
	   	{
			tree.insertBoolean(sc.nextInt(),i); //creates a node and sets the safe value
		} //close for loop
	
		// loop to read pairs of children
		for (int i=0;i<n;i++)
		{
	    	tree.insertIndexes(i,sc.nextInt(),sc.nextInt()); //sets the indexes for both the left and right indexes			   
		} //close for loop
    }
    
    /** Read in query statements
     */
    public static void readQueries () 
	{
		// read in one integer
		int m = sc.nextInt();
		int start; //to store the starting point
		int destination; //to store the destination

		// loop to read pairs of children for query
		for (int i=0;i<m;i++)
		{
	    	start = sc.nextInt();		 //store the start location
	    	destination = sc.nextInt();	 //store the destination

			if(start>destination) //if starting location is greater than destination
			{
				swap(start,destination); //swap the values of start and destination
			} //close if

			int now = destination;
			boolean exit = false;

			do
			{
				if(now!=0)
				{
					if(tree.getSafe(now) == false) //the point is not safe
					{
						System.out.println("NO");
						exit = true;
					}
				
					now =(int) Math.floor((now-1)/2); //set now to it's parents address
				}
				
			} while(now!=start||now!=0|| exit==false);

			if(now==start && exit ==false)
			{
				System.out.println("YES");
			}

			else if(now==0 && exit==false)
			{
				now = start;

				do
				{
					if(now!=0)
					{
						if(tree.getSafe(now)==false) //the point is not safe
						{
							System.out.println("NO");
							exit = true;
						}

						now =(int) Math.floor((now-1)/2);
					}
				} while(now!=0 || exit = false);
			}

			if(now==0 && exit ==false)
			{
				System.out.println("YES");
			}

		}
    }

	public static void swap(int x, int y) //swap function
	{
		int temp = x;
		x = y;
		y = temp;
	} //close swap
		

    
    public static void main(String[] args) 
	{
		sc = new Scanner(System.in);
		readTree();				   // read in the tree
		readQueries();				// read in the queries
    }
}
