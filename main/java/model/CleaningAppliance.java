package model;

public class CleaningAppliance extends Appliance {
    private double area; // м²

    public CleaningAppliance(String name, double power, double area) {
        super(name, power);
        this.area = area;
    }

    public CleaningAppliance(String name, double power, boolean isOn, double area) {
        super(name, power, isOn);
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    @Override
    public double calculateEnergyConsumption() {
        // умовна формула: потужність * (area / 20)
        return getPower() * (area / 20.0);
    }

    @Override
    public double calculateEnergyCost() {
        double kwh = calculateEnergyConsumption() / 1000.0;
        double pricePerKwh = 2.64;
        return kwh * pricePerKwh;
    }

    @Override
    public String getUniqueInfo() {
        return String.format("(прибиральний) площа: %.1f м²", area);
    }
}