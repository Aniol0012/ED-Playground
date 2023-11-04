import java.util.List;
import java.util.Iterator;

public class ex4 {
    /*
    Implementa el método dedup que reciba una lista y elimine de la misma,
    los elementos consecutivos que se encuentren duplicados. Dicha lista no
    contiene nulls y tampoco ella misma será null.
     */
    @SuppressWarnings("all")
    public static <E> void dedup(List<E> list) {
        if (list.isEmpty()) {
            return;
        }

        Iterator<E> it = list.iterator();
        E prevElement = null;

        while (it.hasNext()) {
            E currentElement = it.next();
            if (currentElement.equals(prevElement)) {
                it.remove();
            } else {
                prevElement = currentElement;
            }
        }

    }

    public static void main(String[] args) {
        List<Integer> list = List.of(2, 2, 5, 3, 3, 2, 5, 5);
        dedup(list);
    }
}
