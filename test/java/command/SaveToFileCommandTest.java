package command;

import model.*;
import org.junit.jupiter.api.*;
import service.FileManager;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class SaveToFileCommandTest {

    @Test
    void testSave() {
        Apartment ap = new Apartment();
        ap.addAppliance(new KitchenAppliance("Холодильник", 200, 100));

        FileManager manager = new FileManager("test_save.txt");
        SaveToFileCommand cmd = new SaveToFileCommand(ap, manager);

        assertDoesNotThrow(cmd::execute);
        assertTrue(new File("test_save.txt").exists());
    }
}
