import java.util.NoSuchElementException;

interface Stack<E> {
    void push(E elem);

    E top();

    void pop();

    boolean isEmpty();
}

public class ex2_2019_p1 {
    public static class MyStack<E> implements Stack<E> {
        private static final int DEFAULT_CAPACITY = 10;
        private int size;
        private Object[] theStack;

        public MyStack() {
            theStack = new Object[DEFAULT_CAPACITY];
            size = 0;
        }

        public MyStack(int initialCapacity) {
            theStack = new Object[initialCapacity];
            size = 0;
        }

        public void push(E elem) {
            if (size == theStack.length) {
                resize();
            }
            theStack[size] = elem;
            size += 1;
        }

        public void pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty :(");
            }
            theStack[size - 1] = null;
            size -= 1;
        }

        @SuppressWarnings("unchecked")
        public E top() {
            if (isEmpty()) {
                throw new NoSuchElementException("Stack is empty :(");
            }
            return (E) theStack[size - 1];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void resize() {
            Object[] newStack = new Object[theStack.length * 2];
            System.arraycopy(theStack, 0, newStack, 0, size);
            theStack = newStack;
        }
    }

    // Test code
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        System.out.println("Is the stack empty? " + stack.isEmpty());

        try {
            stack.top();
        } catch (NoSuchElementException e) {
            System.out.println("No element to show. Stack is empty: " + e.getMessage());
        }

        try {
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Cannot pop. Stack is empty: " + e.getMessage());
        }

        for (int i = 1; i <= 12; i++) {
            stack.push(i);
        }

        System.out.println("Top element is: " + stack.top());

        while (!stack.isEmpty()) {
            System.out.println("Popping element: " + stack.top());
            stack.pop();
        }

        System.out.println("Is the stack empty after popping all elements? " + stack.isEmpty());
    }
}
