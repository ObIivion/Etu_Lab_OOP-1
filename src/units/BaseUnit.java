package units;

import supportingFiles.Coordinates;
import supportingFiles.DirectionsOfMove;

public class BaseUnit  extends FieldObject{

    protected int armour;
    protected int attack;
    protected int health;
    protected int longOfMove;
    protected int maxLongOfAttack;

    public String getName() {
        return name;
    }

    public int getArmour() {
        return armour;
    }
    
    public void setArmour(int armor) {
    	this.armour = armor;
    }

    public int getHealth() {
        return health;
    }
    
    public void setHealth(int hp) {
    	this.health = hp;
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
    
    public void setLongOfMove(int lom) {
    	this.longOfMove = lom;
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