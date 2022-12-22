package units.cavalry;

/**
 * 	\brief Класс стреляющей кавалерим, отличается повышенной атакой
 * 	\version 1.0
 * 	\date Ноябрь 2022
 *
 * 	Класс стреляющей кавалерим, отличается повышенной атакой
 *
 */
public class ShootCavalry extends Cavalry {

    public ShootCavalry() {

        this.name = "ShootCavalry";
        this.armour = 6;
        this.health = 30;
        this.attack = 10;
        this.picture = "С";
    }

}
