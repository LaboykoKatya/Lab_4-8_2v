package model;

public abstract class Appliance {
    private String name;
    private double power;
    private boolean isOn;

    public Appliance(String name, double power) {
        this.name = name;
        this.power = power;
        this.isOn = false;
    }

    public Appliance(String name, double power, boolean isOn) {
        this.name = name;
        this.power = power;
        this.isOn = isOn;
    }

    public String getName() {
        return name;
    }

    public double getPower() {
        return power;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    // Скільки енергії (умовна величина) споживає прилад
    public abstract double calculateEnergyConsumption();

    // Скільки це коштує
    public abstract double calculateEnergyCost();

    // Повертає рядок з унікальною інформацією
    public abstract String getUniqueInfo();

    @Override
    public String toString() {
        return String.format("%s [потужність: %.1f Вт, %s] %s",
                name, power, (isOn ? "увімкнено" : "вимкнено"), getUniqueInfo());
    }
}