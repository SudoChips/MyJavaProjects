public class Stock {

    private String symbol;
    private String company;
    private double previousClose;
    private double currentClose;
    private double percentChange;

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // constructor
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public Stock() {
        symbol = "Not Entered";
        company = "Not Entered";
        previousClose = 0.0;
        currentClose = 0.0;
        percentChange = 0.0;
    }

    public Stock(String symbol, String company, double previousClose, double currentClose, double percentChange) {
        this.symbol = symbol;
        this.company = company;
        this.previousClose = previousClose;
        this.currentClose = currentClose;
        this.percentChange = percentChange;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // accessors
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public String symbol() {
        return symbol;
    }

    public String company() {
        return company;
    }

    public double previousClose() {
        return previousClose;
    }

    public double currentClose() {
        return currentClose;
    }

    public double percentChange() {
        return percentChange;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // mutators
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public void symbol(String symbol) {
        this.symbol = symbol;
    }

    public void company(String company) {
        this.company = company;
    }

    public void previousClose(double previousClose) {
        this.previousClose = previousClose;
    }

    public void currentClose(double currentClose) {
        this.currentClose = currentClose;
    }

    public void percentChange(double percentChange) {
        this.percentChange = percentChange;
    }

    /*//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // misc methods
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public double profit() {
        return (price - cost) * quantity;
    }

    public double percentProfit(double totalProfit) {
        return (profit() / totalProfit) * 100;
    }
    */
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}