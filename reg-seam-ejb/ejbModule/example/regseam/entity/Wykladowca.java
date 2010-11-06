package example.regseam.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("W")
public class Wykladowca extends Osoba {
	private static final long serialVersionUID = 1L;
	
	private List<Grupa> wykladowcyGrupy;
	private String tytul;

	@ManyToMany
	public List<Grupa> getWykladowcyGrupy() {
		return wykladowcyGrupy;
	}
	public void setWykladowcyGrupy(List<Grupa> wykladowcyGrupy) {
		this.wykladowcyGrupy = wykladowcyGrupy;
	}
	
	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	
	
}
