package units.LandscapeObjects;

import units.FieldObject;

/*
 * \brief ландшафт - вода
 * \version 1.0
 * \date ноябрь 2022
 * 
 * Класс. представляющий воду на  карте. Нельзя ставить юнитоа на воду. Юниты, проходящие через воду тонут.
 * 
 * 
 * 
 */

public class WaterLandscape extends FieldObject {

	///конструктор, задает имя и символ поля
    public WaterLandscape() {
        this.name = "water";
        this.picture = /*ConsoleColors.PURPLE +  */"~"/* + ConsoleColors.RESET*/;
    }
}

