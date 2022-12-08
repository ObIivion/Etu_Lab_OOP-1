package units.NeutralObjects;
import units.BaseUnit;

public class Trap extends NeutralObject{
	public Trap()
	{
		this.value = 3;
		this.picture = "v";
	}
	public int UnitInteract(BaseUnit interactable){
		System.out.println("Unit stepped into trap, HP decreased by " + value +"\n");
		int unitHP = interactable.getHealth();
		return unitHP - value;	
	}
}
