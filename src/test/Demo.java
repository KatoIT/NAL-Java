package test;

public class Demo {
    Test<String> test = new Test<String>() {
        @Override
        public int compareTo(String o1, String o2) {
            return 0;
        }
    };
}
