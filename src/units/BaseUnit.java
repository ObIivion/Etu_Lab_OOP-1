package units;

import supportingFiles.Coordinates;
import supportingFiles.DirectionsOfMove;


/**
 * 	\brief Базовый класс для всех юнитов
 * 	\version 1.0
 * 	\date Ноябрь 2022
 *
 * 	Класс почти не несёт в себе смысловой нагрузки, создан для того, чтобы от него наследовались все юниты на игровом поле
 *
 */


public class BaseUnit  extends FieldObject{

    protected int armour; ///< Число, обозначающее броню юнита
    protected int attack; ///< Число, обозначающее атаку юнита
    protected int health; ///< Число, обозначающее здоровье юнита
    protected int longOfMove; ///< Число, обозначающее количество клеток, на которое пермещается юнит за 1 ход
    protected int maxLongOfAttack; ///< Число, обозначающее максимальное число клеток, на которое может атаковать юнит юнита

    /// геттер назваиня юнита
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

    /**
     * /brief функция, которая меняет собстенные координаты юнита в соответствии с выбранным направлением
     * @param direction - параметр направления перемещения юнита
     */
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