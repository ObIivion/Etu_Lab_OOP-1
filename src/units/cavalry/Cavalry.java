package units.cavalry;

import units.BaseUnit;

/**
 * 	\brief Базовый класс для кавалерии, от него наследуются конкретные типы кавалерии
 * 	\version 1.0
 * 	\date Ноябрь 2022
 *
 * 	Базовый класс для кавалерии, от него наследуются конкретные типы кавалерии. Отличается увеличенной длиной перемещения за 1 ход
 *
 */

public class Cavalry extends BaseUnit {

    Cavalry() {
        this.longOfMove = 4;
    }

}
