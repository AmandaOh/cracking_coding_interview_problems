import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackOfPlates {

    private class SetOfStacks<T> {

        private Stack<T> top;
        private final int THRESHOLD;
        private int totalSize;

        private SetOfStacks(int threshold) {
            THRESHOLD = threshold;
            top = new Stack<>(threshold);
        }

        private void push(T data) {
            try {
                top.push(data);
            } catch (IndexOutOfBoundsException ex) {
                Stack<T> newStack = new Stack<>(THRESHOLD);
                newStack.next = top;
                top = newStack;
                top.push(data);
            }
            totalSize++;
        }

        private T pop() {
            T data;
            try {
                data = top.pop();
            } catch (EmptyStackException ex) {
                top = top.next;
                data = top.pop();
            }
            totalSize--;
            return data;
        }

        private T popAt(int index) {
            Stack<T> head = top;
            for (int i = 0; i < (totalSize - index - 1); i++) {
                if (head.next != null) {
                    head = head.next;
                } else {
                    head = top.next;
                    top = top.next;
                }
            }
            return head.pop();
        }
    }

    @Test
    void test_pop() {
        SetOfStacks<Integer> setOfStacks = new SetOfStacks<>(2);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);

        assertEquals(3, setOfStacks.pop());
    }

    @Test
    void test_pop_at_once() {
        SetOfStacks<Integer> setOfStacks = new SetOfStacks<>(2);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);

        assertEquals(2, setOfStacks.popAt(1));
    }

    @Test
    void test_pop_at_twice() {
        SetOfStacks<Integer> setOfStacks = new SetOfStacks<>(2);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);

        assertEquals(2, setOfStacks.popAt(1));
        assertEquals(3, setOfStacks.popAt(1));
    }

    //what about shifting elements after removal??

}
