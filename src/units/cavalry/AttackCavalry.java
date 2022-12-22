package units.cavalry;

/**
 * 	\brief Класс атакующей кавалерим, отличается повышенной бронём и здоровьем
 * 	\version 1.0
 * 	\date Ноябрь 2022
 *
 * 	Класс атакующей кавалерим, отличается повышенной бронём и здоровьем
 *
 */

public class AttackCavalry extends Cavalry {

    public AttackCavalry() {
        this.name = "AttackCavalry";
        this.armour = 14;
        this.health = 36;
        this.attack = 4;
        this.picture = "с";
    }

}
