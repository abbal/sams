package example.regseam.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import example.regseam.session.Usprawiedliwienia;

@Entity
public class ListaObecnosci implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Grupa grupa;
	private Usprawiedliwienia usprawiedliwienia;
/*
	@ManyToOne
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
*/
	public Usprawiedliwienia getUsprawiedliwienie() {
		return usprawiedliwienia;
	}
	public void setUsprawiedliwienie(Usprawiedliwienia usprawiedliwienie) {
		this.usprawiedliwienia = usprawiedliwienie;
	}

	private Date data;
	private List<Obecnosc> obecnosci;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	public Grupa getGrupa() {
		return grupa;
	}
	public void setGrupa(Grupa grupa) {
		this.grupa = grupa;
	}

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	@OneToMany(mappedBy="listaObecnosci")
	public List<Obecnosc> getObecnosci() {
		return obecnosci;
	}
	public void setObecnosci(List<Obecnosc> obecnosci) {
		this.obecnosci = obecnosci;
	}

}
