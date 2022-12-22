package factories;

import units.cavalry.AttackCavalry;
import units.cavalry.Cavalry;
import units.cavalry.ShootCavalry;

/*
 * \brief фабрика кавалерии
 * \version 1.0
 * \date ноябрь 2022
 * 
 * Класс-фабрика. отвечающий за создание юнита-кавалерии.
 * 
 * 
 */

public class CavalryFactory {

    public enum CavalryTypes{
        shootCavalry,
        attackCavalry
    } ///< Виды кавалерии

    /**
    * /brief создание кавалерии.
    * @param cavalryType - тип кавалерии
    */
    public Cavalry createUnit(CavalryTypes cavalryType) {
        switch (cavalryType) {
            case shootCavalry:
                return new ShootCavalry();
            case attackCavalry:
                return new AttackCavalry();
        }
        return null;
    }

}
