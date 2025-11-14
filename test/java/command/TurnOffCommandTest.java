package command;

import model.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TurnOffCommandTest {

    Apartment ap;

    @BeforeEach
    void setUp() {
        ap = new Apartment();
        KitchenAppliance k = new KitchenAppliance("Холодильник", 200, 100);
        k.turnOn();
        ap.addAppliance(k);
    }

    @Test
    void testTurnOff() {
        String input = "Холодильник\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        TurnOffCommand cmd = new TurnOffCommand(ap, scanner);
        cmd.execute();

        assertFalse(ap.getAppliances().get(0).isOn());
    }
}
