public abstract class Book
{
    private String ISBN;
    private String title;
    private int yearPublished;
    private double price;
    public Book(String ISBN,String title,int yearPublished,double price)
    {
        this.ISBN = ISBN;
        this.title = title;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    public abstract double buy(String ISBN,int quantity, String email, String address);

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
