///**
// * Desc: Cache class that simulates the different levels of caches.
// */
//
//import java.nio.charset.StandardCharsets;
//
//public class Cache {
//    private CacheList[] caches;
//    private final int numCaches;
//
//    // Constructor ------------------------
//    // YOUR CODE HERE
//    Cache () {
//
//    }
//
//    public CacheList[] getCaches() {
//        return this.caches;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder temp = new StringBuilder();
//        for (int i=0; i<this.numCaches; i++)
//            temp.append("L").append(i+1).append(" CACHE: ")
//                    .append(System.getProperty("line.separator")).append(caches[i])
//                    .append(System.getProperty("line.separator"));
//        return temp.toString();
//    }
//
//    /**
//     * Clears all the caches of data
//     * @return String message "Cache cleared!"
//     */
//    public String clear() {
//        // YOUR CODE HERE
//
//        return "Cache cleared!";
//    }
//
//    /**
//     * Calculates the hash from the content header. The hash formula to use is:
//     * summing the ASCII value of each letter in the content header then modulus it by
//     * the number of caches created
//     * @param contentHeader - ContentItem object header
//     * @return the index of the cache level
//     */
//    private int hashFunction(String contentHeader) {
//        // YOUR CODE HERE
//    }
//
//    /**
//     * Adds a ContentItem object into the cache, along with the eviction policy.
//     * Use either 'lru' or 'mru' to refer to the eviction policy
//     * @param content - ContentItem object
//     * @param evictionPolicy - Either the String "lru" or "mru". Case-insensitive
//     * @return String message on the status of the insert.
//     */
//    public String insert(ContentItem content, String evictionPolicy) {
//        // YOUR CODE HERE
//
//        if // YOUR CODE HERE
//            return String.format("INSERTED: %s", content);
//        else
//            return result;
//    }
//
//    /**
//     * Gets the content from the ContentItem object from the cache (if any)
//     * @param content - ContentItem object
//     * @return Object that can be either a ContentItem object or the String "Cache miss"
//     */
//    public Object retrieveContent(ContentItem content) {
//        // YOUR CODE HERE
//
//        if // YOUR CODE HERE
//            return content;
//        else
//            return "Cache miss";
//    }
//
//    /**
//     * Updates ONLY the ContentItem object's content from the cache (if any).
//     * Do not update any other attributes in the object other than the content attribute.
//     * @param content - ContentItem object
//     * @return String message on the status of the update.
//     */
//    public String updateContent(ContentItem content) {
//        // YOUR CODE HERE
//
//        if // YOUR CODE HERE
//            return String.format("UPDATED: %s", content);
//        else
//            return "Cache miss";
//    }
//}
