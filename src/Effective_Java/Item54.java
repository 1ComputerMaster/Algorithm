package Effective_Java;
import java.util.*;

public class Item54 {
    
    private final List<Integer> cheesesInStock = null;

    public List<Integer> getCheeses() {
        return cheesesInStock.isEmpty() ? null
            : new ArrayList<>(cheesesInStock);
    }

    public void addCheeses(int i) {
        Collections.emptyList();
        cheesesInStock.add(i);
    }

    


}
