import java.util.*;

/**
 * Driver class, you may have to change it to fit your implementation
 * Make sure you compile and run this class
 */
public class CitiesDriver { 
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int number = sc.nextInt();

	MyTree cities = new MyTree(number);
	for (int k = 0; k < number; k++){
		cities.setSafe(k, (sc.nextInt() == 1));
	}
	for (int k = 0; k < number; k++){
		cities.setChild(k, sc.nextInt(), sc.nextInt());
	}

	int command = sc.nextInt();
	for (int k = 0; k < command; k++){
		if (cities.findPath(sc.nextInt(), sc.nextInt())){
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}

    }
}
