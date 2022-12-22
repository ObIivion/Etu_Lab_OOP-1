package units.NeutralObjects;

import units.BaseUnit;

/**
 * \brief контекст нейтральных объектов
 * \version 1.0
 * \date ноябрь 2022
 * 
 * Класс-контекст. отвечающий за взаимодействие нейтральных объектов с юнитами: 
 * позволяет выбрать нужную стратегию для определенного юнита и нейтрального объекта.
 */

public class Context {
	private NeutralObject strategy;
	
    /**
    * /brief конструктор контекста, инициализирует стратегию.
    * @param str - стратегия
    */
	public Context(NeutralObject str)
	{
		this.strategy = str;
	}
	
    /**
    * /brief изменение стратегии на новую.
    * @param str - стратегия
    */
	public void setStrategy(NeutralObject str )
	{
		this.strategy = null;
		this.strategy = str;
	}

    /**
    * /brief выполнение выбранной стратегии.
    * @param interactable - информация о юните, попавшем на поле
    */
	public void ExecuteStrategy(BaseUnit interactable)
	{
		this.strategy.UnitInteract(interactable);
	}
}
