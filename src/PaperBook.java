public class PaperBook extends Book
{
    private int stock;
    private boolean isShippable;

    public PaperBook(String ISBN,String title,int yearPublished,double price,int stock,boolean isShippable)
    {
        super(ISBN,title,yearPublished,price);
        this.stock = stock;
        this.isShippable = isShippable;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isShippable() {
        return isShippable;
    }

    public void setShippable(boolean shippable) {
        isShippable = shippable;
    }

    @Override
    public double buy(String ISBN,int quantity, String email, String address) {
        Inventory.updateQuantity(ISBN,quantity);
        double price = Inventory.calculateTotalPrice(ISBN,quantity);
        if(isShippable())
        {
            ShippingService shippingService = new ShippingService(address);
        }
        return price;
    }
}