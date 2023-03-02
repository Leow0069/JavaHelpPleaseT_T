public class Driver {

    // new ...
    // (1000, 10, "Content Type-1", "0xF1")
    // (1000, 10, "Content Type-2", "GET www.pictures.com")
    // .insert
    // Content Type-A
    public static void main(String[] args) {

        ContentItem item1 = new ContentItem(1000, 10, "Type1","cont1");
        ContentItem item2 = new ContentItem(2000, 20, "Type1", "cont2");
        ContentItem item3 = new ContentItem(3000, 30, "Type1", "cont3");
        ContentItem item4 = new ContentItem(4000, 40, "Type1", "cont4");
        ContentItem item5 = new ContentItem(5000, 50, "Type1", "cont5");


        LinkedList<ContentItem> ll = new LinkedList<>();
        ll.addToHead(item1);
        ll.addToHead(item2);
        ll.addToHead(item3);
        ll.addToHead(item4);
        ll.addToHead(item5);
//
//        ll.removeFromHead();
//        ll.removeFromHead();
//        ll.removeFromTail();
        ll.printLinkedList();

        System.out.println(ll.removeFromTail().toString());
        System.out.println(ll.removeFromTail().toString());
        ll.printLinkedList();

        CacheList cl1 = new CacheList(200);
//        cl1.find(1230);
//        System.out.println(cl1.find(1000));
//        System.out.println(cl1.toString());

    }

}
