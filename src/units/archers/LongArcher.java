package units.archers;


/**
 * 	\brief Класс лучников с увеличенной дальностью атаки, но уменьшенной бронёй, здоровьем и атакой
 * 	\version 1.0
 * 	\date Ноябрь 2022
 *
 * 	Класс лучников с увеличенной дальностью атаки, но уменьшенной бронёй, здоровьем и атакой
 *
 */

public class LongArcher extends Archer {

    public LongArcher() {

        this.name = "LongArcher";
        this.armour = 4;
        this.health = 14;
        this.attack = 5;
        this.picture = "A";
    }

}
