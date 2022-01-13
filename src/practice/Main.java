package practice;

public class Main {

    public static void main(String[] args) {
        // write your code here
        ListTest<Integer> listInteger = new ListTest<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(3);
        listInteger.add(4);

        System.out.println("element 4: " + listInteger.get(4));
        System.out.println("element 1: " + listInteger.get(1));
        System.out.println("element 2: " + listInteger.get(2));

//        listInteger.get(6);
//        System.out.println("element 6: " + listInteger.get(6));

//        listInteger.get(-1);
//        System.out.println("element -1: " + listInteger.get(-1));

        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        LinkedListTest ll = new LinkedListTest(10);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);

        ll.add(4,9);
        ll.add(4,9);
        ll.printList();
    }
}
