public class T3E12 {
    public static abstract class ArrayList<E> extends java.util.AbstractList<E> {
        private Object[] theArray;
        private int size;

        public void rightBulkDelete(int position, int length) {
            if (position < 0 || position > size) {
                throw new IndexOutOfBoundsException("Position is not valid");
            }
            if (position + length >= theArray.length) {
                throw new IndexOutOfBoundsException("Length is too big");
            }
            if (length < 0) {
                throw new IllegalStateException("Length can't be negative");
            }
            System.arraycopy(theArray, position + length, theArray, position, size - (position + length));

            for (int i = position + length; i < size; i++) {
                theArray[i] = null;
            }
            size -= length;
        }
    }
}
