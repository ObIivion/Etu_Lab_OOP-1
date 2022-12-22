package units.infantry;

/**
 * 	\brief Класс копейщиков с увеличенной бронёй и здоровьем, но уменьшенной  атакой
 * 	\version 1.0
 * 	\date Ноябрь 2022
 *
 * 	Класс копейщиков с увеличенной бронёй и здоровьем, но уменьшенной  атакой
 *
 */

public class SpearMan extends Infantry {

    public SpearMan(){
        this.name = "SpearMan";
        this.armour = 8;
        this.health = 26;
        this.attack = 12;
        this.picture = "K";
    }

}
