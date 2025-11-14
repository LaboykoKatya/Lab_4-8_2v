package command;

import model.Apartment;
import model.Appliance;
import service.FileManager;
import java.util.List;

public class LoadFromFileCommand implements Command {
    private final Apartment apartment;
    private final FileManager fileManager;

    public LoadFromFileCommand(Apartment apartment, FileManager fileManager) {
        this.apartment = apartment;
        this.fileManager = fileManager;
    }

    @Override
    public void execute() {
        List<Appliance> loaded = fileManager.load();
        if (loaded != null) {
            apartment.setAppliances(loaded);
            System.out.println("Імпортовано " + loaded.size() + " приладів.");
        } else {
            System.out.println("Завантаження повернуло null.");
        }
    }
}