package d.d.visitor.person;

import d.d.visitor.action.Action;

public abstract class Person {
	public abstract void accept(Action action);
}
