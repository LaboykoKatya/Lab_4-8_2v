package command;

import model.Apartment;
import service.FileManager;

public class LoadFromFileCommand implements Command {
    private Apartment apartment;
    private FileManager fileManager;

    public LoadFromFileCommand(Apartment apartment, FileManager fileManager) {
        this.apartment = apartment;
        this.fileManager = fileManager;
    }

    @Override
    public void execute() {}
}