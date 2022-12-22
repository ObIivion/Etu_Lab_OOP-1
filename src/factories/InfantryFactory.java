package factories;

import units.infantry.Infantry;
import units.infantry.SpearMan;
import units.infantry.SwordsMan;

/*
 * \brief фабрика лучников
 * \version 1.0
 * \date ноябрь 2022
 * 
 * Класс-фабрика. отвечающий за создание юнита-пехоты.
 * 
 * 
 */

public class InfantryFactory {

    public enum InfantryTypes{
        swordsMan,
        spearMan
    } ///< Виды пехоты

    ///создание пехоты
    public Infantry createUnit(InfantryTypes infantryType) {
        switch (infantryType) {
            case swordsMan:
                return new SwordsMan();
            case spearMan:
                return new SpearMan();
        }
        return null;
    }

}
