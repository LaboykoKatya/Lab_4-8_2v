package command;

import model.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ShowAllAppliancesCommandTest {

    @Test
    void testShow() {
        Apartment ap = new Apartment();
        ap.addAppliance(new CleaningAppliance("Пилосос", 500, 40));

        ShowAllAppliancesCommand cmd = new ShowAllAppliancesCommand(ap);

        assertDoesNotThrow(cmd::execute);
    }
}
