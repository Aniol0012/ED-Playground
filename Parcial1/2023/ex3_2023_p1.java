import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ex3_2023_p1 {
    public static void main(String[] args) {
        var elems = List.of("a", "b", "c", "d", "e", "f", "g");
        var list = new ArrayList<>(elems);
        System.out.println("V1");
        removeInPairPosition(list);
        System.out.println(list);

        list = new ArrayList<>(elems);
        System.out.println("V2");
        removeInPairPosition_optimized(list);
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

    static <E> void removeInPairPosition_optimized(List<E> elements) {
        assert elements != null;
        List<E> result = new ArrayList<>();
        Iterator<E> it = elements.iterator();
        int index = 0;
        while (it.hasNext()) {
            E elem = it.next();
            if (index % 2 != 1) {
                result.add(elem);
            }
            index++;
        }
        elements.clear();
        elements.addAll(result);
    }
}
