package command;

import model.Apartment;

public class SortByPowerCommand implements Command {
    private Apartment apartment;

    public SortByPowerCommand(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public void execute() {}
}