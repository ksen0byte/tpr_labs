package lab02;

import lab01.BinaryRelation;
import lab01.Intersection;

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
        BinaryRelation binaryRelation = new BinaryRelation(matrix2);
        System.out.println(binaryRelation.mutualReach());


    }
}
