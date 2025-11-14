package service;

import model.Appliance;
import model.KitchenAppliance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    private FileManager fm;
    private final String testFile = "test_appliances.txt";

    @BeforeEach
    void setUp() {
        fm = new FileManager(testFile);
        new File(testFile).delete();
    }

    @Test
    void testSaveAndLoad() {
        Appliance a1 = new KitchenAppliance("Fridge", 200, 150);

        // Використовуємо Arrays.asList для сумісності
        List<Appliance> appliancesToSave = Arrays.asList(a1);
        fm.save(appliancesToSave);

        List<Appliance> loaded = fm.load();
        assertEquals(1, loaded.size());
        assertEquals("Fridge", loaded.get(0).getName());
    }
}
