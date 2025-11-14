package service;

import model.Appliance;
import model.KitchenAppliance;
import model.CleaningAppliance;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SmartHomeAssistantTest {

    @Test
    void testAnalyzeWithAppliances() {
        SmartHomeAssistant assistant = new SmartHomeAssistant();

        Appliance a1 = new KitchenAppliance("Fridge", 1200, 200);
        a1.turnOn();

        Appliance a2 = new CleaningAppliance("Vacuum", 100, 50);
        a2.turnOn();

        // Використовуємо Arrays.asList() замість List.of()
        List<Appliance> appliances = Arrays.asList(a1, a2);
        assistant.analyze(appliances);
    }

    @Test
    void testAnalyzeEmpty() {
        SmartHomeAssistant assistant = new SmartHomeAssistant();
        // Порожній список
        List<Appliance> emptyList = Arrays.asList();
        assistant.analyze(emptyList);
    }
}
