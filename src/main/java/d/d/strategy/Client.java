package d.d.strategy;

import d.d.strategy.entity.Entity;
import d.d.strategy.entity.SubEntity;
import d.d.strategy.strategyA.StrategyAImpl2;

/**
 * 策略模式，持有策略接口的对象，代替子类重写父类方法。聚合代替继承。
 */
public class Client {
	public static void main(String[] args) {
		Entity entity = new SubEntity();
		entity.A();

		//动态切换
		entity.setStrategyA(new StrategyAImpl2());
		entity.A();

		entity.setStrategyA(() -> System.out.println("动态增加"));
		entity.A();
	}
}
