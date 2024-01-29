import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T3E25 {
    static class LinkedList<E> {
        private Node<E> first = null;
        private Node<E> last = null;
        private int size = 0;
        private int modCount = 0;


        static class Node<E> {
            E item;
            Node<E> prev;
            Node<E> next;

            public Node(Node<E> prev, E item, Node<E> next) {
                this.item = item;
                this.next = next;
                this.prev = prev;
            }
        }
        public void add(E e) {
            if (size == 0) {
                first = new Node<>(null, e, null);
                last = first;
            } else {
                Node<E> newNode = new Node<>(last, e, null);
                last.next = newNode;
                last = newNode;
            }
            size += 1;
            modCount += 1;
        }

        void linkAfter(E e, Node<E> pred) {
            assert pred != null;
            if (size == 0) {
                throw new IllegalStateException("The list is empty");
            }
            if (pred.next == null) {
                Node<E> newNode = new Node<>(pred, e, null);
                last = newNode;
            } else {
                Node<E> newNode = new Node<>(pred, e, pred.next);
                Node<E> nexNode = pred.next;
                pred.next = newNode;
                nexNode.prev = newNode;
            }
            size += 1;
            modCount += 1;

            size += 1;
            modCount += 1;
        }
    }

    @Test
    public void test1() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.linkAfter(2, list.first);
        assertEquals(2, list.last.item);
    }
}
