import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class T3E9 {
    public interface Stack<E> {
        void push(E e);

        void pop();

        E top();

        boolean isEmpty();
    }

    public static class LinkedStack<E> implements Stack<E> {
        private Node<E> top;
        private int size;

        private static class Node<E> {
            E element;
            Node<E> prev;

            Node(E e, Node<E> prev) {
                element = e;
                this.prev = prev;
            }
        }

        public void push(E e) {
            top = new Node<>(e, top);
            size += 1;
        }

        public void pop() {
            if (isEmpty()) {
                throw new IllegalStateException("The stack is empty");
            }
            top = top.prev;
            size -= 1;
        }

        public E top() {
            if (isEmpty()) {
                throw new NoSuchElementException("The stack is empty");
            }
            return top.element;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}
