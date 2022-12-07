import factories.ArcherFactory;
import factories.CavalryFactory;
import factories.InfantryFactory;
import game.GameField;
import supportingFiles.CheckInputService;
import units.Base;

public class Main {
    public static void main(String[] args) {

        gameMenu();
    }
   

    private static void gameMenu() {

        InfantryFactory infantryFactory = new InfantryFactory();
        ArcherFactory archerFactory = new ArcherFactory();
        CavalryFactory cavalryFactory = new CavalryFactory();
        Base base1 = new Base();

        startGameWrites();

        int height = CheckInputService.inputInteger(50, "Your height is too big. It will uncomfortable");
        int width = CheckInputService.inputInteger(50, "Your width is too big. It will uncomfortable");

        GameField gameField = new GameField(height, width);
        gameField.drawField();

        int choice = 0;
        while (choice != 4) {

            startMenuGame();

            choice = CheckInputService.inputInteger(4, "Your input is out of range (1 - 4)");
            switch (choice) {
                case 1:
                    base1.createUnit(gameField);
                    break;
                case 2:
                    base1.removeUnit(gameField);
                    break;
                case 3:
                    gameField.moveUnit();
                    break;
                case 4:
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
        System.out.println("1 - Add unit\n2 - Remove unit\n3 - Move unit \n4 - Escape from the battle");
    }
}