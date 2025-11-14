
package command;

import model.Apartment;
import model.Appliance;
import java.util.List;

public class SortByPowerCommand implements Command {
    private final Apartment apartment;

    public SortByPowerCommand(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public void execute() {
        List<Appliance> sorted = apartment.sortByPower();
        System.out.println("Прилади, відсортовані за потужністю (зростання):");
        int i = 1;
        for (Appliance a : sorted) {
            System.out.printf("%d) %s%n", i++, a);
        }
    }
}