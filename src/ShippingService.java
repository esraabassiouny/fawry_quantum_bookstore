public class ShippingService
{
    private String address;
    public ShippingService(String address)
    {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
