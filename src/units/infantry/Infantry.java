package units.infantry;

import units.BaseUnit;

/**
 * 	\brief Базовый класс для пехотинцев, от него наследуются конкретные типы пехотинцев
 * 	\version 1.0
 * 	\date Ноябрь 2022
 *
 * 	Базовый класс для пехотинцев, от него наследуются конкретные типы пехотинцев
 *
 */

public class Infantry extends BaseUnit {

    final private int maxLongOfAttack = 5;

    public Infantry(){
        this.longOfMove = 1;
    }

}
