public class Cargo {

    private int containerNumber;
    private String name;
    private int tareWeight;
    private int grossWeight;

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // Constructor
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public Cargo() {
        containerNumber = 0;
        name = "Not Entered";
        tareWeight = 0;
        grossWeight = 0;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public Cargo(int containerNumber, String name, int tareWeight, int grossWeight) {
        this.containerNumber = containerNumber;
        this.name = name;
        this.tareWeight = tareWeight;
        this.grossWeight = grossWeight;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // Accessors
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public int containerNumber() {
        return containerNumber;
    }

    public String name() {
        return name;
    }

    public int tareWeight() {
        return tareWeight;
    }

    public int grossWeight() {
        return grossWeight;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // Mutators
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public void containerNumber(int containerNumber) {
        this.containerNumber = containerNumber;
    }

    public void name(String name) { // this. refers to this class, not main
        this.name = name;
    }

    public void tareWeight(int tareWeight) {
        this.tareWeight = tareWeight;
    }

    public void grossWeight(int grossWeight) {
        this.grossWeight = grossWeight;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // Misc Methods
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public int cargoWeight(int grossWeight, int tareWeight) {
        return grossWeight - tareWeight;
    }

    public double percentCargoWeight(int cargoWeight, int grossWeight) {
        return (cargoWeight * 1.0 / grossWeight) * 100;
    }

    public double percentTotal(int cargoWeight, int totalCargoWeight) {
        return (cargoWeight * 1.0 / totalCargoWeight) * 100;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}