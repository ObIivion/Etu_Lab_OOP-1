package units;

import factories.ArcherFactory;
import factories.CavalryFactory;
import factories.InfantryFactory;
import supportingFiles.CheckInputService;
import game.GameField;
import supportingFiles.Coordinates;

public class Base extends FieldObject {
    protected int HP;
    protected int maxUnit=7;
    protected int unitsBuilt = 0;

    public Base(GameField gameField){
        this.picture = "B";
        Coordinates coord = gameField.addBase(this);
        gameField.SetBaseCoords(coord);
        HP = 10;
    }

    public int createUnit(GameField gameField){
        if(unitsBuilt >= maxUnit) {
            System.out.println("Max amount of units\n");
            return unitsBuilt;
        }
        InfantryFactory infantryFactory = new InfantryFactory();
        ArcherFactory archerFactory = new ArcherFactory();
        CavalryFactory cavalryFactory = new CavalryFactory();

        System.out.println("Chose type of unit:");
        System.out.println("1 - Infantry\n2 - Archer\n3 - Cavalry");
        int subChoice = CheckInputService.inputInteger(4, "Your input is out of range (1 - 3)");
        switch (subChoice) {
            case 1:
                System.out.println("Input type of Infantry");
                System.out.println("1 - SwordsMan\n2 - SpearMan");
                int typeChoice = CheckInputService.inputInteger(2, "Your input is out of range (1 - 2)");
                switch (typeChoice) {
                    case 1 -> {
                        final boolean successAdd = gameField.addUnit(infantryFactory.createUnit(InfantryFactory.InfantryTypes.swordsMan));
                        if (successAdd) {
                            this.unitsBuilt++;
                        }
                    }
                    case 2 -> {
                        gameField.addUnit(infantryFactory.createUnit(InfantryFactory.InfantryTypes.spearMan));
                        this.unitsBuilt++;
                    }
                    default -> System.out.println("Error of typeChoice");
                }
                break;
            case 2:
                System.out.println("Input type of Archer");
                System.out.println("1 - LongArcher\n2 - ShortArcher");
                typeChoice = CheckInputService.inputInteger(2, "Your input is out of range (1 - 2)");
                switch (typeChoice) {
                    case 1 -> {
                        gameField.addUnit(archerFactory.createUnit(ArcherFactory.ArcherTypes.longArcher));
                        this.unitsBuilt++;
                    }
                    case 2 -> {
                        gameField.addUnit(archerFactory.createUnit(ArcherFactory.ArcherTypes.shortArcher));
                        this.unitsBuilt++;
                    }
                    default -> System.out.println("Error of typeChoice");
                }
                break;
            case 3:
                System.out.println("Input type of Cavalry");
                System.out.println("1 - ShootCavalry\n2 - AttackCavalry");
                typeChoice = CheckInputService.inputInteger(2, "Your input is out of range (1 - 2)");
                switch (typeChoice) {
                    case 1 -> {
                        gameField.addUnit(cavalryFactory.createUnit(CavalryFactory.CavalryTypes.shootCavalry));
                        this.unitsBuilt++;
                    }
                    case 2 -> {
                        gameField.addUnit(cavalryFactory.createUnit(CavalryFactory.CavalryTypes.attackCavalry));
                        this.unitsBuilt++;
                    }
                    default -> System.out.println("Error of typeChoice");
                }
            default:
                System.out.println("Error of typeChoice");
        }
        return unitsBuilt;

    }

    public int removeUnit(GameField gameField) {
        gameField.deleteUnit();
        this.unitsBuilt--;
        return unitsBuilt;
    }
}