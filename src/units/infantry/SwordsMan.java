package units.infantry;


/**
 * 	\brief Класс мечников с увеличенной бронёй и здоровьем, но уменьшенной  атакой
 * 	\version 1.0
 * 	\date Ноябрь 2022
 *
 * 	Класс мечников с увеличенной бронёй и здоровьем, но уменьшенной  атакой
 *
 */
public class SwordsMan extends Infantry {

    public SwordsMan(){

        this.name = "SwordsMan";
        this.armour = 10;
        this.health = 30;
        this.attack = 8;
        this.picture = "M";
    }

}
