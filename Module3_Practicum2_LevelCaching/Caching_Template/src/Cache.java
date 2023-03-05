/**
 * Desc: Cache class that simulates the different levels of caches.
 */

import java.nio.charset.StandardCharsets;

public class Cache {
    private CacheList[] caches; //array of CacheList objects
    private final int numCaches;

    // Constructor ------------------------
    // YOUR CODE HERE
    //---------------------------------------------------------------------
    Cache () {
        //default 3 cache lists
        this.numCaches = 3;
        // loop to create cachelists
        this.caches = new CacheList[numCaches];
        for (int i=0; i<this.numCaches; i++) {
            caches[i] = new CacheList(200);
        }
    }

    Cache (int numCaches) {
        if (numCaches < 2) {
            numCaches = 2;
        }
        this.numCaches = numCaches;
        // loop to create cachelists
       this.caches = new CacheList[numCaches];
        for (int i=0; i<this.numCaches; i++) {
            caches[i] = new CacheList(200);
        }
    }

    public CacheList[] getCaches() {
        return this.caches;
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (int i=0; i<this.numCaches; i++)
            temp.append("L").append(i+1).append(" CACHE: ")
                    .append(System.getProperty("line.separator")).append(caches[i])
                    .append(System.getProperty("line.separator"));
        return temp.toString();
    }

    /**
     * Clears all the caches of data
     * @return String message "Cache cleared!"
     */
    public String clear() {
        // YOUR CODE HERE
        //---------------------------------------------------------------------
        for (int i=0; i<this.numCaches; i++) {
            caches[i].clear();
        }
        //-------------------------------END-----------------------------------

        return "Cache cleared!";
    }

    /**
     * Calculates the hash from the content header. The hash formula to use is:
     * summing the ASCII value of each letter in the content header then modulus it by
     * the number of caches created
     * @param contentHeader - ContentItem object header
     * @return the index of the cache level
     */
    private int hashFunction(String contentHeader) {
        // YOUR CODE HERE
//        int h(String contentHeader, int M) {
            char ch[];
            ch = contentHeader.toCharArray();
//            int xlength = contentHeader.length();

            int i, sum;
            for (sum=0, i=0; i < contentHeader.length(); i++)
                sum += ch[i];
//            if (sum < 1000) {
                return sum % this.numCaches;
//            } else {
//                // Use folding on a string, summed 4 bytes at a time
////                long sfold(String s, int M) {
//                    int intLength = contentHeader.length() / 4;
//                    long sum = 0;
//                    for (int j = 0; j < intLength; j++) {
//                        char c[] = contentHeader.substring(j * 4, (j * 4) + 4).toCharArray();
//                        long mult = 1;
//                        for (int k = 0; k < c.length; k++) {
//                            sum += c[k] * mult;
//                            mult *= 256;
//                        }
//                    }
//
//                    char c[] = contentHeader.substring(intLength * 4).toCharArray();
//                    long mult = 1;
//                    for (int k = 0; k < c.length; k++) {
//                        sum += c[k] * mult;
//                        mult *= 256;
//                    }
//
//                    return(Math.abs(sum) % this.numCaches);
//                }
//            }
//        header.
    }
//      ORIGINAL
//    private int hashFunction(String contentHeader) {
//        // YOUR CODE HERE
//
//        header.
//    }

    /**
     * Adds a ContentItem object into the cache, along with the eviction policy.
     * Use either 'lru' or 'mru' to refer to the eviction policy
     * @param content - ContentItem object
     * @param evictionPolicy - Either the String "lru" or "mru". Case-insensitive
     * @return String message on the status of the insert.
     */
    public String insert(ContentItem content, String evictionPolicy) {

        // YOUR CODE HERE
        //---------------------------------------------------------------------
        int hash = hashFunction(content.getHeader());

        String result = caches[hash].put(content, evictionPolicy);
        if // YOUR CODE HERE
        //---------------------------------------------------------------------
        (result == null) {
            return String.format("INSERTED: %s", content);
        }
        else
            return result;
    }

    /**
     * Gets the content from the ContentItem object from the cache (if any)
     * @param content - ContentItem object
     * @return Object that can be either a ContentItem object or the String "Cache miss"
     */
    public Object retrieveContent(ContentItem content) {
        // YOUR CODE HERE
        //---------------------------------------------------------------------

        // check cache based on input content's header, get the contentItem,
        Object result = caches[hashFunction(content.getHeader())].find(content.getCid());

        // if content item exist, update retreive content
        if // YOUR CODE HERE
        //---------------------------------------------------------------------
        (result != null)
            return content;
        else
            return "Cache miss";
    }

    /**
     * Updates ONLY the ContentItem object's content from the cache (if any).
     * Do not update any other attributes in the object other than the content attribute.
     * @param content - ContentItem object
     * @return String message on the status of the update.
     */
//    public String updateContent(ContentItem content) {
//        // YOUR CODE HERE
//        //---------------------------------------------------------------------
//
//
//        if // YOUR CODE HERE
//        //---------------------------------------------------------------------
//
//        return String.format("UPDATED: %s", content);
//        else
//            return "Cache miss";
//    }
}
