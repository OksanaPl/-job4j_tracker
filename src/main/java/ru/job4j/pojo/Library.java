package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Алиса в зазеркалье", 105);
        Book book2 = new Book("Психология личности", 258);
        Book book3 = new Book("Слово и дело", 274);
        Book book4 = new Book("Clean code", 100);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            Book bs = books[i];
            System.out.println(bs.getName() + " - " + bs.getPage());
        }
        System.out.println("Меняем местами индекс 0 и 3");
        Book use = books[0];
        books[0] = books[3];
        books[3] = use;
        for (int i = 0; i < books.length; i++) {
            Book bs = books[i];
            System.out.println(bs.getName() + " - " + bs.getPage());
        }
        System.out.println("Выводим книги с именем \"Clean code\"");
        for (int i = 0; i < books.length; i++) {
            Book bs = books[i];
            if (bs.getName().equals("Clean code")) {
                System.out.println(bs.getName());
            }
        }
    }
}


