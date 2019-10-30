package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book clean = new Book("Clean code", 500);
        Book thinking = new Book("Thinking in Java", 1200);
        Book patterns = new Book("Design Patterns", 700);
        Book servlets = new Book("Servlets and JSP", 900);

        Book[] books = new Book[4];
        books[0] = clean;
        books[1] = thinking;
        books[2] = patterns;
        books[3] = servlets;

        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " : " + book.getCount());
        }

        System.out.println("После перестановки:");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " : " + book.getCount());
        }
        System.out.println("Только книги с названием Clean code:");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " : " + book.getCount());
            }
        }

    }
}
