package command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ExitCommandTest {

    @Test
    void testExit() {
        // Використовуємо масив як флаг, щоб перевірити виконання exitAction
        boolean[] exited = {false};

        // Створюємо команду з кастомним дією замість System.exit
        ExitCommand cmd = new ExitCommand(() -> exited[0] = true);

        // Виконуємо команду
        cmd.execute();

        // Перевіряємо, що "вихід" було виконано
        assertTrue(exited[0], "Exit action should be executed");
    }
}
