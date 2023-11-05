import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ex4_2022 {

    public static List<Integer> getMultiples(List<Integer> source, List<Integer> multiples) {
        List<Integer> result = new ArrayList<>();

        if (source.isEmpty() || multiples.isEmpty()) {
            return result;
        }

        Iterator<Integer> sourceIterator = source.iterator();

        while (sourceIterator.hasNext()) {
            int sourceElem = sourceIterator.next();
            Iterator<Integer> multiplesIterator = multiples.iterator();

            while (multiplesIterator.hasNext()) {
                int multipleElem = multiplesIterator.next();

                if (sourceElem % multipleElem == 0) {
                    result.add(sourceElem);
                    break; // Cuando se encuentra un divisor de multiples no hay necesidad
                    // de seguir comproblndo para los siguientes elementos de multiples
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> source1 = List.of(1, 20, 3, 10);
        List<Integer> multiples1 = List.of(1, 2, 3);
        System.out.println("El resultat del primer és: " + getMultiples(source1, multiples1));  // Output should be [1, 20, 3, 10]

        List<Integer> source2 = List.of(1, 20, 3, 10);
        List<Integer> multiples2 = List.of(11, 31);
        System.out.println("El resultat del segon és: " + getMultiples(source2, multiples2));  // Output should be []
    }
}
