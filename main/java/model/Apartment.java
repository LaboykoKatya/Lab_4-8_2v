package model;

import java.util.*;
import java.util.stream.Collectors;

public class Apartment {
    private List<Appliance> appliances = new ArrayList<>();

    public Apartment() {}

    public List<Appliance> getAppliances() {
        return appliances;
    }

    public void setAppliances(List<Appliance> appliances) {
        this.appliances = appliances != null ? appliances : new ArrayList<>();
    }

    public void addAppliance(Appliance a) {
        if (a != null) appliances.add(a);
    }

    public void turnOn(String name) {
        appliances.stream()
                .filter(x -> x.getName().equalsIgnoreCase(name))
                .findFirst()
                .ifPresent(Appliance::turnOn);
    }

    public void turnOff(String name) {
        appliances.stream()
                .filter(x -> x.getName().equalsIgnoreCase(name))
                .findFirst()
                .ifPresent(Appliance::turnOff);
    }

    public List<Appliance> sortByPower() {
        return appliances.stream()
                .sorted(Comparator.comparingDouble(Appliance::getPower))
                .collect(Collectors.toList());
    }

    public List<Appliance> findByPowerRange(double min, double max) {
        return appliances.stream()
                .filter(a -> a.getPower() >= min && a.getPower() <= max)
                .collect(Collectors.toList());
    }

    public double totalPowerOn() {
        return appliances.stream()
                .filter(Appliance::isOn)
                .mapToDouble(Appliance::getPower)
                .sum();
    }

    public List<Appliance> getTurnedOn() {
        return appliances.stream().filter(Appliance::isOn).collect(Collectors.toList());
    }

    public void showAll() {
        if (appliances.isEmpty()) {
            System.out.println("У квартирі немає приладів.");
            return;
        }
        int i = 1;
        for (Appliance a : appliances) {
            System.out.printf("%d) %s%n", i++, a);
        }
    }
}