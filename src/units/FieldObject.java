package units;

import supportingFiles.Coordinates;

/**
 * 	\brief Базовый класс для всех объектов на поле (включая ландшафт, базу и юнитов)
 * 	\version 1.0
 * 	\date Ноябрь 2022
 *
 * 	Класс почти не несёт в себе смысловой нагрузки, создан для того, чтобы от него наследовались все объекты на игровом поле
 */

public class FieldObject {
    protected Coordinates coordinates; ///< Координаты объекта на поле
    protected String name; ///< имя объекта на поле
    protected String picture; ///< символ объекта на поле

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    public Coordinates getCoordinates() { return coordinates; }

    public void setCoordinates(Coordinates coordinates) {

        if (coordinates.col < 0 || coordinates.row < 0) {
            System.out.println("Длина или ширина меньше нуля, невозможно обновить значения");
        } else {
            Coordinates newCoordinates = new Coordinates(coordinates.row, coordinates.col);
            this.coordinates = newCoordinates;
        }

    }
}