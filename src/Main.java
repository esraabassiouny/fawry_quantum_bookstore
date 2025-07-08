import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        Test test = new Test();

        System.out.println("Quantum Bookstore: Starting tests...\n");

        // define books
        PaperBook paper = new PaperBook("ISBN001", "Java Basics", 2010, 120.0, 10, true);
        PaperBook paper1 = new PaperBook("ISBN005", "Thinking in Java", 1998, 100, 8, false);
        EBook ebook = new EBook("ISBN002", "Learn Python", 2021, 70.0, "pdf");
        DemoBook demo = new DemoBook("ISBN003", "A Tour of C++", 2013, 0.0);

        // add books
        List<Book> booksToAdd = new ArrayList<>();
        booksToAdd.add(paper);
        booksToAdd.add(paper1);
        booksToAdd.add(ebook);
        booksToAdd.add(demo);

        test.addBooks(booksToAdd);

        // buy available paper book
        test.buyBook("ISBN001", 2, "user1@example.com", "12 Cairo St");
        // buy available paper book
        test.buyBook("ISBN005", 3, "user1@example.com", "12 Cairo St");
        // buy ebook
        test.buyBook("ISBN002", 1, "user2@example.com", "Nasr City");

        // try to buy DemoBook (throw exception)
        test.buyBook("ISBN003", 1, "user3@example.com", "Giza");

        // buy more than stock available
        test.buyBook("ISBN001", 10, "user4@example.com", "Al-Tahrir St");

        // try to buy book not in inventory
        test.buyBook("ISBN010", 1, "user4@example.com", "Zamalek, Cairo");

        // remove outdated books (no outdated books)
        test.removeOutdatedBooks(40);

        // remove outdated books older than 10 years
        test.removeOutdatedBooks(10);

        // remove outdated books (no outdated books)
        test.removeOutdatedBooks(10);

        System.out.println("Quantum Bookstore: All test cases completed.");
    }
}