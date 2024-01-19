import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class T2E11 {
    @Test
    void test_1() {
        List<Integer> list = List.of(1, 20, 7, 6, 99, 61, 40);
        int min = 1;
        int max = 100;

        assertTrue(checkRange(list.iterator(), Integer::compare, min, max));
    }

    @Test
    void test_2() {
        List<Integer> list = List.of(1, 2, 11, 22, 45, 91, 7);
        int min = 1;
        int max = 90;

        assertFalse(checkRange(list.iterator(), Integer::compare, min, max));
    }

    @Test
    void test_3() {
        List<Integer> list = List.of(1);
        int min = 100;
        int max = 0;

        assertFalse(checkRange(list.iterator(), Integer::compare, min, max));
    }

    @Test
    void test_4() {
        List<Integer> list = List.of(1, 2);
        int min = 1;
        int max = 2;

        assertTrue(checkRange(list.iterator(), Integer::compare, min, max));

        List<Integer> list2 = List.of();
        assertFalse(checkRange(list2.iterator(), Integer::compare, min, max));

    }

    /**
     * The checkRange method, which, given an iterator, returns true or false based on whether all elements
     * accessible through the iterator are within the range defined by two elements passed as parameters along with the
     * iterator: [min, max].
     * @param it
     * @param cmp
     * @param min
     * @param max
     * @return true if all elements are within the range defined by two elements passed as parameters along with the
     * @param <E>
     */
    public static <E> boolean checkRange(Iterator<E> it, Comparator<E> cmp, E min, E max) {
        if (cmp.compare(min, max) > 0 || !it.hasNext()) {
            return false;
        }
        while (it.hasNext()) {
            E next = it.next();

            if (cmp.compare(min, next) > 0) {
                return false;
            } else if (cmp.compare(max, next) < 0) {
                return false;
            }
        }
        return true;
    }
}
