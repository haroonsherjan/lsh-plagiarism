import java.util.*;
/** Class for a tree node
 */
class MyNode{
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
}

/** Class for a binary tree ADT
 */
public class MyTree {
    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed

	public void updateSafety(int cityIndex, int safe)
	{myTree[cityIndex]=new MyNode();
	 size++;
	 if(safe==0)
	   myTree[cityIndex].isSafe=false;
	 else myTree[cityIndex].isSafe=true;
	}

	public void updateChild(int cityIndex, int left, int right)
	{myTree[cityIndex].leftChildIndex=left;
	 myTree[cityIndex].rightChildIndex=right;
	}

	public boolean safePath(int start, int end)
 	{if(myTree[start].isSafe==false)
	      return false;
     else if(myTree[end].isSafe==false)
          return false;
     else if(start==end)
		 return true;
	 else 
	   {for(int i=0;i<size;i++)
		  if(myTree[i].leftChildIndex==start||myTree[i].rightChildIndex==start&&myTree[i].isSafe==true)
		      return safePath(i, end);
		   else if(myTree[i].leftChildIndex==end||myTree.rightChildIndex==end&&myTree[i].isSafe==true)
			   return safePath(start, i);
			  
	      else return false;}
	}
}
