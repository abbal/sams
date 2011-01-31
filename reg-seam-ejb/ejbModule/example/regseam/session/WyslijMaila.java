package example.regseam.session;

import javax.persistence.EntityManager;

import org.domain.regseam.session.Authenticator;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.faces.Renderer;
import org.jboss.seam.log.Log;

import example.regseam.entity.Student;

@Name("wyslijMaila")

public class WyslijMaila {

	@Logger
	private Log log;

	@In
	private FacesMessages facesMessages;

	@In
	private Renderer renderer;
	
	@RequestParameter
	private String index;
	
	private String address;
	private String pass;
	
	@In 
	EntityManager entityManager;
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
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
		Student student = (Student)entityManager.createQuery("select student from Student student where indeks = :index").setParameter("index", index).getSingleResult();
		if (student == null) {
			return;
		}
		this.address = index + "@pjwstk.edu.pl";
		String haslo = password();
		student.setHaslo(Authenticator.generateMD5(haslo));
		entityManager.persist(student);
		System.out.println("#################"+haslo+"#####");
		this.pass = haslo; 
		this.index = index;
	}
	
	public void send() {
		try {
			renderer.render("/email.xhtml");
			facesMessages.add("Email został wysłany");
		} catch (Exception e) {
			log.error("Wyslanie nie powiodło się", e);
			facesMessages.add("Wyslanie nie powiodło się");
		}
	}

	private String password() {
		String all = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		char[] array = all.toCharArray();
		String haslo = "";
		for (int i = 0; i < 8; i ++) {
			int los = (int) (Math.random()*62);
			haslo += array[los];
		}
		return haslo;
	}
}
