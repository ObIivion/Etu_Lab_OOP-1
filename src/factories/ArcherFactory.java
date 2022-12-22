package factories;

import units.archers.Archer;
import units.archers.LongArcher;
import units.archers.ShortArcher;

/*
 * \brief фабрика лучников
 * \version 1.0
 * \date ноябрь 2022
 * 
 * Класс-фабрика. отвечающий за создание юнита-лучника.
 * 
 * 
 */
public class ArcherFactory {

    public enum ArcherTypes{
        longArcher,
        shortArcher
    } ///< Виды лучников

    /// создание юнита
    public Archer createUnit(ArcherTypes archerType) {
        switch (archerType) {
            case longArcher:
                return new LongArcher();
            case shortArcher:
                return new ShortArcher();
        }
        return null;
    }
}
