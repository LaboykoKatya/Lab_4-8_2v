package command;

import model.Apartment;
import service.SmartHomeAssistant;

public class GetAdviceCommand implements Command {
    private final Apartment apartment;
    private final SmartHomeAssistant assistant;

    public GetAdviceCommand(Apartment apartment, SmartHomeAssistant assistant) {
        this.apartment = apartment;
        this.assistant = assistant;
    }

    @Override
    public void execute() {
        assistant.analyze(apartment.getTurnedOn());
    }
}