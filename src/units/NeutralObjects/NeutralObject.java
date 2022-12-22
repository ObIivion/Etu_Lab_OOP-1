package units.NeutralObjects;

import units.BaseUnit;
import units.FieldObject;

/*
 * \brief нейтральный объект
 * \version 1.0
 * \date ноябрь 2022
 * 
 * Класс. представляющий нейтральный объект: является родителем остальных нейтральных объектов.
 * 
 * 
 */

public class NeutralObject extends FieldObject {
	protected int value; ///< определенное значение на которое изменяется одна из хар-к юнита при взаимодействии с нейтральным объектом
	protected int UnitInteract(BaseUnit interactable) {return 0;}

}
