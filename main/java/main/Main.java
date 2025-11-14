package main;

import menu.Menu;
import model.Apartment;
import service.SmartHomeAssistant;

public class Main {
    public static void main(String[] args) {
        Apartment apartment = new Apartment();
        SmartHomeAssistant assistant = new SmartHomeAssistant(apartment);
        Menu menu = new Menu(apartment, assistant);
        menu.show();
    }
}