package gc.examples;

public class GCDemo {
    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / KB);
        System.out.printf("Total: %d%n", totalMemory / KB);
        System.out.printf("Max: %d%n", maxMemory / KB);
    }

    public static void main(String[] args) {
        info();
        User one = new User("1", 1);
        User two = new User("2", 2);
        User three = new User("3", 3);
        User four = new User("4", 4);
        User five = new User("5", 5);
        User six = new User("6", 6);
        User seven = new User("7", 7);
        User eight = new User("8", 8);
        User nine = new User("9", 9);
        User ten = new User("10", 10);
        for (int i = 0; i < 8000; i++) {
            new Person(i, "N" + i);
        }
        info();
    }
}
