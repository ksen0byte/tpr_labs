package lab01;

import java.util.Arrays;

public class BinaryRelation implements Relation {

    private int[][] matrix;
    private int size;

    public BinaryRelation(MatrixType matrixType, int size) {
        this.size = size;
        matrix = new int[size][size];
        switch (matrixType) {
            case NULL: {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            break;
            case FULL: {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        matrix[i][j] = 1;
                    }
                }
            }
            break;
            case DIAGONAL: {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (i == j) {
                            matrix[i][j] = 1;
                        } else {
                            matrix[i][j] = 0;
                        }
                    }
                }
            }
            break;
            case ANTI_DIAGONAL: {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (i == j) {
                            matrix[i][j] = 0;
                        } else {
                            matrix[i][j] = 1;
                        }
                    }
                }
            }
            break;
        }
    }

    public BinaryRelation(int matrix[][]) {
        if (matrix.length != matrix[0].length) {
            throw new RuntimeException("Square matrix required");
        }

        this.size = matrix.length;
        this.matrix = matrix;
    }

    private boolean isEmpty() {
        boolean cond = false;
        if (matrix == null) {
            cond = true;
        }
        return cond;
    }

    private boolean isEqual(BinaryRelation obj) {
        int[][] matrix2 = obj.get();
        boolean isSquare = matrix2.length == matrix2[0].length;
        boolean sizesEqual = matrix2.length == size;
        return isSquare && sizesEqual;
    }

    //Встановити нове відношення
    public void set(int number, int i, int j) {
        matrix[i][j] = number;
    }

    //Отримати матрицю відношення
    public int[][] get() {
        return matrix;
    }

    //Перетин
    @Override
    public BinaryRelation intersection(BinaryRelation obj) {
        int[][] matrix2 = obj.get();
        BinaryRelation result = new BinaryRelation(MatrixType.NULL, size);
        if (isEmpty() || (!isEqual(obj))) {
            result = null;
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if ((matrix[i][j] == 1) && (matrix2[i][j] == 1)) {
                        result.set(1, i, j);
                    }
                }
            }
        }
        return result;
    }

    //Об'єднання
    @Override
    public BinaryRelation union(BinaryRelation obj) {
        int[][] matrix2 = obj.get();
        BinaryRelation result = new BinaryRelation(MatrixType.NULL, size);
        if (isEmpty() || (!isEqual(obj))) {
            result = null;
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if ((matrix[i][j] == 1) || (matrix2[i][j] == 1)) {
                        result.set(1, i, j);
                    }
                }
            }
        }
        return result;
    }

    //Різниця
    @Override
    public BinaryRelation difference(BinaryRelation obj) {
        int[][] matrix2 = obj.get();
        BinaryRelation result = new BinaryRelation(MatrixType.NULL, size);
        if (isEmpty() || (!isEqual(obj))) {
            result = null;
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if ((matrix[i][j] == 1) && (matrix2[i][j] == 0)) {
                        result.set(1, i, j);
                    }
                }
            }
        }
        return result;
    }

    //Симетрична різниця
    @Override
    public BinaryRelation symmetricDifference(BinaryRelation obj) {
        int[][] matrix2 = obj.get();
        BinaryRelation result = new BinaryRelation(MatrixType.NULL, size);
        if (isEmpty() || (!isEqual(obj))) {
            result = null;
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (((matrix[i][j] == 1) && (matrix2[i][j] == 0)) || ((matrix[i][j] == 0) && (matrix2[i][j] == 1))) {
                        result.set(1, i, j);
                    }
                }
            }
        }
        return result;
    }

    //Доповнення
    @Override
    public BinaryRelation addition() {
        BinaryRelation result = new BinaryRelation(MatrixType.NULL, size);
        if (isEmpty()) {
            result = null;
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        result.set(1, i, j);
                    }
                }
            }
        }
        return result;
    }

    //Обернення
    @Override
    public BinaryRelation transpose() {
        BinaryRelation result = new BinaryRelation(MatrixType.NULL, size);
        if (isEmpty()) {
            result = null;
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    result.set(matrix[i][j], j, i);
                }
            }
        }
        return result;
    }

    //Композиція
    @Override
    public BinaryRelation composition(BinaryRelation obj) {
        int[][] matrix2 = obj.get();
        BinaryRelation result = new BinaryRelation(MatrixType.NULL, size);
        if (isEmpty() || (!isEqual(obj))) {
            result = null;
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 1) {
                        for (int k = 0; k < size; k++) {
                            if (matrix2[j][k] == 1) {
                                result.set(1, i, k);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    @Override
    public BinaryRelation composition(BinaryRelation binaryRelation, Integer power) {
        if (power <= 1) {
            return binaryRelation;
        } else {
            BinaryRelation composition = binaryRelation.composition(binaryRelation);
            return binaryRelation.composition(composition, power - 1);
        }
    }

    //Звуження
    @Override
    public BinaryRelation narrowing(int x) {
        BinaryRelation result = new BinaryRelation(MatrixType.NULL, size);
        if (isEmpty()) {
            result = null;
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (i == x) {
                        i++;
                    }
                    if (j == x) {
                        j++;
                    }
                    result.set(1, i, j);
                }
            }
        }
        return result;
    }

    @Override
    public boolean isPartOf(BinaryRelation relation) {
        int[][] left = this.get();
        int[][] right = relation.get();

        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < left[0].length; j++) {
                if (left[i][j] == 1 && right[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matrix: \n");

        for (int[] aMatrix : matrix) {
            for (int j = 0; j < size; j++) {
                sb.append(" ").append(aMatrix[j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean isReflective() {
        for (int i = 0; i < this.size; i++) {
            if (this.matrix[i][i] == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isAntiReflective() {
        for (int i = 0; i < this.size; i++) {
            if (this.matrix[i][i] == 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isSymmetric() {
        int[][] transposedMatrix = this.transpose().get();
        return Arrays.deepEquals(this.matrix, transposedMatrix);
    }

    @Override
    public boolean isAsymmetric() {
        BinaryRelation transposedMatrix = this.transpose();
        BinaryRelation intersection = this.intersection(transposedMatrix);
        BinaryRelation nullMatrix = new BinaryRelation(MatrixType.NULL, intersection.get().length);
        return Arrays.deepEquals(nullMatrix.get(), intersection.get());
    }

    @Override
    public boolean isAntisymmetric() {
        BinaryRelation transposedMatrix = this.transpose();
        BinaryRelation intersection = this.intersection(transposedMatrix);
        int size = intersection.get().length;
        return intersection.isPartOf(new BinaryRelation(MatrixType.DIAGONAL, size));
    }

    @Override
    public boolean isTransitive() {
        return this.composition(this).isPartOf(this);
    }

    @Override
    public boolean isAcyclic() {
        BinaryRelation transposedMatrix = this.transpose();
        BinaryRelation composition = this.composition(this, 5);
        BinaryRelation nullMatrix = new BinaryRelation(MatrixType.NULL, composition.get().length);

        return Arrays.deepEquals(nullMatrix.get(), transposedMatrix.intersection(composition).get());
    }

    @Override
    public boolean isConnected() {
        BinaryRelation transposedMatrix = this.transpose();
        BinaryRelation diagonalMatrix = new BinaryRelation(MatrixType.DIAGONAL, size);
        BinaryRelation antiDiagonalMatrix = new BinaryRelation(MatrixType.ANTI_DIAGONAL, size);

        return Arrays.deepEquals(this.union(transposedMatrix).difference(diagonalMatrix).get(), antiDiagonalMatrix.get());
    }

    @Override
    public boolean isTolerant() {
        return this.isReflective() && this.isSymmetric();
    }

    @Override
    public boolean isEquivalent() {
        return this.isTolerant() && this.isTransitive();
    }

    @Override
    public boolean isQuasiOrder() {
        return this.isReflective() && this.isTransitive();
    }

    @Override
    public boolean isOrder() {
        return this.isQuasiOrder() && this.isAntisymmetric();
    }

    @Override
    public boolean isStrictOrder() {
        return this.isAsymmetric() && this.isTransitive();
    }

    @Override
    public boolean isLinearOrder() {
        return this.isOrder() && this.isConnected();
    }

    @Override
    public boolean isStrictLinearOrder() {
        return this.isLinearOrder() && this.isStrictOrder();
    }

    @Override
    public BinaryRelation reach() {
        BinaryRelation diagonal = new BinaryRelation(MatrixType.DIAGONAL, this.size);
        BinaryRelation result = transitiveClosure();
        return diagonal.union(result);
    }

    @Override
    public BinaryRelation transitiveClosure() {
        BinaryRelation result = this;
        for (int i = 2; i <= size; i++) {
            result = result.union(result.composition(result, i));
        }
        return result;
    }

    @Override
    public BinaryRelation mutualReach() {
        BinaryRelation reach = this.reach();
        BinaryRelation transpose = reach.transpose();
        return reach.union(transpose);
    }

    @Override
    public BinaryRelation symmetricPart() {
        BinaryRelation transpose = this.transpose();
        return this.intersection(transpose);
    }

    @Override
    public BinaryRelation asymmetricPart() {
        BinaryRelation symmetricPart = this.symmetricPart();
        return this.difference(symmetricPart);
    }
}
