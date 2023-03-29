public class Product {
    private String code;
    private String title;
    private int quantity;
    private double price;

    /**
     * Constructor to create a new Product
     * @param code
     * @param title
     * @param quantity
     * @param price
     */
    public Product(String code, String title, int quantity, double price) {
        this.code = code;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * getter
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * getter
     * @return  quantity
     */
    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return code + "  |" + title + "  |" + quantity + "  |" + price;
    }

}
