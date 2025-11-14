package command;
import model.Apartment;

public class CalculateTotalPowerCommand implements Command {
    private final Apartment apartment;

    public CalculateTotalPowerCommand(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public void execute() {
        double total = apartment.totalPowerOn();
        System.out.printf("Загальна потужність увімкнених приладів: %.2f Вт%n", total);
    }
}