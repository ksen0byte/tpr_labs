package rzr;

import lab01.BinaryRelation;
import lab01.Intersection;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    private static int[][] P = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 1, 0},
            {0, 0, 1, 0, 1},
            {1, 0, 0, 1, 0},
            {0, 0, 1, 0, 1}
    };
    private static int[][] Q = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 1, 1},
            {1, 1, 0, 0, 1},
            {0, 0, 0, 0, 0}

    };

    public static void main(String[] args) {
        BinaryRelation PRelation = new BinaryRelation(P);
        BinaryRelation QRelation = new BinaryRelation(Q);

        ex1(PRelation, QRelation);
        ex2(QRelation);

        System.out.println("=======================> Ex 3 <=======================");
        Intersection intersection = new Intersection(Arrays.asList(
                new Intersection.Holder(1, Collections.singletonList(2)),
                new Intersection.Holder(2, Collections.singletonList(5)),
                new Intersection.Holder(3, Collections.singletonList(2))
        ));
        BinaryRelation RRelation = intersection.getBinaryRelation(5);
        System.out.println(RRelation);

    }

    private static void ex1(BinaryRelation PRelation, BinaryRelation QRelation) {
        System.out.println("=======================> Ex 1 <=======================");
        System.out.println("Composition:");
        BinaryRelation composition = PRelation.composition(QRelation);
        System.out.println(composition);

        System.out.println("Symmetric difference:");
        BinaryRelation symmetricDifference = QRelation.symmetricDifference(PRelation);
        System.out.println(symmetricDifference);
    }

    private static void ex2(BinaryRelation QRelation) {
        System.out.println("=======================> Ex 2 <=======================");
        QRelation.printRelationType();
    }
}
