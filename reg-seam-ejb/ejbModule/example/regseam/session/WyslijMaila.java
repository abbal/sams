package example.regseam.session;

import javax.persistence.EntityManager;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.faces.Renderer;
import org.jboss.seam.log.Log;

import example.regseam.entity.Osoba;

@Name("wyslijMaila")

public class WyslijMaila {

	@Logger
	private Log log;

	@In
	private FacesMessages facesMessages;

	@In
	private Renderer renderer;
	private String index;
	private String address;
	private String pass;
	@In EntityManager entityManager;
	
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		Osoba osoba = (Osoba)entityManager.createQuery("select haslo from Osoba haslo where student.indeks = :index");
		this.pass = pass;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.address = index + "@pjwstk.edu.pl";
		this.index = index;
	}
	public void send(String index) {
		try {
			renderer.render("/email.xhtml");
			facesMessages.add("Email sent successfully");
		} catch (Exception e) {
			log.error("Error sending mail", e);
			facesMessages.add("Email sending failed: " + e.getMessage());
		}
	}
}
