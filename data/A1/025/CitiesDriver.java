import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver {
    static Scanner sc;
        
    public static void main(String[] args) {
	sc = new Scanner(System.in);
	//the code below is to construct a tree
	int n = sc.nextInt();
	MyNode[] tree = new MyNode[n];
	for (int i=0;i<n;i++)
	{
		tree[i]=new MyNode();
		tree[i].setState(sc.nextInt());
	}

    tree[0].setParent(-1);//the parent of the root is set to -1
	for (int i=0;i<n;i++) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		//set right left child and parent
		tree[i].setLeft(a);
		tree[i].setRight(b);
		if(a!=-1)
			tree[a].setParent(i);
		if(b!=-1)
			tree[b].setParent(i);
	}

	int m = sc.nextInt();
	for(int i=0;i<m;i++)
	{
		boolean isSafe = false;
		int city1 = sc.nextInt();
		int city2 = sc.nextInt();
		//use an arraylist to keep track of the safe root of city1
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int current1 = city1;
		int index1 = 0;
		do
		{
			temp.add(current1);
			current1 = tree[current1].getParent();
			index1++;
		}while(current1!=-1&&tree[current1].getState());//terminate util we reach the root or find a city that is not safe

		int current2 = city2;
		int index2 = 0;
		do
		{
			//check whether there is a city that is in the routine of city1, if so then there is a safe root
			for(int j=0;j<temp.size();j++)
			{
				if(current2 == temp.get(j)) 
					isSafe = true;
			}
			current2 = tree[current2].getParent();
			index2++;
		}while(current2!=-1&&tree[current2].getState());

		if(isSafe)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	// then process the queries ... fill in your calls below
    }
}
