public class QueueViaStacks {

    private class MyQueue<T> {

        Node<T> head;
        Stack<Node<T>> firstStack;
        Stack<Node<T>> secondStack;

        public MyQueue() {
            firstStack = new Stack<>(10);
            secondStack = new Stack<>(10);
        }

        public void push(T data) {
            if (firstStack.isEmpty()) {
                head = new Node<>(data);
                firstStack.push(head);
                return;
            }
            Node<T> node = new Node(data);
            firstStack.push(node);
            head.next = node;
        }

        public void pop() {

        }
    }
}
