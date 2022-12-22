package units.NeutralObjects;

import units.BaseUnit;

/*
 * \brief контекст нейтральных объектов
 * \version 1.0
 * \date ноябрь 2022
 * 
 * Класс-контекст. отвечающий за взаимодействие нейтральных объектов с юнитами: 
 * позволяет выбрать нужную стратегию для определенного юнита и нейтрального объекта.
 * 
 * 
 */

public class Context {
	private NeutralObject strategy;
	
	///конструктор контекста, инициализирует стратегию
	public Context(NeutralObject str)
	{
		this.strategy = str;
	}
	
	///изменение стратегии на новую
	public void setStrategy(NeutralObject str )
	{
		this.strategy = null;
		this.strategy = str;
	}
	///выполнение выбранной стратегии
	public void ExecuteStrategy(BaseUnit interactable)
	{
		this.strategy.UnitInteract(interactable);
	}
}
