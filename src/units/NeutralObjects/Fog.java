package units.NeutralObjects;
import units.BaseUnit;

public class Fog extends NeutralObject{
	public Fog()
	{
		this.value = 2;
		this.picture = "F";
	}
	public int UnitInteract(BaseUnit interactable) {
		System.out.println("Unit stepped into fog, visibility decreased by " + value +"\n");
		int unitLoM = interactable.getLongOfMove();
		return unitLoM - value;	
	}

}
