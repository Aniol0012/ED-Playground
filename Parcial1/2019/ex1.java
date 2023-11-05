import java.util.Iterator;

public class ex1 {
    public class ArrayList<E> {
        private Object[] theArray;
        private int size; // Mida de la llista

        public ArrayList() {
            theArray = new Object[10];
            size = 0;
        }

        public void addAfter(E element, int position) {
            // assert position -> valid
            // En cas de que la llargada del arraylist donat sigui igual
            // a la maxima, es fa un resize
            if (size == theArray.length) {
                Object[] newArray = new Object[theArray.length * 2];
                System.arraycopy(theArray, 0, newArray, 0, theArray.length);
                theArray = newArray;
            }

            // En cas que la posició sigui -1, se inserta al principi
            if (position == -1) {
                System.arraycopy(theArray, 0, theArray, 1, size);
                theArray[0] = element;
            } else { // Se inserta a la posició donada
                int nextPos = position + 1;
                System.arraycopy(theArray, nextPos, theArray, nextPos + 1, size);
                theArray[nextPos] = element;
            }
        }
    }

    public class LinkedList<E> {
        private Entry<E> header;
        private int size; // Mida de la llista

        public LinkedList() {
            header = new Entry<>(null, null, null);
            header.next = header.previous = header;
            size = 0;
        }
        private static class Entry<E> {
            Entry<E> previous;
            E element;
            Entry<E> next;

            Entry(Entry<E> previous, E element, Entry<E> next) {
                this.previous = previous;
                this.element = element;
                this.next = next;
            }
        }

        public void addAfter(E element, Entry<E> reference) {
            var nextElement = reference.next;
            Entry<E> newElement = new Entry<>(reference, element, nextElement);
            nextElement.previous = newElement;
            size += 1;
        }
    }
}
