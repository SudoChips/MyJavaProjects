public class Account {

    private int id = 0;
    private double balance = 0.0;
    private double annualInterestRate = 0.0;
    private java.util.Date dateCreated;

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // constructor
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public Account() {
        dateCreated = new java.util.Date();
    }

    public Account(int id, double balance) {
        this();
        this.id = id;
        this.balance = balance;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // accessors
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public int id() {
        return this.id;
    }

    public double balance() {
        return this.balance;
    }

    public double annualInterestRate() {
        return this.annualInterestRate;
    }

    public String getDateCreated() {
        return this.dateCreated.toString();
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // mutators
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public void id(int id) {
        this.id = id;
    }

    public void balance(double balance) {
        this.balance = balance;
    }

    public void annualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // misc methods
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public double getMonthlyInterestRate() {
        return (annualInterestRate / 100) / 12;
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    public void withdraw(double withdraw) {
        this.balance -= withdraw;
    }

    public void deposit(double deposit) {
        this.balance += deposit;
    }

    public double total(double monthlyInterest) {
        this.balance += monthlyInterest;
        return this.balance;
    }
}