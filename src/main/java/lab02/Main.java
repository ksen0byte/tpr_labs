package lab02;

import lab01.BinaryRelation;

public class Main {
    private static int[][] matrix1 = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 1, 0},
            {0, 0, 1, 0, 1},
            {1, 0, 0, 1, 0},
            {0, 0, 1, 0, 0}
    };
    private static int[][] matrix2 = {
            {0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0},
    };
    private static int[][] matrix3 = {
            {0, 1, 1, 0, 0},
            {0, 0, 1, 0, 1},
            {0, 1, 0, 0, 0},
            {1, 1, 1, 1, 1},
            {1, 0, 1, 1, 0}
    };


    public static void main(String[] args) {
        BinaryRelation binaryRelation1 = new BinaryRelation(matrix1);
        BinaryRelation binaryRelation2 = new BinaryRelation(matrix2);
//        BinaryRelation binaryRelation3 = new BinaryRelation(matrix3);

        System.out.println("Q " + binaryRelation1);
        System.out.println("P " + binaryRelation2);
//        System.out.println("R " + binaryRelation3);

        //Визначення типу відношення
        System.out.println("Types of relation :");
        binaryRelation1.printRelationType();

        //Факторизація
        System.out.print("\nFactorization of ");
        System.out.println(binaryRelation1.relationFactorization());

    }

    public static void excludeRelationType(BinaryRelation obj) {
        if (obj.isTransitive()) {
            obj.printRelationType();
        } else {
            BinaryRelation objTemp = new BinaryRelation(obj.get());
            objTemp = objTemp.transitiveClosure();
            objTemp.printRelationType();

        }

    }
}
