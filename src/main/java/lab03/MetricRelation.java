package lab03;

import java.text.DecimalFormat;

import static java.lang.Math.abs;

public class MetricRelation {
    private Double[][] matrix;
    private TransitiveType type;
    private int size;

    public MetricRelation(Double[][] matrix) {
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
        Double[][] left = this.matrix;
        Double[][] right = metricRelation.get();
        int size = left.length;

        Double[][] result = new Double[size][size];
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

    public Double[][] get() {
        return this.matrix;
    }

    public MetricRelation union(MetricRelation metricRelation) {
        Double[][] left = this.matrix;
        Double[][] right = metricRelation.get();

        Double[][] result = new Double[size][size];
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
        Double[][] left = this.matrix;
        Double[][] right = metricRelation.get();

        Double[][] result = new Double[size][size];
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
        Double[][] left = this.matrix;
        Double[][] right = metricRelation.get();

        Double[][] result = new Double[size][size];

        switch (type) {
            case ADDITIVE: {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        int counter = 0;
                        Double sum = 0.;

                        for (int k = 0; k < size; k++) {
                            Double leftElem = left[i][k];
                            Double rightElem = right[k][j];
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
                        Double sum = 1.;

                        for (int k = 0; k < size; k++) {
                            Double leftElem = left[i][k];
                            Double rightElem = right[k][j];
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

    public Double findDistance(MetricRelation that) {
        Double[][] m1 = this.matrix;
        Double[][] m2 = that.matrix;

        double distance = 0.;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                distance += abs(m1[i][j] - m2[i][j]);
            }
        }

        return distance * 0.5;
    }

    @Override
    public String toString() {
        DecimalFormat dc = new DecimalFormat("#.##");
        StringBuilder sb = new StringBuilder();
        sb.append("Binary relation of type ").append(type).append(" : \n");

        for (Double[] aMatrix : matrix) {
            for (int j = 0; j < size; j++) {
                sb.append(" ").append(String.format("%6s", dc.format(aMatrix[j])));
            }
            sb.append("\n");
        }
        return sb.toString();

    }
}
