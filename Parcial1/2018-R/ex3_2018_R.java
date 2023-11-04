import java.util.NoSuchElementException;

public class ex3_2018_R {
    // removeFirst -> Elimina el primer elemento de la LinkedList
    // addLast -> Añade un elemento al final del LinkedList

    public class LinkedList<E> {
        private Entry<E> header; // Este es un nodo centinela (dummy) que facilita las operaciones
        private int size;

        public LinkedList() {
            header = new Entry<>(null, null, null);
            header.next = header.previous = header; // Inicialmente, la lista está vacía, por lo que header apunta a sí mismo
            size = 0;
        }

        public E removeFirst() {
            if (size == 0) {
                throw new NoSuchElementException();
            }
            return unlink(header.next);
        }

        public void addLast(E element) {
            linkBefore(element, header);
        }

        private void linkBefore(E element, Entry<E> entry) {
            // Crea un nuevo nodo con el elemento dado
            Entry<E> newNode = new Entry<>(entry.previous, element, entry);
            // Actualiza el nodo anterior para que apunte al nuevo nodo
            newNode.previous.next = newNode;
            // Actualiza el nodo de entrada para que su nodo anterior sea el nuevo nodo
            entry.previous = newNode;
            size++;
        }

        private E unlink(Entry<E> e) {
            // Guarda el elemento para devolverlo
            E result = e.element;
            // Actualiza los enlaces para excluir el nodo e de la lista
            e.previous.next = e.next;
            e.next.previous = e.previous;
            // Limpia las referencias del nodo eliminado
            e.next = e.previous = null;
            e.element = null;
            size--;
            return result;
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
        // ... Otros métodos ...
    }

}
