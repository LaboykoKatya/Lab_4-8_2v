package command;

import model.Apartment;

public class TurnOnCommand implements Command {
    private Apartment apartment;

    public TurnOnCommand(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public void execute() {}
}