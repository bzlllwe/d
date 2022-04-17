package d.d.visitor.person;

import d.d.visitor.action.Action;

public class Woman extends Person {
	@Override
	public void accept(Action action) {
		action.getWomanResult(this);
	}
}
