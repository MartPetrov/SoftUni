package L03Inheritance.P05StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings(List<String> data) {
        this.data = new ArrayList<>();
    }

    public void push(String element) {
        this.data.add(element);
    }

    public String pop() {
        if (!isEmpty()) {
            return this.data.remove(this.data.size() - 1);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String peek() {
       return data.get(this.data.size() - 1);
    }

    public boolean isEmpty() {
return this.data.isEmpty();
    }
}
