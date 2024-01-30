public interface Stack<E> {
    void push(E elem);
    void pop();
    E top();
    boolean isEmpty();
}
