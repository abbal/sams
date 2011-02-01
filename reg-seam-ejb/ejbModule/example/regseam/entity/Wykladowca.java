
/*
 * Projekt inżynierski Polsko-Japońskiej Wyższej Szkoły Technik Komputerowych w Gdańsku
 * "Projekt i implementacja systemu monitorowania obecności       studentów na zajęciach"
 * 
 * Autorzy:
 *     Adam Balcerzak
 *     Tomasz Masztalerz
 *     Piotr Niesiołowski
 *
 * Gdańsk, 2011
 *
 */
package example.regseam.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import example.regseam.session.TytulyNaukowe;

@Entity
@DiscriminatorValue("W")
public class Wykladowca extends Osoba {
	private static final long serialVersionUID = 1L;
	
	private List<Grupa> wykladowcyGrupy;
	private TytulyNaukowe tytul;

	@OneToMany(mappedBy="wykladowca")
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
