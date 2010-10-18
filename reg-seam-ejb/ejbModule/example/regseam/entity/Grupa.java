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
	private Date godzinaStart;
	private Date godzinaStop;
	private List<Student> studenci;

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
		return godzinaStart;
	}
	public void setGodzinaStart(Date godzinaStart) {
		this.godzinaStart = godzinaStart;
	}
	
	public Date getGodzinaStop() {
		return godzinaStop;
	}
	public void setGodzinaStop(Date godzinaStop) {
		this.godzinaStop = godzinaStop;
	}
	
	@ManyToMany(mappedBy="grupy")
	public List<Student> getStudenci() {
		return studenci;
	}	
	public void setStudenci(List<Student> studenci) {
		this.studenci = studenci;
	}

}
