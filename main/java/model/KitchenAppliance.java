package model;

public class KitchenAppliance extends Appliance {
    private double volume; // літри

    public KitchenAppliance(String name, double power, double volume) {
        super(name, power);
        this.volume = volume;
    }

    public KitchenAppliance(String name, double power, boolean isOn, double volume) {
        super(name, power, isOn);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public double calculateEnergyConsumption() {
        // умовна формула: потужність * (volume / 10) (тобто більший об'єм — більше енергії)
        return getPower() * (volume / 10.0);
    }

    @Override
    public double calculateEnergyCost() {
        double kwh = calculateEnergyConsumption() / 1000.0; // перетворимо Вт·год на кВт·год умовно
        double pricePerKwh = 2.64; // приклад тарифу у грн
        return kwh * pricePerKwh;
    }

    @Override
    public String getUniqueInfo() {
        return String.format("(кухонний) об'єм: %.1f л", volume);
    }
}