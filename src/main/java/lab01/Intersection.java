package lab01;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Intersection {

    private List<Holder> holders = new ArrayList<>();

    public Intersection(List<Holder> holders) {
        this.holders = holders;
    }

    public Intersection(BinaryRelation relation) {
        int[][] matrix = relation.get();
        for (int j = 0; j < matrix[0].length; j++) {
            Holder holder = new Holder(j + 1);
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == 1) {
                    holder.addElement(i + 1);
                }
            }
            holders.add(holder);
        }
    }

    @Override
    public String toString() {
        return "Intersection{" + holders + '}';
    }

    @Data
    @AllArgsConstructor
    public static class Holder {
        public Holder(Integer column){
            this.column = column;
        }
        private Integer column;
        private List<Integer> elements = new ArrayList<>();

        void addElement(Integer element) {
            elements.add(element);
        }

        @Override
        public String toString() {
            return "R(" + column + ") = {" + elements + '}';
        }
    }

    public BinaryRelation getBinaryRelation(int size) {
        int[][] matrix = new int[size][size];
        List<Holder> holders = this.holders;
        for (Holder holder : holders) {
            holder.getElements().forEach(el -> {
                matrix[el - 1][holder.getColumn() - 1] = 1;
            });
        }
        return new BinaryRelation(matrix);
    }
}
