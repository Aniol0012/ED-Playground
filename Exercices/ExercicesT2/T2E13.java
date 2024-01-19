import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class T2E13 {
    @Test
    void test_1() {
        List<Integer> list = List.of(90, 10, 9, 16, 89, 71, 40);
        int sample = 70;

        List<Integer> expected = List.of(90, 89, 71);

        assertEquals(expected, greaterThan(list.iterator(), sample));
        assertEquals(expected, greaterThan(list.iterator(), Integer::compare, sample));
    }

    @Test
    void test_2() {
        List<Integer> list = List.of(11, 19, 9, 82, 37, 86, 15);
        int sample = 19;

        List<Integer> expected = List.of(82, 37, 86);

        assertEquals(expected, greaterThan(list.iterator(), sample));
        assertEquals(expected, greaterThan(list.iterator(), Integer::compare, sample));
    }

    @Test
    void test_3() {
        List<Integer> list = List.of(5);
        int sample = 70;

        List<Integer> expected = List.of();

        assertEquals(expected, greaterThan(list.iterator(), sample));
        assertEquals(expected, greaterThan(list.iterator(), Integer::compare, sample));
    }

    /**
     * The greaterThan method, which, given an iterator, returns a list with the elements accessible through the iterator
     * that are greater than another element passed as a parameter. Using Comparable.
     *
     * @param it    iterator
     * @param sample element to compare
     * @param <E>  type of elements
     * @return list of elements greater than sample element
     */
    public static <E extends Comparable<? super E>> List<E> greaterThan(Iterator<E> it, E sample) {
        LinkedList<E> list = new LinkedList<>();

        while (it.hasNext()) {
            E elem = it.next();
            if (elem.compareTo(sample) > 0) {
                list.add(elem);
            }
        }
        return list;
    }

    /**
     * The greaterThan method, which, given an iterator, returns a list with the elements accessible through the iterator
     * that are greater than another element passed as a parameter. Using a comparator.
     *
     * @param it     iterator
     * @param cmp    comparator
     * @param sample element to compare
     * @param <E>    type of elements
     * @return list of elements greater than sample element
     */
    public static <E> List<E> greaterThan(Iterator<E> it, Comparator<? super E> cmp, E sample) {
        LinkedList<E> list = new LinkedList<>();

        while (it.hasNext()) {
            E elem = it.next();
            if (cmp.compare(elem, sample) > 0) {
                list.add(elem);
            }
        }
        return list;
    }
}
