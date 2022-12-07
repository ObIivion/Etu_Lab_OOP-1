package factories;

import units.infantry.Infantry;
import units.infantry.SpearMan;
import units.infantry.SwordsMan;

public class InfantryFactory {

    public enum InfantryTypes{
        swordsMan,
        spearMan
    }

    public Infantry createUnit(InfantryTypes infantryType) {
        switch (infantryType) {
            case swordsMan:
                return new SwordsMan();
            case spearMan:
                return new SpearMan();
        }
        return null;
    }

}
