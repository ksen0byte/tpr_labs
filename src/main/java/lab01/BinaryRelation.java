package lab01;

import lab02.FactorizationClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;

public class BinaryRelation implements Relation {

    private int[][] matrix;
    protected int size;

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
        sb.append("Binary relation: \n");

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
        return reach.intersection(transpose);
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

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @Override
    public BinaryRelation relationFactorization(int[][] matrix) {
        List<FactorizationClass> factorizationClasses = getClassesForFactorization(matrix);

        int size = factorizationClasses.size();

        for (FactorizationClass factorizationClass : factorizationClasses) {
            List<FactorizationClass> connectedClasses = factorizationClass.getConnectedClasses();
            for (Integer rowIndex : factorizationClass.getElements()) {
                int[] row = this.matrix[rowIndex - 1];
                for (int i = 0; i < row.length; i++) {
                    if (row[i] == 1) {
                        int k = i + 1;
                        FactorizationClass connectedClass = factorizationClasses.stream().filter(fc -> fc.getElements().contains(k)).findAny().get();
                        connectedClasses.add(connectedClass);
                    }
                }
            }
        }

        int[][] result = new int[size][size];
        for (FactorizationClass factorizationClass : factorizationClasses) {
            factorizationClass.getConnectedClasses().forEach(connectedClass
                    -> result[factorizationClass.getKey() - 1][connectedClass.getKey() - 1] = 1);

        }

        return new BinaryRelation(result);
    }

    @Override
    public List<FactorizationClass> getClassesForFactorization(int[][] matrix) {
        List<FactorizationClass> factorizationClasses = new ArrayList<>();
        int counter = 1;
        for (int i = 0; i < matrix.length; i++) {
            int k = i + 1;
            if (factorizationClasses.stream().anyMatch(fc -> fc.getElements().contains(k))) continue;

            int[] row = matrix[i];
            FactorizationClass factorizationClass = new FactorizationClass(counter++, k);
            for (int j = k; j < matrix[i].length; j++) {
                if (Arrays.equals(row, matrix[j])) {
                    factorizationClass.addElement(j + 1);
                }
            }
            factorizationClasses.add(factorizationClass);
        }
        return factorizationClasses;
    }

    @Override
    public BinaryRelation relationFactorization() {
        return relationFactorization(this.mutualReach().get());
    }

    @Override
    public void printRelationType() {
        BinaryRelation binaryRelation = this;
        if (binaryRelation.isReflective()) {
            System.out.println("reflective");
        }
        if (binaryRelation.isAntiReflective()) {
            System.out.println("anti reflective");
        }
        if (binaryRelation.isSymmetric()) {
            System.out.println("symmetric");
        }
        if (binaryRelation.isAsymmetric()) {
            System.out.println("asymmetric");
        }
        if (binaryRelation.isAntisymmetric()) {
            System.out.println("anti symmetric");
        }
        if (binaryRelation.isTransitive()) {
            System.out.println("transitive");
        }
        if (binaryRelation.isAcyclic()) {
            System.out.println("acyclic");
        }
        if (binaryRelation.isConnected()) {
            System.out.println("connected");
        }


        if (binaryRelation.isTolerant()) {
            System.out.println("tolerant");
        }
        if (binaryRelation.isEquivalent()) {
            System.out.println("equivalent");
        }
        if (binaryRelation.isQuasiOrder()) {
            System.out.println("quasi order");
        }
        if (binaryRelation.isOrder()) {
            System.out.println("order");
        }
        if (binaryRelation.isStrictOrder()) {
            System.out.println("strict order");
        }
        if (binaryRelation.isLinearOrder()) {
            System.out.println("linear order");
        }
        if (binaryRelation.isStrictLinearOrder()) {
            System.out.println("strict linear order");
        }
    }

    @Override
    public BinaryRelation disparity() {
        BinaryRelation dominant = new BinaryRelation(this.asymmetricPart().get());
        BinaryRelation indifferent = new BinaryRelation(this.symmetricPart().get());
        return (dominant.union(indifferent.union(dominant.transpose())).addition());
    }

    @Override
    public Double findDistance(BinaryRelation that) {
        int[][] m1 = new int[size][size];
        int[][] m2 = new int[size][size];

        // creating mMatrix
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                m1[i][j] = this.matrix[i][j] - this.matrix[j][i];
                m2[i][j] = that.matrix[i][j] - that.matrix[j][i];
            }
        }

        double distance = 0.;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                distance += abs(m1[i][j] - m2[i][j]);
            }
        }

        return distance * 0.5;
    }

}
