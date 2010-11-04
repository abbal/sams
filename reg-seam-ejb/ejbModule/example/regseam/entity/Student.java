package example.regseam.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.hibernate.validator.Length;

@Entity
@DiscriminatorValue("S")
public class Student extends Osoba {
	private static final long serialVersionUID = 1L;
	
    private String grupaDziekanska;
    private String indeks;
    private List<Grupa> grupy;
    
    @Length(max = 15)
	public String getIndeks() {
		return indeks;
	}
	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	@Length(max = 15)
	public String getGrupaDziekanska() {
		return grupaDziekanska;
	}
	public void setGrupaDziekanska(String grupaDziekanska) {
		this.grupaDziekanska = grupaDziekanska;
	}
	
	@ManyToMany
	public List<Grupa> getGrupy() {
		return grupy;
	}
	public void setGrupy(List<Grupa> grupy) {
		this.grupy = grupy;
	}

}
