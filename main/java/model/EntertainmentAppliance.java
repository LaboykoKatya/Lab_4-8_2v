package model;

public class EntertainmentAppliance extends Appliance {
    private double screenSize; // дюйми

    public EntertainmentAppliance(String name, double power, double screenSize) {
        super(name, power);
        this.screenSize = screenSize;
    }

    public EntertainmentAppliance(String name, double power, boolean isOn, double screenSize) {
        super(name, power, isOn);
        this.screenSize = screenSize;
    }

    public double getScreenSize() {
        return screenSize;
    }

    @Override
    public double calculateEnergyConsumption() {
        // умовна формула: потужність * (screenSize / 40)
        return getPower() * (screenSize / 40.0);
    }

    @Override
    public double calculateEnergyCost() {
        double kwh = calculateEnergyConsumption() / 1000.0;
        double pricePerKwh = 2.64;
        return kwh * pricePerKwh;
    }

    @Override
    public String getUniqueInfo() {
        return String.format("(розважальний) екран: %.1f\"", screenSize);
    }
}