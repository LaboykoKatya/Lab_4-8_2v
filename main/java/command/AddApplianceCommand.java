package command;

import model.Apartment;

public class AddApplianceCommand implements Command {
    private Apartment apartment;

    public AddApplianceCommand(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public void execute() {}
}