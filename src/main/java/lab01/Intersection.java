package lab01;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Intersection {

    private List<Holder> result = new ArrayList<>();

    public Intersection(BinaryRelation relation) {
        int[][] matrix = relation.get();
        for (int j = 0; j < matrix[0].length; j++) {
            Holder holder = new Holder(j + 1);
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == 1) {
                    holder.addElement(i + 1);
                }
            }
            result.add(holder);
        }
    }

    @Override
    public String toString() {
        return "Intersection{" + result + '}';
    }

    @Data
    class Holder {
        private final Integer column;
        private List<Integer> elements = new ArrayList<>();

        void addElement(Integer element) {
            elements.add(element);
        }

        @Override
        public String toString() {
            return "R(" + column + ") = {" + elements + '}';
        }
    }
}
