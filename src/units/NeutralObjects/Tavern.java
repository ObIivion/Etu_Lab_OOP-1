package units.NeutralObjects;
import units.BaseUnit;

public class Tavern extends NeutralObject{
	public Tavern()
	{
		this.value = 3;
		this.picture = "T";
	}
	public int UnitInteract(BaseUnit interactable){
		System.out.println("Unit stepped into tavern, HP increased by " + value +"\n");
		int unitHP = interactable.getHealth();
		interactable.setHealth(unitHP + value);
		System.out.println("Your HP is now " + interactable.getHealth() +"\n");
		return unitHP + value;	
	}

}
