package command;

import model.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SortByPowerCommandTest {

    @Test
    void testSort() {
        Apartment ap = new Apartment();
        ap.addAppliance(new CleaningAppliance("Пилосос", 500, 40));
        ap.addAppliance(new KitchenAppliance("Холодильник", 200, 100));

        SortByPowerCommand cmd = new SortByPowerCommand(ap);

        assertDoesNotThrow(cmd::execute);
    }
}
