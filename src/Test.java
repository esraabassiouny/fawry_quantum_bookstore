import java.util.List;

public class Test
{
    public void addBooks(List<Book> booksToAdd) {
        System.out.println("Quantum Bookstore: Adding books...");
        for (Book book : booksToAdd) {
            Inventory.addBook(book);
            System.out.println("Quantum Bookstore: Book added - " + book.getTitle());
        }
        System.out.println();
    }

    public void buyBook(String ISBN, int quantity, String email, String address) {
        try {
            Book book = Inventory.findBook(ISBN);
            double price = book.buy(ISBN, quantity, email, address);
            System.out.println("Quantum Bookstore: Purchased \"" + book.getTitle() + "\". Total price = " + price+"\n");
        } catch (RuntimeException e) {
            System.out.println("Quantum Bookstore: " + e.getMessage());
        }
    }

    public void removeOutdatedBooks(int noOfYears) {
        List<Book> outdated = Inventory.removeOutdatedBooks(noOfYears);
        if(!outdated.isEmpty())
        {
            System.out.println("Quantum Bookstore: Outdated books removed:");
            for (Book book : outdated) {
                System.out.println(" - " + book.getTitle() + " (" + book.getYearPublished() + ")");
            }
            System.out.println();
        }
        else
        {
            System.out.println("Quantum Bookstore: No Outdated books\n");
        }
    }
}
