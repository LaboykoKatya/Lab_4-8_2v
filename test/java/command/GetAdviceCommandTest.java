package command;

import model.*;
import org.junit.jupiter.api.*;
import service.SmartHomeAssistant;

import static org.junit.jupiter.api.Assertions.*;

class GetAdviceCommandTest {

    @Test
    void testAdvice() {
        Apartment ap = new Apartment();
        SmartHomeAssistant assistant = new SmartHomeAssistant();

        GetAdviceCommand cmd = new GetAdviceCommand(ap, assistant);

        assertDoesNotThrow(cmd::execute);
    }
}
