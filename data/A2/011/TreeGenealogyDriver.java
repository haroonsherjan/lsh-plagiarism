///////////////////////////////////////////
//
// Lab: 09 Ex 2
//
// Driver class for MyTree
//
//////////////////////////////////////////


import java.util.*;

public class TreeGenealogyDriver
{

    public static void main(String[] args) 
	{
		Scanner input = new Scanner (System.in);
		
		// Input no. of nodes in tree & creates an array of nodes
		int size = input.nextInt();
		IntNode[] arr = new IntNode [size];

		// Create nodes
		for(int x = 0; x < size; x++)
		{
			arr[x] = new IntNode (x);
		}

		// Input left and right child of nodes
		for(int x = 0; x < size; x++)
		{
			int left = input.nextInt();
			int right = input.nextInt();
			
			if( left != -1 )
				arr[x].setLeft(arr[left]);
			if (right != -1)
				arr[x].setRight(arr[right]);
		}

		// Creation of tree
		MyTree tree = new MyTree (arr[0]);

		// Input no. of operations to perform
		int operations = input.nextInt();

		// Perform checks
		for(int x = 0; x < operations; x++)
		{
			int a = input.nextInt();
			int b = input.nextInt();
			tree.checkTree(a, b);
		}

    }	// end main method
}   // end TreeGenealogyDriver
