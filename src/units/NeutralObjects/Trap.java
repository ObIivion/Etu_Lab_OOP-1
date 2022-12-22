package units.NeutralObjects;
import units.BaseUnit;

/**
 * \brief ловушка
 * \version 1.0
 * \date ноябрь 2022
 * 
 * Класс. представляющий ловушку: при попадании юнита на клетку с ловушкой, он теряет здоровье.
 */

public class Trap extends NeutralObject{
	/// конструктор, задает символ и value объектв
	public Trap()
	{
		this.value = 3;
		this.picture = "v";
	}
    /**
    * /brief взаимодействие юнита с объектом - уменьшение злоровья на value
    * @param interactable - информация о юните, попавшем на поле
    */
	public int UnitInteract(BaseUnit interactable){
		System.out.println("Unit stepped into trap, HP decreased by " + value +"\n");
		int unitHP = interactable.getHealth();
		interactable.setHealth(unitHP - value);
		System.out.println("Your HP is now " + interactable.getHealth() +"\n");
		return unitHP - value;	
	}
}
