package example.regseam.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Version;
import org.hibernate.validator.Length;

@Entity
public class ListaObecnosci implements Serializable
{
    
    private Long id;
    private Student student;
    private Long data;
    private String usprawiedliwienie;

    public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Long getData() {
		return data;
	}

	public void setData(Long data) {
		this.data = data;
	}

	public String getUsprawiedliwienie() {
		return usprawiedliwienie;
	}

	public void setUsprawiedliwienie(String usprawiedliwienie) {
		this.usprawiedliwienie = usprawiedliwienie;
	}

	@Id @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
