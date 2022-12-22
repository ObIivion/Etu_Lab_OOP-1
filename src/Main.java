import game.GameField;
import supportingFiles.CheckInputService;
import units.Base;

/**
 * 	\brief Класс - точка входа в программу. Для взаимодействия пользователя с игрой через меню
 * 	\version 1.0
 * 	\date Ноябрь 2022
 *
 * 	Основной класс для взаимодействия пользователя с игрой с помощью меню.
 * 	В этом классе создаётся объект поля и с помощью него пользователь может взаимодействовать с полем
 *
 */

public class Main {
    public static void main(String[] args) {

        gameMenu();
    }

    /// функция, предоставляющая пользователю возможность взаимодействовать с игрой с помощью меню
    private static void gameMenu() {

        Base base1 = null;

        startGameWrites();

        int height = CheckInputService.inputInteger(50, "Your height is too big. It will uncomfortable");
        int width = CheckInputService.inputInteger(50, "Your width is too big. It will uncomfortable");

        GameField gameField = new GameField(height, width);
        gameField.drawField();

        int choice = 0;
        while (choice != 5) {

            startMenuGame();

            choice = CheckInputService.inputInteger(5, "Your input is out of range (1 - 4)");
            switch (choice) {
                case 1:
                    if(base1 != null)
                        base1.createUnit(gameField);
                    else
                        System.out.println("Build a base first\n");
                    break;
                case 2:
                    if(base1 != null)
                        base1.removeUnit(gameField);
                    else
                        System.out.println("Build a base first\n");
                    break;
                case 3:
                    gameField.moveUnit();
                    break;
                case 4:
                    base1 = new Base(gameField);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Error of Choice");
            }
        }
    }

    private static void startGameWrites() {
        System.out.println("Start game");
        System.out.println("Set height and width of field");
    }

    private static void startMenuGame() {

        System.out.println("MenuGame");
        System.out.println("Make your choice");
        System.out.println("1 - Add unit\n2 - Remove unit\n3 - Move unit \n4 - Build a base \n5 - Escape from the battle");
    }
}