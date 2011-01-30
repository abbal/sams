package example.regseam.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.validator.Length;
import org.hibernate.validator.Pattern;
import org.jboss.security.integration.password.Password;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Osoba implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String imie;
	private String nazwisko; 
	private String login;
	private String haslo;
	private String rola;
	
	private boolean flaga;
	
	 
    public boolean isFlaga() {
		return flaga;
	}
	public void setFlaga(boolean flaga) {
		this.flaga = flaga;
	}

	public String getRola() {
		return rola;
	}
	public void setRola(String rola) {
		this.rola = rola;
	}
	@Id
    @GeneratedValue
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Length(max = 15)
	@Pattern(regex="^\\p{Lu}\\p{Ll}+", message="musi składać się z samych liter")
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	
	@Length(max = 30)
	@Pattern(regex="^(\\p{Lu}\\p{Ll}+)[- (\\p{Lu}\\p{Ll}+)]*", message="musi składać się z samych liter")
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	@Length(min = 8)
	@Password(methodName = "md5")
	public String getHaslo() {
		return haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	} 
}
