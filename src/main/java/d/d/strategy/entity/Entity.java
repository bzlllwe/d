package d.d.strategy.entity;

import d.d.strategy.strategyA.StrategyA;

public abstract class Entity {

	private StrategyA strategyA;

	public StrategyA getStrategyA() {
		return strategyA;
	}

	public void setStrategyA(StrategyA strategyA) {
		this.strategyA = strategyA;
	}

	public void A(){
		strategyA.A();
	}

	public void B(){};
	public void C(){};

}
