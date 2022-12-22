package units.LandscapeObjects;
import units.FieldObject;

/*
 * \brief ландшафт - поле
 * \version 1.0
 * \date ноябрь 2022
 * 
 * Класс. представляющий поле карты
 * 
 * 
 * 
 */

public class FieldLandscape extends FieldObject {

	///конструктор, задает имя и символ поля
    public FieldLandscape(){
        this.name = "grass field";
        this.picture = /*ConsoleColors.GREEN + */ "*" /* + ConsoleColors.RESET */;
    }
}
