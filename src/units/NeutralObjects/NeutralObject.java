package units.NeutralObjects;

import units.BaseUnit;
import units.FieldObject;


public class NeutralObject extends FieldObject {
	protected int value;
	protected int UnitInteract(BaseUnit interactable) {return 0;}

}
