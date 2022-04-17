package d.d.visitor.person;

import d.d.visitor.action.Action;

public class Man extends  Person {
	@Override
	public void accept(Action action) {
		action.getManResult(this);
	}
}
