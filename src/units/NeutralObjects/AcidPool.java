package units.NeutralObjects;
import units.BaseUnit;

public class AcidPool extends NeutralObject {
	public AcidPool() {
			this.value = 2;
			this.picture = "P";
	}
	public int UnitInteract(BaseUnit interactable) {
		System.out.println("Unit stepped on acid, armour decreased by " + value +"\n");
		int unitArmour = interactable.getArmour();
		return unitArmour - value;	
	}

}
