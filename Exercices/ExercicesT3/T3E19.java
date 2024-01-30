import java.util.NoSuchElementException;

public class T3E19 {

    public static class LinkedStack<E> implements Stack<E> {
        private Node<E> top;

        private static class Node<E> {
            E element;
            Node<E> next;

            Node(E element, Node<E> next) {
                this.element = element;
                this.next = next;
            }
        }

        public LinkedStack() {
            top = null;
        }

        @Override
        public void push(E elem) {
            top = new Node<>(elem, top);
        }

        @Override
        public void pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Cannot pop from an empty stack");
            }
            top = top.next;
        }

        @Override
        public E top() {
            if (isEmpty()) {
                throw new NoSuchElementException("Cannot peek at an empty stack");
            }
            return top.element;
        }

        @Override
        public boolean isEmpty() {
            return top == null;
        }
    }

}
