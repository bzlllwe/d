package d.d.visitor;

import d.d.visitor.action.Action;
import d.d.visitor.person.Person;

import java.util.LinkedList;
import java.util.List;

public class PersonList {
	private List<Person> persons = new LinkedList<>();

	public void addPerson(Person p){
		persons.add(p);
	}

	public void removePerson(Person p){
		persons.remove(p);
	}

	public void display(Action a){
		for (Person p : persons) {
			p.accept(a);
		}
	}
}
