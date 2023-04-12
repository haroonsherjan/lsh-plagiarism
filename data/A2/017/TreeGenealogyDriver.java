import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;
	//create MyTree which contains array
	static MyTree tree=null;
	static int n=0;

    /** Read in the tree
     */
    public static void readTree () {
	// read in one integer
	n = sc.nextInt();

	//create MyTree with integer parameter
	tree=new MyTree(2*n+1);
	// loop to read pairs of children
	for (int i=0;i<2*n;i++) {
		//save the input as the element of array
	    tree.array()[i+1]=sc.nextInt();			   // modify this line
	}
    }
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
	int m = sc.nextInt();
	// loop to read pairs of children for query
	for (int i=0;i<m;i++) {
	    int a=sc.nextInt();			   // modify this line
	    int b=sc.nextInt();			   // modify this line
		
		//search the index of element a
		int indexA=0;
		for(int j=0;j<=2*n;j++)
		{
			if(tree.array()[j]==a)
			{
				indexA=j;
				break;
			}
		}

		//search the index of element b
		int indexB=0;
		for(int j=0;j<=2*n;j++)
		{
			if(tree.array()[j]==b)
			{
				indexB=j;
				break;
			}
		}
		
		//to control that only 1 output is printed
		boolean outputIsPrinted=false;

		//A is the left sibling of B
		if(indexA+1==indexB)
		{
			int flag=1;
			for(int x=0,y=1;x<tree.array().length;x+=2*y,y++)
			{
				if(indexA==x)
				{
					flag=0;
					break;
				}
			}
			if(flag==1)
			{
				System.out.println("LEFT SIBLING");
				outputIsPrinted=true;
			}
		}

		//A is the right sibling of B
		if(indexA-1==indexB&&!outputIsPrinted)
		{
			int flag=1;
			for(int x=0,y=1;x<tree.array().length;x+=2*y,y++)
			{
				if(indexB==x)
				{
					flag=0;
					break;
				}
			}
			if(flag==1)
			{
				System.out.println("RIGHT SIBLING");
				outputIsPrinted=true;
			}
		}

		//A is the ancestor of B
		if((2*indexA+1==indexB||2*indexA+2==indexB)&&!outputIsPrinted)
		{
			System.out.println("ANCESTOR");
			outputIsPrinted=true;
		}	

		//A is the descendant of B
		if(((int)((indexA-1)/2)==indexB)&&!outputIsPrinted)
		{
			System.out.println("DESCENDANT");
			outputIsPrinted=true;
		}

		//none of the conditions above
		if(!outputIsPrinted)
		{
			System.out.println("NONE");
		}
	}
    }
    
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	readTree();				   // read in the tree
	readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
    }
}
