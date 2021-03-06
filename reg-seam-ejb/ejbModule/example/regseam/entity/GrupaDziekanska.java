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

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import org.hibernate.validator.Length;

@Entity
public class GrupaDziekanska implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nazwa;
	private List<Student> studenci;
	private boolean flaga;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Length(max = 20)
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	@OneToMany(mappedBy = "grupaDziekanska")
	public List<Student> getStudenci() {
		return studenci;
	}
	public void setStudenci(List<Student> studenci) {
		this.studenci = studenci;
	}

	public boolean isFlaga() {
		return flaga;
	}
	public void setFlaga(boolean flaga) {
		this.flaga = flaga;
	}

}
