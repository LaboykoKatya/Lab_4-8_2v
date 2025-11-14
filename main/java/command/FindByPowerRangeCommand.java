package command;

import model.Apartment;
import model.Appliance;
import java.util.List;
import java.util.Scanner;

public class FindByPowerRangeCommand implements Command {
    private final Apartment apartment;
    private final Scanner scanner;

    public FindByPowerRangeCommand(Apartment apartment, Scanner scanner) {
        this.apartment = apartment;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            System.out.print("Мінімальна потужність: ");
            double min = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Максимальна потужність: ");
            double max = Double.parseDouble(scanner.nextLine().trim());
            List<Appliance> list = apartment.findByPowerRange(min, max);
            if (list.isEmpty()) {
                System.out.println("Приладів у цьому діапазоні не знайдено.");
            } else {
                System.out.println("Знайдені прилади:");
                int i = 1;
                for (Appliance a : list) System.out.printf("%d) %s%n", i++, a);
            }
        } catch (NumberFormatException e) {
            System.out.println("Невірне число.");
        }
    }
}