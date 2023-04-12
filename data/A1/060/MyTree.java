/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;             // is the city safe?
   // int leftChildIndex;			  // left child index in array
   // int rightChildIndex;		 // right child index in array

    int city;
    public MyNode(int number,boolean safety)
	{
       city = number;
	   isSafe = safety;

}
    /*else  if(child < root)
		        {
			                leftChildIndex = child;
				             }
				              else
				             {
					                   rightChildIndex = child;
						                }


}

/*    public void setLeft(int city,boolean safety)
	{
     leftChildIndex = city;
	 isSafe = safety;
	}
	
    public void setRight(int city,boolean safety)
	{
		rightChildIndex = city;
		isSafe = safety;
		}

    */
}

/** Class for a binary tree ADT
 */
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed
    int[] nodes;
    public MyTree(int[] safe,int[] child)
	{
		int[] status_safe = safe;
		nodes = child;
		boolean  status;
		for(int i=0;i<nodes.length;i++)
				{  if(status_safe[i]==0)
				{ status =true;
					}
					else
					{
						status=false;
						}
					myTree[i] = new MyNode(nodes[i],status);
        size++;   
	}
	}
    
	public boolean getRoute(int start,int end)
	{
		int indexBegin=0;
		int indexEnd =0;
       for(int j=0;j<nodes.length;j++)
	   {
		   if(nodes[j]==start)
		   {
			   indexBegin = j;
			   }
			   if(nodes[j]==end)
			   {
				   indexEnd = j;
				   }
		   }

		   return check(indexBegin,indexEnd);


		}

     public boolean check(int start,int end)
	 {
		 boolean result;
		 for(int k=start;k<=end;k++)
		 {
			 if(myTree[k].isSafe)
			 {
				 result =true;
				 }
				 else
				 {
					 result =  false;
					 }
			 }
 return result;		 
}
	// fill in your ADT methods here
    // ...
}
