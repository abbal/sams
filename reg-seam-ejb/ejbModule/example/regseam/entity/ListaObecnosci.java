package example.regseam.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

import example.regseam.session.DzienTygodnia;

@Entity
public class ListaObecnosci implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Student student;
	private Grupa grupa;
	private Long data;
	private String usprawiedliwienie;

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

//	public String getGodzina() {
//		Calendar godz = Calendar.getInstance();
//		godz.setTime(new Date(data));
//		String h = godz.get(Calendar.HOUR_OF_DAY) < 10 ? "0" + godz.get(Calendar.HOUR_OF_DAY) : "" + godz.get(Calendar.HOUR_OF_DAY);
//		String m = godz.get(Calendar.MINUTE) < 10 ? "0" + godz.get(Calendar.MINUTE) : "" + godz.get(Calendar.MINUTE);
//		return h + ":" + m;
//	}
//
//	public String getDzien() {
//		Calendar godz = Calendar.getInstance();
//		godz.setTime(new Date(data));
//		String dzien = DzienTygodnia.values()[godz.get(Calendar.DAY_OF_WEEK)].toString();
//		return dzien;
//	}
}