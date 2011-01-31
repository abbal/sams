package example.regseam.session;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.domain.regseam.session.Authenticator;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessages;

import example.regseam.entity.Osoba;

@Scope(ScopeType.SESSION)
@Name("haslo")
public class Haslo implements Serializable{
	private static final long serialVersionUID = 1L;

	@In 
	EntityManager entityManager;

	private String login;
	private String haslo;
	private String nowe;
	private String potwierdzenie;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getHaslo() {
		return haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	public String getNowe() {
		return nowe;
	}
	public void setNowe(String nowe) {
		this.nowe = nowe;
	}
	public String getPotwierdzenie() {
		return potwierdzenie;
	}
	public void setPotwierdzenie(String potwierdzenie) {
		this.potwierdzenie = potwierdzenie;
	}

	public void zmien(long id) {
		Osoba osoba = entityManager.find(Osoba.class, id);
		if (osoba != null && osoba.getLogin().equals(login) && nowe.equals(potwierdzenie) 
				&& nowe.length() > 7 && osoba.getHaslo().equals(Authenticator.generateMD5(haslo))) {
			osoba.setHaslo(Authenticator.generateMD5(nowe));
			entityManager.persist(osoba);
			StatusMessages.instance().add("Hasło zostało zmienione");
			return;
		}
		StatusMessages.instance().add("Zmiana hasła nie powiodła się");
	}
}
