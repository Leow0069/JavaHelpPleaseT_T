/**
 * Desc: Content Item class that dictates the data being stored.
 */
public class ContentItem {
    private int cid;
    private int size;
    private String header;
    private String content;

    public ContentItem(int cid, int size, String header, String content) {
        this.cid = cid;
        this.size = size;
        this.header = header;
        this.content = content;
    }

    // ----------------------------- Accessor Methods ---------------------------
    // YOUR CODE HERE

    public int getCid() {
        return this.cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getSize() {
        return this.size;
    }

    public String getHeader() {
        return this.header;
    }

    public String getContent() {
        return this.content;
    }

    @Override
    public String toString(){
        return String.format("CONTENT ID: %d SIZE: %d HEADER: %s CONTENT: %s",
                getCid(), getSize(), getHeader(), getContent());
    }
}
