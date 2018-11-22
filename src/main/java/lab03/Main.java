package lab03;

public class Main {
    private static double[][] matrix1 = {
            {0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {5, 4, 0, 2, 3},
            {3, 2, 0, 0, 1},
            {2, 1, 0, 0, 0}
    };
    private static double[][] matrix2 = {
            {0, 0, 0, 0, 0},
            {5, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {4, 0, 0, 0, 0},
            {7, 2, 0, 3, 0},
    };
    private static double[][] matrix3 = {
            {1, 0, 0, 0, 7},
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 6, 0, 1, 0},
            {0, 0, 0, 0, 1}
    };
    private static double[][] matrix4 = {
            {1, 0, 0, 0, 0},
            {0, 1, 2, 0, 8},
            {0, 0, 1, 0, 4},
            {1, 1, 2, 1, 8},
            {0, 0, 0, 0, 1}
    };


    public static void main(String[] args) {

        MetricRelation metricRelation = new MetricRelation(matrix1);

    }
}
