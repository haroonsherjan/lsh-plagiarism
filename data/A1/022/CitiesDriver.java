import java.util.*;
public class CitiesDriver {
    static Scanner sc;
	static MyTree city = new MyTree();
    
    /** Read in the tree
     */
    public static void readTree () 
	{
		/// Read in the tree
		// read in one integer
		int n = sc.nextInt();
		
		// read in tree, safety line
		for (int i = 0; i < n; i++)
			city.addNode(new Node(sc.nextInt()));
		
		// loop to read pairs of children
		for (int i = 0; i < n; i++)
		{
			int child1 = sc.nextInt();
			int child2 = sc.nextInt();
			myTree.get(i).setLeft(child1);
			myTree.get(i).setRight(child2);
			myTree.get(child1).setParent(i);
			myTree.get(child2).setParent(i);
    	}
	}
	
    
    public static void main(String[] args) 
	{
		sc = new Scanner(System.in);
		readTree();				   // read in the tree

		int m = sc.nextInt(); // number of querries
		for (int i = 0; i < m; i++)
		{
			int city1 = sc.nextInt();
			int city2 = sc.nextInt();
			city.travel(city1, city2);
		}
    }
}
