package example.regseam.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

import example.regseam.session.Usprawiedliwienia;

@Entity
public class ListaObecnosci implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Student student;
	private Grupa grupa;
	private Long data;
	private Usprawiedliwienia usprawiedliwienia;

	@ManyToOne
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	public Usprawiedliwienia getUsprawiedliwienie() {
		return usprawiedliwienia;
	}
	public void setUsprawiedliwienie(Usprawiedliwienia usprawiedliwienie) {
		this.usprawiedliwienia = usprawiedliwienie;
	}

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

	public Long getData() {
		return data;
	}
	public void setData(Long data) {
		this.data = data;
	}

}
