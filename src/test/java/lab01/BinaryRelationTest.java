package lab01;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class BinaryRelationTest {
    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] matrix3;

    @Before
    public void setUp() {
        matrix1 = new int[][]{
                {1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1}
        };
        matrix2 = new int[][]{
                {1, 1},
                {0, 1}
        };
        matrix3 = new int[][]{
                {1, 1, 0},
                {0, 0, 0},
                {1, 0, 1}
        };
    }

    @Test
    public void testComposition_power1() {
        BinaryRelation binaryRelation = new BinaryRelation(matrix1);
        BinaryRelation result = binaryRelation.composition(binaryRelation, 1);

        int[][] expected = {
                {1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1}
        };
        assertTrue(Arrays.deepEquals(expected, result.get()));
    }


    @Test
    public void testComposition_power2() {
        BinaryRelation binaryRelation = new BinaryRelation(matrix1);
        BinaryRelation result = binaryRelation.composition(binaryRelation, 2);

        int[][] expected = {
                {1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        assertTrue(Arrays.deepEquals(expected, result.get()));
    }

    @Test
    public void testComposition_power3() {
        BinaryRelation binaryRelation = new BinaryRelation(matrix1);
        BinaryRelation result = binaryRelation.composition(binaryRelation, 3);

        int[][] expected = {
                {1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        assertTrue(Arrays.deepEquals(expected, result.get()));
    }

    @Test
    public void testReach_2x2() {
        BinaryRelation binaryRelation = new BinaryRelation(matrix2);
        BinaryRelation result = binaryRelation.reach();

        int[][] expected = {
                {1, 1},
                {0, 1}
        };
        assertTrue(Arrays.deepEquals(expected, result.get()));
    }

    @Test
    public void testReach_3x3() {
        BinaryRelation binaryRelation = new BinaryRelation(matrix3);
        BinaryRelation result = binaryRelation.reach();

        int[][] expected = {
                {1, 1, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        assertTrue(Arrays.deepEquals(expected, result.get()));
    }

    @Test
    public void testIsEquivalent_2x2() {
        int[][] m = {
                {1, 0},
                {0, 1}
        };

        BinaryRelation binaryRelation = new BinaryRelation(m);
        assertTrue(binaryRelation.isEquivalent());
    }

    @Test
    public void testRelationFactorization() {
        int[][] m = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0, 1}
        };

        BinaryRelation binaryRelation = new BinaryRelation(m);
        BinaryRelation relationFactorization = binaryRelation.relationFactorization();

        int[][] expected = {
                {1, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 1, 1}
        };

        assertTrue(Arrays.deepEquals(expected, relationFactorization.get()));

    }
}