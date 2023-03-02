import com.sun.source.tree.WhileLoopTree;

/**
 * Desc: Cache List class is the Singly Linked list class that implements
 *        the caching abilities of the different level of caches.
 */
public class CacheList extends LinkedList<ContentItem>{
    private int remainingSize;  // remaining size after ContentItem objects have been added
    private final int maxSize;  // refers to the max size of the cache, currently set at 200

    public CacheList(int size) {
        super();
        this.maxSize = size;
        this.remainingSize = size;
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        Node<ContentItem> curr = getHead();
        while (curr != null) {
            temp.append("[").append(curr.getData()).append("]\n");
            curr = curr.getNext();
        }
        return String.format("""
                REMAINING SPACE:%d
                ITEMS:%d
                LIST:
                %s""", this.remainingSize, getNumItems(), temp);
    }

    /**
     * Adds a node containing a ContentItem object to the beginning of the list.
     * Uses either the lru/mru eviction policy to remove items from the cache when necessary.
     * @param content - ContentItem object
     * @param evictionPolicy - Either the String "lru" or "mru". Case-insensitive
     * @return null (if successful) or an error message
     */
    public String put(ContentItem content, String evictionPolicy) {
        // YOUR CODE HERE
        //---------------------------------------------------------------------
        if (this.head == null)
            // if there is no head Node, set this to the head Node
            this.head = new Node(e, null);
       else {
            // if there is existing nodes, put result input node in front,
            find(content.getCid());
            // else return null if existing content doenst exist

            if (return = null) {
                // check size limit
                // if content.size <= remaining size, create new node an add as head
                // if content.size > remaining size, use LRU or MRU to remove, then create new node and add as head
                //

                this.head = new Node(e, this.head);

            }
        }
    }

    /**
     * Searches for the ContentItem object in the cache given the content id.
     * If the item is found, it is then moved to the beginning of the list
     * @param cid - ContentItem id
     * @return ContentItem object or null
     */
    public ContentItem find(int cid) {
        // YOUR CODE HEREd
        //---------------------------------------------------------------------
        Node<ContentItem> curr = this.getHead();
        Node<ContentItem> prev = null;

        while (curr != null ) {
            System.out.println("looping");
            if (curr.getData().getCid() == cid) {

                prev.setNext(curr.getNext());
                curr.setNext(this.getHead());
                this.setHead(curr);

                return curr.getData();
            }
            prev = curr;
            curr = curr.getNext();
        }
        System.out.println("No content item found");
        return null;
    }

    /**
     * Updates the content of the ContentItem object (if it is found). Node is then moved to the
     * beginning of the list.
     *
     * @param cid - ContentItem id
     * @param content - New ContentItem object for updating the old object
     * @return true if updated, null otherwise
     */
//    public Boolean update(int cid, ContentItem content) {
//        // YOUR CODE HERE
//        //---------------------------------------------------------------------
//
//    }

    /**
     * Removes the first item of the list
     */
    public void mruEvict() {
        // YOUR CODE HERE
        //---------------------------------------------------------------------

        removeFromHead();
    }

    /**
     * Removes the last item of the list
     */
    public void lruEvict() {
        // YOUR CODE HERE
        //---------------------------------------------------------------------
        removeFromTail();
    }

    /**
     * Removes all items from the list
     */
//    public void clear(){
//        // YOUR CODE HERE
//        //---------------------------------------------------------------------
//
//    }
}
