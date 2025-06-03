public class BookStore {

    private int sku;
    private String item;
    private double price;
    private double cost;
    private int quantity;

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // constructor
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public BookStore() {
        sku = 0;
        item = "Not Entered";
        price = 0.0;
        cost = 0.0;
        quantity = 0;
    }

    public BookStore(int sku, String item, double price, double cost, int quantity) {
        this.sku = sku;
        this.item = item;
        this.price = price;
        this.cost = cost;
        this.quantity = quantity;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // accessors
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public int sku() {
        return sku;
    }

    public String item() {
        return item;
    }

    public double price() {
        return price;
    }

    public double cost() {
        return cost;
    }

    public int quantity() {
        return quantity;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // mutators
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public void sku(int sku) {
        this.sku = sku;
    }

    public void item(String item) {
        this.item = item;
    }

    public void price(double price) {
        this.price = price;
    }

    public void cost(double cost) {
        this.cost = cost;
    }

    public void quantity(int quantity) {
        this.quantity = quantity;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // misc methods
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public double profit() {
        return (price - cost) * quantity;
    }

    public double percentProfit(double totalProfit) {
        return (profit() / totalProfit) * 100;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}