package lab02;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class FactorizationClass {
    private static Integer counter = 1;
    private Integer key;
    private List<Integer> elements = new ArrayList<>();
    private List<FactorizationClass> connectedClasses = new ArrayList<>();


    public FactorizationClass(Integer... elements) {
        this.key = counter++;
        this.elements.addAll(Arrays.asList(elements));
    }

    public void addElement(Integer element) {
        elements.add(element);
    }


}
