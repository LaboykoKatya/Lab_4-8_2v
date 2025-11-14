package command;

import model.Apartment;

public class ShowAllAppliancesCommand implements Command {
    private final Apartment apartment;

    public ShowAllAppliancesCommand(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public void execute() {
        System.out.println("\n===== Усі прилади =====");
        apartment.showAll();
    }
}