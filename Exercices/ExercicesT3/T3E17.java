import org.junit.jupiter.api.Test;

import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T3E17 {
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

            Node<E> prevNode = newNode.previous;

            prevNode.next = newNode;
            entry.previous = newNode;

            size += 1;
        }

        public E removeFirst() {
            if (size == 0) {
                throw new NoSuchElementException("There is no first element");
            }
            return unlink(header.next);
        }

        public E removeLast() {
            if (size == 0) {
                throw new NoSuchElementException("There is no last element");
            }
            return unlink(header.previous);
        }

        private E unlink(Node<E> node) {
            E removedElem = node.element;
            Node<E> prevElem = node.previous;
            Node<E> nextElem = node.next;

            prevElem.next = nextElem;
            nextElem.previous = prevElem;

            // This is made to help garbage collector
            node.element = null;
            node.next = null;
            node.previous = null;

            size--;
            return removedElem;
        }
    }

    @Test
    void removeFirstAndLast() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        assertEquals(1, list.removeFirst());
        assertEquals(2, list.removeFirst());
        assertEquals(5, list.removeLast());
    }

}

