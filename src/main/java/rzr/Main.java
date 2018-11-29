package rzr;

import lab01.BinaryRelation;
import lab01.Intersection;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    private static BinaryRelation PRelation = new BinaryRelation(new int[][]{
            {1, 1, 0, 1, 1},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 1, 0},
            {1, 0, 0, 1, 1},
            {1, 0, 0, 1, 1}
    });
    private static BinaryRelation QRelation = new BinaryRelation(new int[][]{
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0},
            {1, 1, 1, 1, 0}

    });
    private static BinaryRelation RRelation;

    static {
        Intersection intersection = new Intersection(Arrays.asList(
                new Intersection.Holder(1, Arrays.asList(1, 3)),
                new Intersection.Holder(2, Collections.singletonList(2)),
                new Intersection.Holder(4, Arrays.asList(2, 3)),
                new Intersection.Holder(5, Arrays.asList(1, 2, 3))
        ));
        RRelation = intersection.getBinaryRelation(5);
    }

    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
        ex5();

        System.out.println("=======================> Ex 6 <=======================");

    }

    private static void ex5() {
        System.out.println("=======================> Ex 5 <=======================");
        System.out.println("Relation factorization");
        BinaryRelation relationFactorization = PRelation.relationFactorization(PRelation.symmetricPart().get());
        System.out.println(relationFactorization);
    }

    private static void ex4() {
        System.out.println("=======================> Ex 4 <=======================");
        System.out.println("Dominant relation");
        System.out.println(PRelation.asymmetricPart());
        System.out.println("Ignorant relation");
        System.out.println(PRelation.asymmetricPart());
        System.out.println("Disparity relation");   // непорівняльності
        System.out.println(PRelation.disparity());
    }

    private static void ex3() {
        System.out.println("=======================> Ex 3 <=======================");
        System.out.println("Transitive closure");
        BinaryRelation transitiveClosure = RRelation.transitiveClosure();
        System.out.println(transitiveClosure);
        System.out.println("Transitive closure");
        BinaryRelation mutualReach = RRelation.mutualReach();
        System.out.println(mutualReach);
    }

    private static void ex1() {
        System.out.println("=======================> Ex 1 <=======================");
        System.out.println("Composition:");
        BinaryRelation composition = PRelation.composition(QRelation);
        System.out.println(composition);

        System.out.println("Symmetric difference:");
        BinaryRelation symmetricDifference = QRelation.symmetricDifference(PRelation);
        System.out.println(symmetricDifference);
    }

    private static void ex2() {
        System.out.println("=======================> Ex 2 <=======================");
        QRelation.printRelationType();
    }
}
