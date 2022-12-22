package units.NeutralObjects;
import units.BaseUnit;

/*
 * \brief кислота
 * \version 1.0
 * \date ноябрь 2022
 * 
 * Класс. туман: при попадании юнита на клетку с туманом, он хуже видит и его скорость перемещения уменьшается.
 * 
 * 
 */

public class Fog extends NeutralObject{
	public Fog()
	{
		this.value = 2;
		this.picture = "F";
	}
	///взаимодействие юнита с объектом - теряет value от длины хода
	public int UnitInteract(BaseUnit interactable) {
		System.out.println("Unit stepped into fog, visibility decreased by " + value +"\n");
		int unitLoM = interactable.getLongOfMove();
		interactable.setLongOfMove(unitLoM - value);
		System.out.println("Your visibility is now " + interactable.getLongOfMove() +"\n");
		return unitLoM - value;	
	}

}
