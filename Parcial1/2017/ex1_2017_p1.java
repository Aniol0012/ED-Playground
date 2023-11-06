import java.util.Comparator;
import java.util.Iterator;

public class ex1_2017_p1 {
    public static <E> boolean checkRange(Iterator<E> it, Comparator<E> cmp, E min, E max) {
        while (it.hasNext()) {
            E element = it.next();
            if (cmp.compare(element, min) < 0 || cmp.compare(element, max) > 0) {
                return false;
            }
        }
        return true;
    }
}
