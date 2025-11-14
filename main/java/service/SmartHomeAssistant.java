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

            System.out.printf("""
                    Прилад: %s
                    • Унікальна інформація: %s
                    • Потужність: %.0f Вт
                    • Енергоспоживання (умовне): %.2f
                    • Вартість: %.2f грн
                    ------------------------------------
                    """,
                    a.getName(),
                    a.getUniqueInfo(),
                    a.getPower(),
                    consumption,
                    cost);
        }

        System.out.printf("Загальна потужність увімкнених приладів: %.2f Вт%n", totalPower);

        // Найбільш затратний прилад
        Appliance worst = onAppliances.stream()
                .max(Comparator.comparingDouble(Appliance::calculateEnergyConsumption))
                .orElse(null);

        if (totalPower > 1000) {
            System.out.println("""
                     УВАГА!
                    Загальна потужність перевищує безпечний поріг 1000 Вт.
                    Рекомендація: вимкніть найбільш енергозатратний прилад:
                    → """ + worst.getName());
        } else {
            System.out.println("""
                     Система працює в безпечному режимі.
                    Рекомендація: періодично вимикайте непотрібні прилади
                    для економії електроенергії.
                    """);
        }
    }
}