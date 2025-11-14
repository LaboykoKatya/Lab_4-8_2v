package model;

public class EntertainmentAppliance extends Appliance {
    private double screenSize;

    public EntertainmentAppliance(String name, double power, double screenSize) {
        super(name, power);
        this.screenSize = screenSize;
    }

    // Гетери, сетери
}