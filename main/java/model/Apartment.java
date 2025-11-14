package model;

import java.util.ArrayList;
import java.util.List;

public class Apartment {
    private List<Appliance> appliances = new ArrayList<>();

    public Apartment() {
        this.appliances = new ArrayList<>();
    }

    public void addAppliance(Appliance appliance) {}
    public void removeAppliance(Appliance appliance) {}

    public void turnOnAppliance(String name) {}
    public void turnOffAppliance(String name) {}

    public List<Appliance> getTurnedOnAppliances() {
        return new ArrayList<>();
    }

    public void sortByPower() {}
    public void findByPowerRange(double min, double max) {}
    public double calculateTotalPower() { return 0; }
    public List<Appliance> getAllAppliances() { return appliances; }
}