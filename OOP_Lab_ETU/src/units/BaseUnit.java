package units;

import supportingFiles.Coordinates;
import supportingFiles.DirectionsOfMove;

public class BaseUnit {

    protected String name;
    protected String picture;
    protected int armour;
    protected int attack;
    protected int health;
    protected int longOfMove;
    protected int maxLongOfAttack;
    protected Coordinates coordinates;

    public String getName() {
        return name;
    }

    public int getArmour() {
        return armour;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public String getPicture() {
        return picture;
    }

    public int getLongOfMove() {
        return longOfMove;
    }

    public int getMaxLongOfAttack() {
        return maxLongOfAttack;
    }

    public Coordinates getCoordinates() { return coordinates; }

    public void changeLocation(DirectionsOfMove direction) {
        switch (direction) {
            case UP:
                this.coordinates.row -= longOfMove;
                break;
            case DOWN:
                this.coordinates.row += longOfMove;
                break;
            case LEFT:
                this.coordinates.col -= longOfMove;
                break;
            case RIGHT:
                this.coordinates.col += longOfMove;
                break;

        }
    }

    public void setCoordinates(Coordinates coordinates) {

        if (coordinates.col < 0 || coordinates.row < 0) {
            System.out.println("Длина или ширина меньше нуля, невозможно обновить значения");
        } else {
            Coordinates newCoordinates = new Coordinates(coordinates.row, coordinates.col);
            this.coordinates = newCoordinates;
        }
    }
}
