package command;

public class ExitCommand implements Command {

    private final Runnable exitAction;

    // Конструктор з можливістю передати будь-яку дію (тест / продакшн)
    public ExitCommand(Runnable exitAction) {
        this.exitAction = exitAction;
    }

    @Override
    public void execute() {
        System.out.println("Вихід...");
        exitAction.run();
    }
}
