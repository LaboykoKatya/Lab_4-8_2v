package command;

import model.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FindByPowerRangeCommandTest {

    Apartment ap;

    @BeforeEach
    void setUp() {
        ap = new Apartment();
        ap.addAppliance(new KitchenAppliance("Холодильник", 200, 100));
        ap.addAppliance(new CleaningAppliance("Пилосос", 500, 50));
    }

    @Test
    void testFindRange() {
        String input = "100\n300\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        FindByPowerRangeCommand cmd = new FindByPowerRangeCommand(ap, scanner);
        assertDoesNotThrow(cmd::execute);
    }
}
