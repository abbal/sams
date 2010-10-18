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
    private String index;
    private List<Grupa> grupy;
    
    @Length(max = 15)
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
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
