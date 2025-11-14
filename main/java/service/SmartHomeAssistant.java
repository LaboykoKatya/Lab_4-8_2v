package service;

import model.Appliance;

import java.util.Comparator;
import java.util.List;

public class SmartHomeAssistant {

    public void analyze(List<Appliance> onAppliances) {
        if (onAppliances == null || onAppliances.isEmpty()) {
            System.out.println("Немає увімкнених приладів для аналізу.");
            return;
        }

        System.out.println("\n--- Аналіз енергоспоживання — увімкнені прилади ---");

        double totalPower = 0;

        for (Appliance a : onAppliances) {
            double consumption = a.calculateEnergyConsumption();
            double cost = a.calculateEnergyCost();
            totalPower += a.getPower();

            System.out.printf(
                    "Прилад: %s\n" +
                            "• Унікальна інформація: %s\n" +
                            "• Потужність: %.0f Вт\n" +
                            "• Енергоспоживання (умовне): %.2f\n" +
                            "• Вартість: %.2f грн\n" +
                            "------------------------------------\n",
                    a.getName(),
                    a.getUniqueInfo(),
                    a.getPower(),
                    consumption,
                    cost
            );
        }

        System.out.printf("Загальна потужність увімкнених приладів: %.2f Вт%n", totalPower);

        // Найбільш затратний прилад
        Appliance worst = onAppliances.stream()
                .max(Comparator.comparingDouble(Appliance::calculateEnergyConsumption))
                .orElse(null);

        if (totalPower > 1000) {
            System.out.println(
                    "УВАГА!\n" +
                            "Загальна потужність перевищує безпечний поріг 1000 Вт.\n" +
                            "Рекомендація: вимкніть найбільш енергозатратний прилад:\n" +
                            "→ " + worst.getName()
            );
        } else {
            System.out.println(
                    "Система працює в безпечному режимі.\n" +
                            "Рекомендація: періодично вимикайте непотрібні прилади\n" +
                            "для економії електроенергії.\n"
            );
        }
    }
}
