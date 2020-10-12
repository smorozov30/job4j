package gc.examples;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", name, age);
    }

    public static void main(String[] args) {
        byte[] value = new byte[] {'a'};
        User user = new User("a", 1);
        byte coder = 1;
        boolean res = true;
        int i = 5;
        System.out.println(sizeOf(i));
    }
}
