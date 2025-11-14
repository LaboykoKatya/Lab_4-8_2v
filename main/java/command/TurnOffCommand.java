package command;

import model.Apartment;

public class TurnOffCommand implements Command {
    private Apartment apartment;

    public TurnOffCommand(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public void execute() {}
}