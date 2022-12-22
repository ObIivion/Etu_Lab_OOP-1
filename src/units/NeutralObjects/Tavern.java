package units.NeutralObjects;
import units.BaseUnit;

/*
 * \brief таверна
 * \version 1.0
 * \date ноябрь 2022
 * 
 * Класс. представляющий тавернк: при попадании юнита на клетку с таверной, он восстанавливает здоровье.
 * 
 * 
 */

public class Tavern extends NeutralObject{
	public Tavern()
	{
		this.value = 3;
		this.picture = "T";
	}
	
	///взаимодействие объекта с объектом - увеличение здоровья на value
	public int UnitInteract(BaseUnit interactable){
		System.out.println("Unit stepped into tavern, HP increased by " + value +"\n");
		int unitHP = interactable.getHealth();
		interactable.setHealth(unitHP + value);
		System.out.println("Your HP is now " + interactable.getHealth() +"\n");
		return unitHP + value;	
	}

}
