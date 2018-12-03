package rzr;

import lab01.BinaryRelation;
import lab01.Intersection;
import lab03.MetricRelation;

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
    private static MetricRelation SRelation = new MetricRelation(new Double[][]{
            {0., -1., 1., -2., 0.},
            {1., 0., 2., -1., 1.},
            {-1., -2., 0., -3., -1.},
            {2., 1., 3., 0., 2.},
            {0., -1., 1., -2., 0.},
    });
    private static MetricRelation TRelation = new MetricRelation(new Double[][]{
            {0., -2., -2., 1., -2.},
            {2., 0., 0., 3., 0.},
            {2., 0., 0., 3., 0.},
            {-1., -3., -3., 0., -3.},
            {2., 0., 0., 3., 0.},
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
        ex6();
        ex7();
        ex8();
    }

    private static void ex8() {
        System.out.println("=======================> Ex 8 <=======================");
        System.out.println("S:");
        System.out.println(SRelation);
        System.out.println("T:");
        System.out.println(TRelation);
        System.out.println("Distance between s and t");
        System.out.println(SRelation.findDistance(TRelation));
    }

    private static void ex7() {
        System.out.println("=======================> Ex 7 <=======================");
        System.out.println("Q:");
        System.out.println(QRelation);
        System.out.println("R:");
        System.out.println(RRelation);
        System.out.println("Distance between q and r");
        System.out.println(QRelation.findDistance(RRelation));
    }

    private static void ex6() {
        System.out.println("=======================> Ex 6 <=======================");
        System.out.println("R:");
        System.out.println(RRelation);
        System.out.println("Maximum:");
        System.out.println(RRelation.max());
        System.out.println("Minimum:");
        System.out.println(RRelation.min());
        System.out.println("Major:");
        System.out.println(RRelation.major());
        System.out.println("Minor:");
        System.out.println(RRelation.minor());
    }

    private static void ex5() {
        System.out.println("=======================> Ex 5 <=======================");
        BinaryRelation symmetricPart = PRelation.symmetricPart();
        System.out.println("Symmetric part");
        System.out.println(symmetricPart);
        BinaryRelation relationFactorization = PRelation.relationFactorization(symmetricPart.get());
        System.out.println("Relation factorization");
        System.out.println(relationFactorization);
    }

    private static void ex4() {
        System.out.println("=======================> Ex 4 <=======================");
        System.out.println("Dominant relation");
        System.out.println(PRelation.asymmetricPart());
        System.out.println("Ignorant relation");
        System.out.println(PRelation.symmetricPart());
        System.out.println("Disparity relation");   // непорівняльності
        System.out.println(PRelation.disparity());
    }

    private static void ex3() {
        System.out.println("=======================> Ex 3 <=======================");
        System.out.println("Transitive closure");
        BinaryRelation transitiveClosure = RRelation.transitiveClosure();
        System.out.println(transitiveClosure);
        System.out.println("Symmetric part");
        BinaryRelation mutualReach = RRelation.mutualReach();
        System.out.println(mutualReach);
    }

    private static void ex1() {
        System.out.println("=======================> Ex 1 <=======================");
        System.out.println("Composition:");
        BinaryRelation composition = QRelation.composition(RRelation);
        System.out.println(composition);

        System.out.println("Symmetric difference:");
        BinaryRelation symmetricDifference = QRelation.symmetricDifference(RRelation);
        System.out.println(symmetricDifference);
    }

    private static void ex2() {
        System.out.println("=======================> Ex 2 <=======================");
        System.out.println("Q:");
        System.out.println(QRelation);
        QRelation.printRelationType();
    }
}
