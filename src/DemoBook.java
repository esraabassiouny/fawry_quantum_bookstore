public class DemoBook extends Book
{
    public DemoBook(String ISBN,String title,int yearPublished,double price)
    {
        super(ISBN,title,yearPublished,price);
    }

    @Override
    public double buy(String ISBN, int quantity, String email, String address) {
        throw new RuntimeException("This book is not for sale\n");
    }
}
