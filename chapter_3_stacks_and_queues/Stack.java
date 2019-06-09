import java.util.EmptyStackException;

public class Stack<T> {

    private final int THRESHOLD;
    private Node<T> top;
    private int size;
    public Stack<T> next;

    public Stack(int threshold) {
        THRESHOLD = threshold;
        size = 0;
    }

    public void push(T data) {
        size++;
        if (size > THRESHOLD) { throw new IndexOutOfBoundsException("Stack is full"); }
        if (top == null) {
            top = new Node<>(data);
            return;
        }
        Node<T> node = new Node<>(data);
        node.next = top;
        top = node;
    }

    public T pop() {
        if (size < 1) { throw new EmptyStackException(); }
        T value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public T peek() {
        return top.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}