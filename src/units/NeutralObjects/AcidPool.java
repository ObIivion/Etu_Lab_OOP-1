package units.NeutralObjects;
import units.BaseUnit;

/*
 * \brief кислота
 * \version 1.0
 * \date ноябрь 2022
 * 
 * Класс. представляющий кислотную лужу: при попадании юнита на клетку с кислотой, он теряет броню.
 * 
 * 
 */

public class AcidPool extends NeutralObject {
	public AcidPool() {
			this.value = 2;
			this.picture = "P";
	}
	
	/// взаимодействие юнита с объектом - теряет value от его брони
	public int UnitInteract(BaseUnit interactable) {
		System.out.println("Unit stepped on acid, armour decreased by " + value +"\n");
		int unitArmour = interactable.getArmour();
		interactable.setArmour(unitArmour - value);
		System.out.println("Your armour is now " + interactable.getArmour() +"\n");
		return unitArmour - value;	
	}

}
