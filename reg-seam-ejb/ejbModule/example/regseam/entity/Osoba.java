package example.regseam.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.jboss.security.integration.password.Password;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.security.management.UserPassword;
import org.jboss.seam.security.management.PasswordHash;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Osoba implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String imie;
	private String nazwisko; 
	private String login; 
/*	 @NotNull  
	 @Length(min = 8)  
	 @UserPassword(hash = "md5")*/
	private String haslo;
	private String rola;
	
	 
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
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	
	@Length(max = 30)
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
