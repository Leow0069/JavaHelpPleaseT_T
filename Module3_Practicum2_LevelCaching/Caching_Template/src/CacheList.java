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
        // check maximum size here
        if (maxSize < content.getSize()) {
            return "content size is bigger than remaining";
        } else if (content.getSize() <= 0){
            return "content size must be bigger than 0";
        } else {
            if (this.getHead() == null) {
                // if there is no head Node, set this to the head Node
                this.addToHead(content);
                remainingSize -= content.getSize();
            } else {
                // if there is existing nodes, content exists
                if (findOnly(content.getCid()) != null) {
                    // detach and push to head
                    return "duplicate item found";
                    // content doesnt exists
                } else {
                    // need to create the new node
                    // first check if remaining size >= content.size, create new node an add as head

                    while (remainingSize < content.getSize()) {
                        if (evictionPolicy.equalsIgnoreCase("lru")) {
                            this.lruEvict();
                        } else if (evictionPolicy.equalsIgnoreCase("mru")) {
                            this.mruEvict();
                        } else {
                            return "please state lru or mru for evicion policy";
                        }
                    }
                    this.addToHead(content);
                    remainingSize -= content.getSize();
                    return null;
                }
            }
        } return null;
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

        // while curr has body,
        while (curr != null) {
            // search through for matching content id
            if (curr.getData().getCid() == cid) {
                if (curr.getNext() != null) {
                    // set found item as head
                    prev.setNext(curr.getNext());
                    curr.setNext(this.getHead());
                    this.setHead(curr);

                    return curr.getData();
                // if found match but only 1 item,
                } else {
                    return curr.getData();
                }
            }
            prev = curr;
            curr = curr.getNext();
        }
        System.out.println("No content item found");
        return null;
    }

    /**
     * Purely to search for the ContentItem object in the cache given the content id
     * @param cid - ContentItem id
     * @return ContentItem object or null
     */
    public ContentItem findOnly(int cid) {
        // YOUR CODE HERE
        //---------------------------------------------------------------------
        Node<ContentItem> curr = this.getHead();

        while (curr != null) {
            if (curr.getData().getCid() == cid) {
                return curr.getData();
            }
            curr = curr.getNext();
        }
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
    public Boolean update(int cid, ContentItem content) {
        // YOUR CODE HERE
        //---------------------------------------------------------------------
        // find item in list and push to head using search function
        ContentItem originalContent = this.find(cid);
        if (originalContent != null) {
            //replace content data
            originalContent.setContent(content.getContent());
            return true;
        } else {
            return null;
        }
    }

    /**
     * Removes the first item of the list
     */
    public void mruEvict() {
        // YOUR CODE HERE
        //---------------------------------------------------------------------
        remainingSize += this.removeFromHead().getSize();
    }

    /**
     * Removes the last item of the list
     */
    public void lruEvict() {
        // YOUR CODE HERE
        //---------------------------------------------------------------------
//        removeFromTail();
        remainingSize += this.removeFromTail().getSize();
    }

    /**
     * Removes all items from the list
     */
    public void clear(){
        // YOUR CODE HERE
        //---------------------------------------------------------------------
        // TODO to double check!
        Node<ContentItem> node = new Node<>(null,null);
        this.setHead(node);

        this.remainingSize = this.maxSize;
        System.out.println("cache cleared");
    }
}
