package command;

import model.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TurnOnCommandTest {

    Apartment ap;

    @BeforeEach
    void setUp() {
        ap = new Apartment();
        ap.addAppliance(new KitchenAppliance("Холодильник", 200, 100));
    }

    @Test
    void testTurnOn() {
        String input = "Холодильник\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        TurnOnCommand cmd = new TurnOnCommand(ap, scanner);
        cmd.execute();

        assertTrue(ap.getAppliances().get(0).isOn());
    }
}
