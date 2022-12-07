package game;
import supportingFiles.CheckInputService;
import supportingFiles.Coordinates;
import supportingFiles.DirectionsOfMove;
import units.BaseUnit;
import units.Base;
import units.FieldObject;
import java.util.ArrayList;

public class GameField {
    private int width;
    private int height;
    private int numberOfUnits = 0;
    private Coordinates baseCoord;
    private ArrayList<BaseUnit> listOfUnits = new ArrayList<BaseUnit>();
    

    private String field = "";

    public GameField(int height, int width) {
        this.height = height;
        this.width = width;
    }
    
    public int GetWidth() {
    	return width;
    }
    
    public int GetHeight() {
    	return height;
    }
    
    public void SetBaseCoords(Coordinates baseCoord)
    {
    	this.baseCoord = baseCoord;
    }
    
    // конструктор копирования..
    public GameField(GameField gameField){
    this.width = gameField.width;
    this.height = gameField.height;
    this.numberOfUnits = gameField.numberOfUnits;
    this.listOfUnits = gameField.listOfUnits;
    this.field = gameField.field;
    }

    private boolean checkNumberOfUnits() {
        return numberOfUnits > ((height * width) / 2) ? false : true;
    }

    private boolean checkRowColumn(int column, int row) {
        return column >= width || row >= height ? false : true;
    }

    public void drawField() {

        System.out.println("start creating field\n");
        for(int i=0; i<height; i++ ) {
            for(int j=0; j<width; j++) {

                if (j == width-1) {
                    field += "X\n";
                } else if (i == 0 || j == 0 || i == height-1) {
                    field += "X ";
                } else {
                    field += "  ";
                }
            }
        }

        System.out.println("count of symbols of field: " + field.length());
        System.out.print(field);

    }

    private void showListOfUnits() {

        System.out.println("List of units");
        for (int i=0; i<listOfUnits.size(); i++) {
            System.out.println((i + 1) + " - " + listOfUnits.get(i).getName() + " - row: " + listOfUnits.get(i).getCoordinates().row + " - col " + listOfUnits.get(i).getCoordinates().col);
        }
    }

    private void moveUnit(BaseUnit unit, int indexToMove, int newIndex) {

        char[] chars = field.toCharArray();
        chars[indexToMove] = ' ';
        chars[newIndex] = unit.getPicture().charAt(0);
        String modifiedString = new String(chars);
        this.field = modifiedString;

        cls();
        System.out.println("field after move:");
        System.out.println(field);
    }

    public void addUnit(BaseUnit unit) {

        System.out.println("input row and column for unit");
        int col = CheckInputService.inputInteger(width - 2, "Width input out of field");
        int row = CheckInputService.inputInteger(height - 2, "Height input out of field");
        if(baseCoord.col == col && baseCoord.row == row)
        {
        	System.out.println("Base already exists at these coordinates. Can't add a new unit\n");
        	return;
        }
        for (int i=0;i<listOfUnits.size(); i++)
        {
        	BaseUnit curr = listOfUnits.get(i);
        	Coordinates currCoord = curr.getCoordinates();
        	if(currCoord.row == row && currCoord.col == col)
        	{
        		System.out.println("Unit already exists at these coordinates. Can't add a new unit\n");
        		return;
        	}
        }
        

        boolean checkRowColumn = checkRowColumn(col, row);
        final boolean checkNumberOfUnits = checkNumberOfUnits();

        if (checkNumberOfUnits && checkRowColumn) {

            Coordinates unitCoordinates = new Coordinates(row, col);
            unit.setCoordinates(unitCoordinates);
            listOfUnits.add(unit);

            int index = ((width * 2 - 1) * unitCoordinates.row) + ((unitCoordinates.col * 2) + unitCoordinates.row);

            char[] chars = field.toCharArray();
            chars[index] = unit.getPicture().charAt(0);
            String modifiedString =  new String(chars);
            field = modifiedString;

            //cls();
            System.out.println("field after adding:");
            System.out.println(field);
        } else {
            System.out.println("Number of units > then can be or your row and col are incorrect");
        }
    }
    
    public Coordinates addBase(Base unit) {

        System.out.println("input row and column for base");
        int col = CheckInputService.inputInteger(width - 2, "Width input out of field");
        int row = CheckInputService.inputInteger(height - 2, "Height input out of field");

        boolean checkRowColumn = checkRowColumn(col, row);
        final boolean checkNumberOfUnits = checkNumberOfUnits();

        if (checkNumberOfUnits && checkRowColumn) {

            Coordinates unitCoordinates = new Coordinates(row, col);
            unit.setCoordinates(unitCoordinates);

            int index = ((width * 2 - 1) * unitCoordinates.row) + ((unitCoordinates.col * 2) + unitCoordinates.row);

            char[] chars = field.toCharArray();
            chars[index] = unit.getPicture().charAt(0);
            String modifiedString =  new String(chars);
            field = modifiedString;

            //cls();
            System.out.println("field after adding:");
            System.out.println(field);
            return unitCoordinates;
        } else {
            System.out.println("Number of units > then can be or your row and col are incorrect");
            return null;
        }
        
    }

    public void deleteUnit() {

        showListOfUnits();
        System.out.println("chose what unit you wanna delete (input number)");


        int choice = CheckInputService.inputInteger(listOfUnits.size(), "Incorrect input of unit");

        int col = listOfUnits.get(choice - 1).getCoordinates().col;
        int row = listOfUnits.get(choice - 1).getCoordinates().row;

        int indexToDelete = ((width * 2 - 1) * row) + ((col * 2) + row);

        char[] chars = field.toCharArray();
        chars[indexToDelete] = ' ';
        String modifiedString = new String(chars);
        this.field = modifiedString;

        cls();
        System.out.println("field after delete:");
        System.out.println(field);

        listOfUnits.remove(choice - 1);
    }

    public void moveUnit() {

        showListOfUnits();
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
            case 1:
                newIndex = indexToMove - ((width * 2) * unit.getLongOfMove());
                if (newIndex < width) {
                    System.out.println("new unit position is out of field");
                } else {
                    moveUnit(unit, indexToMove, newIndex);
                    listOfUnits.get(choice - 1).changeLocation(DirectionsOfMove.UP);
                }
                break;

            case 2:
                newIndex = indexToMove + ((width * 2) * unit.getLongOfMove());
                System.out.println("Index to move - " + indexToMove + ", newIndex = " + newIndex);
                if (newIndex > field.length() - width) {
                    System.out.println("new unit position is out of field");
                } else {
                    moveUnit(unit, indexToMove, newIndex);
                    listOfUnits.get(choice - 1).changeLocation(DirectionsOfMove.DOWN);
                }
                break;

            case 3:
                newIndex = indexToMove - unit.getLongOfMove() * 2;
                System.out.println("Index to move - " + indexToMove + ", newIndex = " + newIndex);
                if (newIndex / (width + 1) == 1) {
                    System.out.println("new unit position is out of field");
                } else {
                    moveUnit(unit, indexToMove, newIndex);
                    listOfUnits.get(choice - 1).changeLocation(DirectionsOfMove.LEFT);
                }
                break;

            case 4:
                newIndex = indexToMove + unit.getLongOfMove() * 2;
                System.out.println("Index to move - " + indexToMove + ", newIndex = " + newIndex);
                if (newIndex / width == 1) {
                    System.out.println("new unit position is out of field");
                } else {
                    moveUnit(unit, indexToMove, newIndex);
                    listOfUnits.get(choice - 1).changeLocation(DirectionsOfMove.RIGHT);
                }
                break;
            default:
                System.out.println("Input error");
                break;
        }
    }

    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }
    

}


