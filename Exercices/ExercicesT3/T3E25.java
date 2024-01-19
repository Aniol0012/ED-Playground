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

        void linkAfter(E e, Node<E> pred) {
            // assert pred != null
            Node<E> next = pred.next;
            Node<E> newNode = new Node<>(pred, e, next);
            pred.next = newNode;
            if (next != null) {
                next.prev = newNode;
            } else {
                last = newNode;
            }
            size += 1;
            modCount += 1;
        }
    }
}
