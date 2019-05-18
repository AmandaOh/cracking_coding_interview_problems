import java.util.Objects;

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

        return this.next.equals(that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(next, data);
    }
}
