package model;

public class CleaningAppliance extends Appliance {
    private double area;

    public CleaningAppliance(String name, double power, double area) {
        super(name, power);
        this.area = area;
    }

    // Гетери, сетери
}