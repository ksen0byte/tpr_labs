package lab02;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class FactorizationClass {
    private Integer key;
    private List<Integer> elements = new ArrayList<>();
    private List<FactorizationClass> connectedClasses = new ArrayList<>();


    public FactorizationClass(Integer key, Integer... elements) {
        this.key = key;
        this.elements.addAll(Arrays.asList(elements));
    }

    public FactorizationClass(List<Integer> elements) {
        this.elements.addAll(elements);
    }

    public void addElement(Integer element) {
        elements.add(element);
    }


    @Override
    public String toString() {
        return "\n{" + key + " : " + elements + "}";
    }
}
