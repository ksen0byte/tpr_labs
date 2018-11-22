package lab02;

import lab01.BinaryRelation;

public class Main {
    private static int[][] matrix1 = {
            {1, 0, 0, 0, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 0, 1}
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
        BinaryRelation binaryRelation3 = new BinaryRelation(matrix3);

        System.out.println("Q " + binaryRelation1);
        System.out.println("P " + binaryRelation2);
//        System.out.println("R " + binaryRelation3);

        //Визначення типу відношення
        System.out.println("Types of relation :");
        typeOfRelationExclusion(binaryRelation1);

        //Факторизація
        System.out.print("\nFactorization of ");
        System.out.println(binaryRelation2.relationFactorization());

    }

    public static void typeOfRelation(BinaryRelation obj) {
        if (obj.isReflective()) {
            System.out.println("Is reflective");
        }
        if (obj.isAntiReflective()) {
            System.out.println("Is anti reflective");
        }
        if (obj.isSymmetric()) {
            System.out.println("Is symmetric");
        }
        if (obj.isAsymmetric()) {
            System.out.println("Is asymmetric");
        }
        if (obj.isAntisymmetric()) {
            System.out.println("Is anti symmetric");
        }
        if (obj.isTransitive()) {
            System.out.println("Is transitive");
        }
        if (obj.isAcyclic()) {
            System.out.println("Is acyclic");
        }
        if (obj.isConnected()) {
            System.out.println("Is connected");
        }


        if (obj.isTolerant()) {
            System.out.println("Is tolerant");
        }
        if (obj.isEquivalent()) {
            System.out.println("Is equivalent");
        }
        if (obj.isQuasiOrder()) {
            System.out.println("Is quasi order");
        }
        if (obj.isOrder()) {
            System.out.println("Is order");
        }
        if (obj.isStrictOrder()) {
            System.out.println("Is strict order");
        }
        if (obj.isLinearOrder()) {
            System.out.println("Is linear order");
        }
        if (obj.isStrictLinearOrder()) {
            System.out.println("Is strict linear order");
        }


    }

    public static void typeOfRelationExclusion(BinaryRelation obj) {
        if (obj.isTransitive()) {
            typeOfRelation(obj);
        } else {
            BinaryRelation objTemp = new BinaryRelation(obj.get());
            objTemp = objTemp.transitiveClosure();
            typeOfRelation(objTemp);

        }

    }
}
