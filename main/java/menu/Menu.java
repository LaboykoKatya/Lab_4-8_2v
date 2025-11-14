package menu;

import command.*;
import model.Apartment;
import service.SmartHomeAssistant;
import service.FileManager;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Apartment apartment;
    private SmartHomeAssistant assistant;
    private FileManager fileManager;
    private final Map<Integer, Command> commands = new LinkedHashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public Menu(Apartment apartment, SmartHomeAssistant assistant) {
        this.apartment = apartment;
        this.assistant = assistant;
        this.fileManager = new FileManager();
        initializeCommands();
    }

    private void initializeCommands() {
        // Прив’язуємо номери пунктів меню до команд
        commands.put(1, new AddApplianceCommand(apartment));
        commands.put(2, new TurnOnCommand(apartment));
        commands.put(3, new TurnOffCommand(apartment));
        commands.put(4, new SortByPowerCommand(apartment));
        commands.put(5, new FindByPowerRangeCommand(apartment));
        commands.put(6, new CalculateTotalPowerCommand(apartment));
        commands.put(7, new GetAdviceCommand(assistant));
        commands.put(8, new SaveToFileCommand(apartment, fileManager));
        commands.put(9, new LoadFromFileCommand(apartment, fileManager));
        commands.put(0, new ExitCommand());
    }

    public void show() {
        int choice;
        do {
            System.out.println("""
                \n===== МЕНЮ =====
                1. Додати прилад
                2. Увімкнути прилад
                3. Вимкнути прилад
                4. Сортувати за потужністю
                5. Знайти прилад у діапазоні потужності
                6. Загальна потужність увімкнених приладів
                7. Отримати пораду від розумного помічника
                8. Зберегти у файл
                9. Завантажити з файлу
                0. Вихід
                Виберіть пункт меню: 
                """);

            choice = scanner.nextInt();
            Command command = commands.get(choice);

            if (command != null) {
                command.execute();
            } else {
                System.out.println(" Невірний вибір. Спробуйте ще раз.");
            }
        } while (choice != 0);
    }
}