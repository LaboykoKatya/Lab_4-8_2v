package command;

import model.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTotalPowerCommandTest {

    Apartment ap;

    @BeforeEach
    void setUp() {
        ap = new Apartment();
        KitchenAppliance k = new KitchenAppliance("Холодильник", 200, 100);
        k.turnOn();
        ap.addAppliance(k);
    }

    @Test
    void testCalculateTotal() {
        CalculateTotalPowerCommand cmd = new CalculateTotalPowerCommand(ap);
        assertDoesNotThrow(cmd::execute);
        assertEquals(200, ap.totalPowerOn());
    }
}
