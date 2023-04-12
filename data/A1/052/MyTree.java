/** Class for a tree node
 */
public class MyTree {
	private int[] left;
	private int[] right;              // use array approach to implement the tree, size for number of cities
    private boolean[] safe;           //left[] and right[] each refers to left child and right child
	private int size;                 //safe[] for state of each city

	public MyTree(int n){
		size = n;
		left = new int[n];
		right = new int[n];
		safe = new boolean[n];
	}

	public void setChild(int name, int leftC, int rightC){
		left[name] = leftC;
		right[name] = rightC;
	}

	public void setSafe(int name, boolean state){
		safe[name] = state;
	}

	public boolean findPath(int start, int end){
		int[] way1 = new int[size];               //here I first try to find a common root
		int[] way2 = new int[size];               //I start with finding the routes from city "start" and "end" to the capital
		way1[0] = start;                          //and call them way1 and way2, "count" is for the size
		way2[0] = end;
		int count1 = 1;
		int count2 = 1;

		while(start != 0 && end != 0){              //keep going util both "strat" and "end" reaches the capital
			for (int i = 0; i< size; i++){
				if (left[i] == start || right[i] == start){     //if start is a child of some city, add the city into the
					way1[count1] = i;                           // way1 and count++, and assign the root city to "start" for      
					count1 ++;                                  // keeping on searching the route
					start = i;
				}
				if (left[i] == end || right[i] == end){         // similar to above
					way2[count2] = i;
					count2 ++;
					end = i;
				}
			}
		}

		int common;
		int coPoint1 = count1;                             //after finding the routes, I here try to find the first
		int coPoint2 = count2;                             //city the two ways collide, which is the first common root
		for (int i = count1 - 1; i >= 0; i--){
			for (int j = count2 - 1; j >= 0; j--){
				if (way1[i] == way2[j]){
					common = way1[i];
					coPoint1 = i;                          //coPoint1 identify the position of the first common root in way1
					coPoint2 = j;
				}
			}
		}

		boolean path = true;
		for (int i = 0; i <= coPoint1; i++){             //along the two ways to their first common root, find whether it is safe
			path = path && safe[way1[i]];
		}
		for (int j = 0; j <= coPoint2; j++){
			path = path && safe[way2[j]];
		}

		return path;
	}

}
