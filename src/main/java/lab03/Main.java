package lab03;

public class Main {
    private static double[][] matrix1 = {
            {0, 0, 0, 5, 0},
            {2, 0, 0, 7, 1},
            {4, 2, 0, 9, 3},
            {0, 0, 0, 0, 0},
            {1, 0, 0, 6, 0}
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

        MetricRelation metricRelation1 = new MetricRelation(matrix1);
        MetricRelation metricRelation2 = new MetricRelation(matrix2);
//        MetricRelation metricRelation3 = new MetricRelation(matrix3);
//        MetricRelation metricRelation4 = new MetricRelation(matrix4);

        System.out.println("P " + metricRelation1);

        System.out.println("Q " + metricRelation2);

//        System.out.println("P1 " + metricRelation3);
//
//        System.out.println("Q1 " + metricRelation4);

        System.out.println("Intersection P and Q:");
        System.out.println(metricRelation1.intersection(metricRelation2));
        System.out.println("Union P and Q:");
        System.out.println(metricRelation1.union(metricRelation2));
        System.out.println("Difference P and Q:");
        System.out.println(metricRelation1.difference(metricRelation2));
        System.out.println("Composition P and Q:");
        System.out.println(metricRelation1.composition(metricRelation2));

//        System.out.println("Intersection P1 and Q1:");
//        System.out.println(metricRelation3.intersection(metricRelation4));
//        System.out.println("Union P1 and Q1:");
//        System.out.println(metricRelation3.union(metricRelation4));
//        System.out.println("Difference P1 and Q1:");
//        System.out.println(metricRelation3.difference(metricRelation4));
//        System.out.println("Composition P1 and Q1:");
//        System.out.println(metricRelation3.composition(metricRelation4));

    }

}
