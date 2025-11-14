package command;

import service.FileManager;
import model.Apartment;

public class SaveToFileCommand implements Command {
    private final Apartment apartment;
    private final FileManager fileManager;

    public SaveToFileCommand(Apartment apartment, FileManager fileManager) {
        this.apartment = apartment;
        this.fileManager = fileManager;
    }

    @Override
    public void execute() {
        fileManager.save(apartment.getAppliances());
    }
}