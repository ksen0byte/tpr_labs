package lab03;

import org.junit.Test;

import java.util.Arrays;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static org.junit.Assert.assertTrue;

public class MetricRelationTest {

    @Test
    public void composition_additive() {
        double[][] p = {
                {0, 0, 0, 5, 0},
                {2, 0, 0, 7, 1},
                {4, 2, 0, 9, 3},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 6, 0},
        };

        double[][] q = {
                {0, 0, 0, 0, 0},
                {5, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {4, 0, 0, 0, 0},
                {7, 2, 0, 3, 0},
        };

        double[][] expected = {
                {9, 0, 0, 0, 0},
                {9.5, 3, 0, 4, 0},
                {10, 5, 0, 6, 0},
                {0, 0, 0, 0, 0},
                {10, 0, 0, 0, 0},
        };

        MetricRelation pRelation = new MetricRelation(p);
        MetricRelation qRelation = new MetricRelation(q);
        double[][] result = pRelation.composition(qRelation).get();

        System.out.println(Arrays.deepToString(result));

        assertTrue(Arrays.deepEquals(result, expected));

    }

    @Test
    public void composition_multiplicative() {
        double[][] p = {
                {1, 3, 6, 6, 12},
                {0, 1, 2, 2, 4},
                {0, 0, 1, 1, 2},
                {0, 0, 1, 1, 2},
                {0, 0, 0, 0, 1},
        };

        double[][] q = {
                {1, 0, 0, 2, 10},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 6},
                {0, 0, 0, 1, 5},
                {0, 0, 0, 0, 1},
        };

        double[][] expected = {
                {1, 3, 6, sqrt(12), pow(129600, 0.25)},
                {0, 1, 2, 2, pow(480, 1. / 3)},
                {0, 0, 1, 1, pow(60, 1. / 3)},
                {0, 0, 1, 1, pow(60, 1. / 3)},
                {0, 0, 0, 0, 1},
        };

        MetricRelation pRelation = new MetricRelation(p);
        MetricRelation qRelation = new MetricRelation(q);
        double[][] result = pRelation.composition(qRelation).get();

        System.out.println(pRelation.composition(qRelation));

        assertTrue(Arrays.deepEquals(result, expected));
    }

}