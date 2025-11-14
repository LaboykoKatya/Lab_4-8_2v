package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentTest {

    private Apartment apartment;
    private Appliance kitchen, cleaning, entertainment;

    @BeforeEach
    void setUp() {
        apartment = new Apartment();
        kitchen = new KitchenAppliance("Fridge", 200, 150);
        cleaning = new CleaningAppliance("Vacuum", 100, 40);
        entertainment = new EntertainmentAppliance("TV", 150, 32);
        apartment.addAppliance(kitchen);
        apartment.addAppliance(cleaning);
        apartment.addAppliance(entertainment);
    }

    @Test
    void testAddAndGetAppliances() {
        List<Appliance> list = apartment.getAppliances();
        assertEquals(3, list.size());
        assertTrue(list.contains(kitchen));
    }

    @Test
    void testTurnOnOff() {
        apartment.turnOn("Vacuum");
        assertTrue(cleaning.isOn());
        apartment.turnOff("Vacuum");
        assertFalse(cleaning.isOn());
    }

    @Test
    void testSortByPower() {
        List<Appliance> sorted = apartment.sortByPower();
        assertEquals(cleaning, sorted.get(0));
        assertEquals(kitchen, sorted.get(2));
    }

    @Test
    void testFindByPowerRange() {
        List<Appliance> list = apartment.findByPowerRange(120, 250);
        assertEquals(2, list.size());
        assertTrue(list.contains(kitchen));
        assertTrue(list.contains(entertainment));
    }

    @Test
    void testTotalPowerOn() {
        kitchen.turnOn();
        entertainment.turnOn();
        double total = apartment.totalPowerOn();
        assertEquals(350, total, 0.01);
    }

    @Test
    void testGetTurnedOn() {
        kitchen.turnOn();
        List<Appliance> turnedOn = apartment.getTurnedOn();
        assertEquals(1, turnedOn.size());
    }

    @Test
    void testShowAll() {
        apartment.showAll();
    }
}
