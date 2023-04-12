import java.util.*;

public class CitiesDriver
{
	public static void main(String [] args)
	{
		Scanner stdIn = new Scanner(System.in);

		int n = stdIn.nextInt(); //no. of cities


		MyNode[] cities = new MyNode[n];

//***********************************************************

		for ( int i = 0; i < n; i++) //setting isSafe
		{
			cities[i] = new MyNode();
			cities[i].setIsSafe(stdIn.nextInt());
		}

//***********************************************************
		
		for (int i = 0; i < n; i++) //setting right and left child index
		{
			cities[i].setLeftChildIndex(stdIn.nextInt());
			cities[i].setRightChildIndex(stdIn.nextInt());
		}

//***********************************************************
/*
for (int i = 0; i < n; i++)
{
	System.out.println("isSafe = " +cities[i].getIsSafe() + " leftChildIndex = " + cities[i].getLeftChildIndex() + " rightchildIndex = " + cities[i].getRightChildIndex()); 
	}
	*/

	int m = stdIn.nextInt(); //number of queries
	int start;//index of start city
	int end = 0;//index of end city
	int curr = end;//index of current node we are at
	boolean isPath = true;

/*
 case 1: check if destination city or start city is unsafe,
if any is unsafe print unsafe
	case 2:
check the childs of each array[] to see which one has destination city
so basically we need a destination city variable that keeps changing
as we check
then check array[] with the child as the destination city if it is safe
if safe continue until we reach the start city then we stop and we print
	safe
	else break and print unsafe
		*/

for (int j = 0; j<m; j++)
{
	start = stdIn.nextInt();
	end = stdIn.nextInt();
	curr = end;

	if (cities[start].getIsSafe() == false || cities[end].getIsSafe() == false)
	{
		isPath = false;
		System.out.println("NO");
	}

	else
	{
		while (curr!=start)
		{
			for(int k = 0; k < n; k++) //iterating through cities array
			{
				if(cities[k].getRightChildIndex() == curr)
				{
					curr = k;
				}

				if(cities[k].getLeftChildIndex() == curr)
				{
					curr = k;
				}
			}//end for loop

			if(cities[curr].getIsSafe() == false)
			{
				isPath = false;
				System.out.println("NO");
				break; //break out of while loop and continue onto next query
			}

			//else continue onto next curr

		}//end while loop
	}// end else

	if (isPath == true)
	{
		System.out.println("YES");
	}

}//end for number of queries loop

	
	}//end of main
}//end of CitiesDriver.java



