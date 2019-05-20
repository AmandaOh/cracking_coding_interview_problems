import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Palindrome {

    //assuming singly linked list
    private boolean solve(LinkedListNode<Character> list) {
        LinkedListNode<Character> head = list;
        LinkedListNode<Character> runner = list;
        Queue<Character> startOfListToMid = Collections.asLifoQueue(new LinkedList<>());

        while(runner != null && runner.next != null) {
            startOfListToMid.add(head.data);
            head = head.next;
            //move runner twice as fast as head
            runner = runner.next.next;
        }

        //skip middle character if odd length
        if (runner != null) {
            head = head.next;
        }

        //compare list after midpoint to start of list to determine if palindrome
        while(head != null) {
            if (head.data != startOfListToMid.poll()) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

    @Test
    void redder_returns_true() {
        LinkedListNode<Character> node1 = new LinkedListNode<>();
        node1.data = 'r';
        LinkedListNode<Character> node2 = new LinkedListNode<>();
        node2.data = 'e';
        LinkedListNode<Character> node3 = new LinkedListNode<>();
        node3.data = 'd';
        LinkedListNode<Character> node4 = new LinkedListNode<>();
        node4.data = 'd';
        LinkedListNode<Character> node5 = new LinkedListNode<>();
        node5.data = 'e';
        LinkedListNode<Character> node6 = new LinkedListNode<>();
        node6.data = 'r';

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        assertTrue(solve(node1));
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
