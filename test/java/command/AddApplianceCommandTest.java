package command;

import model.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AddApplianceCommandTest {

    private Apartment apartment;

    @BeforeEach
    void setUp() {
        apartment = new Apartment();
    }

    @Test
    void testAddKitchenAppliance() {
        String input = "1\nХолодильник\n200\n100\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        AddApplianceCommand cmd = new AddApplianceCommand(apartment, scanner);
        cmd.execute();

        assertEquals(1, apartment.getAppliances().size());
        assertEquals("Холодильник", apartment.getAppliances().get(0).getName());
    }
}
