package lab05;

import lab01.BinaryRelation;
import lab01.Intersection;
import lab02.FactorizationClass;
import lab03.MetricRelation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        findLinearDistance();

        MetricRelation s = new MetricRelation(new Double[][]{
                {0., 1., -1., 2., -1.},
                {-1., 0., -2., 1., -2.},
                {1., 2., 0., 3., 0.},
                {-2., -1., -3., 0., -3.},
                {1., 2., 0., 3., 0.},
        });

        MetricRelation t = new MetricRelation(new Double[][]{
                {0., 0., -3., 0., -3.},
                {0., 0., -3., 0., -3.},
                {3., 3., 0., 3., 0.},
                {0., 0., -3., 0., -3.},
                {3., 3., 0., 3., 0.},
        });
        System.out.println("S:");
        System.out.println(s);
        System.out.println("T:");
        System.out.println(t);

        System.out.println("Distance:");
        System.out.println(s.findDistance(t));
        System.out.println("================================================================================================");

        findStructuralDistance();
    }

    private static void findLinearDistance() {
        Intersection intersection = new Intersection(Arrays.asList(
                new Intersection.Holder(1, Collections.singletonList(1)),
                new Intersection.Holder(2, Collections.singletonList(2)),
                new Intersection.Holder(3, Collections.singletonList(3)),
                new Intersection.Holder(4, Arrays.asList(4, 5)),
                new Intersection.Holder(5, Arrays.asList(2, 3, 5))
        ));
        BinaryRelation r = intersection.getBinaryRelation(5);
        BinaryRelation q = new BinaryRelation(new int[][]{
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 0, 0, 1},
        });
        System.out.println("R: ");
        System.out.println(r);
        System.out.println("Q: ");
        System.out.println(q);
        System.out.println("Distance from r to q:");
        System.out.println(q.findDistance(r));
        System.out.println("===============================================================================================");
    }

    private static void findStructuralDistance() {
//        BinaryRelation br1 = new BinaryRelation(new int[][]{
//                {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//                {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//                {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//                {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
//        });
//        BinaryRelation br2 = new BinaryRelation(new int[][]{
//                {1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
//                {0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0},
//                {0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0},
//                {0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0},
//                {1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
//                {0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0},
//                {0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
//                {1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//        });
        BinaryRelation br1 = new BinaryRelation(new int[][]{
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 0, 0, 1},
        });
        BinaryRelation br2 = br1.symmetricPart();
        List<FactorizationClass> classes1 = br1.getClassesForFactorization(br1.get());
        System.out.println(classes1);
        List<FactorizationClass> classes2 = br2.getClassesForFactorization(br2.get());
        System.out.println(classes2);

        List<FactorizationClass> result = new ArrayList<>();
        classes1.forEach(fc1 -> {
            classes2.forEach(fc2 -> {
                List<Integer> elements1 = fc1.getElements();
                List<Integer> elements2 = fc2.getElements();
                List<Integer> common = new ArrayList<>(elements1);
                common.retainAll(elements2);
                if (!common.isEmpty()) {
                    result.add(new FactorizationClass(common));
                }
            });
        });
        System.out.println("==================================================== Class intersection ====================================================");
        IntStream.range(0, result.size()).forEach(value -> result.get(value).setKey(value + 1));
        System.out.println(result);

        List<Integer> subClasses1 = new ArrayList<>();
        classes1.forEach(fc1 -> {
            int count = countClasses(result, fc1);
            subClasses1.add(count);
        });

        List<Integer> subClasses2 = new ArrayList<>();
        classes2.forEach(fc1 -> {
            int count = countClasses(result, fc1);
            subClasses2.add(count);
        });
        System.out.println(subClasses2);

        double distance = 0;
        for (int i = 0; i < classes1.size(); i++) {
            int pi = classes1.get(i).getElements().size();
            distance += (2 * (pi - subClasses1.get(i)) - subClasses1.get(i) + 1);
        }
        for (int i = 0; i < classes2.size(); i++) {
            int s2 = classes2.get(i).getElements().size();
            distance += (2 * (s2 - subClasses2.get(i)) - subClasses2.get(i) + 1);
        }
        System.out.println("==================================================== Structural distance ====================================================");
        System.out.println(distance);
    }

    private static int countClasses(List<FactorizationClass> result, FactorizationClass fc1) {
        List<Integer> elements = fc1.getElements();
        int count = 0;
        for (FactorizationClass fcr : result) {
            ArrayList<Integer> common = new ArrayList<>(fcr.getElements());
            common.retainAll(elements);
            if (!common.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}
