import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDupsNoBuffer {

    class LinkedListNode<T> {
        LinkedListNode<T> next = null;
        T data;

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            LinkedListNode<T> that = (LinkedListNode<T>) o;
            if (that.data != this.data) {
                System.out.println("Expected: " + this.data + " but got: " + that.data);
                return false;
            }

            if(this.next == null && that.next == null) {
                return true;
            }

            return that.next.equals(this.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(next, data);
        }
    }

    private LinkedListNode<Integer> solve(LinkedListNode<Integer> list) {
        LinkedListNode<Integer> head = list;
        while(head != null) {
            LinkedListNode<Integer> runner = head;

            while(runner.next != null) {
                if(head.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            head = head.next;
        }

        return list;
    }

    @Test
    void unsorted_linkedList() {
        LinkedListNode<Integer> node1 = new LinkedListNode<>();
        node1.data = 1;
        LinkedListNode<Integer> node2 = new LinkedListNode<>();
        node2.data = 4;
        LinkedListNode<Integer> node3 = new LinkedListNode<>();
        node3.data = 1;
        LinkedListNode<Integer> node4 = new LinkedListNode<>();
        node4.data = 2;
        LinkedListNode<Integer> node5 = new LinkedListNode<>();
        node5.data = 2;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        LinkedListNode<Integer> expectedNode1 = new LinkedListNode<>();
        expectedNode1.data = 1;
        LinkedListNode<Integer> expectedNode2 = new LinkedListNode<>();
        expectedNode2.data = 4;
        LinkedListNode<Integer> expectedNode3 = new LinkedListNode<>();
        expectedNode3.data = 2;
        expectedNode1.next = expectedNode2;
        expectedNode2.next = expectedNode3;

        assertEquals(expectedNode1, solve(node1));
    }
}
