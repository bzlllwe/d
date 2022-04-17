package d.d.visitor.action;

import d.d.visitor.action.Action;
import d.d.visitor.person.Man;
import d.d.visitor.person.Woman;

public class Wait extends Action {
	@Override
	public void getManResult(Man man) {
		System.out.println("man : wait");
	}

	@Override
	public void getWomanResult(Woman woman) {
		System.out.println("woman : wait");
	}
}
