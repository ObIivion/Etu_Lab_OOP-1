package units.LandscapeObjects;

import units.FieldObject;

/**
 * \brief ландшафт - гора
 * \version 1.0
 * \date ноябрь 2022
 * 
 * Класс. представляющий гору на карте. юниты не могут проходить через гору, нельзя ставить юнитов на гору
 */

public class MountainLandscape extends FieldObject {

	///конструктор, задает имя и символ поля
    public MountainLandscape() {
        this.name = "Mountain";
        this.picture = /*ConsoleColors.WHITE + */"^" /* + ConsoleColors.RESET*/;
    }

}
