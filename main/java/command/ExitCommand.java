package command;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Вихід...");
        System.exit(0);
    }
}