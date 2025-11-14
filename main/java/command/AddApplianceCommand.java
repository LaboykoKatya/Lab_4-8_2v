package command;

import model.*;
import java.util.Scanner;

public class AddApplianceCommand implements Command {
    private final Apartment apartment;
    private final Scanner scanner;

    public AddApplianceCommand(Apartment apartment, Scanner scanner) {
        this.apartment = apartment;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Виберіть тип приладу: 1-Кухонний, 2-Прибиральний, 3-Розважальний");
        String t = scanner.nextLine().trim();
        int type;
        try {
            type = Integer.parseInt(t);
        } catch (NumberFormatException e) {
            System.out.println("Невірний вибір типу.");
            return;
        }

        System.out.print("Назва: ");
        String name = scanner.nextLine().trim();
        System.out.print("Потужність (Вт): ");
        double power;
        try {
            power = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Невірне значення потужності.");
            return;
        }

        Appliance a = null;
        switch (type) {
            case 1 -> {
                System.out.print("Об'єм (л): ");
                double vol = Double.parseDouble(scanner.nextLine().trim());
                a = new KitchenAppliance(name, power, vol);
            }
            case 2 -> {
                System.out.print("Площа (м²): ");
                double area = Double.parseDouble(scanner.nextLine().trim());
                a = new CleaningAppliance(name, power, area);
            }
            case 3 -> {
                System.out.print("Розмір екрана (дюйми): ");
                double screen = Double.parseDouble(scanner.nextLine().trim());
                a = new EntertainmentAppliance(name, power, screen);
            }
            default -> {
                System.out.println("Невідомий тип приладу.");
                return;
            }
        }
        apartment.addAppliance(a);
        System.out.println("Прилад додано: " + a.getName());
    }
}