package example.regseam.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import org.hibernate.validator.Length;

@Entity
public class Obecnosc implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Student student;
	private String usprawiedliwienie;
	private ListaObecnosci listaObecnosci;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	public String getUsprawiedliwienie() {
		return usprawiedliwienie;
	}
	public void setUsprawiedliwienie(String usprawiedliwienie) {
		this.usprawiedliwienie = usprawiedliwienie;
	}

	@ManyToOne
	public ListaObecnosci getListaObecnosci() {
		return listaObecnosci;
	}
	public void setListaObecnosci(ListaObecnosci listaObecnosci) {
		this.listaObecnosci = listaObecnosci;
	}

}