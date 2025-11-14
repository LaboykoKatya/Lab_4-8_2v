package model;

public class KitchenAppliance extends Appliance {
    private double volume;

    public KitchenAppliance(String name, double power, double volume) {
        super(name, power);
        this.volume = volume;
    }

    // Гетери, сетери
}