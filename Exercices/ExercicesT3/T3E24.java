public class T3E24 {
    public static class LinkedList<E> {
        private Node<E> first = null;
        private Node<E> last = null;
        private int size = 0;
        private int modCount = 0;

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
        public void linkBeforeLast(E e) {
            if (size == 0) {
                Node<E> newNode = new Node<>(null, e, null);
                first = newNode;
                last = newNode;
            } else if (size == 1) {
                Node<E> newNode = new Node<>(null, e, last);
                first = newNode;
                last.prev = newNode;
            } else {
                Node<E> newNode = new Node<>(last.prev, e, last);
                last.prev.next = newNode;
                last.prev = newNode;
            }
            size += 1;
            modCount += 1;
        }
    }
}
