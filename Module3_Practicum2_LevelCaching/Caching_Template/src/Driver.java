public class Driver {

    public static void main(String[] args) {

//        ContentItem item1 = new ContentItem(1000, 10, "Type1","cont1");
//        ContentItem item2 = new ContentItem(2000, 20, "Type1", "cont2");
//        ContentItem item3 = new ContentItem(3000, 30, "Type1", "cont3");
//        ContentItem item4 = new ContentItem(4000, 40, "Type1", "cont4");
//        ContentItem item5 = new ContentItem(5000, 50, "Type1", "cont5");
//        ContentItem item6 = new ContentItem(6000, 60, "Type1", "cont6");
//        ContentItem item7 = new ContentItem(7000, 70, "Type1", "cont6");
//        ContentItem item210 = new ContentItem(210, 210, "Type1", "cont210");
//        ContentItem item200 = new ContentItem(200, 200, "Type1", "cont200");
//        ContentItem item190 = new ContentItem(190, 190, "Type1", "cont190");

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

//        CacheList cl1 = new CacheList(200);
////        item head = null
//        cl1.put(item1, "lru");
//        cl1.put(item2, "lru");
//        cl1.put(item3, "lru");
//        cl1.put(item4, "lru");
//        cl1.put(item5, "lru");
//        cl1.put(item6, "lru");
//        cl1.put(item7, "lru");

//        System.out.println(cl1.toString());
//
//        System.out.println(cl1.find(3000));
//        System.out.println(cl1.find(4000));
//
//        System.out.println(cl1.toString());
//
//        System.out.println(cl1.put(item3,"mru"));

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
//
//        cl1.clear();
//        System.out.println(cl1);

            CacheList myCacheList = new CacheList(200); //create a CacheList

            //Create multiple ContentItem for testing
            ContentItem c1 = new ContentItem(1, 20, "C-1 Header", "This is C-1");
            ContentItem c2 = new ContentItem(2, 30, "C-2 Header", "This is C-2");
            ContentItem c3 = new ContentItem(3, 100, "C-3 Header", "This is C-3");
            ContentItem c4 = new ContentItem(4, 70, "C-4 Header", "This is C-4");
            ContentItem c5 = new ContentItem(5, 200, "C-5 Header", "This is C-5");
            ContentItem c0 = new ContentItem(0, 0, "C-0 Header", "This is invalid content object");
            ContentItem cNeg = new ContentItem(0, -1, "C-Neg Header", "This is invalid content object");
            ContentItem cBig = new ContentItem(0, 210, "C-Big Header", "Content bigger than maxSize");

            //Variable for Eviction Policies
            String mru = "mru";
            String lru = "lru";

            System.out.println("--------Edge Cases for Put()--------");
            //Test edge cases for arguments input of put()
            //try to put 'null' as content | eviction policy doesn't matter
            //expecting to return an error message as String
            System.out.println(myCacheList.put(null,lru)); //Optional, can handle this in Cache

            //try to put content with size <= 0 | eviction policy doesn't matter
            //expecting to return an error message as String
            System.out.println(myCacheList.put(c0, mru)); //Optional, can handle this in Cache
            System.out.println(myCacheList.put(cNeg, mru)); //Optional, can handle this in Cache
            //try to put content with size > maxSize
            System.out.println(myCacheList.put(cBig, lru));

            //try to put valid content with invalid eviction policy
            //expecting to return an error message as String
            System.out.println(myCacheList.put(c1,"why evict"));

            System.out.println("\n--------Valid Put()--------");
            //add 3 c1,c2 and c3 to myCacheList | eviction policy doesn't matter for this case
            //Test put()
            //expecting myCacheList has 3 items -> c3, c2 and c1 | remaining size is 50
            System.out.println(myCacheList.put(c1, mru)); //expected null
            System.out.println(myCacheList.put(c2, mru)); //expected null
            System.out.println(myCacheList.put(c3, mru)); //expected null
            System.out.println();
            System.out.println(myCacheList);//Print what is inside myCacheList with toString()

            System.out.println("\n--------Test lruEvict()--------");
            //check eviction policy is working inside put()
            //test lru
            //expecting to remove c1 while adding c4 | remaining size should b 0
            //myCacheList has 3 items -> c4, c3 and c2
            System.out.println(myCacheList.put(c4,lru)); //expected null
            System.out.println();
            System.out.println(myCacheList);//Print what is inside myCacheList with toString()

            System.out.println("\n--------Test mruEvict()--------");
            //test lru
            //expecting to remove c4 while adding back c1 | remaining size should b 50
            //myCacheList has 3 items -> c1, c3 and c2
            System.out.println(myCacheList.put(c1,mru)); //expected null
            System.out.println();
            System.out.println(myCacheList);//Print what is inside myCacheList with toString()

            System.out.println("\n--------Test to Evict All--------");
            //expecting to remove all: c1, c3 and c2 to make space for c5 | remaining size should b 0
            //myCacheList has 1 item -> c5
            System.out.println(myCacheList.put(c5,mru)); //expected null
            System.out.println();
            System.out.println(myCacheList);//Print what is inside myCacheList with toString()

            System.out.println("\n--------Test Edge Cases for find()--------");
            //test edge cases for argument input of find()
            //trying to find content in empty list
            CacheList empty = new CacheList(200);
            System.out.println(empty.find(1)); // expecting null

            //trying to find content which is not inside in myCacheList
            System.out.println(myCacheList.find(9)); //expecting null

            System.out.println("\n--------Test valid find()--------");
            //trying to find a content while there is only one item in list
            System.out.println(myCacheList.find(5)); // expecting to return c5 content
            System.out.println("\nAdd back c1, c2, c3 in order"); //eviction doesn't matter for this case
            myCacheList.put(c3,lru);
            myCacheList.put(c2,lru);
            myCacheList.put(c1,lru);
            //trying to find cid = 3 (c3) in myCacheList
            System.out.println(myCacheList.find(3)); //expecting to return c3 content
            System.out.println();
            System.out.println(myCacheList); //c3 should move to top of the List

            System.out.println("\n--------Test Edge Cases for update()--------");
            //Object with updated content information to update the c1
            ContentItem toUpdate = new ContentItem(1, 20, "C-1 Header", "This is Updated C-1");
            //test edge cases for argument input of update()
            //trying to update content in empty list
            System.out.println(empty.update(1, toUpdate)); // expecting null
            //trying to update with null
            System.out.println(myCacheList.update(1,null)); //expecting null

            System.out.println("\n--------Test valid update()--------");
            System.out.println("\n--------Before Update--------");
            System.out.println(myCacheList); // order in list should b c3, c1, c2
            //trying to update cid = 1 (c1) in myCacheList
            System.out.println(myCacheList.update(1, toUpdate)); //expecting true
            System.out.println();
            System.out.println("\n--------After Update--------");
            System.out.println(myCacheList); //c1 should move to top of the list with updated content info

            //trying to update when there is only 1 item in CacheList
            CacheList solo = new CacheList(200);
            solo.put(c1, lru);
            System.out.println("\n--------Before Update--------");
            System.out.println(solo);
            //changing the content back
            toUpdate.setContent("This is Another Updated C-1");
            System.out.println(solo.update(1, toUpdate)); //expecting true
            System.out.println();
            System.out.println("\n--------After Update--------");
            System.out.println(solo);

            System.out.println("\n--------Test clear()--------");
            //clearing myCacheList
            myCacheList.clear();
            System.out.println(myCacheList); //expecting -> remaining space 200, items 0, List empty

        Cache cache1 = new Cache();
        cache1.insert(c1, "lru");
        System.out.println(cache1.toString());
        System.out.println(cache1.insert(c2, "lru"));
        System.out.println(cache1.insert(c3, "lru"));
        System.out.println(cache1.toString());





        }
    }


