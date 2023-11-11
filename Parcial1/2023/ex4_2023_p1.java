import java.util.Arrays;

public class ex4_2023_p1 {
    public class ArrayList<E> {
        Object[] elements = new Object[5];
        int size = 0;
        int modCount = 0;

        public ArrayList() {
        }

        public void shiftSuffixLeft(int position, ArrayList<? extends E> newSuffix) {
            if (position < 0 || position > size) {
                throw new IndexOutOfBoundsException("Index: " + position + ", Size: " + size);
            }
            if (newSuffix == null) {
                throw new NullPointerException("newSuffix is null");
            }

            ensureCapacity(size + newSuffix.size);

            System.arraycopy(elements, position, elements, position + newSuffix.size, size - position);

            System.arraycopy(newSuffix.elements, 0, elements, position, newSuffix.size);

            size += newSuffix.size;
            modCount++;
        }

        private void ensureCapacity(int minCapacity) {
            while (minCapacity > elements.length) {
                Object[] newElements = new Object[size * 2];
                System.arraycopy(elements, 0, newElements, 0, size);
                elements = newElements;
            }
        }

        @Override
        public String toString() {
            return "ArrayList{" +
                    "elements=" + Arrays.toString(elements) +
                    ", size=" + size +
                    ", modCount=" + modCount +
                    '}';
        }
    }
}
