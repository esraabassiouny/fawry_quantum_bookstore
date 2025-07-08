import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Inventory
{
    private static List<Book> books = new ArrayList<>();
    public static void addBook(Book book)
    {
        for(Book inventoryBook:books)
        {
           if(inventoryBook.getISBN().equals(book.getISBN()))
               throw new RuntimeException("This book already added before\n");
        }
        books.add(book);
    }

    public static List<Book> removeOutdatedBooks(int noOfYears)
    {
        List<Book> outdatedBooks = new ArrayList<>();
        int currentYear = LocalDate.now().getYear();
        for(Book book:books)
        {
            if(currentYear - book.getYearPublished() >= noOfYears)
            {
                outdatedBooks.add(book);
            }
        }
        books.removeAll(outdatedBooks);
        return outdatedBooks;
    }

    public static Book findBook(String ISBN)
    {
        for(Book inventoryBook:books)
        {
            if(inventoryBook.getISBN().equals(ISBN))
            {
                return inventoryBook;
            }
        }
        throw new RuntimeException("Book in not found\n");
    }

    public static boolean checkQuantity(PaperBook book,int quantity)
    {
        return book.getStock() >= quantity;
    }
    public static void updateQuantity(String ISBN,int quantity)
    {
        Book book = findBook(ISBN);
        if (book instanceof PaperBook) {
            if (checkQuantity(((PaperBook) book), quantity))
            {
                //update stock if paper book
                int newQuantity = ((PaperBook) book).getStock() - quantity;
                ((PaperBook) book).setStock(newQuantity);
            }
            else  // quantity available not enough
            {
                throw new RuntimeException("Quantity available is not enough\n");
            }
        }
    }

    public static double getPriceByISBN(String ISBN) {
        for(Book inventoryBook:books)
        {
            if(inventoryBook.getISBN().equals(ISBN))
            {
                return inventoryBook.getPrice();
            }
        }
        throw new RuntimeException("Book in not found\n");
    }
    public static double calculateTotalPrice(String ISBN,int quantity)
    {
        double price = getPriceByISBN(ISBN);
        return price*quantity;
    }
}

