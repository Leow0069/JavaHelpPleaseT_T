/**
 * Desc: Node class to store the content items. Each node will store 1 content item.
 */
public class Node<E>{
    private E data;
    private Node<E> next;

    public Node(E e, Node<E> n) {
        this.data = e;
        this.next = n;
    }

    // ----------------------- Accessor methods ------------------------
    // YOUR CODE HERE
    public E getData() {
        return this.data;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return String.format("CONTENT:%s\n", this.data);
    }
}
