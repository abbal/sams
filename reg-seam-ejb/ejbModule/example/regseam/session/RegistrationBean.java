package example.regseam.session;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.End;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;

import example.regseam.entity.Person;

@Stateful
@Name("registration")
@Scope(ScopeType.SESSION)
public class RegistrationBean implements Registration {
	@Logger
	private Log log;

	@In
	Person person;

	@In
	EntityManager entityManager;

	private boolean confirmed = false;

	@End
	public String register() {

		log.info("Trying to register");
		if (confirmed) {
			entityManager.persist(person);
			confirmed = false;
			return "/register.xhtml";
		}
		
		return "failure";
	}

	@Begin
	public String confirm() {
		confirmed = true;
        return "/confirm.xhtml";
	}

	@Remove
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	

}
