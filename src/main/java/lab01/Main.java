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

        Intersection intersection = new Intersection(P);
        System.out.println(intersection);

//        System.out.println("MATRIX P:");
//        P.show();
//        System.out.println("\nMATRIX Q:");
//        Q.show();
//        System.out.println("\nMATRIX R:");
//        R.show();


//        result = P.composition(Q);
//        System.out.println("\nP o Q :");
//        result.show();
//
//        System.out.println("\nR!:");
//        R.addition().show();
//        System.out.println("\nR! ^(-1):");
//        R.addition().transpose().show();
//        System.out.println("\n(P o Q)/((R!) ^(-1)) :");
//        result = result.difference(R.addition().transpose());
//        result.show();

    }
}
