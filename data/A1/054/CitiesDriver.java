import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
	static Scanner sc;
	static city[] cities;//i have create a city class
	/** Read in the tree
	 */
	public static void readTree () {
		/// Read in the tree
		// read in one integer
		int n = sc.nextInt();
		// read in tree, safety line
		cities = new city[n]; 
		for (int i=0;i<n;i++) 
		{
			cities[i]=new city(i);
			cities[i].setSafe(sc.nextInt());
		}// modify this line

		// loop to read pairs of children
		for (int i=0;i<n;i++) {
			cities[i].setChild( sc.nextInt(),sc.nextInt());//set left and right child index
		}
		for(int i=0;i<n;i++)
		{
			int left = cities[i].getLeft();
			int right = cities[i].getRight();
			if(left>=0)
			{
				cities[left].setParent(i);
			}//set parent 
			if(right>=0)
			{
				cities[right].setParent(i);
			}//set parent

		}
	}

	/** Read in query statements
	 */
	public static void readQueries () {
		// read in one integer
		int m = sc.nextInt();
		// loop to read pairs of children for query
		for (int i=0;i<m;i++) {
			boolean ispath = path( sc.nextInt(), sc.nextInt());
			if(ispath)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		readTree();       // read in the tree
		readQueries();    // read in the queries

		// then process the queries ... fill in your calls below
	}
	public static boolean path(int i,int j)
	{
		ArrayList<city> path1 = new ArrayList<city>();//to record the cities from city i to root
		ArrayList<city> path2 = new ArrayList<city>();//to record the cities from city j to root

		city temp = cities[i];
		while(temp.getParent()!=-1)
		{
			path1.add(temp);
			temp = cities[temp.getParent()];
		}
		path1.add(cities[0]);//put the cities to path1

		temp = cities[j];
		while(temp.getParent()!=-1)
		{
			path2.add(temp);
			temp = cities[temp.getParent()];
		}
		path2.add(cities[0]);//put the ciities to path2

		for(int k=0;k<path1.size();k++)
		{
			for(int a=0;a<path2.size();a++)
			{
				//find the same city on the path
				if(path1.get(k).getIndex()==path2.get(a).getIndex())
				{
					if(path1.get(k).isSafe()==1)//the city is safe
					{
						return true;
					}
					else//the city is not safe
						return false;
				}
				else if(path1.get(k).isSafe()==0||path2.get(a).isSafe()==0)//if there any city not safe return false
				{
					return false;
				}
			}
		}
		return true;
	}




}

//the city class, I find MyTree.java not fit my method so  i use my own class
class city
{
	private int index;//the city's index
	private int left=-1;//left child index
	private int right=-1;//right child index
	private int isSafe;
	private int parent=-1;//parent index

	public city(int index)
	{
		this.index = index;
	}

	public city(int left,int right)
	{
		this.left = left;
		this.right = right;
	}
	public int getIndex()
	{
		return index;
	}
	public void setChild(int i,int j)
	{
		left = i;
		right = j;
	}
	public void setParent(int num)
	{
		parent = num;
	}
	public int getLeft()
	{
		return left;
	}
	public int getRight()
	{
		return right;
	}
	public int getParent()
	{
		return parent;
	}
	public void setSafe(int i)
	{
		isSafe = i;
	}
	public int isSafe()
	{
		return isSafe;
	}
}
