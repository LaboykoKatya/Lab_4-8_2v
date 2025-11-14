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
            System.out.println(
                    "===== МЕНЮ =====\n" +
                            "1. Додати прилад\n" +
                            "2. Увімкнути прилад\n" +
                            "3. Вимкнути прилад\n" +
                            "4. Сортувати за потужністю\n" +
                            "5. Знайти прилади за діапазоном потужності\n" +
                            "6. Порахувати загальну потужність увімкнених\n" +
                            "7. Отримати пораду від розумного помічника\n" +
                            "8. Зберегти у файл\n" +
                            "9. Завантажити з файлу\n" +
                            "10. Показати всі прилади\n" +
                            "0. Вихід\n"
            );

            System.out.print("Введіть опцію: ");
            String in = scanner.nextLine().trim();

            Command cmd = null;

            switch (in) {
                case "1":
                    cmd = new AddApplianceCommand(apartment, scanner);
                    break;
                case "2":
                    cmd = new TurnOnCommand(apartment, scanner);
                    break;
                case "3":
                    cmd = new TurnOffCommand(apartment, scanner);
                    break;
                case "4":
                    cmd = new SortByPowerCommand(apartment);
                    break;
                case "5":
                    cmd = new FindByPowerRangeCommand(apartment, scanner);
                    break;
                case "6":
                    cmd = new CalculateTotalPowerCommand(apartment);
                    break;
                case "7":
                    cmd = new GetAdviceCommand(apartment, assistant);
                    break;
                case "8":
                    cmd = new SaveToFileCommand(apartment, fileManager);
                    break;
                case "9":
                    cmd = new LoadFromFileCommand(apartment, fileManager);
                    break;
                case "10":
                    cmd = new ShowAllAppliancesCommand(apartment);
                    break;
                case "0":
                    cmd = new ExitCommand(() -> System.exit(0));
                    break;
                default:
                    System.out.println("Невірна опція, спробуйте ще раз.");
            }

            if (cmd != null) cmd.execute();
        }
    }
}
