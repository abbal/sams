package example.regseam.session;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;

import example.regseam.entity.Person;

@Name("personList")
public class PersonList {

	@In
	EntityManager entityManager;

	@DataModel(scope = ScopeType.PAGE)
	protected List<Person> persons;

	@DataModelSelection
	protected Person selected;

	@Factory("persons")
	public void loadPersons() {
		persons = entityManager.createQuery("select p from Person p")
				.getResultList();
	}

	public String delete() {
		selected = entityManager.find(Person.class, selected.getId());
		entityManager.remove(selected);
		return "success";
	}

}
