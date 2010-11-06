package example.regseam.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;

import org.hibernate.validator.Digits;
import org.hibernate.validator.Length;

@Entity
public class Grupa implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String przedmiot;
	private int semestr;
	private long godzinaStart;
	private long godzinaStop;
	private int dzien;
	private List<Student> studenci;
	private List<Wykladowca> wykladowcy;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Length(max = 20)
	public String getPrzedmiot() {
		return przedmiot;
	}
	public void setPrzedmiot(String przedmiot) {
		this.przedmiot = przedmiot;
	}
	
	@Digits(integerDigits=1)
	public int getSemestr() {
		return semestr;
	}
	public void setSemestr(int semestr) {
		this.semestr = semestr;
	}
	
	public Date getGodzinaStart() {
		return new Date(godzinaStart);
	}
	public void setGodzinaStart(long godzinaStart) {
		this.godzinaStart = godzinaStart;
	}
	
	public Date getGodzinaStop() {
		return new Date(godzinaStop);
	}
	public void setGodzinaStop(long godzinaStop) {
		this.godzinaStop = godzinaStop;
	}

	public int getDzien() {
		return dzien;
	}
	public void setDzien(int dzien) {
		this.dzien = dzien;
	}

	@ManyToMany(mappedBy="studenciGrupy")
	public List<Student> getStudenci() {
		return studenci;
	}	
	public void setStudenci(List<Student> studenci) {
		this.studenci = studenci;
	}

	@ManyToMany(mappedBy="wykladowcyGrupy")
	public List<Wykladowca> getWykladowcy() {
		return wykladowcy;
	}
	public void setWykladowcy(List<Wykladowca> wykladowcy) {
		this.wykladowcy = wykladowcy;
	}

}
