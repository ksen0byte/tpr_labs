package lab03;

public class MetricRelation {
    private double[][] matrix;
    private TransitiveType type;
    private int size;

    public MetricRelation(double[][] matrix) {
        this.matrix = matrix;
        this.size = matrix.length;
        if (isAdditive()) {
            type = TransitiveType.ADDITIVE;
        } else {
            type = TransitiveType.MULTIPLICATIVE;
        }
    }

    public boolean isAdditive() {
        for (int i = 0; i < this.size; i++) {
            if (this.matrix[i][i] == 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isMultiplicative() {
        for (int i = 0; i < this.size; i++) {
            if (this.matrix[i][i] == 0) {
                return false;
            }
        }
        return true;
    }

    public MetricRelation intersection(MetricRelation metricRelation) {
        double[][] left = this.matrix;
        double[][] right = metricRelation.get();
        int size = left.length;

        double[][] result = new double[size][size];
        switch (type) {
            case ADDITIVE: {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (left[i][j] != 0 && right[i][j] != 0) {
                            result[i][j] = (left[i][j] + right[i][j]) / 2;
                        }
                    }
                }
                break;
            }
            case MULTIPLICATIVE: {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (left[i][j] != 0 && right[i][j] != 0) {
                            result[i][j] = Math.sqrt(left[i][j] * right[i][j]);
                        }
                    }
                }
                break;
            }
        }
        return new MetricRelation(result);
    }

    public double[][] get() {
        return this.matrix;
    }

    public MetricRelation union(MetricRelation metricRelation) {
        double[][] left = this.matrix;
        double[][] right = metricRelation.get();

        double[][] result = new double[size][size];
        switch (type) {
            case ADDITIVE: {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (left[i][j] != 0 && right[i][j] != 0) {
                            result[i][j] = (left[i][j] + right[i][j]) / 2;
                        } else {
                            result[i][j] = (left[i][j] + right[i][j]);
                        }
                    }
                }
                break;
            }
            case MULTIPLICATIVE: {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (left[i][j] != 0 && right[i][j] != 0) {
                            result[i][j] = Math.sqrt(left[i][j] * right[i][j]);
                        } else {
                            result[i][j] = (left[i][j] + right[i][j]);
                        }
                    }
                }
                break;
            }
        }
        return new MetricRelation(result);

    }

    public MetricRelation difference(MetricRelation metricRelation) {
        double[][] left = this.matrix;
        double[][] right = metricRelation.get();

        double[][] result = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (left[i][j] != 0 && right[i][j] == 0) {
                    result[i][j] = left[i][j];
                }
            }
        }

        return new MetricRelation(result);

    }

    public MetricRelation composition(MetricRelation metricRelation) {
        double[][] left = this.matrix;
        double[][] right = metricRelation.get();

        double[][] result = new double[size][size];

        switch (type) {
            case ADDITIVE: {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        int counter = 0;
                        double sum = 0;

                        for (int k = 0; k < size; k++) {
                            double leftElem = left[i][k];
                            double rightElem = right[k][j];
                            if (leftElem != 0 && rightElem != 0) {
                                counter++;
                                sum += leftElem + rightElem;
                            }
                        }
                        result[i][j] = counter == 0 ? 0 : sum / counter;
                    }
                }
                break;
            }
            case MULTIPLICATIVE: {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        int counter = 0;
                        double sum = 1;

                        for (int k = 0; k < size; k++) {
                            double leftElem = left[i][k];
                            double rightElem = right[k][j];
                            if (leftElem != 0 && rightElem != 0) {
                                counter++;
                                sum *= leftElem * rightElem;
                            }
                        }
                        result[i][j] = counter == 0 ? 0 : Math.pow(sum, 1. / counter);
                    }
                }

                break;
            }
        }

        return new MetricRelation(result);

    }
}
