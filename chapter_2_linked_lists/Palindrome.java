import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Palindrome {

    //assuming singly linked list
    private boolean solve(LinkedListNode<Character> list) {
        LinkedListNode<Character> head = list;
        LinkedListNode<Character> tail = list;
        int length = 1;

        //navigate to tail of list
        while(tail.next != null) {
            tail = tail.next;
            length++;
        }


        //place pointer after mid point of list
        LinkedListNode<Character> nodeAfterMid = head;
        int midIndex = 0;

        if (length % 2 == 0) {
            midIndex = (length / 2);
            for (int i = 0; i < midIndex + 1; i++) {
                nodeAfterMid = nodeAfterMid.next;
            }
        } else {
            midIndex = (length - 1) / 2;
            for (int i = 0; i < midIndex + 1; i++) {
                nodeAfterMid = nodeAfterMid.next;
            }
        }

        //get start to midpoint
        for (int i = 0; i < midIndex - 1; i++) {
            head = head.next;
        }
        head.next = null;

        //reverse arrangement of nodes after midpoint
        LinkedListNode<Character> pointer = nodeAfterMid;

        while(pointer != tail) {
            LinkedListNode<Character> node = new LinkedListNode<>();
            node.data = pointer.data;
            node.next = tail.next;
            tail.next = node;
            pointer = pointer.next;
        }

        return list.equals(tail);
    }

    @Test
    void madam_returns_true() {
        LinkedListNode<Character> node1 = new LinkedListNode<>();
        node1.data = 'm';
        LinkedListNode<Character> node2 = new LinkedListNode<>();
        node2.data = 'a';
        LinkedListNode<Character> node3 = new LinkedListNode<>();
        node3.data = 'd';
        LinkedListNode<Character> node4 = new LinkedListNode<>();
        node4.data = 'a';
        LinkedListNode<Character> node5 = new LinkedListNode<>();
        node5.data = 'm';

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        assertTrue(solve(node1));
    }

    @Test
    void rotator_returns_true() {
        LinkedListNode<Character> node1 = new LinkedListNode<>();
        node1.data = 'r';
        LinkedListNode<Character> node2 = new LinkedListNode<>();
        node2.data = 'o';
        LinkedListNode<Character> node3 = new LinkedListNode<>();
        node3.data = 't';
        LinkedListNode<Character> node4 = new LinkedListNode<>();
        node4.data = 'a';
        LinkedListNode<Character> node5 = new LinkedListNode<>();
        node5.data = 't';
        LinkedListNode<Character> node6 = new LinkedListNode<>();
        node6.data = 'o';
        LinkedListNode<Character> node7 = new LinkedListNode<>();
        node7.data = 'r';

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        assertTrue(solve(node1));
    }
}
