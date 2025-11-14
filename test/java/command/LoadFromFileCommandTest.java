package command;

import model.*;
import org.junit.jupiter.api.*;
import service.FileManager;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoadFromFileCommandTest {

    private FileManager fileManager;
    private Apartment ap;

    @BeforeEach
    void setUp() {
        fileManager = new FileManager("test_load.txt");
        ap = new Apartment();

        // Видаляємо старий тестовий файл
        new File("test_load.txt").delete();

        // Зберігаємо тестовий прилад
        List<Appliance> appliances = Arrays.asList(
                new KitchenAppliance("Холодильник", 200, 100)
        );
        fileManager.save(appliances);
    }

    @Test
    void testLoad() {
        LoadFromFileCommand cmd = new LoadFromFileCommand(ap, fileManager);
        cmd.execute();

        assertEquals(1, ap.getAppliances().size());
        assertEquals("Холодильник", ap.getAppliances().get(0).getName());
    }
}
