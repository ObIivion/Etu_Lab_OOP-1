package units.NeutralObjects;

import units.BaseUnit;

public class Context {
	private NeutralObject strategy;
	public Context(NeutralObject str)
	{
		this.strategy = str;
	}
	public void setStrategy(NeutralObject str )
	{
		this.strategy = null;
		this.strategy = str;
	}
	public void ExecuteStrategy(BaseUnit interactable)
	{
		this.strategy.UnitInteract(interactable);
	}
}
