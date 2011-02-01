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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.Length;
import org.hibernate.validator.Pattern;

@Entity
@DiscriminatorValue("S")
public class Student extends Osoba {
	private static final long serialVersionUID = 1L;

	private GrupaDziekanska grupaDziekanska;
	private String indeks;
	private List<Grupa> studenciGrupy;
	private List<Obecnosc> obecnosci;

	@Length(max = 15)
	@Pattern(regex="^s\\d{1,4}$", message="niepoprawny format")
	public String getIndeks() {
		return indeks;
	}
	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	@ManyToOne
	public GrupaDziekanska getGrupaDziekanska() {
		return grupaDziekanska;
	}
	public void setGrupaDziekanska(GrupaDziekanska grupaDziekanska) {
		this.grupaDziekanska = grupaDziekanska;
	}

	@ManyToMany(mappedBy = "studenci")
	public List<Grupa> getStudenciGrupy() {
		return studenciGrupy;
	}
	public void setStudenciGrupy(List<Grupa> studenciGrupy) {
		this.studenciGrupy = studenciGrupy;
	}

	@OneToMany(mappedBy = "student")
	public List<Obecnosc> getObecnosci() {
		return obecnosci;
	}
	public void setObecnosci(List<Obecnosc> obecnosci) {
		this.obecnosci = obecnosci;
	}

	public List<Obecnosc> obecnoscGrupa(long grupaId) {
		List<Obecnosc> wynik = new ArrayList<Obecnosc>();
		List<Obecnosc> tmp = new ArrayList<Obecnosc>();
		for (Obecnosc ob : obecnosci) {
			if (ob.getListaObecnosci().getGrupa().getId() == grupaId) {
				tmp.add(ob);
			}
		}
		List<Long> daty = new ArrayList<Long>();
		for (Obecnosc ob : tmp) {
			daty.add(ob.getListaObecnosci().getData().getTime());
		}
		Collections.sort(daty);
		for (Long data : daty) {
			for (Obecnosc ob : tmp) {
				if (ob.getListaObecnosci().getData().getTime() == data) {
					wynik.add(ob);
					break;
				}
			}
		}
		return wynik;
	}

	public List<Integer> dlugosc() {
		List<Integer> wynik = new ArrayList<Integer>();
		int max = 0;
		for (Grupa grupa : studenciGrupy) {
			int tmp = 0;
			for (Obecnosc obecnosc : obecnosci) {
				if (obecnosc.getListaObecnosci().getGrupa().getId() == grupa.getId()) {
					tmp++;
				}
			}
			if (tmp > max) {
				max = tmp;
			}
		}
		for (int i = 1; i <= max; i++) {
			wynik.add(i);
		}
		return wynik;
	}
}
