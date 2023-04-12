import java.util.*;

public class TreeGenealogyDriver {

    public static void main(String[] args) {

        // sc1 is used to read lines from the input
        // sc2 is used to tokenise and parse lines read by sc1

        Scanner sc1 = new Scanner(System.in);
        int N = Integer.parseInt(sc1.nextLine());
        MyTree tree = new MyTree(N);

        // construct tree

        for (int element = 0; element < N; element++) {

            Scanner sc2 = new Scanner(sc1.nextLine());
            int left = sc2.nextInt();
            int right = sc2.nextInt();

            tree.set(element,left,right);

        }

        // process queries

        int M = Integer.parseInt(sc1.nextLine());

        for (int i = 0; i < M; i++) {

            Scanner sc2 = new Scanner(sc1.nextLine());
            int A = sc2.nextInt();
            int B = sc2.nextInt();

            System.out.println(tree.relationship(A,B));

        }

    }

}
