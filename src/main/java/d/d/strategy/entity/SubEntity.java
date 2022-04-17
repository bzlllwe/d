package d.d.strategy.entity;

import d.d.strategy.strategyA.StrategyA;
import d.d.strategy.strategyA.StrategyAImpl1;

public class SubEntity extends Entity {
	public SubEntity(){
		setStrategyA(new StrategyAImpl1());
	}
}
