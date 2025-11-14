package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ApplianceTest {

    @Test
    void testKitchenAppliance() {
        KitchenAppliance k = new KitchenAppliance("Fridge", 200, 150);
        assertEquals(200, k.getPower());
        assertEquals("Fridge", k.getName());
        assertTrue(k.calculateEnergyConsumption() > 0);
        assertTrue(k.calculateEnergyCost() > 0);
        assertTrue(k.getUniqueInfo().contains("об'єм"));
    }

    @Test
    void testCleaningAppliance() {
        CleaningAppliance c = new CleaningAppliance("Vacuum", 100, 40);
        assertEquals(40, c.getArea());
        assertTrue(c.calculateEnergyConsumption() > 0);
        assertTrue(c.calculateEnergyCost() > 0);
    }

    @Test
    void testEntertainmentAppliance() {
        EntertainmentAppliance e = new EntertainmentAppliance("TV", 150, 32);
        assertEquals(32, e.getScreenSize());
        assertTrue(e.calculateEnergyConsumption() > 0);
        assertTrue(e.calculateEnergyCost() > 0);
        assertTrue(e.getUniqueInfo().contains("екран"));
    }
}

