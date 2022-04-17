package d.d.visitor;

import d.d.visitor.action.Fail;
import d.d.visitor.action.Success;
import d.d.visitor.person.Man;
import d.d.visitor.person.Woman;

public class Client {

	public static void main(String[] args) {
		PersonList personList = new PersonList();
		personList.addPerson(new Man());
		personList.addPerson(new Man());
		personList.addPerson(new Woman());
		personList.addPerson(new Woman());

		Success success = new Success();
		personList.display(success);

		System.out.println("------------");

		Fail fail = new Fail();
		personList.display(fail);

	}
}
