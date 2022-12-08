package factories;

import units.cavalry.AttackCavalry;
import units.cavalry.Cavalry;
import units.cavalry.ShootCavalry;

public class CavalryFactory {

    public enum CavalryTypes{
        shootCavalry,
        attackCavalry
    }

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
