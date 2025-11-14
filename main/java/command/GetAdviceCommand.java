package command;

import service.SmartHomeAssistant;

public class GetAdviceCommand implements Command {
    private SmartHomeAssistant assistant;

    public GetAdviceCommand(SmartHomeAssistant assistant) {
        this.assistant = assistant;
    }

    @Override
    public void execute() {}
}