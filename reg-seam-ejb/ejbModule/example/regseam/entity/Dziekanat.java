package example.regseam.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class Dziekanat extends Osoba {
private static final long serialVersionUID = 1L;
	
private long id;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}
	

}
