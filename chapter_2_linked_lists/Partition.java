import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Partition {

    private LinkedListNode<Integer> solve(LinkedListNode<Integer> list, int partition) {
        LinkedListNode<Integer> partitionNode = new LinkedListNode();
        partitionNode.data = partition;
        boolean isPartitionIncluded = false;
        LinkedListNode<Integer> headOfPartitionedList = partitionNode;

        while (list != null) {
            LinkedListNode<Integer> currentNode = new LinkedListNode<>();
            currentNode.data = list.data;

            if (list.data < partition) {
                currentNode.next = headOfPartitionedList;
                headOfPartitionedList = currentNode;
            } else if (list.data == partition && !isPartitionIncluded) {
                isPartitionIncluded = true;
            } else {
                currentNode.next = partitionNode.next;
                partitionNode.next = currentNode;
            }

            list = list.next;
        }


        return headOfPartitionedList;
    }

    @Test
    void test() {
        LinkedListNode<Integer> node1 = new LinkedListNode<>();
        node1.data = 3;
        LinkedListNode<Integer> node2 = new LinkedListNode<>();
        node2.data = 5;
        LinkedListNode<Integer> node3 = new LinkedListNode<>();
        node3.data = 8;
        LinkedListNode<Integer> node4 = new LinkedListNode<>();
        node4.data = 5;
        LinkedListNode<Integer> node5 = new LinkedListNode<>();
        node5.data = 10;
        LinkedListNode<Integer> node6 = new LinkedListNode<>();
        node6.data = 2;
        LinkedListNode<Integer> node7 = new LinkedListNode<>();
        node7.data = 1;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        LinkedListNode<Integer> expectedNode1 = new LinkedListNode<>();
        expectedNode1.data = 1;
        LinkedListNode<Integer> expectedNode2 = new LinkedListNode<>();
        expectedNode2.data = 2;
        LinkedListNode<Integer> expectedNode3 = new LinkedListNode<>();
        expectedNode3.data = 3;
        LinkedListNode<Integer> expectedNode4 = new LinkedListNode<>();
        expectedNode4.data = 5;
        LinkedListNode<Integer> expectedNode5 = new LinkedListNode<>();
        expectedNode5.data = 10;
        LinkedListNode<Integer> expectedNode6 = new LinkedListNode<>();
        expectedNode6.data = 5;
        LinkedListNode<Integer> expectedNode7 = new LinkedListNode<>();
        expectedNode7.data = 8;

        expectedNode1.next = expectedNode2;
        expectedNode2.next = expectedNode3;
        expectedNode3.next = expectedNode4;
        expectedNode4.next = expectedNode5;
        expectedNode5.next = expectedNode6;
        expectedNode6.next = expectedNode7;

        assertEquals(expectedNode1, solve(node1, 5));
    }
}
