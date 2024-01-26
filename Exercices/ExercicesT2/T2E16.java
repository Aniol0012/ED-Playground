import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

public class T2E16 {
    public static <E extends Comparable<? super E>> void splitOnRangeInclusive(Iterator<E> it, List<E> in, List<E> out, E min_range, E max_range) {
        if (min_range.compareTo(max_range) > 0) {
            return;
        }
        while (it.hasNext()) {
            E elem = it.next();
            if (elem == null) {
                continue;
            }
            if (elem.compareTo(min_range) >= 0 && elem.compareTo(max_range) <= 0) {
                in.add(elem);
            }
            if (elem.compareTo(max_range) > 0 || elem.compareTo(min_range) < 0) {
                out.add(elem);
            }
        }
    }

    @Test
    public void testEmptyList() {
        List<Integer> in = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        List<Integer> list = Arrays.asList();
        splitOnRangeInclusive(list.iterator(), in, out, 5, 11);
        assertTrue(in.isEmpty(), "List 'in' should be empty");
        assertTrue(out.isEmpty(), "List 'out' should be empty");
    }

    @Test
    public void testListWithMultipleElements() {
        List<Integer> in = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        List<Integer> list = Arrays.asList(10, 20, 30, 1);
        splitOnRangeInclusive(list.iterator(), in, out, 5, 11);
        assertEquals(Arrays.asList(10), in, "List 'in' should contain [10]");
        assertEquals(Arrays.asList(20, 30, 1), out, "List 'out' should contain [20, 30, 1]");
    }

    @Test
    public void testListWithInRangeElements() {
        List<Integer> in = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        List<Integer> list = Arrays.asList(1, 2, 3, 10);
        splitOnRangeInclusive(list.iterator(), in, out, 2, 3);
        assertEquals(Arrays.asList(2, 3), in, "List 'in' should contain [2, 3]");
        assertEquals(Arrays.asList(1, 10), out, "List 'out' should contain [1, 10]");
    }

    @Test
    public void testListWithOutOfRangeElements() {
        List<Integer> in = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        List<Integer> list = Arrays.asList(3, 4, 5, 10);
        splitOnRangeInclusive(list.iterator(), in, out, 7, 2);
        assertTrue(in.isEmpty(), "List 'in' should be empty");
        assertTrue(out.isEmpty(), "List 'out' should be empty");
    }

    @Test
    public void testNulls() {
        List<Integer> in = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        List<Integer> list = Arrays.asList(3, null, 5, 10);
        splitOnRangeInclusive(list.iterator(), in, out, 4, 10);
        assertTrue(Arrays.asList(5, 10).equals(in), "List 'in' should contain [5, 10]");
        assertTrue(Arrays.asList(3).equals(out), "List 'out' should contain [3, null]");
    }
}
