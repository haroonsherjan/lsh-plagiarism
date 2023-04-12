import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class TreeGenealogyDriver {
    static Scanner sc;

    /** Read in the tree
     */
    public static void readTree () {
	// read in one integer
		int noOfLines = sc.nextInt();
		// loop to read pairs of children
		position[0] = 0;
		for (int i=0;i<noOfLines;i++) {
		    int x = sc.nextInt();				// modify this line
				if (x != -1){
					position[2*i + 1] = x;		//leftNode's value = x
				}
				else{
					position[2*i + 1] = null;	//if y = -1, leave leftNode as null
				}
		    int y = sc.nextInt();			   // modify this line
			if (y != -1){
				position[2*i + 2] = y;		//rightNode's value = y
			}
			else{
				position[2*1 + 2] = null;  //if y = -1, leave rightNode as null
			}
    	}
	}
    
    /** Read in query statements
     */
    public static void readQueries () {
	// read in one integer
		int noOfInstr = sc.nextInt();
		// loop to read pairs of children for query
		for (int i=0;i<noOfInstr;i++) {
		    int a = sc.nextInt();			   // modify this line
			public int getPosition(a){
				indexA = a.getIndex();
				return indexA;		//return position of a given value of a
			}
			
		    int b = sc.nextInt();			   // modify this line
			public int getPosition(b){
				indexB = b.getIndex();
				return indexB;		//return position of b given value of b
			}
		}
	}
    
    public static void main(String[] args) {
		sc = new Scanner(System.in);
		readTree();				   // read in the tree
		readQueries();				// read in the queries

	// then process the queries ... fill in your calls below
		public readQueries(){
			if (indexA == indexB + 1){
				for (int i = 0; i < noOfLines; i++){
					if ((indexA == 2i+2)&&(indexB == 2i+1)){	//for same level i
						System.out.println("RIGHT SIBLING");
					}
				}
			}
			else if (indexA == indexB - 1){
				for (int i = 0; i < noOfLines; i++){
					if ((indexA==2i+1)&&(indexB == 2i+2)){		//for same level i
						System.out.println("LEFT SIBLING");
					}
				}
			}
			else if ((indexA == indexB*2 +1)|| (indexA == indexB*2 +2) || (indexA == 0 && (indexB ==1|| indexB ==2))){	//a is ancestor, b is descendant
				System.out.println("ANCESTOR");
			}
			else if ((indexB == indexA*2+1) || (indexB == indexA*2 +2)||(indexB == 0 && (indexA== 1 || indexA == 2))){ //a is descendant, b is ancestor
				System.out.println("DESCENDANT");
			}
			else{
				System.out.println("NONE");
			}

		}

	}

}
