import java.util.*;

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

    // O(n)
    public static <E> void drop_v3(List<E> elements, int n) {
        assert elements != null;
        assert n >= 0;
        if (n < 0 || n > elements.size()) {
            throw new IllegalArgumentException();
        }
        int size = elements.size();
        for (int i = n; i < size; i++) {
            elements.set(i - n, elements.get(i));
        }
        for (int i = 0; i < n; i++) {
            // This can be done with removeLast
            elements.remove(elements.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h"));
        List<String> list2 = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h"));
        List<String> list3 = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h"));

        // Measure and print the execution time for each drop method
        measureAndPrintTime(() -> drop(list, 4), "drop");
        System.out.println("list after drop = " + list);

        measureAndPrintTime(() -> drop_v2(list2, 4), "drop_v2");
        System.out.println("list2 after drop_v2 = " + list2);

        measureAndPrintTime(() -> drop_v3(list3, 4), "drop_v3");
        System.out.println("list3 after drop_v3 = " + list3);
    }

    public static void measureAndPrintTime(Runnable task, String taskName) {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Execution time of " + taskName + " (nanoseconds): " + duration);
    }
}
