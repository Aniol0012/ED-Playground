import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class T3E8 {
    public interface Stack<E> {
        void push(E e);

        void pop();

        E top();

        boolean isEmpty();
    }

    public static class MyStack<E> implements Stack<E> {
        private static final int DEFAULT_CAPACITY = 10;
        private int size;
        private Object[] theStack;

        public MyStack() {
            this.theStack = new Object[DEFAULT_CAPACITY];
            this.size = 0;
        }

        public MyStack(int initialCapacity) {
            this.theStack = new Object[initialCapacity];
            this.size = 0;
        }

        @Override
        public void push(E elem) {
            if (size == theStack.length) {
                resize();
            }
            theStack[size++] = elem;
        }

        private void resize() {
            Object[] newStack = new Object[theStack.length * 2];
            System.arraycopy(theStack, 0, newStack, 0, theStack.length);
            theStack = newStack;
        }

        @Override
        public void pop() {
            if (isEmpty()) {
                throw new IllegalStateException("The stack is empty");
            }
            theStack[--size] = null;
        }

        @Override
        @SuppressWarnings("all") // This is necessary for the unchecked cast to E
        public E top() {
            if (isEmpty()) {
                throw new NoSuchElementException("The stack is empty");
            }
            return (E) theStack[size - 1];
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        // Extra: Implementation of System.arraycopy(src, srcPos, dest, destPos, length)
        private static void copyArray(Object[] src, int srcPos, Object[] dest, int destPos, int length) {
            for (int i = 0; i < length; i++) {
                if (srcPos + i < src.length && destPos + i < dest.length) {
                    dest[destPos + i] = src[srcPos + i];
                }
            }
        }
    }
    @Test
    public void test1_pushAndTop() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.top());
    }

    @Test
    public void test2_popAndIsEmpty() {
        MyStack<String> stack = new MyStack<>();
        stack.push("test");
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void test3_popEmptyStack() {
        MyStack<Double> stack = new MyStack<>();
        Exception exception = assertThrows(IllegalStateException.class, stack::pop);
        assertEquals("The stack is empty", exception.getMessage());
    }

    @Test
    public void test4_topEmptyStack() {
        MyStack<Object> stack = new MyStack<>();
        Exception exception = assertThrows(NoSuchElementException.class, stack::top);
        assertEquals("The stack is empty", exception.getMessage());
    }

    @Test
    public void test5_pushBeyondCapacity() {
        MyStack<Integer> stack = new MyStack<>(1);
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.top());
    }
}
