package command;

import model.Apartment;

public class CalculateTotalPowerCommand implements Command {
    private Apartment apartment;

    public CalculateTotalPowerCommand(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public void execute() {}
}