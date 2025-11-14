package command;

import model.Apartment;
import java.util.Scanner;

public class TurnOffCommand implements Command {
    private final Apartment apartment;
    private final Scanner scanner;

    public TurnOffCommand(Apartment apartment, Scanner scanner) {
        this.apartment = apartment;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Введіть назву приладу для вимкнення: ");
        String name = scanner.nextLine().trim();
        apartment.turnOff(name);
        System.out.println("Спроба вимкнення: " + name);
    }
}