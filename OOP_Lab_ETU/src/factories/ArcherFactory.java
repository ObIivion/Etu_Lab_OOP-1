package factories;

import units.archers.Archer;
import units.archers.LongArcher;
import units.archers.ShortArcher;

public class ArcherFactory {

    public enum ArcherTypes{
        longArcher,
        shortArcher
    }

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
