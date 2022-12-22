package units.archers;

/**
 * 	\brief Класс лучников с уменьшенной дальностью атаки, но увеличенной бронёй, здоровьем и атакой
 * 	\version 1.0
 * 	\date Ноябрь 2022
 *
 * 	Класс лучников с уменьшенной дальностью атаки, но увеличенной бронёй, здоровьем и атакой
 *
 */
public class ShortArcher extends Archer {

    public ShortArcher() {

        this.name = "ShortArcher";
        this.armour = 6;
        this.health = 16;
        this.attack = 7;
        this.picture = "а";
    }

}
