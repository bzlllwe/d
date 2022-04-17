package d.d.visitor.action;


import d.d.visitor.person.Man;
import d.d.visitor.person.Woman;

public class Fail extends Action {
	@Override
	public void getManResult(Man man) {
		System.out.println("man : fail");
	}

	@Override
	public void getWomanResult(Woman woman) {
		System.out.println("woman : fail");
	}
}
