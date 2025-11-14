package command;

import model.Apartment;

public class FindByPowerRangeCommand implements Command {
    private Apartment apartment;

    public FindByPowerRangeCommand(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public void execute() {}
}