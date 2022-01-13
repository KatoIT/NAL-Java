package exercise;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedListTest<Integer> listTest = new LinkedListTest<>();
        listTest.add(1);
        listTest.add(3);
        listTest.add(5);
        listTest.add(2);
        listTest.add(4);
        for (Integer i :
                listTest) {
            System.out.println(i);
        }
    }
}
