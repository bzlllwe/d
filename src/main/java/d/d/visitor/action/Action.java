package d.d.visitor.action;

import d.d.visitor.person.Man;
import d.d.visitor.person.Woman;

public abstract class Action {

	public abstract void getManResult(Man man);
	public abstract void getWomanResult(Woman woman);
}
