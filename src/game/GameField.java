package game;
import supportingFiles.CheckInputService;
import supportingFiles.Coordinates;
import supportingFiles.DirectionsOfMove;
import units.BaseUnit;
import units.Base;
import units.FieldObject;
import units.LandscapeObjects.FieldLandscape;
import units.LandscapeObjects.MountainLandscape;
import units.LandscapeObjects.WaterLandscape;
import java.util.ArrayList;
import units.NeutralObjects.*;

/**
 * 	\brief Класс игрового поля
 * 	\version 1.0
 * 	\date Ноябрь 2022
 *
 * 	Класс, для управления игровым полем: создание поля с ландшафтом, добавление/удаление юнитов,
 * 	перемещение юнитов, добавления базы, взаимодействия юнитов с объектами ландшафта.
 */

public class GameField {
    private int width; ///< длина поля
    private int height; ///< высота поля
    private int numberOfUnits = 0; ///< хранит число юнитов на поле
    private Coordinates baseCoord; ///< координаты базы на поле
    private ArrayList<BaseUnit> listOfUnits = new ArrayList<>(); ///< список юнитов на поле
    private FieldObject[] landscapes = new FieldObject[7]; ///< список ландшафтов для генерации поля с ландшафтом

    private String field = ""; ///< строка, которая по сути представяет из себя поле

    /// конструктор создания поля
    public GameField(int height, int width) {
        this.height = height;
        this.width = width;
        landscapes[0] = new FieldLandscape();
        landscapes[1] = new MountainLandscape();
        landscapes[2] = new WaterLandscape();
        landscapes[3] = new AcidPool();
        landscapes[4] = new Fog();
        landscapes[5] = new Tavern();
        landscapes[6] = new Trap();
    }

    /// сеттер для координаты базы
    public void SetBaseCoords(Coordinates baseCoord)
    {
        this.baseCoord = baseCoord;
    }

    /// конструктор копирования поля
    public GameField(GameField gameField){
        this.width = gameField.width;
        this.height = gameField.height;
        this.numberOfUnits = gameField.numberOfUnits;
        this.listOfUnits = gameField.listOfUnits;
        this.field = gameField.field;
        this.baseCoord = gameField.baseCoord;
        this.landscapes = gameField.landscapes;
    }

    /// проверка возможности добавления нового юнита в зависимости от их текущего количества и размера самого поля
    private boolean checkNumberOfUnits() {
        return numberOfUnits <= ((height * width) / 2);
    }

    /// проверка, попадают ли переданные координаты в созданное поле, если координаты не попадают в поле - возвращает false
    private boolean checkRowColumn(int column, int row) {
        return column < width && row < height;
    }

    /// функция для отрисовки поля в консоли
    public void drawField() {

        String objImage;
        int randomIndex;

        System.out.println("start creating field\n");
        for(int i=0; i<height; i++ ) {
            for(int j=0; j<width; j++) {

                if (j == width-1) {
                    field += "X\n";
                } else if (i == 0 || j == 0 || i == height-1) {
                    field += "X ";
                } else {
                    randomIndex = (int) (Math.random() * 7);
                    objImage = landscapes[randomIndex].getPicture();
                    field += objImage + " ";
                }
            }
        }

        System.out.println("count of symbols of field: " + field.length());
        System.out.print(field);

    }

    /// вывод в консоли списка юнитов с координатами
    private boolean showListOfUnits() {

        System.out.println("List of units");
        if (listOfUnits.size() == 0) {
            System.out.println("List of units is empty");
            return false;
        } else {
            for (int i = 0; i < listOfUnits.size(); i++) {
                System.out.println((i + 1) + " - " + listOfUnits.get(i).getName() + " - row: " + listOfUnits.get(i).getCoordinates().row + " - col " + listOfUnits.get(i).getCoordinates().col);
            }
            return true;
        }
    }

    /// функция для перемещения переданного юнита
    private void moveUnit(BaseUnit unit, int indexToMove, int newIndex) {

        char[] chars = field.toCharArray();
        
        switch (chars[newIndex]) {
        
		case '~':
			 System.out.println("Oops, new your location is water, unit has drowned");
	         chars[indexToMove] = '*';
	         field = new String(chars);
	         deleteUnit(unit);
			break;
		case '^':
            System.out.println("Your new location is Mountain, unit can't climb the mountain");
            System.out.println("Field stay without changes");
			break;
		case 'P':
			Context contAcid = new Context(new AcidPool());
			contAcid.ExecuteStrategy(unit);
			break;
		case 'F':
			Context contFog = new Context(new Fog());
			contFog.ExecuteStrategy(unit);
			break;
		case 'T':
			Context contTavern = new Context(new Tavern());
			contTavern.ExecuteStrategy(unit);
			break;
		case 'v':
			Context contTrap = new Context(new Trap());
			contTrap.ExecuteStrategy(unit);
			break;

		default:
			chars[indexToMove] = '*';
            chars[newIndex] = unit.getPicture().charAt(0);
            field = new String(chars);
            System.out.println("field after move:");
		}

        cls();
        System.out.println(field);
    }

    /**
     * /brief функция добавления юнита на поле
     * @param unit - юнит
     */
    public boolean addUnit(BaseUnit unit) {

        System.out.println("input row and column for unit");
        int col = CheckInputService.inputInteger(width - 2, "Width input out of field");
        int row = CheckInputService.inputInteger(height - 2, "Height input out of field");

        if (baseCoord.col == col && baseCoord.row == row) {
            System.out.println("Base already exists at these coordinates. Can't add a new unit\n");
            return false;
        }

        for (BaseUnit curr : listOfUnits) {
            Coordinates currCoord = curr.getCoordinates();
            if (currCoord.row == row && currCoord.col == col) {
                System.out.println("Unit already exists at these coordinates. Can't add a new unit\n");
                return false;
            }
        }

        boolean checkRowColumn = checkRowColumn(col, row);
        final boolean checkNumberOfUnits = checkNumberOfUnits();

        if (checkNumberOfUnits && checkRowColumn) {

            Coordinates unitCoordinates = new Coordinates(row, col);
            int index = ((width * 2 - 1) * unitCoordinates.row) + ((unitCoordinates.col * 2) + unitCoordinates.row);
            char[] chars = field.toCharArray();

            if (chars[index] == landscapes[1].getPicture().toCharArray()[0] || chars[index] == landscapes[2].getPicture().toCharArray()[0]) {
                System.out.println("You tried to place unit on unreal landscape");
                return false;
            }
            chars[index] = unit.getPicture().charAt(0);
            field = new String(chars);
            unit.setCoordinates(unitCoordinates);
            listOfUnits.add(unit);

            System.out.println("field after adding:");
            System.out.println(field);
            return true;
        } else {
            System.out.println("Number of units > then can be or your row and col are incorrect");
            return false;
        }
    }

    /**
     * /brief функция добавления базы на поле
     * @param base - база
     */
    public Coordinates addBase(Base base) {

        System.out.println("input row and column for base");
        int col = CheckInputService.inputInteger(width - 2, "Width input out of field");
        int row = CheckInputService.inputInteger(height - 2, "Height input out of field");

            Coordinates unitCoordinates = new Coordinates(row, col);
            base.setCoordinates(unitCoordinates);

            int index = ((width * 2 - 1) * unitCoordinates.row) + ((unitCoordinates.col * 2) + unitCoordinates.row);

            char[] chars = field.toCharArray();
            chars[index] = base.getPicture().charAt(0);
            field = new String(chars);

            System.out.println("field after adding:");
            System.out.println(field);
            return unitCoordinates;
    }

    /**
     * /brief функция удаления юнита
     */
    public void deleteUnit() {

        if (showListOfUnits()) {

            System.out.println("chose what unit you wanna delete (input number)");

            int choice = CheckInputService.inputInteger(listOfUnits.size(), "Incorrect input of unit");

            int col = listOfUnits.get(choice - 1).getCoordinates().col;
            int row = listOfUnits.get(choice - 1).getCoordinates().row;

            int indexToDelete = ((width * 2 - 1) * row) + ((col * 2) + row);

            char[] chars = field.toCharArray();
            chars[indexToDelete] = ' ';
            field = new String(chars);

            cls();
            System.out.println("field after delete:");
            System.out.println(field);

            listOfUnits.remove(choice - 1);
        }
    }

    /**
     * /brief удаление переданного в функцию юнита с поля и из списка юнитов
     * @param unit - юнит
     */
    public void deleteUnit(BaseUnit unit) {
        int col = unit.getCoordinates().col;
        int row = unit.getCoordinates().col;

        int indexToDelete = ((width * 2 - 1) * row) + ((col * 2) + row);

        char[] chars = field.toCharArray();
        chars[indexToDelete] = ' ';
        field = new String(chars);

        cls();
        System.out.println("field after delete:");
        System.out.println(field);

        listOfUnits.remove(listOfUnits.indexOf(unit));
    }

    /**
     * /brief функция для перемещения юнита. Выбор юнита для пемещения происходит внутри функции
     */
    public void moveUnit() {

        if (showListOfUnits()) {
            System.out.println("chose unit to move (input number)");

            int choice = CheckInputService.inputInteger(listOfUnits.size(), "Incorrect input of unit");

            BaseUnit unit = listOfUnits.get(choice - 1);
            int col = listOfUnits.get(choice - 1).getCoordinates().col;
            int row = listOfUnits.get(choice - 1).getCoordinates().row;
            int indexToMove = ((width * 2 - 1) * row) + ((col * 2) + row);

            System.out.println("chose direction to move:\n1 - up\n2 - down\n3 - left\n4 - right");

            int direction = CheckInputService.inputInteger(4, "Incorrect input of direction");

            int newIndex;
            switch (direction) {
                case 1 -> {
                    newIndex = indexToMove - ((width * 2) * unit.getLongOfMove());
                    if (newIndex < width) {
                        System.out.println("new unit position is out of field");
                    } else {
                        moveUnit(unit, indexToMove, newIndex);
                        listOfUnits.get(choice - 1).changeLocation(DirectionsOfMove.UP);
                    }
                }
                case 2 -> {
                    newIndex = indexToMove + ((width * 2) * unit.getLongOfMove());
                    System.out.println("Index to move - " + indexToMove + ", newIndex = " + newIndex);
                    if (newIndex > field.length() - width) {
                        System.out.println("new unit position is out of field");
                    } else {
                        moveUnit(unit, indexToMove, newIndex);
                        listOfUnits.get(choice - 1).changeLocation(DirectionsOfMove.DOWN);
                    }
                }
                case 3 -> {
                    newIndex = indexToMove - unit.getLongOfMove() * 2;
                    System.out.println("Index to move - " + indexToMove + ", newIndex = " + newIndex);
                    if (newIndex / (width + 1) == 1) {
                        System.out.println("new unit position is out of field");
                    } else {
                        moveUnit(unit, indexToMove, newIndex);
                        listOfUnits.get(choice - 1).changeLocation(DirectionsOfMove.LEFT);
                    }
                }
                case 4 -> {
                    newIndex = indexToMove + unit.getLongOfMove() * 2;
                    System.out.println("Index to move - " + indexToMove + ", newIndex = " + newIndex);
                    if (newIndex / width == 1) {
                        System.out.println("new unit position is out of field");
                    } else {
                        moveUnit(unit, indexToMove, newIndex);
                        listOfUnits.get(choice - 1).changeLocation(DirectionsOfMove.RIGHT);
                    }
                }
                default -> System.out.println("Input error");
            }
        }
    }

    /**
     * /brief костыль для очищения консоли
     */
    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }
}