package command;

import model.Apartment;
import java.util.Scanner;

public class TurnOnCommand implements Command {
    private final Apartment apartment;
    private final Scanner scanner;

    public TurnOnCommand(Apartment apartment, Scanner scanner) {
        this.apartment = apartment;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Введіть назву приладу для увімкнення: ");
        String name = scanner.nextLine().trim();
        apartment.turnOn(name);
        System.out.println("Спроба увімкнення: " + name);
    }
}