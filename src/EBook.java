public class EBook extends Book
{
    private String fileType;

    private boolean isViaEmail;

    public EBook(String ISBN,String title,int yearPublished,double price,String fileType,boolean isViaEmail)
    {
        super(ISBN,title,yearPublished,price);
        this.fileType = fileType;
        this.isViaEmail = isViaEmail;
    }
    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public double buy(String ISBN,int quantity, String email, String address) {
        Inventory.updateQuantity(ISBN,quantity);
        double price = Inventory.calculateTotalPrice(ISBN,quantity);
        if(isViaEmail())
        {
            MailService mailService = new MailService(email);
        }
        return price;
    }

    public boolean isViaEmail() {
        return isViaEmail;
    }

    public void setViaEmail(boolean viaEmail) {
        isViaEmail = viaEmail;
    }
}