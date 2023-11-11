import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ex3_2023_p1 {
    public static void main(String[] args) {
        var elems = List.of("a", "b", "c", "d", "e", "f", "g");
        var list = new ArrayList<>(elems);
        removeInPairPosition(list);
        System.out.println(list);
    }

    static <E> void removeInPairPosition(List<E> elements) {
        assert elements != null;
        Iterator<E> iterator = elements.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            iterator.next();
            if (index % 2 != 0) {
                iterator.remove();
            }
            index++;
        }
    }

}
