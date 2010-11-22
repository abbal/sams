package example.regseam.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import example.regseam.session.TytulyNaukowe;

@Entity
@DiscriminatorValue("W")
public class Wykladowca extends Osoba {
	private static final long serialVersionUID = 1L;
	
	private List<Grupa> wykladowcyGrupy;
	private TytulyNaukowe tytul;

	@ManyToMany(mappedBy="wykladowcy")
	public List<Grupa> getWykladowcyGrupy() {
		return wykladowcyGrupy;
	}
	public void setWykladowcyGrupy(List<Grupa> wykladowcyGrupy) {
		this.wykladowcyGrupy = wykladowcyGrupy;
	}
	
	public TytulyNaukowe getTytul() {
		return tytul;
	}
	public void setTytul(TytulyNaukowe tytul) {
		this.tytul = tytul;
	}
	
	
}
