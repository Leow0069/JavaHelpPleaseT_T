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
        ContentItem item6 = new ContentItem(6000, 60, "Type1", "cont6");
        ContentItem item7 = new ContentItem(7000, 70, "Type1", "cont6");
        ContentItem item210 = new ContentItem(210, 210, "Type1", "cont210");
        ContentItem item200 = new ContentItem(200, 200, "Type1", "cont200");
        ContentItem item190 = new ContentItem(190, 190, "Type1", "cont190");

//        LinkedList<ContentItem> ll = new LinkedList<>();
//        ll.addToHead(item1);
//        ll.addToHead(item2);
//        ll.addToHead(item3);
//        ll.addToHead(item4);
//        ll.addToHead(item5);
//
//        ll.removeFromHead();
//        ll.removeFromHead();
//        ll.removeFromTail();
//        ll.printLinkedList();
//
//        System.out.println(ll.removeFromTail().toString());
//        System.out.println(ll.removeFromTail().toString());
//        ll.printLinkedList();

        CacheList cl1 = new CacheList(200);
//        item head = null
        cl1.put(item1, "lru");
        cl1.put(item2, "lru");
        cl1.put(item3, "lru");
        cl1.put(item4, "lru");
        cl1.put(item5, "lru");
//        cl1.put(item6, "lru");
//        cl1.put(item7, "lru");

        System.out.println(cl1.toString());

        System.out.println(cl1.find(3000));
        System.out.println(cl1.find(4000));

        System.out.println(cl1.toString());

        System.out.println(cl1.put(item3,"mru"));

//        item size >
//        System.out.println(cl1.put(item200,"lru"));
//        System.out.println(cl1.toString());
//
//        System.out.println(cl1.put(item190,"lru"));
//
////        item exist, detach and push to top
////        item not exist, create new, content size smaller than remaining
////        item not exist, create new, content size larger than remaining
//
////        System.out.println(cl1.find(1000));
//        System.out.println(cl1.toString());
//
//        cl1.find(1230);
//        System.out.println(cl1.find(190));
//
//        System.out.println(cl1.find(210));
//        System.out.println(cl1.put(item210,"lru"));

        cl1.clear();
        System.out.println(cl1);
    }

}
