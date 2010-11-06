package example.regseam.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.validator.Length;

@Entity
@DiscriminatorValue("S")
public class Student extends Osoba {
	private static final long serialVersionUID = 1L;
	
    private GrupaDziekanska grupaDziekanska;
    private String indeks;
    private List<Grupa> studenciGrupy;
    
    @Length(max = 15)
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

	@ManyToMany
	public List<Grupa> getStudenciGrupy() {
		return studenciGrupy;
	}
	public void setStudenciGrupy(List<Grupa> studenciGrupy) {
		this.studenciGrupy = studenciGrupy;
	}

}
