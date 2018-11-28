package lab01;

public class Main {
    public static void main(String[] args) {
        //P matrix
        int[][] p = {{0, 0, 0, 1, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1}};
        //Q matrix

        int[][] q = {{0, 1, 0, 0, 1},
                {1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0}};
        //R matrix
        int[][] r = {{1, 1, 0, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 1, 0, 1},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 0, 0}};


        BinaryRelation P = new BinaryRelation(p);
        BinaryRelation Q = new BinaryRelation(q);
        BinaryRelation R = new BinaryRelation(r);

        System.out.println(P.composition(Q));

        System.out.println("P " + P);
        System.out.println("Q " + Q);
        System.out.println("R " + R);


        BinaryRelation result = P.composition(Q);
        System.out.println("\nP o Q :");
        System.out.println(result);

        System.out.println("\nR!:");
        System.out.println(R.addition());
        System.out.println("\nR! ^(-1):");
        System.out.println(R.addition().transpose());
        System.out.println("\n(P o Q)/((R!) ^(-1)) :");
        result = result.difference(R.addition().transpose());
        System.out.println(result);

        Intersection intersection = new Intersection(P);
        System.out.println(intersection);

    }
}
