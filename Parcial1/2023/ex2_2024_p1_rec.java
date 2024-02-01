import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ex2_2024_p1_rec {

    // O(n)
    public static <E> void drop(List<E> elements, int n) {
        assert elements != null;
        assert n >= 0;
        if (n < 0 || n > elements.size()) {
            throw new IllegalArgumentException();
        }
        Iterator<E> it = elements.iterator();
        int i = 0;
        List<E> list = new LinkedList<>();

        while (it.hasNext()) {
            E elem = it.next();
            if (i >= n) {
                list.add(elem);
            }
            i++;
        }
        elements.clear();
        elements.addAll(list);
    }

    // O(n*m)
    public static <E> void drop_v2(List<E> elements, int n) {
        assert elements != null;
        assert n >= 0;
        if (n < 0 || n > elements.size()) {
            throw new IllegalArgumentException();
        }
        Iterator<E> it = elements.iterator();
        int i = 0;
        while (it.hasNext()) {
            E elem = it.next();
            if (i < n) {
                it.remove();
            }
            i++;
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h"));
        drop(list, 4);
        System.out.println("list = " + list);

        List<String> list2 = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h"));
        drop_v2(list2, 4);
        System.out.println("list2 = " + list2);
    }
}
