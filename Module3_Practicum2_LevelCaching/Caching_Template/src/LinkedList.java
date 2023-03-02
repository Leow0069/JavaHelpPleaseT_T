/**
 * Desc: Generic Linked List implementation.
 */
public class LinkedList<E> {
    private Node<E> head;
    private int numItems;   // number of Node objects currently in the Linked List

    public LinkedList() {
        this.head = null;
        numItems = 0;
    }

    // ----------------------- Accessor methods ------------------------
    // YOUR CODE HERE
    public Node<E> getHead() {
        return this.head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public int getNumItems() {
        return this.numItems;
    }

    // ----------------------- Accessor methods END ------------------------
    public boolean isEmpty() {
        return this.numItems == 0;
    }

    /**
     * Add an item to the head of the linked list
     *
     * @param e item to add
     */
    public void addToHead(E e) {
        // YOUR CODE HERE
        //---------------------------------------------------------------------
        if (this.head == null)
            // if there is no head Node, set this to the head Node
            this.head = new Node(e, null);
        else
            // otherwise the current head node is set to the
            // next pointer in the new node. The new Node is then set
            // as the new head of the Linked list
            this.head = new Node(e, this.head);
    }

    /**
     * Remove item from the head of the linked list
     *
     * @return item removed from the head of the linked list
     */
    public E removeFromHead() {
        // YOUR CODE HERE
        //---------------------------------------------------------------------
        // temporarily store the head node to prevent breaking changes
        Node<E> curr = this.head;
        // if curr is not empty
        if (curr != null) {
            // assign head to next node so first head node gets dumped
            this.head = curr.getNext();
            // return dumped data to track the size that will be available once again
            return curr.getData();
        }
        return null;
    }

    /**
     * Remove item from the tail of the linked list
     *
     * @return item removed from the tail of the linked list
     */
    public E removeFromTail() {
        // YOUR CODE HERE
        //---------------------------------------------------------------------
        // temporarily store the head node to prevent breaking changes
        Node<E> curr = this.head;
        // use to store the previous node
        Node<E> prev = null;

        // traversing to search for the Node to remove
        while (curr != null) {
            // check for the last node which holds null at .next
            if (curr.getNext() == null) {
                if (prev == null){
                    // if theres only one node, prev will still be null, so need to specifically assign head to null to avoid null pointer exception
                    this.head = null;
                    // return dumped data to track the size that will be available once again
                    return curr.getData();
                }
                // if curr.next is null, dump curr
                prev.setNext(null);
                // return dumped data to track the size that will be available once again
                return curr.getData();
                // Node has been removed, loop exited
            }
            // store the current Node in the previous temporary container
            prev = curr;
            curr = curr.getNext();
        }
//        TODO your list is empty
//        System.out.println("Your list is empty");
        return null;
    }

    public void printLinkedList() {
        // temporarily store the head node to prevent breaking changes
        // the Node curr important as it acts like a points and keep changing
        Node curr = this.head;

        // traversing the Linked List
        while (curr != null) {
            // printing the data stored in the Node obj
            System.out.println(curr.getData());
            // move on to the next node in the list
            curr = curr.getNext();
        }
    }
}
