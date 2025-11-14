package menu;

import service.FileManager;
import service.SmartHomeAssistant;
import command.*;
import java.util.Scanner;
import model.Apartment;

public class Menu {
    private final Apartment apartment = new Apartment();
    private final FileManager fileManager = new FileManager();
    private final SmartHomeAssistant assistant = new SmartHomeAssistant();
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
        ===== МЕНЮ =====
        1. Додати прилад
        2. Увімкнути прилад
        3. Вимкнути прилад
        4. Сортувати за потужністю
        5. Знайти прилади за діапазоном потужності
        6. Порахувати загальну потужність увімкнених
        7. Отримати пораду від розумного помічника
        8. Зберегти у файл
        9. Завантажити з файлу
        10. Показати всі прилади
        0. Вихід
        """);

            System.out.print("Введіть опцію: ");
            String in = scanner.nextLine().trim();
            Command cmd = null;
            switch (in) {
                case "1" -> cmd = new AddApplianceCommand(apartment, scanner);
                case "2" -> cmd = new TurnOnCommand(apartment, scanner);
                case "3" -> cmd = new TurnOffCommand(apartment, scanner);
                case "4" -> cmd = new SortByPowerCommand(apartment);
                case "5" -> cmd = new FindByPowerRangeCommand(apartment, scanner);
                case "6" -> cmd = new CalculateTotalPowerCommand(apartment);
                case "7" -> cmd = new GetAdviceCommand(apartment, assistant);
                case "8" -> cmd = new SaveToFileCommand(apartment, fileManager);
                case "9" -> cmd = new LoadFromFileCommand(apartment, fileManager);
                case "10" -> cmd = new ShowAllAppliancesCommand(apartment);

                case "0" -> cmd = new ExitCommand();
                default -> System.out.println("Невірна опція, спробуйте ще раз.");
            }
            if (cmd != null) cmd.execute();
        }
    }
}