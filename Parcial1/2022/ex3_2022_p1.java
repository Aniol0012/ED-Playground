import java.util.NoSuchElementException;

public class ex3_2022_p1 {
    // Made to test implementation
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.linkLast(1);
        list.linkLast(2);
        System.out.println(list);
    }

    public static class LinkedList<E> {
        private Node<E> first = null;
        private Node<E> last = null;
        private int size = 0;
        private int modCount = 0; // Every time the collection is modified, mocCount must be incremented

        public LinkedList() {
        }

        private static class Node<E> {
            E item;
            Node<E> next;
            Node<E> prev;

            Node(Node<E> prev, E element, Node<E> next) {
                this.item = element;
                this.next = next;
                this.prev = prev;
            }
        }

        public void linkLast(E e) {
            System.out.printf("Given element: " + e + " -> ");
            Node<E> lastElement = last;
            Node<E> newElement = new Node<>(lastElement, e, null);
            // In case the list is empty
            if (lastElement == null) {
                System.out.println("List was empty");
                first = newElement;
            } else {
                System.out.println("List was not empty");
                lastElement.next = newElement;
            }
            last = newElement;
            size += 1;
            modCount += 1;
        }

        public E unlinkFirst() {
            if (first == null) {
                throw new NoSuchElementException("List is empty, nothing to unlink :(");
            }
            E firstElement = first.item;
            Node<E> nextElement = first.next;
            first.item = null;
            first.next = null;

            if (nextElement != null) {
                nextElement.prev = null;
            } else {
                last = null;
            }

            first = nextElement;
            size -= 1;
            modCount += 1;
            return firstElement;
        }


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LinkedList -> [");
            Node<E> current = first;
            while (current != null) {
                sb.append(current.item);
                current = current.next;
                if (current != null) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
