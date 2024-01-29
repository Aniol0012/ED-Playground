import java.util.Iterator;
import java.util.LinkedList;


public class T2E9 {
    public static <E> void modifyPrefix(LinkedList<E> src, LinkedList<E> tfg) {
        if (src == null || tfg == null) {
            throw new IllegalArgumentException("src and tfg cannot be null");
        }
        if (src.isEmpty() || tfg.isEmpty()) {
            return;
        }

        Iterator<E> it = src.iterator();
        Iterator<E> itDest = tfg.iterator();
        int i = 0;

        while (it.hasNext() && itDest.hasNext()) {
            tfg.set(i, it.next());
            i++;
        }
    }
}
