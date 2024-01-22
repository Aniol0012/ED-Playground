import org.junit.jupiter.api.Test;

import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class T3E16 {
    public class LinkedList<E> extends AbstractSequentialList<E> implements List<E> {
        private Node<E> header = new Node<E>(null, null, null);
        private int size = 0;

        public LinkedList() {
            header.next = header.previous = header;
        }

        @Override
        public int size() {
            return 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void throwIfIsEmpty() {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override
        public ListIterator<E> listIterator(int index) {
            return null;
        }

        private static class Node<E> {
            E element;
            Node<E> next;
            Node<E> previous;

            Node(E e, Node<E> next, Node<E> previous) {
                element = e;
                this.next = next;
                this.previous = previous;
            }
        }

        public E getFirst() {
            throwIfIsEmpty();
            return header.next.element;
        }

        // This implementation uses the previous field of the header node because it is a circular list.
        public E getLast() {
            throwIfIsEmpty();
            return header.previous.element;
        }

        public void addFirst(E element) {
            addBefore(element, header.next);
        }

        private void addBefore(E e, Node<E> entry) {
            Node<E> newNode = new Node<>(e, entry, entry.previous);
            newNode.previous.next = newNode;
            entry.previous = newNode;
            size += 1;
        }
    }

    @Test
    void addAndGetFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        assertEquals(1, list.getFirst());

        list.addFirst(2);
        assertEquals(2, list.getFirst());

        list.addFirst(3);
        assertEquals(3, list.getFirst());
    }

    @Test
    void addAndGetLast() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        assertEquals(1, list.getLast());

        list.addFirst(2);
        assertEquals(1, list.getLast());

        list.addFirst(3);
        assertEquals(1, list.getLast());
    }

    @Test
    void checkOrderAfterAddingElements() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        assertEquals(3, list.getFirst());
        assertEquals(1, list.getLast());
    }

    @Test
    void emptyListShouldThrowExceptionOnGetFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, list::getFirst);
    }

    @Test
    void emptyListShouldThrowExceptionOnGetLast() {
        LinkedList<Integer> list = new LinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, list::getLast);
    }
}
