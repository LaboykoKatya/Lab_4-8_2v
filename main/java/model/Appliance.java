package model;

public abstract class Appliance {
    protected String name;
    protected double power;
    protected boolean isOn;

    public Appliance(String name, double power) {
        this.name = name;
        this.power = power;
    }

    public void turnOn() {}
    public void turnOff() {}
    public void getPower() {}
    public void isOn() {}
    public void getAdvice(){}

}