package units.archers;

import units.BaseUnit;

/**
 * 	\brief Базовый класс для лучников, от него наследуются конкретные типы лучников
 * 	\version 1.0
 * 	\date Ноябрь 2022
 *
 * 	Базовый класс для лучников, от него наследуются конкретные типы лучников
 *
 */

public class Archer extends BaseUnit {

    final private int maxLongOfAttack = 5;

    public Archer() {

        this.longOfMove = 2;
    }

}
